package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tema;
import com.example.demo.repository.TemaRepository;

@Service
public class TemaServiceImpl implements TemaService {

	@Autowired
	TemaRepository temaRepository;

	@Override
	public List<Tema> findAllTema() {
		return temaRepository.findAll();
	}

	@Override
	public Optional<Tema> findTemaById(Long id) {
		return temaRepository.findById(id);
	}

	@Override
	public Tema saveTema(Tema newTema) {
		return temaRepository.save(newTema);
	}

	@Override
	public String deleteTema(Long id) {
		if (temaRepository.findById(id) != null) {
			temaRepository.deleteById(id);
			return "OK";
		}
		return "ERROR: el id no existe";
	}

	@Override
	public String updateTema(Tema tema) {
		if (temaRepository.findById(tema.getId()) != null) {
			temaRepository.save(tema);
			return "OK";
		}
		return "ERROR: el id no existe";
	}

	@Override
	public List<Tema> findLikeNombre(String nombre) {
		return temaRepository.findLikeNombre(nombre);
	}
}
