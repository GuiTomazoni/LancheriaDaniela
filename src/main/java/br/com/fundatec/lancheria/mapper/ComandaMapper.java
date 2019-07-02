package br.com.fundatec.lancheria.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;import br.com.fundatec.lancheria.dto.ItemPedidoDto;
import br.com.fundatec.lancheria.dto.PedidoInputDto;
import br.com.fundatec.lancheria.entity.Comanda;
import br.com.fundatec.lancheria.entity.Item;
import br.com.fundatec.lancheria.service.ItemService;

@Component
public class ComandaMapper {

	private ItemService itemService;
	
	
	public ComandaMapper(ItemService itemService) {
		this.itemService = itemService;
	}


	public List<Comanda> mapearComanda(List<ItemPedidoDto> itensPedidos) {
		List<Comanda> comandas = new ArrayList<>();
		for(int i = 0; i < itensPedidos.size(); i++) {
			Item item = itemService.buscar(itensPedidos.get(i).getId());
			Integer quantidade = itensPedidos.get(i).getQuantidade();	
			Comanda comanda = new Comanda(quantidade, item);
			comandas.add(comanda);
		}
		return comandas;
	}
	
	public List<ItemPedidoDto> mapearItem(List<Comanda> comandas){
		List<ItemPedidoDto> itensPedidosDto = new ArrayList<>();
		for(int i = 0; i < comandas.size(); i++) {
			Long id = comandas.get(i).getItem().getId();
			Integer quantidade = comandas.get(i).getQuantidade();
			ItemPedidoDto itemPedidoDto = new ItemPedidoDto (id, quantidade);
			itensPedidosDto.add(itemPedidoDto);
		}
		return itensPedidosDto;
	}
}
