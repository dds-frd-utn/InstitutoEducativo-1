package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {

	void save(Optional<Material> materialToUpdate);
		
	@Query(value = "select * from material as m where m.titulo like :titulo", nativeQuery = true)  
	List<Material> findLikeTitulo(@Param("titulo")String title);
}
