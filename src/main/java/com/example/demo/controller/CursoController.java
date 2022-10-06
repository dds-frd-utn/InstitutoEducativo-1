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
	
//	@RequestMapping(value = "/cursos/id_tema/{id_tema}", method = RequestMethod.GET, produces = "application/json")
//	public List<Curso> getCursoLikeId(@PathVariable("id_tema") String id_tema) {
//	    System.out.println(id_tema);
//		return cursoService.findLikeId("%"+id_tema+"%");
//	}
	
	@RequestMapping(value = "/cursos/add", method = RequestMethod.POST, produces = "application/json")
	public Curso addCurso(Curso curso) {
		return cursoService.saveCurso(curso);
	}

	@RequestMapping(value = "/cursos/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteCurso(@PathVariable Long id) {
		return cursoService.deleteCurso(id);
	}
	
	@RequestMapping(value = "/cursos/update", method = RequestMethod.PUT, produces = "application/json")
	public String updateCurso(Curso curso) {
		return cursoService.updateCurso(curso);
	}
	
	@RequestMapping(value = "/cursos/{id}/materiales", method = RequestMethod.GET, produces = "application/json")
	public List<Curso> getMaterialesByCurso(@PathVariable Long id_curso) {
		return cursoService.getMaterialesByCurso(id_curso);
	}

}
