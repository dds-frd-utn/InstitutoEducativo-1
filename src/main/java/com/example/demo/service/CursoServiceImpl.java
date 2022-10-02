package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Curso;
import com.example.demo.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	CursoRepository cursoRepository;

	@Override
	public List<Curso> findAllCurso() {
		return cursoRepository.findAll();
	}	
	
	@Override
	public Optional<Curso> findCursoById(Long id) {
		return cursoRepository.findById(id);
	}

	@Override
	public Curso saveCurso(Curso newCurso) {
		return cursoRepository.save(newCurso);
	}

	@Override
	public String updateCurso(Curso curso) {
		if (cursoRepository.findById(curso.getId()) != null) {
			cursoRepository.save(curso);
			return "OK";
		}
		return "ERROR: el id no existe";
	}
	@Override
	public String deleteCurso(Long id) {
		if (cursoRepository.findById(id) != null) {
			cursoRepository.deleteById(id);
			return "OK";
		}
		return "ERROR: el id no existe";
	}

	
}