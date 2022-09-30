package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // notation (le agrega comportamientos y atributos a la clase)
public class DemoApplication {

	// el static sirve para buscar la clase (si no lo tiene significa que es una instancia)
	//El proyecto comienza a ejecutarse con esta clase
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
