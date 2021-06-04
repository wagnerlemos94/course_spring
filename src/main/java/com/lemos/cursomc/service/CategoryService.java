package com.lemos.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.lemos.cursomc.domain.Categoria;
import com.lemos.cursomc.repository.CategoriaRepository;
import com.lemos.cursomc.service.exceptions.DataIntegrityException;
import com.lemos.cursomc.service.exceptions.ObjectNotFoundException;


@Service
public class CategoryService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {	
		Optional<Categoria> obj =  repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado !: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		List<Categoria> lista =  repo.findAll();
		return lista;
	}
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {			
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("NÃO E POSSÍVEL EXCLUIR UMA CATEGORIA QUE POSSUI PRODUTOS");
		}
	}
	

}
