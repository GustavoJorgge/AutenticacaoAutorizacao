package com.example.sistemaSeguro.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableJpaRepositories("com.example.sistemaSeguro.repository")
@EntityScan("com.example.sistemaSeguro.model")
public class SistemaSeguroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaSeguroApplication.class, args);
	}

}
