package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Attention, all controllers services etc must be uder package of this app, otherwise will not be initialized
 * @author pavel
 *
 */
@SpringBootApplication
public class SpringBootDataApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataApp.class, args);

	}

}
