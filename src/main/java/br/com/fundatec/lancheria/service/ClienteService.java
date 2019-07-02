package br.com.fundatec.lancheria.service;

import org.springframework.stereotype.Service;

import br.com.fundatec.lancheria.entity.Cliente;
import br.com.fundatec.lancheria.repository.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente buscar(String nome) {
		return clienteRepository.findByNomeIgnoringCase(nome);
	}
	
}
