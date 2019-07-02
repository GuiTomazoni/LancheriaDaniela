package br.com.fundatec.lancheria.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fundatec.lancheria.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{

	Cliente findByNomeIgnoringCase(String nome);
}
