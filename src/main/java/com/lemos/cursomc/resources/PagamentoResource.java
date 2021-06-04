package com.lemos.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lemos.cursomc.domain.Pagamento;
import com.lemos.cursomc.service.PagamentoService;

@RestController
@RequestMapping(value="/pagamentos")
public class PagamentoResource {

	@Autowired
	private PagamentoService pagamentoService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pagamento> buscar(@PathVariable Integer id){
		Pagamento obj = pagamentoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
