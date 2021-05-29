package com.lemos.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemos.cursomc.domain.Category;
import com.lemos.cursomc.domain.Client;
import com.lemos.cursomc.repository.ClientRepository;
import com.lemos.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client buscar(Integer id) {
		
		Optional<Client> obj =  clientRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado !: " + id + ", Tipo: " + Category.class.getName()));
	}

}
