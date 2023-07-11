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
		
		cemiteroDAO.save(cemiterio);
		helper.limpaTela();
		
		helper.listaCemiterio(cemiteroDAO.findAll());
	}

}
