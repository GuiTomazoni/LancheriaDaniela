package br.com.fundatec.lancheria.service;

import org.springframework.stereotype.Service;

import br.com.fundatec.lancheria.entity.Item;
import br.com.fundatec.lancheria.repository.ItemRepository;

@Service
public class ItemService {

	private ItemRepository itemRepository;
	
	
	
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}



	public Item buscar(Long id) {
		return itemRepository.findById(id).orElse(null);
	}
}
