package br.com.fundatec.lancheria.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fundatec.lancheria.entity.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long>{

	List<Pedido> findByNomeContainingIgnoringCase(String nome);
}
