package br.com.fundatec.lancheria.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import br.com.fundatec.lancheria.entity.Cliente;
import br.com.fundatec.lancheria.entity.Item;
import br.com.fundatec.lancheria.entity.Comanda;

public class PedidoInputDto {

	private List<ItemPedidoDto> itensPedidos;
	@NotBlank(message = "O campo Entrega deve ser preenchido")
	public String entrega;
	public String cliente;
	
	public PedidoInputDto(List<ItemPedidoDto> itensPedidos,
			@NotBlank(message = "O campo Entrega deve ser preenchido") String entrega, String cliente) {
		this.itensPedidos = itensPedidos;
		this.entrega = entrega;
		this.cliente = cliente;
	}

	public PedidoInputDto() {
		
	}

	public List<ItemPedidoDto> getItensPedidos() {
		return itensPedidos;
	}

	public void setItensPedidos(List<ItemPedidoDto> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}

	public String getEntrega() {
		return entrega;
	}

	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	
	
	
	
}
