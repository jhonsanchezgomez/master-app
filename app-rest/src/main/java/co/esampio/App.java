package co.esampio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "co.esampio")
@EnableJpaRepositories(basePackages={"co.esampio.repo.repository"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
