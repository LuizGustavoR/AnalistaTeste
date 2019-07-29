package analista.teste;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import analista.teste.entities.Diretor;
import database.DB;

/**
 * Unit test for alelo.
 */
public class Teste_1 {

	private static WebDriver driver;
	private static DB myDatabase;
	private static String baseUrl = "https://www.google.com/";

	@BeforeClass
	public static void setUpTest() {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		driver = new ChromeDriver();
		myDatabase = new DB();
	}

	@AfterClass
	public static void tearDownTest() {
		driver.close();
		driver.quit();
	}

	/*
	 * Cenário 1: Stanley Kubrick e Laranja Mecânica
	 */
	@Test
	public void testStanleyOrange() {

		driver.get(baseUrl);

		Diretor dir = myDatabase.getDiretores().get(0);
		String searchFor = dir.getNome() + " e " + dir.getFilmes().get(0).getNome();
		String resultadoPesquisa = callChromeDriver(searchFor);
		System.out.println(resultadoPesquisa);

		resultadoPesquisa = resultadoPesquisa.split(" ")[1];
		assertEquals(resultadoPesquisa, "123.000");

	}
	
	/*
	 * Cenário 2: Martin Scorsese e O Lobo de Wall Street
	 */
	@Test
	public void testMartinWolf() {

		driver.get(baseUrl);

		Diretor dir = myDatabase.getDiretores().get(1);
		String searchFor = dir.getNome() + " e " + dir.getFilmes().get(0).getNome();
		String resultadoPesquisa = callChromeDriver(searchFor);
		System.out.println(resultadoPesquisa);

		resultadoPesquisa = resultadoPesquisa.split(" ")[1];
		assertEquals(resultadoPesquisa, "409.000");

	}
	
	/*
	 * Cenário 3: Quentin Tarantino e Bastardos Inglórios
	 */
	@Test
	public void testQuentinBastard() {

		driver.get(baseUrl);

		Diretor dir = myDatabase.getDiretores().get(3);
		String searchFor = dir.getNome() + " e " + dir.getFilmes().get(1).getNome();
		String resultadoPesquisa = callChromeDriver(searchFor);
		System.out.println(resultadoPesquisa);

		resultadoPesquisa = resultadoPesquisa.split(" ")[1];
		assertEquals(resultadoPesquisa, "114.000");

	}
	
	/*
	 * Cenário 4: James Cameron e Avatar
	 */
	@Test
	public void testJamesAvatar() {

		driver.get(baseUrl);

		Diretor dir = myDatabase.getDiretores().get(4);
		String searchFor = dir.getNome() + " e " + dir.getFilmes().get(2).getNome();
		String resultadoPesquisa = callChromeDriver(searchFor);
		System.out.println(resultadoPesquisa);

		resultadoPesquisa = resultadoPesquisa.split(" ")[1];
		assertEquals(resultadoPesquisa, "50.300.000");

	}

	private String callChromeDriver(String searchFor) {

		WebElement element = driver.findElement(By.name("q"));

		element.sendKeys(searchFor);
		element.sendKeys(Keys.RETURN);

		return driver.findElement(By.id("resultStats")).getText();

	}

}
