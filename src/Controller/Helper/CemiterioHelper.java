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
		String nome = view.getTxtNome().getText();
		String endereco = view.getTxtEndereco().getText();
		String bairro = view.getTxtBairro().getText();
		
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
		
		if(cemiterio.getNome() == "" || cemiterio.getEndereco() == "" || cemiterio.getBairro() == "") {
			return true;
		}
		
		return false;
	}
}
