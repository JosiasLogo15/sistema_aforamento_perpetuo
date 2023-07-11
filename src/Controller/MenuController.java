package Controller;

import Controller.Helper.MenuHelper;
import VIEW.TelaCadastroCemiterio;
import VIEW.TelaMenuPrincipal;

public class MenuController {
	private final TelaMenuPrincipal view;
	private final TelaCadastroCemiterio cemiterioView;
	
	public MenuController(TelaMenuPrincipal view) {
		this.view = view;
		this.cemiterioView = new TelaCadastroCemiterio();
	}
	
	public void cadastraCemiterio() {
		cemiterioView.mostraTela();
	}
	
	
}
