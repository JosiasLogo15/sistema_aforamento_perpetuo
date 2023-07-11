package Controller.Helper;

import Model.Usuario;
import VIEW.TelaLogin;

public class LoginHelper {
	private final TelaLogin view;
	
	public LoginHelper(TelaLogin view) {
		this.view = view;
	}
	
	public Usuario obterModelo() {
		String nome = view.getTxtNome().getText();
		String senha = view.getPsswdSenha().getText().toString();
		Usuario usuario = new Usuario(nome, senha);
		return usuario;
	}
	
	public void setarModelo(Usuario usuario) {
		String nome = usuario.getNome();
		String senha = usuario.getSenha();
		view.getTxtNome().setText(nome);
		view.getPsswdSenha().setText(senha);
	}
	
	public void limpaTela() {
		view.getTxtNome().setText("");
		view.getPsswdSenha().setText("");
	}
}
