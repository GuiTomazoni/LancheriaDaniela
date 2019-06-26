package br.com.fundatec.lancheria.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String lanche;
	private String bebida;
	private Double valor;	
	private String origemDoPedido;
	
	public Pedido() {
		
	}

	public Pedido(Long id, String lanche, String bebida, Double valor, String origemDoPedido) {
		this.id = id;
		this.lanche = lanche;
		this.bebida = bebida;
		this.valor = valor;
		this.origemDoPedido = origemDoPedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLanche() {
		return lanche;
	}

	public void setLanche(String lanche) {
		this.lanche = lanche;
	}
	
	public String getBebida() {
		return bebida;
	}
	
	public void setBebida(String bebida) {
		this.bebida = bebida;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getOrigemDoPedido() {
		return origemDoPedido;
	}

	public void setOrigemDoPedido(String origemDoPedido) {
		this.origemDoPedido = origemDoPedido;
	}
		
}
