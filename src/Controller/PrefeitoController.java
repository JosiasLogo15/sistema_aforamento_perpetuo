package Controller;

import Controller.Helper.PrefeitoHelper;
import DAO.PrefeitoDAO;
import Model.Prefeito;
import VIEW.TelaCadastroPrefeito;

public class PrefeitoController {
	private final TelaCadastroPrefeito view;
	private PrefeitoHelper helper;
	private PrefeitoDAO prefeitoDAO;
	private int codigo;
	
	
	public PrefeitoController(TelaCadastroPrefeito view) {
		this.view = view;
		this.helper = new PrefeitoHelper(view);
		this.prefeitoDAO = new PrefeitoDAO();
	}

	public void cadastrar() {
		Prefeito prefeito = helper.obterModelo();
		
		prefeitoDAO.save(prefeito);
		
		listaPrefeitos();
		view.exibeMensagem("Prefeito cadastrado com sucesso!");
	}
	
	public void listaPrefeitos() {
		helper.listaPrefeitos(prefeitoDAO.findAll());
	}

	public void excluir() {
		int codigo = helper.capturaValor();
		Prefeito prefeito = prefeitoDAO.findById(codigo);
		prefeitoDAO.delete(prefeito);
		listaPrefeitos();
		view.exibeMensagem("Registro excluido com sucesso!");
	}

	
	public void preencheTela() {
		this.codigo = helper.capturaValor();
		Prefeito prefeito = prefeitoDAO.findById(codigo);
		helper.preencheTela(prefeito);
	}
	
	public void alterar() {
		Prefeito prefeito = helper.obterModelo();
		prefeito.setCodigoPrefeito(codigo);
		prefeitoDAO.update(prefeito);
		
		helper.limpaTela();
		view.exibeMensagem("Registro alterado com sucesso!");
		listaPrefeitos();
	}
	
	
	
	

}
