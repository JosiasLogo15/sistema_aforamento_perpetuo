package Controller;

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
		
		usuarioDAO.save(usuario);
		view.exibeMensagem("Usuario cadastrado com sucesso!");
	}

}
