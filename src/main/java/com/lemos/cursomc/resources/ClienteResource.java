package com.lemos.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lemos.cursomc.domain.Cliente;
import com.lemos.cursomc.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService; 
	
	@RequestMapping(value="/cadastro",method = RequestMethod.POST)
	public ResponseEntity<Void> cadastro(@RequestBody Cliente cliente){
		clienteService.cadastro(cliente);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{id}",  method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){		
		Cliente obj = clienteService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<Client>> buscarTodos(){
//		List<Client> lista = clientService.buscarTodos();
//		return ResponseEntity.ok().body(lista);
//	}

}
