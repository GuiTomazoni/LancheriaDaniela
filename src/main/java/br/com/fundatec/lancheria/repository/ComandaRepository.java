package br.com.fundatec.lancheria.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fundatec.lancheria.entity.Comanda;
import br.com.fundatec.lancheria.entity.Pedido;

@Repository
public interface ComandaRepository extends CrudRepository<Comanda, Long>{

	List<Comanda> findByPedido(Pedido pedido);
}
