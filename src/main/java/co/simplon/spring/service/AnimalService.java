package co.simplon.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.simplon.spring.model.Animal;

@Service
public interface AnimalService {

	public Animal save(Animal animal);

	public List<Animal> getAll();

	// renvoit un obj de la classe Optional, qui contient une methode "isPresent"
	public Optional<Animal> findById(Long id);

	public List<Animal> findByName(String name);

	public List<Animal> findByEspece(String espece);

	public List<Animal> findByNameEspece(String name, String espece);

}
