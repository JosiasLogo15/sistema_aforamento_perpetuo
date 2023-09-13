package Controller.Helper;

import Model.Usuario;
import VIEW.TelaCadastroUsuario;

public class UsuarioHelper {
	private TelaCadastroUsuario view;
	
		public UsuarioHelper(TelaCadastroUsuario view) {
			this.view = view;
		}

		public Usuario obterModelo() {
			Usuario usuario = new Usuario();
			String nome = view.getTxtNome().getText().toString();
			String senha = new String(view.getPsswdSenha().getPassword());
			
			usuario.setNome(nome);
			usuario.setSenha(senha);
			return usuario;
		}
		
		
}
