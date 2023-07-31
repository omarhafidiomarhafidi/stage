package com.cb.apii;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class ApiiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiiApplication.class, args);
	}

}
