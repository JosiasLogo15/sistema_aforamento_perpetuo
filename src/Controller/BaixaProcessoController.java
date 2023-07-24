package Controller;

import Controller.Helper.BaixaProcessoHelper;
import DAO.AforamentoDAO;
import DAO.PrefeitoDAO;
import DAO.ProcessoDAO;
import Model.Aforamento;
import Model.Processo;
import VIEW.TelaBaixaProcesso;

public class BaixaProcessoController {
	private final TelaBaixaProcesso view;
	private final BaixaProcessoHelper helper;
	private final ProcessoDAO processoDAO;
	private final AforamentoDAO aforamentoDAO;
	
	private Aforamento aforamento;
	private Processo processo;
	private PrefeitoDAO prefeitoDAO;

	public BaixaProcessoController(TelaBaixaProcesso view) {
		this.view = view;
		this.helper = new BaixaProcessoHelper(view);
		this.processoDAO = new ProcessoDAO();
		this.prefeitoDAO = new PrefeitoDAO();
		this.aforamentoDAO = new AforamentoDAO();
	}

	public void baixaProcesso() {
		aforamento = helper.obterModelo();
		aforamentoDAO.save(aforamento);
		helper.limpaTela();
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
		
		helper.preencheTela(aforamento);
		
	}

}
