package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Material;
import com.example.demo.repository.MaterialRepository;

@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialRepository materialRepository;

	@Override
	public List<Material> findAllMaterial() {
		return materialRepository.findAll();
	}

	@Override
	public Optional<Material> findMaterialById(Long id) {
		return materialRepository.findById(id);
	}

	@Override
	public Material saveMaterial(Material newPost) {
		return materialRepository.save(newPost);
	}

	@Override
	public String deleteMaterial(Long id) {
		if (materialRepository.findById(id) != null) {
			materialRepository.deleteById(id);
			return "OK";
		}
		return "ERROR: el id no existe";
	}

	@Override
	public String updateMaterial(Material material) {
		if (materialRepository.findById(material.getId()) != null) {
			materialRepository.save(material);
			return "OK";
		}
		return "ERROR: el id no existe";
	}

	@Override
	public List<Material> findLikeTitulo(String titulo) {
		return materialRepository.findLikeTitulo(titulo);
	}
}
