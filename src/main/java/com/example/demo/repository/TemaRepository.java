package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {

	void save(Optional<Tema> TemaToUpdate);
		
	@Query(value = "select * from temas as t where t.nombre like :nombre", nativeQuery = true)  
	List<Tema> findLikeNombre(@Param("nombre")String nombre);
}
