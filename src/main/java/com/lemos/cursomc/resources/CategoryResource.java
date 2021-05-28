package com.lemos.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lemos.cursomc.domain.Category;
import com.lemos.cursomc.service.CategoryService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService; 
	
	@RequestMapping(value = "/{id}",  method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){		
		Category obj = categoryService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Category>> buscarTodos(){
		List<Category> lista = categoryService.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}

}
