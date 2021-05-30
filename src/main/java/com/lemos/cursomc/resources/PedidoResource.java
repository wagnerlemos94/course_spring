package com.lemos.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lemos.cursomc.domain.Pedido;
import com.lemos.cursomc.service.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(value="/{id}")
	public ResponseEntity<Pedido> buscar(@PathVariable Integer id){
		Pedido obj = pedidoService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
