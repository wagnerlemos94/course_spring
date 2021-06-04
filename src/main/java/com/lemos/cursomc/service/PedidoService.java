package com.lemos.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemos.cursomc.domain.Categoria;
import com.lemos.cursomc.domain.Pedido;
import com.lemos.cursomc.repository.PedidoRepository;
import com.lemos.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado !: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
}
