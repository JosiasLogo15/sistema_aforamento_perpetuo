package Controller.Helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Model.Prefeito;
import VIEW.TelaCadastroPrefeito;

public class PrefeitoHelper {
	private final TelaCadastroPrefeito view;
	
	public PrefeitoHelper(TelaCadastroPrefeito view) {
		this.view = view;
	}

	public Prefeito obterModelo() {
		Prefeito prefeito = new Prefeito();
		
		String nome = view.getTxtNome().getText();
		Date dataInicio = view.getCldrInicio().getDate();
		Date dataFinal = view.getCldrFinal().getDate();
		
		prefeito.setNome(nome);
		prefeito.setDataInicio(dataInicio);
		prefeito.setDataFinal(dataFinal);
		
		return prefeito;
	}

	public void listaPrefeitos(List<Prefeito> listaPrefeitos) {
		
		DefaultTableModel dtmPrefeito = (DefaultTableModel) view.getTable().getModel();
		dtmPrefeito.setNumRows(0);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		for(Prefeito p : listaPrefeitos) {
			Object[] dados = {
					p.getCodigoPrefeito(),
					p.getNome(),
					formato.format(p.getDataInicio()),
					formato.format(p.getDataFinal())
			};
			
			dtmPrefeito.addRow(dados);
		}
		
	}

	public int capturaValor() {
		int linha = view.getTable().getSelectedRow();
		int coluna = 0;
		int valor = (int) view.getTable().getValueAt(linha, coluna);
		
		return valor;
	}

	public void preencheTela(Prefeito prefeito) {
		String nome = prefeito.getNome();
		Date dataInicio = prefeito.getDataInicio();
		Date dataFinal = prefeito.getDataFinal();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		view.getTxtNome().setText(nome);
		view.getCldrInicio().setDate(dataInicio);
		view.getCldrFinal().setDate(dataFinal);
	}

	public void limpaTela() {
		view.getTxtNome().setText("");
		view.getCldrInicio().setDate(null);
		view.getCldrFinal().setDate(null);
	}

	

}
