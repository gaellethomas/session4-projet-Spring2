package co.simplon.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//permet de lancer la configuration de notre application et d’indiquer les packages à considérer
@SpringBootApplication // (scanBasePackages= "co.simplon.spring")
public class Session4ProjetSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(Session4ProjetSpringApplication.class, args);
	}
}
