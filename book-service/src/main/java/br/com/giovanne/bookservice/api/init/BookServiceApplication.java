package br.com.giovanne.bookservice.api.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients(basePackages = "br.com.giovanne.bookservice.proxy")
@ComponentScan(basePackages = {
		"br.com.giovanne.bookservice.controller",
		"br.com.giovanne.bookservice.model",
		"br.com.giovanne.bookservice.repository",
})
@EntityScan(basePackages = "br.com.giovanne.bookservice.model")
@EnableJpaRepositories(basePackages = "br.com.giovanne.bookservice.repository")
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

}
