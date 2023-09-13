package Controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controller.Helper.PrefeitoHelper;
import DAO.PrefeitoDAO;
import Model.Prefeito;
import VIEW.TelaCadastroPrefeito;

public class PrefeitoController {
	private final TelaCadastroPrefeito view;
	private PrefeitoHelper helper;
	private PrefeitoDAO prefeitoDAO;
	
	
	public PrefeitoController(TelaCadastroPrefeito view) {
		this.view = view;
		this.helper = new PrefeitoHelper(view);
		this.prefeitoDAO = new PrefeitoDAO();
	}

	public void cadastrar() {
		Prefeito prefeito = helper.obterModelo();
		
		try {
			prefeitoDAO.save(prefeito);
			
			listaPrefeitos();
			
			helper.limpaTela();
			
			view.exibeMensagem("Prefeito cadastrado com sucesso!");
		} catch (SQLException e) {
			view.errorMensagem("Ocorreu um erro ao cadastrar o Prefeito", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		
	}
	
	public void listaPrefeitos() {
		try {
			helper.listaPrefeitos(prefeitoDAO.findAll());
		} catch (SQLException e) {
			view.errorMensagem("Ocorreu um erro ao listar os Prefeitos", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void excluir() {
		Prefeito prefeito;
		try {
		int codigo = helper.capturaValor();
		prefeito = prefeitoDAO.findById(codigo);
		prefeitoDAO.delete(prefeito);
		listaPrefeitos();
		helper.limpaTela();
		view.exibeMensagem("Registro excluido com sucesso!");
		}catch (SQLException e) {
			view.errorMensagem("Ocorreu um erro ao realizar a exclusão do Registro: ", "Erro de Exclusão", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	
	public void preencheTela() {
		int codigo = helper.capturaValor();
		Prefeito prefeito;
		try {
			prefeito = prefeitoDAO.findById(codigo);
			helper.preencheTela(prefeito);
		} catch (SQLException e) {
			view.errorMensagem("Ocorreu um erro "+ e, "Warning", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	public void alterar() {
		try {
			int codigo = helper.capturaValor();
			Prefeito prefeito = helper.obterModelo();
			prefeito.setCodigoPrefeito(codigo);
			
			prefeitoDAO.update(prefeito);
			helper.limpaTela();
			view.exibeMensagem("Registro alterado com sucesso!");
			listaPrefeitos();
		} catch (SQLException e) {
			view.errorMensagem("Ocorreu um erro ao alterar o registro ", "Erro de alteração", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

}
