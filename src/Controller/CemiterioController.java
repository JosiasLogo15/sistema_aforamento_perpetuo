package Controller;

import Controller.Helper.CemiterioHelper;
import DAO.CemiterioDAO;
import Model.Cemiterio;
import VIEW.TelaCadastroCemiterio;

public class CemiterioController {
	private TelaCadastroCemiterio view;
	private CemiterioHelper	helper;
	private CemiterioDAO cemiteroDAO = new CemiterioDAO(); 
	
	public CemiterioController(TelaCadastroCemiterio view) {
		this.view = view;
		helper = new CemiterioHelper(view);
	}
	
	public void cadastrar() {
		Cemiterio cemiterio = helper.obterModelo();
		if(helper.verificaModelo(cemiterio)) {
			cemiteroDAO.save(cemiterio);
		}else {
			view.exibeMensagem("COMPLETE TODOS OS CAMPOS PARA CADASTRAR");
		}
		
		helper.limpaTela();
		listaCemiterio();
		
	}
	
	public void listaCemiterio() {
		helper.listaCemiterio(cemiteroDAO.findAll());
	}

	public void excluir(int selectedColumn) {
		Cemiterio cemiterio = cemiteroDAO.findById(selectedColumn);
		cemiteroDAO.delete(cemiterio);
		
		view.exibeMensagem("Cemiterio deletado com sucesso");
	}
	
}
