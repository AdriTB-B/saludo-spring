package com.adri.saludospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SaludoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaludoSpringApplication.class, args);
	}

	@Bean
	List<User> listaUsuarios(){
		return new ArrayList<>();
	}
}
