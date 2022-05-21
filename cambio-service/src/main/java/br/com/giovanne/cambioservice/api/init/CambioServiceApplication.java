package br.com.giovanne.cambioservice.api.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"br.com.giovanne.cambioservice.controller",
		"br.com.giovanne.cambioservice.model",
		"br.com.giovanne.cambioservice.repository"
})
@EntityScan(basePackages = "br.com.giovanne.cambioservice.model")
@EnableJpaRepositories(basePackages = "br.com.giovanne.cambioservice.repository")
public class CambioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CambioServiceApplication.class, args);
	}

}
