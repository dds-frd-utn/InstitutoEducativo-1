package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Alumno;

public interface AlumnoService {
	public List<Alumno> findAllAlumno();

	public Optional<Alumno> findAlumnoById(Long id);

	public Alumno saveAlumno(Alumno newAlumno);

	public String deleteAlumno(Long id);

	public String updateAlumno(Alumno alumno);
	

}