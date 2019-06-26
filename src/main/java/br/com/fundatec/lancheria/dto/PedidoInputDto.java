package br.com.fundatec.lancheria.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class PedidoInputDto {

	public String lanche;
	public String bebida;
	@PositiveOrZero(message = "O valor deve ser maior ou igual a zero")
	public Double valor;
	@NotBlank(message = "O campo Entrega deve ser preenchido")
	public String entrega;
	
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
