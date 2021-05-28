package com.lemos.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemos.cursomc.domain.Category;
import com.lemos.cursomc.repository.CategoryRepository;
import com.lemos.cursomc.service.exceptions.ObjectNotFoundException;


@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category buscar(Integer id) {	
		Optional<Category> obj =  categoryRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado !: " + id + ", Tipo: " + Category.class.getName()));
	}
	
	public List<Category> buscarTodos(){
		List<Category> lista =  categoryRepository.findAll();
		return lista;
	}
	

}
