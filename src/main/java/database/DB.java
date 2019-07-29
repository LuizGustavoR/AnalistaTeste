package database;

import java.util.ArrayList;

import analista.teste.entities.Diretor;
import analista.teste.entities.Filme;

public class DB {
	
	private ArrayList<Diretor> diretores;
	private ArrayList<Filme> filmes;

	public DB() {
		super();
		generateData();
	}

	private void generateData() {
		
		diretores = new ArrayList<Diretor>();
		filmes = new ArrayList<Filme>();
		
		filmes.add(new Filme("Laranja Mecânica", "1971"));
		filmes.add(new Filme("2001: Uma Odisséia no Espaço", "1968"));
		filmes.add(new Filme("O Iluminado", "1980"));
		diretores.add(new Diretor(0, "Stanley Kubrick", "26-07-1928", new ArrayList<Filme>(filmes)));
		
		filmes.clear();
		
		filmes.add(new Filme("O Lobo de Wall Street", "2013"));
		filmes.add(new Filme("A Invenção de Hugo Cabret", "2011"));
		filmes.add(new Filme("Ilha do Medo", "2010"));
		diretores.add(new Diretor(1, "Martin Scorsese", "17-11-1942", new ArrayList<Filme>(filmes)));

		filmes.clear();
		
		filmes.add(new Filme("E.T.: O Extraterrestre", "1982"));
		filmes.add(new Filme("Tubarão", "1975"));
		filmes.add(new Filme("Indiana Jones e os Caçadores da Arca Perdida", "1981"));
		diretores.add(new Diretor(2, "Steven Spielberg", "18-12-1946", new ArrayList<Filme>(filmes)));
		
		filmes.clear();
		
		filmes.add(new Filme("Django Livre", "2012"));
		filmes.add(new Filme("Bastardos Inglórios", "2009"));
		filmes.add(new Filme("Kill Bill: Volume 1", "2003"));
		diretores.add(new Diretor(3, "Quentin Tarantino", "27-03-1963", new ArrayList<Filme>(filmes)));
		
		filmes.clear();
		
		filmes.add(new Filme("O Exterminador do Futuro", "1984"));
		filmes.add(new Filme("Titanic", "1997"));
		filmes.add(new Filme("Avatar", "2009"));
		diretores.add(new Diretor(4, "James Cameron", "16-08-1954", new ArrayList<Filme>(filmes)));
		
	}

	public ArrayList<Diretor> getDiretores() {
		return diretores;
	}

	public void setDiretores(ArrayList<Diretor> diretores) {
		this.diretores = diretores;
	}

	public ArrayList<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(ArrayList<Filme> filmes) {
		this.filmes = filmes;
	}

}