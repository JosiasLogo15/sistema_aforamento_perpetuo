package Model;

import java.util.Date;

public class Processo {

	private int numeroProcesso;
	private String requerente;
	private String medida;
	private String falecido;
	private Date dataEntrada;
	private String endereco;
	private String bairro;
	private String quadra;
	private String estaca;
	private String rg;
	private int codigoCemiterio;
	private String nacionalidade;
	private String numeroProcessoString;
	
	public int getNumeroProcesso() {
		return numeroProcesso;
	}
	public void setNumeroProcesso(int numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}
	public String getRequerente() {
		return requerente;
	}
	public void setRequerente(String requerente) {
		this.requerente = requerente;
	}
	public String getMedida() {
		return medida;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}
	public String getFalecido() {
		return falecido;
	}
	public void setFalecido(String falecido) {
		this.falecido = falecido;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getQuadra() {
		return quadra;
	}
	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}
	public String getEstaca() {
		return estaca;
	}
	public void setEstaca(String estaca) {
		this.estaca = estaca;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public int getCodigoCemiterio() {
		return codigoCemiterio;
	}
	public void setCodigoCemiterio(int codigoCemiterio) {
		this.codigoCemiterio = codigoCemiterio;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	
	  public String getNumeroProcessoString() {
		  this.numeroProcessoString = String.valueOf(numeroProcesso);
		return numeroProcessoString;
	}
	
	public String toString() { 
		  return getNumeroProcessoString();
	  }
	  
	  
	 
	
}
