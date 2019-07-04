package br.com.fundatec.lancheria.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fundatec.lancheria.dto.ItemPedidoDto;
import br.com.fundatec.lancheria.dto.PedidoInputDto;
import br.com.fundatec.lancheria.dto.PedidoOutputDto;
import br.com.fundatec.lancheria.entity.Comanda;
import br.com.fundatec.lancheria.entity.Pedido;
import br.com.fundatec.lancheria.service.ClienteService;

@Component
public class PedidoMapper {

	private ComandaMapper comandaMapper;
	private ClienteService clienteService;

	

	public PedidoMapper(ComandaMapper comandaMapper, ClienteService clienteService) {
		this.comandaMapper = comandaMapper;
		this.clienteService = clienteService;
	}

	public PedidoOutputDto mapearPedidoOutputDto (Pedido pedido) {
		List<ItemPedidoDto> itensPedidos = comandaMapper.mapearItem(pedido.getItensPedidos());
		return new PedidoOutputDto(
				pedido.getId(),
				itensPedidos,
				pedido.getOrigemDoPedido(),
				pedido.getCliente().getNome()
				);
	}
	
	public Pedido mapearPedido (PedidoInputDto pedidoInputDto) {
		List<Comanda> itensPedidos = comandaMapper.mapearComanda(pedidoInputDto.getItensPedidos());
		return new Pedido(null,
				itensPedidos,
				pedidoInputDto.getEntrega(),
				clienteService.buscar(pedidoInputDto.getCliente())
				);
	}

	public List<PedidoOutputDto> mapearListaPedidoOutputDto(List<Pedido> listaPedidos) {
		List<PedidoOutputDto> pedidosOutputDto = new ArrayList<>();
		for(int i = 0; i < listaPedidos.size(); i++) {
			List<ItemPedidoDto> itensPedidos = comandaMapper.mapearItem(listaPedidos.get(i).getItensPedidos());
			Long id = listaPedidos.get(i).getId();
			String origem = listaPedidos.get(i).getOrigemDoPedido();
			String nome = listaPedidos.get(i).getCliente().getNome();
			PedidoOutputDto pedidoOutputDto = new PedidoOutputDto(id, itensPedidos, origem, nome);
			pedidosOutputDto.add(pedidoOutputDto);
		}
		return pedidosOutputDto;
	}
}
