package analista.teste.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Filme {
	
	private String nome;
	private Date dataLancamento;
	
	public Filme(String nome, String anoLancamento) {
		super();
		this.nome = nome;
		this.dataLancamento = parseYear(anoLancamento);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = parseYear(dataLancamento);
	}
	
	private Date parseYear(String year) {
		try {
			return new SimpleDateFormat("yyyy").parse(year);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String printYear(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		Integer year = cal.get(Calendar.YEAR);
		return year.toString();
	}
	
	@Override
	public String toString() {
		return "Filme [nome=" + nome + ", dataLancamento=" + printYear(dataLancamento) + "]";
	}
	
}
