package Controller;

import Controller.Helper.MenuHelper;
import VIEW.TelaCadastroCemiterio;
import VIEW.TelaCadastroPrefeito;
import VIEW.TelaCadastroUsuario;
import VIEW.TelaMenuPrincipal;

public class MenuController {
	private final TelaMenuPrincipal view;
	private final TelaCadastroCemiterio cemiterioView;
	private final TelaCadastroPrefeito prefeitoView;
	private final TelaCadastroUsuario usuarioView;
	
	public MenuController(TelaMenuPrincipal view) {
		this.view = view;
		this.cemiterioView = new TelaCadastroCemiterio();
		this.prefeitoView = new TelaCadastroPrefeito();
		this.usuarioView = new TelaCadastroUsuario();
	}
	
	public void cadastraCemiterio() {
		cemiterioView.mostraTela();
	}

	public void cadastraPrefeito() {
		prefeitoView.mostraTela();
	}

	public void cadastraUsuario() {
		usuarioView.mostraTela();
	}
	
	
}
