package analista.teste;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import analista.teste.entities.TesteJson;
import io.restassured.RestAssured;
import io.restassured.response.Response;

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

		// Pega arquivo json na pasta resources
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("teste2.json").getFile());
		String expectedData = FileUtils.readFileToString(file, "UTF-8");

		// Transforma arquivo em objeto
		Gson gson = new Gson();
		TesteJson t2 = gson.fromJson(expectedData, TesteJson.class); // deserializes json into t2

		Response response = RestAssured.get();
		response.then().assertThat().body("userId", equalTo(t2.getUserId())).body("id", equalTo(t2.getId()))
				.body("title", equalTo(t2.getTitle())).body("completed", equalTo(t2.isCompleted()));

	}

	/*
	 * Cenário 2: Compara os valores do response
	 */
	@Test
	public void testResponseComArquivo() {

		Response response = RestAssured.get();
		response.then().assertThat().body("userId", equalTo(1)).body("id", equalTo(1))
				.body("title", equalTo("delectus aut autem")).body("completed", equalTo(false));

	}

}
