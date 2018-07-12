package co.simplon.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.simplon.spring.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

	public List<Animal> findByName(String name);

	public Optional<Animal> findById(Long id);

	public List<Animal> findByNameStartsWithIgnoreCase(@Param("name") String name);

	public List<Animal> findByEspeceStartsWithIgnoreCase(@Param("espece") String espece);

	public List<Animal> findByNameStartsWithAndEspeceStartsWithAllIgnoreCase(@Param("name") String name,
			@Param("espece") String espece);
}
