package Model;

import java.util.Date;

public class Prefeito {
	private int codigoPrefeito;
	private String nome;
	private Date dataInicio;
	private Date dataFinal;
	
	public int getCodigoPrefeito() {
		return codigoPrefeito;
	}
	public void setCodigoPrefeito(int codigoPrefeito) {
		this.codigoPrefeito = codigoPrefeito;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
}
