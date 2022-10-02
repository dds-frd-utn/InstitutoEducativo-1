package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

	
	void save(Optional<Alumno> AlumnoToUpdate);
	
}
	