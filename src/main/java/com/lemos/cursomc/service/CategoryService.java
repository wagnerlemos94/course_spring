package com.lemos.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemos.cursomc.domain.Categoria;
import com.lemos.cursomc.repository.CategoriaRepository;
import com.lemos.cursomc.service.exceptions.ObjectNotFoundException;


@Service
public class CategoryService {
	
	@Autowired
	private CategoriaRepository categoryRepository;
	
	public Categoria buscar(Integer id) {	
		Optional<Categoria> obj =  categoryRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado !: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> buscarTodos(){
		List<Categoria> lista =  categoryRepository.findAll();
		return lista;
	}
	

}
