package br.com.fundatec.lancheria.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comanda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "idPedido")
	private Pedido pedido;
	private Integer quantidadeDeItens;
	@ManyToOne
	@JoinColumn(name = "idItem")
	private Item item;

	public Comanda() {

	}

	public Comanda(Pedido pedido, Integer quantidade, Item item) {
		this.pedido = pedido;
		this.quantidadeDeItens = quantidade;
		this.item = item;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getQuantidade() {
		return quantidadeDeItens;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidadeDeItens = quantidade;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
