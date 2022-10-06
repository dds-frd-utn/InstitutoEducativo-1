package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Material;

public interface MaterialService {
	public List<Material> findAllMaterial();

	public Optional<Material> findMaterialById(Long id);

	public Material saveMaterial(Material newMaterial);

	public String deleteMaterial(Long id);

	public String updateMaterial(Material material);
	
	public List<Material> findLikeTitulo(String titulo);
	
	public List <Material> getMaterialesByCurso(Long id_curso);
}
