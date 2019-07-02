package br.com.fundatec.lancheria.LancheriaDaniela;

import org.apache.http.HttpHeaders;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fundatec.lancheria.dto.PedidoOutputDto;
import br.com.fundatec.lancheria.entity.Cliente;
import br.com.fundatec.lancheria.entity.Item;
import br.com.fundatec.lancheria.entity.Pedido;
import br.com.fundatec.lancheria.repository.ClienteRepository;
import br.com.fundatec.lancheria.repository.ComandaRepository;
import br.com.fundatec.lancheria.repository.ItemRepository;
import br.com.fundatec.lancheria.repository.PedidoRepository;
import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IncluirPedidoTest {

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
	private Item Heineken;
	private Item CachorroQuente;
	private Item Xis;
	
	@Before
	public void setup() {
		RestAssured.port = port;
		RestAssured.baseURI = "http://localhost";
		comandaRepository.deleteAll();
		pedidoRepository.deleteAll();
		itemRepository.deleteAll();
		clienteRepository.deleteAll();
		cliente = clienteRepository.save(new Cliente(null, "Guilherme", "51981932166", "Fundatec"));
		CocaCola = itemRepository.save(new Item("Coca-cola", new Double(4.50)));
		Heineken = itemRepository.save(new Item("Heineken", new Double(12.00)));
		CachorroQuente = itemRepository.save(new Item("Cachorro Quente", new Double(9.00)));
		Xis = itemRepository.save(new Item("Xis-Carne", new Double(14.00)));
	}
	
	@Test
	public void deveIncluirPedidoNoLocal() {
		
		PedidoOutputDto pedidoOutputDto = RestAssured
		.given()
		.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		.body("{"+ 
				"	\"itensPedidos\": [{" + 
				"		\"id\": " + CocaCola.getId() + "," + 
				"		\"quantidade\": 2" + 
				"	}, {" + 
				"		\"id\":" + Xis.getId() + ","+ 
				"		\"quantidade\": 6" + 
				"	}]," + 
				"	\"entrega\": \"Local\"," + 
				"	\"cliente\": \"" + cliente.getNome() + "\" " +
				"}")
		.when()
		.post("/v1/pedidos")
		.then()
		.assertThat()
		.statusCode(HttpStatus.CREATED.value())
		.extract().as(PedidoOutputDto.class);
		
		Assert.assertTrue(pedidoRepository.count() > 0);
		Assert.assertTrue(pedidoOutputDto.getId() > 0);
		
		Assert.assertEquals(CocaCola.getId(), pedidoOutputDto.getItens().get(0).getId());
		Assert.assertEquals(2, pedidoOutputDto.getItens().get(0).getQuantidade().intValue());
		
		Assert.assertEquals(Xis.getId(), pedidoOutputDto.getItens().get(1).getId());
		Assert.assertEquals(6, pedidoOutputDto.getItens().get(1).getQuantidade().intValue());
		
		Assert.assertEquals("Local", pedidoOutputDto.getEntrega());
		
	}
}
