package br.com.fundatec.lancheria.service;

import org.springframework.stereotype.Service;

import br.com.fundatec.lancheria.entity.Comanda;
import br.com.fundatec.lancheria.repository.ComandaRepository;

@Service
public class ComandaService {

	private ComandaRepository comandaRepository;

	public ComandaService(ComandaRepository comandaRepository) {
		this.comandaRepository = comandaRepository;
	}
	
	public Comanda salvar(Comanda comanda) {
		return comandaRepository.save(comanda);		
	}
}
