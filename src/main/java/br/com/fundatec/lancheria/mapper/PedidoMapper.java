package br.com.fundatec.lancheria.mapper;

import org.springframework.stereotype.Component;

import br.com.fundatec.lancheria.dto.PedidoInputDto;
import br.com.fundatec.lancheria.dto.PedidoOutputDto;
import br.com.fundatec.lancheria.entity.Pedido;

@Component
public class PedidoMapper {

	public PedidoOutputDto mapearPedidoOutputDto (Pedido pedido) {
		return new PedidoOutputDto(
				pedido.getId(),
				pedido.getLanche(),
				pedido.getBebida(),
				pedido.getValor(),
				pedido.getOrigemDoPedido()
				);
	}
	
	public Pedido mapearPedido (PedidoInputDto pedidoInputDto) {
		return new Pedido(null,
				pedidoInputDto.getLanche(),
				pedidoInputDto.getBebida(),
				pedidoInputDto.getValor(),
				pedidoInputDto.getEntrega()
				);
	}
}
