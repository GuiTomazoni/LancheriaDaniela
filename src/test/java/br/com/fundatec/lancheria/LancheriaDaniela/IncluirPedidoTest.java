package br.com.fundatec.lancheria.LancheriaDaniela;

import org.apache.http.HttpHeaders;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IncluirPedidoTest {

	@LocalServerPort
	private int port;
	
	@Before
	public void setup() {
		RestAssured.port = port;
		RestAssured.baseURI = "http://localhost";
	}
	
	@Test
	public void deveIncluirPedidoPorTelefone() {
		RestAssured
		.given()
		.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		.body("{" + 
				"	\"Lanche\": \"Cachorro quente\"," + 
				"	\"Bebida\": \"Pepsi lata\"," + 
				"	\"Valor\": 15," +
				"   \"Entrega\": \"Local\" " +
				"}")
		.when()
		.post("/v1/pedidos")
		.then()
		.assertThat()
		.body("Lanche", Matchers.equalTo("Cachorro quente"))
		.body("Bebida", Matchers.equalTo("Pepsi lata"))
		.body("Valor", Matchers.equalTo(15))
		.body("Entrega", Matchers.equalTo("Local"))
		.body("id", Matchers.greaterThan(0))
		.statusCode(HttpStatus.CREATED.value());
		
	}
}
