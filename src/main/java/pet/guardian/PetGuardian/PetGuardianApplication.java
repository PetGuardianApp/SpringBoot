package pet.guardian.PetGuardian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class PetGuardianApplication {
	public static void main(String[] args) {
		SpringApplication.run(PetGuardianApplication.class, args);
	}
	@GetMapping("/")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("API Version: 0.1", name);
	}

}
