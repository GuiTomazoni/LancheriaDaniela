package br.com.fundatec.lancheria.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fundatec.lancheria.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{

}
