package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Cursos;
import com.projetojpa.repository.CursosRepository;


@Service
public class CursosService {
    private final CursosRepository cursosRepository;

    @Autowired
    public CursosService(CursosRepository cursosRepository) {
        this.cursosRepository = cursosRepository;
    }
    public List<Cursos> buscaTodosCursos() {
        return cursosRepository.findAll();  
    }
    public Cursos buscaCursosId(Long id) {
    	Optional <Cursos> cursos = cursosRepository.findById(null);
    	return cursos.orElse(null);
    }
    public Cursos SalvaCursos(Cursos cursos) {
    	return cursosRepository.save(cursos);
    }
    public Cursos alterarCursos (Long id, Cursos alterarCur) {
    	Optional <Cursos> existeCursos = cursosRepository.findById(id);
    	if (existeCursos.isPresent()) {
    		alterarCur.setId(id);
    		return cursosRepository.save(alterarCur);
    	}
    	return null;
}
    public boolean apagarCursos(Long id) {
    	Optional <Cursos> existeCursos = cursosRepository.findById(id);
		if(existeCursos.isPresent()) {
    		cursosRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }
}