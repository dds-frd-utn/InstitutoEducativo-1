package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Curso;
//import com.example.demo.entity.Material;

public interface CursoService {
	public List<Curso> findAllCurso();

	public Optional<Curso> findCursoById(Long id);

	public Curso saveCurso(Curso newCurso);
	
	//public List <Material> getMaterialesByCurso(Long id_curso);
	
	public List<Curso> findAllCurso(Long id);
}