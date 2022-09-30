package com.example.demo.controller;
//Para meterlo en controllers solo tuve que arrastrarlo
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //me crea una notation para el servicio de solicitudes
//Para agregar los import uso: Ctrl + Shift + o
public class HolaMundo {
	
	@GetMapping(path = "/casa") //me indica a que URL va a responder el get
	public String holaMundo() {
		
		return "Hola Mundo!!";
		
	}
	
}
