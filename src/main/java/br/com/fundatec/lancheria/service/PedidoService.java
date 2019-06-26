package br.com.fundatec.lancheria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fundatec.lancheria.entity.Pedido;
import br.com.fundatec.lancheria.repository.PedidoRepository;

@Service
public class PedidoService {

	private PedidoRepository pedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	public List<Pedido> listar(String nome){
		return pedidoRepository.findByNomeContainingIgnoringCase(nome);
	}
	
	public Pedido salvar(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
}
