package Controller.Helper;

import java.util.Date;

import DAO.CemiterioDAO;
import Model.Cemiterio;
import Model.Processo;
import VIEW.TelaEntradaProcesso;

public class ProcessoHelper {
	private TelaEntradaProcesso view;
	private CemiterioDAO cemiterioDAO = new CemiterioDAO();
	private Cemiterio cemiterio;
	public ProcessoHelper(TelaEntradaProcesso view) {
		this.view = view;
	}

	public Processo obterModelo() {
		Processo processo = new Processo();
		String numeroProcesso = view.getTxtNumeroProcesso().getText();
		String requerente = view.getTxtRequerente().getText();
		String falecido = view.getTxtFalecido().getText();
		String Rg = view.getTxtRg().getText();
		String endereco = view.getTxtEndereco().getText();
		String bairro = view.getTxtBairro().getText();
		String quadra = view.getTxtQuadra().getText();
		String estaca = view.getTxtEstaca().getText();
		String medida = view.getTxtMedida().getText();
		Date dataEntrada = view.getDataEntrada().getDate();
		String nacionalidade = view.getTxtNacionalidade().getText();
		String cemiterio = view.getCmbbxCemiterio();
		return null;
	}
	
	public void listaComboBox() {
		view.getCmbbxCemiterio().add();
	}
}
