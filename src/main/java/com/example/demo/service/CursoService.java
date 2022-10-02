package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Curso;

public interface CursoService {
	public List<Curso> findAllCurso();

	public Optional<Curso> findCursoById(Long id);

	public Curso saveCurso(Curso newCurso);

	public String deleteCurso(Long id);

	public String updateCurso(Curso curso);
}