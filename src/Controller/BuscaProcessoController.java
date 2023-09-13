package Controller;

import Controller.Helper.BuscaProcessoHelper;
import DAO.ProcessoDAO;
import Model.Processo;
import VIEW.TelaBuscaProcesso;

public class BuscaProcessoController {
	private final TelaBuscaProcesso view;
	private final BuscaProcessoHelper helper;
	private ProcessoDAO processoDAO;
	
	public BuscaProcessoController(TelaBuscaProcesso view){
		this.view=view;
		this.helper = new BuscaProcessoHelper(view);
	}

	public void setarTableSorter() {
		helper.setarTableSorter();
	}

	public void buscar() {
		helper.buscar();
	}

	public void listaProcessos() {
		processoDAO = new ProcessoDAO();
		helper.listaProcessos(processoDAO.findAll());
		
	}

	public void obterValor() {
		int codigo = helper.obterValor();
		Processo processo = processoDAO.findById(codigo);
		view.getCmbbxProcesso().setSelectedItem(processo);
	}
}
