package com.br.desafio.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class Application {

	public static void main(String[] args) {
		
		log.info("Starting Application");
		
		SpringApplication.run(Application.class, args);
	}

}