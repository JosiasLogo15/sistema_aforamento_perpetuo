package Controller;

import Controller.Helper.MenuHelper;
import VIEW.TelaBaixaProcesso;
import VIEW.TelaCadastroCemiterio;
import VIEW.TelaCadastroPrefeito;
import VIEW.TelaCadastroUsuario;
import VIEW.TelaEntradaProcesso;
import VIEW.TelaMenuPrincipal;

public class MenuController {
	private final TelaMenuPrincipal view;
	private final TelaCadastroCemiterio cemiterioView;
	private final TelaCadastroPrefeito prefeitoView;
	private final TelaCadastroUsuario usuarioView;
	private final TelaEntradaProcesso entradaProcessoView;
	private final TelaBaixaProcesso baixaProcessoView;
	
	public MenuController(TelaMenuPrincipal view) {
		this.view = view;
		this.cemiterioView = new TelaCadastroCemiterio();
		this.prefeitoView = new TelaCadastroPrefeito();
		this.usuarioView = new TelaCadastroUsuario();
		this.entradaProcessoView = new TelaEntradaProcesso();
		this.baixaProcessoView = new TelaBaixaProcesso();
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

	public void EntradaProcesso() {
		entradaProcessoView.mostraTela();
	}

	public void BaixaProcesso() {
		baixaProcessoView.mostraTela();
	}
	
	
}
