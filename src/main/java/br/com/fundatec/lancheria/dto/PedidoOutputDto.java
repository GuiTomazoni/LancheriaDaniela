package br.com.fundatec.lancheria.dto;

public class PedidoOutputDto {
	
	private Long id;
	private String lanche;
	private String bebida;
	private Double valor;
	private String entrega;
	
	public PedidoOutputDto() {
		
	}	

	public PedidoOutputDto(Long id, String lanche, String bebida, Double valor, String entrega) {
		this.id = id;
		this.lanche = lanche;
		this.bebida = bebida;
		this.valor = valor;
		this.entrega = entrega;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
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

	public String getEntrega() {
		return entrega;
	}

	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}
	
	
}
