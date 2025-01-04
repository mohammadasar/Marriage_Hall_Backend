package com.example.marriagehall;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.annotation.Import;

@Import(ValidationAutoConfiguration.class)
@SpringBootApplication
public class MarriagehallApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarriagehallApplication.class, args);
	}

}
