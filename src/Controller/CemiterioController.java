package Controller;

import javax.swing.JOptionPane;

import Controller.Helper.CemiterioHelper;
import DAO.CemiterioDAO;
import Model.Cemiterio;
import VIEW.TelaCadastroCemiterio;

public class CemiterioController {
	private TelaCadastroCemiterio view;
	private CemiterioHelper	helper;
	private CemiterioDAO cemiteroDAO = new CemiterioDAO(); 
	private int codigo;
	
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
		
		limpaTela();
		listaCemiterio();
		
	}
	
	public void limpaTela() {
		helper.limpaTela();
	}
	
	public void listaCemiterio() {
		helper.listaCemiterio(cemiteroDAO.findAll());
	}

	public void excluir() {
		
		int valorCapturado = helper.capturaValor();
		Cemiterio cemiterio = cemiteroDAO.findById(valorCapturado);
		int opcao = view.mensagemConfirmacao("TEM CERTEZA QUE DESEJA FAZER A EXCLUSÃO DO REGISTRO "+ cemiterio.getNome(), "ATENTION", JOptionPane.YES_NO_OPTION);
		if(opcao == JOptionPane.YES_OPTION) {
			
			cemiteroDAO.delete(cemiterio);
			
			view.exibeMensagem("Cemiterio deletado com sucesso");
			limpaTela();
			listaCemiterio();
		}else {
			view.exibeMensagem("OPERAÇÃO CANCELADA COM SUCESSO");
			limpaTela();
		}
	}

	public void preencheTela() {
		this.codigo = helper.capturaValor();
		Cemiterio cemiterio = cemiteroDAO.findById(codigo);
		helper.preencheTela(cemiterio);
		
	}

	public void alterar() {
		Cemiterio cemiterio = helper.obterModelo();
		cemiterio.setCodigoCemiterio(helper.capturaValor());
		int opcao = view.mensagemConfirmacao("TEM CERTEZA QUE DESEJA ALTERAR O REGISTRO "+ cemiterio.getNome(), "ATENTION", JOptionPane.YES_NO_OPTION);
		if(opcao == JOptionPane.YES_OPTION) {
			cemiteroDAO.update(cemiterio);
			helper.limpaTela();
			listaCemiterio();
		}else {
			view.exibeMensagem("OPERAÇÃO CANCELADA COM SUCESSO!s");
			helper.limpaTela();
		}
		
	}

	
}
