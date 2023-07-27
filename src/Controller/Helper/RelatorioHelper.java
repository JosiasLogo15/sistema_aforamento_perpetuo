package Controller.Helper;

import javax.swing.table.DefaultTableModel;

import VIEW.TelaRelatorio;

public class RelatorioHelper {
	private final TelaRelatorio view;

	public RelatorioHelper(TelaRelatorio view) {
		this.view = view;
	}
	
	public int obterOpcao() {
		int opcao = 0;
		if(view.getRdbtnAforamento().isSelected()) {
			 opcao = 0;
		}else if(view.getRdbtnProcesso().isSelected()){
			 opcao = 1;
		}
		return opcao;
	}

	public int obterNumero() {
		int numero = Integer.parseInt(view.getTxtBusca().getText());
		return numero;
	}

	public void listaTabela() {
		DefaultTableModel table = (DefaultTableModel) view.getTable().getModel();
		table.setNumRows(0);
	}
	
}
