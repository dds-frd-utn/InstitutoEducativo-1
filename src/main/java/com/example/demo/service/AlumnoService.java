package com.example.demo.service;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Alumno;
//import com.example.demo.entity.Curso;

public interface AlumnoService {
	public List<Alumno> findAllAlumno();

	public Optional<Alumno> findAlumnoById(Long id);

	public Alumno saveAlumno(Alumno newAlumno);

	public String deleteAlumno(Long id);

	public String updateAlumno(Alumno alumno);
	
	//public List<Curso> findAllCurso(Long id);

}