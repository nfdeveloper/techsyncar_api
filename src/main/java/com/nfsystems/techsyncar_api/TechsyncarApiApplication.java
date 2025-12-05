package com.nfsystems.techsyncar_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TechsyncarApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechsyncarApiApplication.class, args);
	}

}
