package com.example.demo.repository;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Curso;
//import com.example.demo.entity.Material;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	void save(Optional<Curso> CursoToUpdate);
		
	//@Query(value = "select * from material as m where m.id_curso = :id", nativeQuery = true)  
	//List<Material> getMaterialesByCurso(@Param("id") Long id_curso);
}


