package com.lemos.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lemos.cursomc.domain.Produto;
import com.lemos.cursomc.service.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> buscar(@PathVariable Integer id){
		Produto obj = produtoService.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
