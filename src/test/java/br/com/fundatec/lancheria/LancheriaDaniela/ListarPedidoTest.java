package br.com.fundatec.lancheria.LancheriaDaniela;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fundatec.lancheria.dto.PedidoOutputDto;
import br.com.fundatec.lancheria.entity.Cliente;
import br.com.fundatec.lancheria.entity.Comanda;
import br.com.fundatec.lancheria.entity.Item;
import br.com.fundatec.lancheria.entity.Pedido;
import br.com.fundatec.lancheria.repository.ClienteRepository;
import br.com.fundatec.lancheria.repository.ComandaRepository;
import br.com.fundatec.lancheria.repository.ItemRepository;
import br.com.fundatec.lancheria.repository.PedidoRepository;
import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ListarPedidoTest {

	@LocalServerPort
	private int port;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ComandaRepository comandaRepository;
	private Cliente cliente;
	private Item CocaCola;
	private Item Xis;
	
	@Before
	public void setUp() {
		RestAssured.port = port;
		RestAssured.baseURI = "http://localhost";
		comandaRepository.deleteAll();
		pedidoRepository.deleteAll();
		itemRepository.deleteAll();
		clienteRepository.deleteAll();
		cliente = clienteRepository.save(new Cliente(null, "Guilherme", "51981932166", "Fundatec"));		
	}
	
	@Test
	public void deveBuscarUmaListaDePedidos() {
		Xis = itemRepository.save(new Item("Xis-Carne", new Double(14.00)));
		CocaCola = itemRepository.save(new Item("Coca-cola", new Double(4.50)));
		Comanda item1 = new Comanda(1, Xis);
		Comanda item2 = new Comanda(2, CocaCola);
		comandaRepository.save(item1);
		comandaRepository.save(item2);
		Pedido pedido = pedidoRepository.save(new Pedido(null, null, cliente.getEndereco(), cliente));
		item1.setPedido(pedido);
		item2.setPedido(pedido);
		
		
		PedidoOutputDto[] pedidosOutputDto = RestAssured
		.given()
		.when()
		.get("/v1/pedidos")
		.then()
		.statusCode(HttpStatus.OK.value())
		.extract().as(PedidoOutputDto[].class);
		
		Assert.assertTrue(pedidoRepository.count() > 0);
		
//		for (PedidoOutputDto pedidoOutputDto : pedidosOutputDto) {
//			Assert.assertEquals(Xis.getId(), pedidoOutputDto.getItens().get(0).getId());
//			Assert.assertEquals(1, pedidoOutputDto.getItens().get(0).getQuantidade().intValue());
//			Assert.assertEquals(CocaCola.getId(), pedidoOutputDto.getItens().get(1).getId());
//			Assert.assertEquals(2, pedidoOutputDto.getItens().get(1).getQuantidade().intValue());
//		}
		
	}
}
