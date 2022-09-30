package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TemaService;
import com.example.demo.entity.Tema;

@RestController

public class TemaController {
	@Autowired
	TemaService temaService;
	
	@RequestMapping(value = "/temas", method = RequestMethod.GET, produces = "application/json")
	public List<Tema> getTema() {
		return temaService.findAllTema();
	}
	
	@RequestMapping(value = "/temas/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Tema> getTema(@PathVariable("id") Long id) {
		return temaService.findTemaById(id);
	}
	
	@RequestMapping(value = "/temas/nombre/{nombre}", method = RequestMethod.GET, produces = "application/json")
	public List<Tema> getTemaLikeTitulo(@PathVariable("nombre") String nombre) {
	    System.out.println(nombre);
		return temaService.findLikeNombre("%"+nombre+"%");
	}
	
	@RequestMapping(value = "/temas/add", method = RequestMethod.POST, produces = "application/json")
	public Tema addPostPost(Tema tema) {
		return temaService.saveTema(tema);
	}

	@RequestMapping(value = "/temas/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteTema(@PathVariable Long id) {
		return temaService.deleteTema(id);
	}
	
	@RequestMapping(value = "/temas/update", method = RequestMethod.PUT, produces = "application/json")
	public String updateTema(Tema tema) {
		return temaService.updateTema(tema);
	}	
}
