package br.com.fundatec.lancheria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fundatec.lancheria.dto.PedidoInputDto;
import br.com.fundatec.lancheria.dto.PedidoOutputDto;
import br.com.fundatec.lancheria.entity.Pedido;
import br.com.fundatec.lancheria.mapper.PedidoMapper;
import br.com.fundatec.lancheria.service.PedidoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class LancheriaController {
	
	private PedidoService pedidoService;
	private PedidoMapper pedidoMapper;
	
	public LancheriaController(PedidoService pedidoService, PedidoMapper pedidoMapper) {
		this.pedidoService = pedidoService;
		this.pedidoMapper = pedidoMapper;
	}
	
	@GetMapping("/v1/pedidos")
	@ApiOperation(value = "Listar todos os pedidos", notes = "Lista todos os pedidos cadastrados")
	public ResponseEntity<List<PedidoOutputDto>> getPedidos(@RequestParam(defaultValue = "")Pedido pedidos){
		List<Pedido> listaPedidos = pedidoService.listarPedidos();
		List<PedidoOutputDto> listaPedidoDto = pedidoMapper.mapearListaPedidoOutputDto(listaPedidos);
		return ResponseEntity.status(HttpStatus.OK).body(listaPedidoDto);
	}



	@PostMapping("/v1/pedidos")
	@ApiOperation(value = "Inclui um novo pedido", notes = "Inclui um novo pedido no banco")
	public ResponseEntity<?> incluirPedido(@Valid @RequestBody PedidoInputDto pedidoInputDto){
		Pedido pedido = pedidoMapper.mapearPedido(pedidoInputDto);
		pedido = pedidoService.salvar(pedido, pedido.getItensPedidos());
		PedidoOutputDto pedidoOutputDto = pedidoMapper.mapearPedidoOutputDto(pedido);

		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoOutputDto);
	}
}
