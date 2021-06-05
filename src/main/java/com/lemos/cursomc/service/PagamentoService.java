package com.lemos.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemos.cursomc.domain.Pagamento;
import com.lemos.cursomc.repository.PagamentoRepository;
import com.lemos.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public Pagamento find(Integer id) {
		Optional<Pagamento> obj = pagamentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado !: " + id + ", Tipo: " + Pagamento.class.getName()));
	}

}
