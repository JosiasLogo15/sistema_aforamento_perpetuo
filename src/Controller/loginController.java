package Controller;

import Controller.Helper.LoginHelper;
import DAO.UsuarioDAO;
import Model.Usuario;
import VIEW.telaLoginVIEW;

public class loginController {
	
	private final telaLoginVIEW view;
	
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();


	private LoginHelper helper;
	
	public loginController(telaLoginVIEW view) {
		this.view = view;
		this.helper = new LoginHelper(view);
	}
	
	public void login(String nome, String senha) {
		Usuario usuario = helper.obterModelo();
		
	}
	
	
}
