package com.lemos.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemos.cursomc.domain.Produto;
import com.lemos.cursomc.repository.ProdutoRepository;
import com.lemos.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto buscar(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado !: " + id + ", Tipo: " + Produto.class.getName()));
	}

}
