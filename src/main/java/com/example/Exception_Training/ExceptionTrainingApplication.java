package com.example.Exception_Training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ExceptionTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionTrainingApplication.class, args);
	}

}
