package Controller;

import javax.swing.JOptionPane;

import Controller.Helper.LoginHelper;
import DAO.UsuarioDAO;
import Model.Usuario;
import VIEW.TelaLogin;
import VIEW.TelaMenuPrincipal;

public class LoginController {
	
	private final TelaLogin view;
	
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();


	private LoginHelper helper;
	
	public LoginController(TelaLogin view) {
		this.view = view;
		this.helper = new LoginHelper(view);
	}
	
	public void login() {
		Usuario usuario = helper.obterModelo();
		
		Boolean resultado = usuarioDAO.verificaNoBanco(usuario);
		
		if (resultado == true) {
			TelaMenuPrincipal menu = new TelaMenuPrincipal();
			menu.setUsuario(usuario.getNome());
			menu.mostraTela();
			menu.preencheInfo();
			view.dispose();
		}else {
			view.exibeMensagem("Usuário ou senha inválidos!");
			helper.limpaTela();
		}
	}
	
	
}
