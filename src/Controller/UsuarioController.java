package Controller;

import java.sql.SQLException;

import Controller.Helper.UsuarioHelper;
import DAO.UsuarioDAO;
import Model.Usuario;
import VIEW.TelaCadastroUsuario;

public class UsuarioController {
	private final TelaCadastroUsuario view;
	private final UsuarioHelper helper;
	private UsuarioDAO usuarioDAO;
	
	public UsuarioController(TelaCadastroUsuario view) {
		this.view = view;
		helper = new UsuarioHelper(view);
		usuarioDAO = new UsuarioDAO();
	}

	public void cadastrar() {
		Usuario usuario = helper.obterModelo();
		
		try {
			usuarioDAO.save(usuario);
		} catch (SQLException e) {
			view.exibeMensagem("Houve um erro ao cadastrar o usuário");
			e.printStackTrace();
		}
		
		view.exibeMensagem("Usuario cadastrado com sucesso!");
	}

}
