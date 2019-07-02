package br.com.fundatec.lancheria.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fundatec.lancheria.dto.PedidoInputDto;
import br.com.fundatec.lancheria.dto.PedidoOutputDto;
import br.com.fundatec.lancheria.entity.Pedido;
import br.com.fundatec.lancheria.mapper.PedidoMapper;
import br.com.fundatec.lancheria.service.PedidoService;


@RestController
public class LancheriaController {
	
	private PedidoService pedidoService;
	private PedidoMapper pedidoMapper;
	
	public LancheriaController(PedidoService pedidoService, PedidoMapper pedidoMapper) {
		this.pedidoService = pedidoService;
		this.pedidoMapper = pedidoMapper;
	}



	@PostMapping("/v1/pedidos")
	public ResponseEntity<?> incluirPedido(@Valid @RequestBody PedidoInputDto pedidoInputDto){
		Pedido pedido = pedidoMapper.mapearPedido(pedidoInputDto);
		pedido = pedidoService.salvar(pedido, pedido.getItensPedidos());
		PedidoOutputDto pedidoOutputDto = pedidoMapper.mapearPedidoOutputDto(pedido);

		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoOutputDto);
	}
}
