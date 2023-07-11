package Controller.Helper;

import Model.Cemiterio;
import VIEW.TelaMenuPrincipal;

public class MenuHelper {
	private TelaMenuPrincipal view;
	
	public MenuHelper(TelaMenuPrincipal view) {
		this.view = view;
	}
	
	public Cemiterio obterModelo() {
		Cemiterio cemiterio = new Cemiterio();
		
		return cemiterio;
	}
}
