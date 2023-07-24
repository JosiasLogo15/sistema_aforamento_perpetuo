package Controller.Helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import DAO.PrefeitoDAO;
import Model.Aforamento;
import Model.Prefeito;
import Model.Processo;
import VIEW.TelaBaixaProcesso;

public class BaixaProcessoHelper {
	private final TelaBaixaProcesso view;
	
	public BaixaProcessoHelper(TelaBaixaProcesso view) {
		this.view = view;
	}

	public Aforamento obterModelo() {
		Aforamento aforamento = new Aforamento();
		
		Processo numeroProcesso = obterNumeroProcesso();
		int numeroAforamento = Integer.parseInt(view.getTxtAforamento().getText());
		Date data = view.getDataAforamento().getDate();
		String observacao = view.getTxtObservacao().getText();
		Prefeito prefeito = obterCodigoPrefeito();
		String livro = view.getTxtLivro().getText();
		String folha = view.getTxtFolha().getText();
		
		aforamento.setNumeroAforamento(numeroAforamento);
		aforamento.setNumeroProcesso(numeroProcesso.getNumeroProcesso());
		aforamento.setDataAforamento(data);
		aforamento.setCodigoPrefeito(prefeito.getCodigoPrefeito());
		aforamento.setObservacoes(observacao);
		aforamento.setLivro(livro);
		aforamento.setFolha(folha);
		
		return aforamento;
	}

	
	private Prefeito obterCodigoPrefeito() {
		return (Prefeito) view.getCmbbxPrefeito().getSelectedItem();
	}

	public Processo obterNumeroProcesso() {
		return (Processo) view.getCmbbxProcesso().getSelectedItem();
	}
	
	public void listaCmbBoxProcessos(List<Processo> listaProcessos) {
		DefaultComboBoxModel comboBoxProcessos = (DefaultComboBoxModel) view.getCmbbxProcesso().getModel();
		
		for(Processo p: listaProcessos) {
			comboBoxProcessos.addElement(p);
		}
		
	}
	
	public void listaCmbBoxPrefeitos(List<Prefeito> listaPrefeitos) {
		DefaultComboBoxModel comboBoxPrefeitos = (DefaultComboBoxModel) view.getCmbbxPrefeito().getModel();
		
		for(Prefeito p: listaPrefeitos) {
			comboBoxPrefeitos.addElement(p);
		}
	}

	public void listaAforamentos(List<Aforamento> aforamentos) {
		DefaultTableModel table = (DefaultTableModel) view.getTable().getModel();
		table.setNumRows(0);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		for (Aforamento a: aforamentos) {
			Object[] dados = {
					a.getNumeroAforamento(),
					a.getNumeroProcesso(),
					sdf.format(a.getDataAforamento()),
					a.getLivro(),
					a.getFolha(),
					a.getSituacao()
			};
			table.addRow(dados);
		}
	}

	public void limpaTela() {
		view.getTxtAforamento().setText("");
		view.getDataAforamento().setDate(null);
		view.getTxtFolha().setText("");
		view.getTxtLivro().setText("");
		view.getTxtObservacao().setText("");
		view.getCmbbxPrefeito().setSelectedItem(null);
		view.getCmbbxPrefeito().setSelectedItem(null);
		
	}

	public void preencheTela(Aforamento aforamento) {
		Prefeito prefeito = new Prefeito();
		PrefeitoDAO prefeitoDAO = new PrefeitoDAO();
		
		int numeroProcesso = aforamento.getNumeroProcesso();
		Prefeito codigoPrefeito = prefeitoDAO.findById(aforamento.getCodigoPrefeito());
		String observação = aforamento.getObservacoes();
		int numeroAforamento = aforamento.getNumeroAforamento();
		Date data = aforamento.getDataAforamento();
		String folha = aforamento.getFolha();
		String livro = aforamento.getLivro();
		String situacao = aforamento.getSituacao();

		view.getCmbbxProcesso().setSelectedItem(numeroProcesso);
		view.getCmbbxPrefeito().setSelectedItem(codigoPrefeito.getNome());
		view.getTxtAforamento().setText(Integer.toString(numeroAforamento));
		view.getDataAforamento().setDate(data);
		view.getTxtFolha().setText(folha);
		view.getTxtLivro().setText(livro);
		view.getTxtObservacao().setText(observação);
	}

	public int obterCodigo() {
		int linha = view.getTable().getSelectedRow();
		int conluna = 0;
		int valor = (int) view.getTable().getValueAt(linha, conluna);
		return valor;
	}


}
