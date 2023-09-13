package Controller;

import java.sql.SQLException;

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
		
		Boolean resultado;
		try {
			resultado = usuarioDAO.verificaNoBanco(usuario);
			
			if (resultado == true) {
			TelaMenuPrincipal menu = new TelaMenuPrincipal();
			menu.setUsuario(usuario.getNome());
			menu.mostraTela();
			menu.preencheInfo();
			helper.limpaTela();
			view.dispose();
		}else {
			view.exibeMensagem("Usuário ou senha inválidos!");
			helper.limpaTela();
		}
		} catch (SQLException e) {
			view.exibeMensagem("Houve um erro ao realizar o login");;
			e.printStackTrace();
		}
		
		
	}
	
	
}
