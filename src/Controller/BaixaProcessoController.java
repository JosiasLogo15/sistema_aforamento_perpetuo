package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Controller.Helper.BaixaProcessoHelper;
import DAO.AforamentoDAO;
import DAO.CemiterioDAO;
import DAO.PrefeitoDAO;
import DAO.ProcessoDAO;
import DAO.SituacaoDAO;
import Model.Aforamento;
import Model.Cemiterio;
import Model.Prefeito;
import Model.Processo;
import Model.Situacao;
import VIEW.TelaBaixaProcesso;
import VIEW.TelaBuscaProcesso;


public class BaixaProcessoController {
	private final TelaBaixaProcesso view;
	private final BaixaProcessoHelper helper;
	private final ProcessoDAO processoDAO;
	private final AforamentoDAO aforamentoDAO;
	private final CemiterioDAO cemiterioDAO;
	private final SituacaoDAO situacaoDAO;
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
		this.situacaoDAO = new SituacaoDAO();
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
		try {
			helper.listaCmbBoxPrefeitos(prefeitoDAO.findAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listaAforamentos() {
		try {
			helper.listaAforamentos(aforamentoDAO.findAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void preencheTela() {
		int codigo = helper.obterCodigo();
		
		try {
			aforamento = aforamentoDAO.findById(codigo);
			Prefeito prefeito = prefeitoDAO.findById(aforamento.getCodigoPrefeito()); 
			Processo processo = processoDAO.findById(aforamento.getNumeroProcesso());
			Situacao situacao = situacaoDAO.findById(aforamento.getSituacao());
			
			helper.preencheTela(aforamento, prefeito, processo, situacao);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void atualizar() {
		try {
			
		aforamento = helper.obterModelo();
		int opcao = view.mensagemConfirmacao("Deseja fazer a alteração no registro " + aforamento.getNumeroAforamento(), "ATENTION", JOptionPane.YES_NO_OPTION);
		if(opcao == JOptionPane.YES_OPTION) {
		aforamentoDAO.update(aforamento);
		limpaTela();
		listaAforamentos();
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
		int opcao = view.mensagemConfirmacao("Deseja realizar a exclusão do registro " + aforamento.getNumeroAforamento(), "ATENTION", JOptionPane.YES_NO_OPTION);
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

	public void imprimirComLogo(){
		try {
			int codigo = helper.obterCodigo();
			aforamento = aforamentoDAO.findById(codigo);
			processo = processoDAO.findById(aforamento.getNumeroProcesso());
			Cemiterio cemiterio = cemiterioDAO.findById(processo.getCodigoCemiterio());
			Prefeito prefeito = prefeitoDAO.findById(aforamento.getCodigoPrefeito());
			helper.escreveDocumentoComLogo(aforamento, processo, cemiterio, prefeito);
			
			  
			TimeUnit.SECONDS.sleep(30); 
				  
				
			helper.limpaArquivo();
		}catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			view.errorMensagem("Ocorreu um erro ao imprimir o arquivo", "ERROR", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
			 
	}
	
	public void imprimirSemLogo(){
		/*
		 * if(helper.camposVazios()) {
		 * view.errorMensagem("SELECIONE UM PROCESSO PARA A IMPRESSÃO", "ATENTION",
		 * JOptionPane.WARNING_MESSAGE); }else {
		 */
		try {
			int codigo = helper.obterCodigo();
			aforamento = aforamentoDAO.findById(codigo);
			processo = processoDAO.findById(aforamento.getNumeroProcesso());
			Cemiterio cemiterio = cemiterioDAO.findById(processo.getCodigoCemiterio());
			Prefeito prefeito = prefeitoDAO.findById(aforamento.getCodigoPrefeito());
			helper.escreveDocumentoSemLogo(aforamento, processo, cemiterio, prefeito);
			
			  try { 
				  TimeUnit.SECONDS.sleep(30); 
				  } catch (InterruptedException e) { 
					  e.printStackTrace(); 
				}
			  
			helper.limpaArquivo(); 
			  } catch (IOException e) {
				  view.errorMensagem("Ocorreu um erro ao escrever o arquivo", "ERROR", JOptionPane.ERROR_MESSAGE); 
				  e.printStackTrace(); 
			  } catch (SQLException e) {
				view.errorMensagem("Ocorreu um erro ao imprimir o arquivo", "ERROR", JOptionPane.ERROR_MESSAGE); 
				e.printStackTrace();
			}
		}	 
	
	
	private boolean camposVazios(Aforamento aforamento) {
		if(aforamento.getNumeroAforamento() == 0 || aforamento.getCodigoPrefeito() == 0 || 
				aforamento.getNumeroAforamento() == 0 || aforamento.getDataAforamento() == null || 
				aforamento.getFolha() == null || aforamento.getLivro() == null) {
			return true;
		}
		return false;
	}

	private void limpaArquivo() {
		try {
			helper.limpaArquivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listaSituacao() {
		try {
			helper.listaSituacao(situacaoDAO.findAll());
		} catch (SQLException e) {
			view.errorMensagem("Houve um erro em buscar a situacao", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void buscaProcesso(JComboBox cmbbxProcesso) {
		TelaBuscaProcesso telaBuscaProcesso = new TelaBuscaProcesso(cmbbxProcesso);
		telaBuscaProcesso.setLocationRelativeTo(view.getFrmBaixaProcesso());
		telaBuscaProcesso.mostraTela();
	}

	public void mostraNome() {
			helper.mostraNome();

	}

}
