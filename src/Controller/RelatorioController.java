package Controller;

import Controller.Helper.RelatorioHelper;
import DAO.AforamentoDAO;
import DAO.ProcessoDAO;
import Model.Aforamento;
import Model.Processo;
import VIEW.TelaRelatorio;

public class RelatorioController {
	private final TelaRelatorio view;
	private final RelatorioHelper helper;
	private ProcessoDAO processoDAO;
	private AforamentoDAO aforamentoDAO;
	private Processo processo;
	private Aforamento aforamento;
	
	
	public RelatorioController(TelaRelatorio view) {
		this.view = view;
		this.helper = new RelatorioHelper(view);
		this.processoDAO = new ProcessoDAO();
		this.aforamentoDAO = new AforamentoDAO();
	}


	public void buscar() {
		int opcao = helper.obterOpcao();
		
		if(opcao == 0) {
			int numeroAforamento = helper.obterNumero();
			aforamento = aforamentoDAO.findById(numeroAforamento);
			helper.listaTabela();
		}
		else {
			int numeroProcesso = helper.obterNumero();
			processo = processoDAO.findById(numeroProcesso);
			helper.listaTabela();
		}
	}
	
}
