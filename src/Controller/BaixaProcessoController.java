package Controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import Controller.Helper.BaixaProcessoHelper;
import DAO.AforamentoDAO;
import DAO.CemiterioDAO;
import DAO.PrefeitoDAO;
import DAO.ProcessoDAO;
import Model.Aforamento;
import Model.Cemiterio;
import Model.Prefeito;
import Model.Processo;
import VIEW.TelaBaixaProcesso;

public class BaixaProcessoController {
	private final TelaBaixaProcesso view;
	private final BaixaProcessoHelper helper;
	private final ProcessoDAO processoDAO;
	private final AforamentoDAO aforamentoDAO;
	private final CemiterioDAO cemiterioDAO;
	private PrefeitoDAO prefeitoDAO;
	
	
	private Aforamento aforamento;
	private Processo processo;
	private Cemiterio cemiterio;

	public BaixaProcessoController(TelaBaixaProcesso view) {
		this.view = view;
		this.helper = new BaixaProcessoHelper(view);
		this.processoDAO = new ProcessoDAO();
		this.prefeitoDAO = new PrefeitoDAO();
		this.aforamentoDAO = new AforamentoDAO();
		this.cemiterioDAO = new CemiterioDAO();
	}

	public void baixaProcesso() {
		aforamento = helper.obterModelo();
		aforamentoDAO.save(aforamento);
		
		limpaTela();
		listaAforamentos();
	}

	public void listaCmbBoxProcessos() {
		helper.listaCmbBoxProcessos(processoDAO.findAll());
	}

	public void listaCmbBoxPrefeitos() {
		helper.listaCmbBoxPrefeitos(prefeitoDAO.findAll());
	}

	public void listaAforamentos() {
		helper.listaAforamentos(aforamentoDAO.findAll());
	}

	public void preencheTela() {
		int codigo = helper.obterCodigo();
		aforamento = aforamentoDAO.findById(codigo);
		Prefeito prefeito = prefeitoDAO.findById(aforamento.getCodigoPrefeito()); 
		Processo processo = processoDAO.findById(aforamento.getNumeroProcesso());
		
		helper.preencheTela(aforamento, prefeito, processo);
		
	}

	public void atualizar() {
		try {
			
		aforamento = helper.obterModelo();
		int opcao = view.mensagemConfirmacao("Deseja fazer a alteração no registro " + aforamento.getNumeroAforamento(), "ATENTION", JOptionPane.YES_NO_OPTION);
		if(opcao == JOptionPane.YES_OPTION) {
		aforamentoDAO.update(aforamento);
		limpaTela();
		view.exibeMensagem("Registro atualizado com sucesso");
		
		}else {
			view.exibeMensagem("Opcao cancelada!");
			limpaTela();
			listaAforamentos();
		}
		}catch (Exception e) {
			view.exibeMensagem("Ocorreu um erro ao atualizar o registro " + e);
		}
	}
	
	public void limpaTela() {
		helper.limpaTela();
	}

	public void excluir() {
		int opcao = view.mensagemConfirmacao("MENSAGEM DE CONFIRMAÇÃO", "CONFIRMAÇÃO", JOptionPane.YES_NO_OPTION);
		if(opcao == JOptionPane.YES_OPTION) {
			aforamento = helper.obterModelo();
			aforamentoDAO.delete(aforamento);
			view.exibeMensagem("Exclusão feita com sucesso!");
			limpaTela();
			listaAforamentos();
		}else {
			view.exibeMensagem("Opção cancelada!");
			limpaTela();
			listaAforamentos();
		}
		
	}

	public void setarTableSorter() {
		helper.setarTableSorter();
	}

	public void imprimir(){
		aforamento = helper.obterModelo();
		processo = processoDAO.findById(aforamento.getNumeroProcesso());
		Cemiterio cemiterio = cemiterioDAO.findById(processo.getCodigoCemiterio());
		Prefeito prefeito = prefeitoDAO.findById(aforamento.getCodigoPrefeito());
		helper.imprimir(aforamento, processo, cemiterio, prefeito);
	}

}
