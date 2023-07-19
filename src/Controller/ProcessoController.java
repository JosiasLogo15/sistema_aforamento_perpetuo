package Controller;

import Controller.Helper.ProcessoHelper;
import Model.Processo;
import VIEW.TelaEntradaProcesso;

public class ProcessoController {
	private TelaEntradaProcesso view;
	private ProcessoHelper helper;
	
	public ProcessoController(TelaEntradaProcesso view) {
		this.view = view;
		this.helper = new ProcessoHelper(view);
	}

	public void cadastrar() {
		Processo processo = helper.obterModelo();
		
	}
	
	
}
