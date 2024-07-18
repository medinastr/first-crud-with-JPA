package com.medinastrr.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// this will be executed after the Spring Beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {     // custom code
			System.out.println("Runner say hello.");
		};
	}

}
