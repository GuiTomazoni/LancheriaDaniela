package br.com.fundatec.lancheria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fundatec.lancheria.entity.Comanda;
import br.com.fundatec.lancheria.entity.Pedido;
import br.com.fundatec.lancheria.repository.PedidoRepository;

@Service
public class PedidoService {

	private PedidoRepository pedidoRepository;
	private ComandaService comandaService;

	
	
	public PedidoService(PedidoRepository pedidoRepository, ComandaService comandaService) {
		this.pedidoRepository = pedidoRepository;
		this.comandaService = comandaService;
	}

	public List<Pedido> listarPedidosPorNomeDeCliente(String nome){
		return null; //pedidoRepository.findByNomeContainingIgnoringCase(nome);
	}
	
	public Pedido salvar(Pedido pedido) {
		pedido = pedidoRepository.save(pedido);
		for(Comanda comanda : pedido.getComandas()) {
			comandaService.salvar(comanda);
		}
		return pedido;
	}
}
