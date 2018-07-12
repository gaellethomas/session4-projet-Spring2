package co.simplon.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.simplon.spring.model.Animal;
import co.simplon.spring.service.AnimalService;

@Controller
// pour indiquer au controller qu il doit repondre lorsqu il recoit une requete
// pour l URL /animal
@RequestMapping("/animal")
public class AnimalController {

	@Inject
	private AnimalService animalService;

	// indique au controller qu il faut repondre avec cette methode si il recoit
	// une requete HTTP de type GET
	@RequestMapping(method = RequestMethod.GET)
	// pour lui dire de construire automatiquement la reponse
	@ResponseBody
	public List<Animal> findAll(@RequestParam(name = "nameParam", defaultValue = "") String name,
			@RequestParam(name = "especeParam", defaultValue = "") String espece) {
		List<Animal> liste = new ArrayList<>();
		if (!name.equals("") && !espece.equals("")) {
			liste = animalService.findByNameEspece(name, espece);
		} else if (!name.equals("")) {
			liste = animalService.findByName(name);
		} else if (!espece.equals("")) {
			liste = animalService.findByEspece(espece);
		} else {
			liste = animalService.getAll();
		}
		return liste;
	}

	// j indique que dans l URL de la requete ce qui suit /animal/ s appelle "id"
	@RequestMapping(value = "/{idDansURL}", method = RequestMethod.GET)
	@ResponseBody
	public Animal findById(@PathVariable("idDansURL") Long id, HttpServletResponse response) {
		Optional<Animal> animalTrouve = animalService.findById(id);
		Animal animal = null;
		response.setStatus(404);
		if (animalTrouve.isPresent()) {
			animal = animalTrouve.get();
			response.setStatus(200);
		}
		return animal;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody

	// @RequestBody attend dans le corps de la req qu il y ait un obj de type
	// attendu au format JSON (JavaScript Object Notation)
	// dans ce cas on code: public Animal create(@RequestBody Animal animalACreer) {

	// pour des donnees via un formulaire qui a une correspondance entre les nom des
	// champ du form et des att de l obj, on utilise @ModelAttribute
	public Animal create(@ModelAttribute Animal animalACreer) {
		return animalService.save(animalACreer);
	}

}
