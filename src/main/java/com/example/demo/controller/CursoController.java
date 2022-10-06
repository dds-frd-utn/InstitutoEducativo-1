package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CursoService;
import com.example.demo.entity.Curso;
//import com.example.demo.entity.Material;

@RestController

public class CursoController {
	@Autowired
	CursoService cursoService;
	
	@RequestMapping(value = "/cursos", method = RequestMethod.GET, produces = "application/json")
	public List<Curso> getCurso() {
		return cursoService.findAllCurso();
	}
	
	@RequestMapping(value = "/cursos/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Curso> getCurso(@PathVariable("id") Long id) {
		return cursoService.findCursoById(id);
	}
	
	
	@RequestMapping(value = "/cursos/add", method = RequestMethod.POST, produces = "application/json")
	public Curso addCurso(Curso curso) {
		return cursoService.saveCurso(curso);
	}

	
	//@RequestMapping(value = "/cursos/{id}/materiales", method = RequestMethod.GET, produces = "application/json")
	//public List<Material> getMaterialesByCurso(@PathVariable("id") Long id_curso) {
	  //  System.out.println(id_curso);
		//return cursoService.getMaterialesByCurso(id_curso);
	//}

}
