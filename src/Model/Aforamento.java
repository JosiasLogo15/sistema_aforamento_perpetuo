package Model;

import java.util.Date;

public class Aforamento {
	private int numeroAforamento;
	private String observacoes;
	private Date dataAforamento;
	private int numeroProcesso;
	private int codigoPrefeito;
	
	
	public int getNumeroAforamento() {
		return numeroAforamento;
	}
	public void setNumeroAforamento(int numeroAforamento) {
		this.numeroAforamento = numeroAforamento;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Date getDataAforamento() {
		return dataAforamento;
	}
	public void setDataAforamento(Date dataAforamento) {
		this.dataAforamento = dataAforamento;
	}
	public int getNumeroProcesso() {
		return numeroProcesso;
	}
	public void setNumeroProcesso(int numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}
	public int getCodigoPrefeito() {
		return codigoPrefeito;
	}
	public void setCodigoPrefeito(int codigoPrefeito) {
		this.codigoPrefeito = codigoPrefeito;
	}
	
	
}
