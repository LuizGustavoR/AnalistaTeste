package analista.teste;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

/**
 * Unit test for simple App.
 */
public class Teste_2 {

	@Before
	public void setup() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.basePath = "/todos/1";
//	    RestAssured.port = 443;
	}

	/*
	 * Cenário 1: Compara response com arquivo
	 */
	@Test
	public void testResponseValues() throws IOException {
		
		ClassLoader classLoader = getClass().getClassLoader();
	    File file = new File(classLoader.getResource("teste2.json").getFile());
	    String expectedData = FileUtils.readFileToString(file, "UTF-8");

		Response response = RestAssured.get();

		assertEquals(expectedData, response.asString().trim());

	}

	/*
	 * Cenário 2: Compara os valores do response
	 */
	@Test
	public void testResponseComArquivo() {
		
		Response response = RestAssured.get();
		response.then().assertThat()
		.body("userId", equalTo(1))
        .body("id", equalTo(1))
        .body("title", equalTo("delectus aut autem"))
        .body("completed", equalTo(false));
		
	}

}
