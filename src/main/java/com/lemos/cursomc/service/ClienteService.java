package com.lemos.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemos.cursomc.domain.Categoria;
import com.lemos.cursomc.domain.Cliente;
import com.lemos.cursomc.repository.ClienteRepository;
import com.lemos.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clientRepository;
	
	public Cliente buscar(Integer id) {
		
		Optional<Cliente> obj =  clientRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado !: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
