package analista.teste.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Diretor {
	
	private int id;
	private String nome;
	private Date dataNascimento;
	private ArrayList<Filme> filmes;
	
	public Diretor(int id, String nome, String dataNascimento, ArrayList<Filme> filmes) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = parseDate(dataNascimento);
		this.filmes = filmes;
	}
	
	public Diretor(int id, String nome, String dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = parseDate(dataNascimento);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = parseDate(dataNascimento);
	}

	public ArrayList<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(ArrayList<Filme> filmes) {
		this.filmes = filmes;
	}
	
	private Date parseDate(String date) {
		try {
			return new SimpleDateFormat("dd-MM-yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String printDate(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		month++;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return day + "-" + month + "-" + year;
	}

	@Override
	public String toString() {
		return "Diretor [id=" + id + ", nome=" + nome + ", dataNascimento=" + printDate(dataNascimento) + ", filmes=" + filmes
				+ "]";
	}
	
}
