package co.simplon.spring.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import co.simplon.spring.model.Animal;
import co.simplon.spring.repository.AnimalRepository;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Inject
	private AnimalRepository animalRepository;

	@Override
	public Animal save(Animal animal) {
		return animalRepository.save(animal);

	}

	@Override
	public List<Animal> getAll() {
		return animalRepository.findAll();
	}

	@Override
	public Optional<Animal> findById(Long id) {
		return animalRepository.findById(id);
	}

	@Override
	public List<Animal> findByName(String name) {
		return animalRepository.findByNameStartsWithIgnoreCase(name);

	}

	@Override
	public List<Animal> findByEspece(String espece) {
		return animalRepository.findByEspeceStartsWithIgnoreCase(espece);
	}

	@Override
	public List<Animal> findByNameEspece(String name, String espece) {
		return animalRepository.findByNameStartsWithAndEspeceStartsWithAllIgnoreCase(name, espece);
	}

}
