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
	
	public Pedido salvar(Pedido pedido, List<Comanda> itensPedidos) {
		pedido = pedidoRepository.save(pedido);
		for(Comanda comanda : itensPedidos) {
			comanda.setPedido(pedido);
			comandaService.salvar(comanda);
		}
		pedido.setItensPedidos(comandaService.buscarPorPedido(pedido));
		return pedido;
	}

	public List<Pedido> listarPedidos() {
		return (List<Pedido>) pedidoRepository.findAll();
	}
}
