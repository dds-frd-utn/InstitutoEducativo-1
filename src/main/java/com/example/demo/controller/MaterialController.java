package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MaterialService;
import com.example.demo.entity.Material;

@RestController

public class MaterialController {
	@Autowired
	MaterialService materialService;
	
	@RequestMapping(value = "/materiales", method = RequestMethod.GET, produces = "application/json")
	public List<Material> getMaterial() {
		return materialService.findAllMaterial();
	}
	
	@RequestMapping(value = "/materiales/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Material> getMaterial(@PathVariable("id") Long id) {
		return materialService.findMaterialById(id);
	}
	
	@RequestMapping(value = "/materiales/titulo/{titulo}", method = RequestMethod.GET, produces = "application/json")
	public List<Material> getMaterialLikeTitulo(@PathVariable("titulo") String titulo) {
	    System.out.println(titulo);
		return materialService.findLikeTitulo("%"+titulo+"%");
	}
	
	@RequestMapping(value = "/materiales/add", method = RequestMethod.POST, produces = "application/json")
	public Material addPostPost(Material material) {
		return materialService.saveMaterial(material);
	}

	@RequestMapping(value = "/materiales/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteMaterial(@PathVariable Long id) {
		return materialService.deleteMaterial(id);
	}
	
	@RequestMapping(value = "/materiales/update", method = RequestMethod.PUT, produces = "application/json")
	public String updateMaterial(Material material) {
		return materialService.updateMaterial(material);
	}	
	@RequestMapping(value = "/materiales/cursos/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<Material> getMaterialesByCurso(@PathVariable("id") Long id_curso) {
	    System.out.println(id_curso);
		return materialService.getMaterialesByCurso(id_curso);
	}
}
