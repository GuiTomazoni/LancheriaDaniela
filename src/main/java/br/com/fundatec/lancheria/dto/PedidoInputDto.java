package br.com.fundatec.lancheria.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import br.com.fundatec.lancheria.entity.Cliente;
import br.com.fundatec.lancheria.entity.Item;
import br.com.fundatec.lancheria.entity.Comanda;

public class PedidoInputDto {

	private List<Comanda> itensPedidos;
	@NotBlank(message = "O campo Entrega deve ser preenchido")
	public String entrega;
	public Cliente cliente;
	
	public PedidoInputDto() {
		
	}
	
	public PedidoInputDto(List<Comanda> itensPedidos, @NotBlank(message = "O campo Entrega deve ser preenchido") String entrega,
			Cliente cliente) {
		this.itensPedidos = itensPedidos;
		this.entrega = entrega;
		this.cliente = cliente;
	}
	
	public List<Comanda> getItens() {
		return itensPedidos;
	}
	
	public void setItens(List<Comanda> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}
	
	public String getEntrega() {
		return entrega;
	}
	
	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}
