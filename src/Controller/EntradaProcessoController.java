package Controller;

import Controller.Helper.EntradaProcessoHelper;
import DAO.CemiterioDAO;
import DAO.ProcessoDAO;
import Model.Processo;
import VIEW.TelaEntradaProcesso;

public class EntradaProcessoController {
	private TelaEntradaProcesso view;
	private EntradaProcessoHelper helper;
	private ProcessoDAO processoDAO;
	
	public EntradaProcessoController(TelaEntradaProcesso view) {
		this.view = view;
		this.helper = new EntradaProcessoHelper(view);
		this.processoDAO = new ProcessoDAO();
	}

	public void cadastrar() {
		try {
		Processo processo = helper.obterModelo();
		processoDAO.save(processo);
		view.exibeMensage("Entrada feita com sucesso!");
		listaProcessos();
		limpaTela();
		}catch (Exception e) {
			view.exibeMensage("Ocorreu um erro: " + e);
		}
	}

	public void limpaTela() {
		helper.limpaTela();
	}

	public void listaComboBox() {
		CemiterioDAO cemiterioDAO = new CemiterioDAO();
		if(view.getCmbbxCemiterio().getItemCount() == 0) {
			helper.listaComboBox(cemiterioDAO.findAll());
		}
	}

	public void excluir() {
		try {
		int numeroProcesso =  helper.capturaValor();
		processoDAO.delete(processoDAO.findById(numeroProcesso));
		listaProcessos();
		view.exibeMensage("Registro deletado com sucesso");
		}catch (Exception e) {
			view.exibeMensage("Ocorreu um erro: " + e);
		}
	}

	public void listaProcessos() {
		helper.listaProcessos(processoDAO.findAll());
	}

	public void preencheTela() {
		int numeroProceso = helper.capturaValor();
		helper.preencheTela(processoDAO.findById(numeroProceso));
		
	}

	public void alterar() {
		Processo processo = helper.obterModelo();
		try {
		processoDAO.update(processo);
		view.exibeMensage("Alteração feita com sucesso!");
		listaProcessos();
		limpaTela();
		}catch (Exception e) {
			view.exibeMensage("Ocorreu um erro: " + e);
		}
	}

	public void setarTableSorter() {
		helper.setarTableSorter();
		
	}

	public void buscar() {
		helper.buscar();
		
	}

	
}
