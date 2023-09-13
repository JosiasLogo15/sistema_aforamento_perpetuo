package Controller.Helper;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import Model.Cemiterio;
import VIEW.TelaCadastroCemiterio;

public class CemiterioHelper {
	private TelaCadastroCemiterio view;

	public CemiterioHelper(TelaCadastroCemiterio view) {
		this.view = view;
	}
	
	public Cemiterio obterModelo() {
		Cemiterio cemiterio = new Cemiterio();
		String nome = view.getTxtNome().getText().toUpperCase();
		String endereco = view.getTxtEndereco().getText().toUpperCase();
		String bairro = view.getTxtBairro().getText().toUpperCase();
		
		cemiterio.setNome(nome);
		cemiterio.setEndereco(endereco);
		cemiterio.setBairro(bairro);
		
		return cemiterio;
	}
	
	
	public void limpaTela() {
		view.getTxtNome().setText("");
		view.getTxtEndereco().setText("");
		view.getTxtBairro().setText("");
	}

	public void listaCemiterio(List<Cemiterio> listaCemiterios) {
		
		DefaultTableModel dtmCemiterio = (DefaultTableModel) view.getTable().getModel();
		dtmCemiterio.setNumRows(0);
		
		for(Cemiterio c : listaCemiterios) {
			Object[] dados = {
					c.getCodigoCemiterio(),
					c.getNome(),
					c.getEndereco(),
					c.getBairro()
			};
			
			dtmCemiterio.addRow(dados);
		}
		
	}

	public boolean verificaModelo(Cemiterio cemiterio) {
		
		String nome = cemiterio.getNome();
		String endereco = cemiterio.getEndereco();
		String bairro = cemiterio.getBairro();
		
		if(nome == "" || endereco == "" ||  bairro == "") {
			return false;
		}
		
		return true;
	}

	public int capturaValor() {
		int linha = view.getTable().getSelectedRow();
		int coluna = 0;
		int valor = (int) view.getTable().getValueAt(linha, coluna);
		return valor;
	}

	public void preencheTela(Cemiterio cemiterio) {
		String nome = cemiterio.getNome();
		String endereco = cemiterio.getEndereco();
		String bairro = cemiterio.getBairro();
		
		view.getTxtNome().setText(nome);
		view.getTxtEndereco().setText(endereco);
		view.getTxtBairro().setText(bairro);
	}
}
