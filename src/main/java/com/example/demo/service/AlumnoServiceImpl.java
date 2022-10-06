package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Curso;
import com.example.demo.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepository; 
									

	@Override
	public List<Alumno> findAllAlumno() {
		return alumnoRepository.findAll();
	}

	@Override
	public Optional<Alumno> findAlumnoById(Long id) {
		return alumnoRepository.findById(id);
	}

	@Override
	public Alumno saveAlumno(Alumno newAlumno) {
		return alumnoRepository.save(newAlumno);
	}

	@Override
	public String deleteAlumno(Long id) {
		if (alumnoRepository.findById(id) != null) {
			alumnoRepository.deleteById(id);
			return "OK";
		}
		return "ERROR: el id no existe";
	}

	@Override
	public String updateAlumno(Alumno alumno) {
		if (alumnoRepository.findById(alumno.getId()) != null) {
			alumnoRepository.save(alumno);
			return "OK";
		}

		return "ERROR: el id no existe";
	}

	public List<Curso> findAllCurso(Long id){
		return alumnoRepository.findAllCurso(id);
	}

}
