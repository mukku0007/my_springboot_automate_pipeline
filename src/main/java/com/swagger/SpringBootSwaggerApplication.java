package com.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Student Restful API",
				version = "1.0.0",
				description = "Student API Documentation"
				),
		servers = @Server(
				url = "http://localhost:8081",
				description = "Student API Url"
				)
		)
public class SpringBootSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwaggerApplication.class, args);
	}

}
