package co.esampio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "co.esampio")
@EnableJpaRepositories(basePackages={"co.esampio.repo.repository"})
// Se debe extender de SpringBootServletInitializer
public class App extends SpringBootServletInitializer{
	
	//Configuración necesaria para el servidor de aplicacciones WildFly.
	private static Class<App> applicationClass = App.class;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	//Configuración necesaria para el servidor de aplicacciones WildFly.
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

}
