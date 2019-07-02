package br.com.fundatec.lancheria.dto;

public class ItemPedidoDto {

	private Long id;
	private Integer quantidade;
	
	
	
	public ItemPedidoDto() {
	}


	public ItemPedidoDto(Long id, Integer quantidade) {
		this.id = id;
		this.quantidade = quantidade;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
