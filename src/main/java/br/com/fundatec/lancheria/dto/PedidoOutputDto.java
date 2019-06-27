package br.com.fundatec.lancheria.dto;

import java.util.List;

import br.com.fundatec.lancheria.entity.Cliente;
import br.com.fundatec.lancheria.entity.Item;
import br.com.fundatec.lancheria.entity.Comanda;

public class PedidoOutputDto {
	
	private Long id;
	private List<Comanda> itensPedidos;
	private String entrega;
	private Cliente cliente;
	
	public PedidoOutputDto() {
		
	}

	public PedidoOutputDto(Long id, List<Comanda> itensPedidos, String entrega, Cliente cliente) {
		this.id = id;
		this.itensPedidos = itensPedidos;
		this.entrega = entrega;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
