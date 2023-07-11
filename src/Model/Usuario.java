package Model;

public class Usuario {
	private int codigoUsuario;
	private String nome;
	private String senha;
	
	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getCodigoUsuario() {
		return codigoUsuario;
	}
	
	public void setCodigoUsuario(int codigo) {
		this.codigoUsuario = codigo;
	}
	
}
