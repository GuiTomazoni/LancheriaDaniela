package br.com.fundatec.lancheria.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "item")
	private List<Comanda> itensPedidos;
	private String origemDoPedido;
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

	public Pedido() {

	}
	
	public Pedido(Long id, List<Comanda> itensPedidos, String origemDoPedido, Cliente cliente) {
		this.id = id;
		this.itensPedidos = itensPedidos;
		this.origemDoPedido = origemDoPedido;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Comanda> getItensPedidos() {
		return itensPedidos;
	}

	public void setItensPedidos(List<Comanda> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}

	public String getOrigemDoPedido() {
		return origemDoPedido;
	}

	public void setOrigemDoPedido(String origemDoPedido) {
		this.origemDoPedido = origemDoPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	

}