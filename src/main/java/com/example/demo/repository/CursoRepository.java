package com.example.demo.repository;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Curso;
//import com.example.demo.entity.Material;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	void save(Optional<Curso> CursoToUpdate);
		
	//@Query(value = "select * from material as m where m.id_curso = :id", nativeQuery = true)  
	//List<Material> getMaterialesByCurso(@Param("id") Long id_curso);
	
	@Query(value = "select c.id, c.nombre, c.id_tema, c.fecha_inicio, c.id_docente from cursos_personales as cp join alumno_curso_personal as acp on cp.id = acp.id_curso_personal INNER JOIN cursos AS c ON cp.id_curso = c.id where acp.id_alumno=:id", nativeQuery = true)
	List<Curso> findAllCurso(@Param("id") Long id);
}


