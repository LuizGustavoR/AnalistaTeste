package analista.teste;

import database.DB;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		System.out.println("Hello World!");

		DB dados = new DB();

		for (int i = 0; i < 5; i++) {
			System.out.println(dados.getDiretores().get(i));
		}

	}
}
