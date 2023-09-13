package Controller.Helper;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import DAO.CemiterioDAO;
import Model.Processo;
import VIEW.TelaBuscaProcesso;

public class BuscaProcessoHelper {
	private final TelaBuscaProcesso view;
	
	public BuscaProcessoHelper(TelaBuscaProcesso view) {
		this.view = view;
	}

	public void setarTableSorter() {
		DefaultTableModel modelo = (DefaultTableModel) view.getTable().getModel();
		TableRowSorter<DefaultTableModel> tableSorter = new TableRowSorter<DefaultTableModel>(modelo);
		view.getTable().setRowSorter(tableSorter);
	}

	public void buscar() {
	    DefaultTableModel modelo = (DefaultTableModel) view.getTable().getModel();
	    TableRowSorter<DefaultTableModel> tableSorter = new TableRowSorter<>(modelo);
	    view.getTable().setRowSorter(tableSorter);
	    
	    String texto = view.getTxtFiltro().getText().toUpperCase();
	    String colunaSelecionada = getColunaSelecionada();

	    int coluna = especificaColuna(tableSorter, modelo, colunaSelecionada);
	    tableSorter.setRowFilter(RowFilter.regexFilter(texto, coluna));
	    
	    if (tableSorter.getViewRowCount() == 0) {
	        view.exibeMensagem("Dado Inexistente");
	        tableSorter.setRowFilter(null);
	    }
	}
	
	private String getColunaSelecionada() {
	    if (view.getRdbtnNumeroProcesso().isSelected()) {
	        return "Nº Processo";
	    } else if (view.getRdbtnRequerente().isSelected()) {
	        return "Requerente";
	    } else if (view.getRdbtnFalecido().isSelected()) {
	        return "Falecido";
	    } else if (view.getRdbtnDataEntrada().isSelected()) {
	        return "Data de Entrada";
	    }
	    
	    return null;
	}

	private int especificaColuna(TableRowSorter<DefaultTableModel> tableSorter, DefaultTableModel modelo, String colunaSelecionada) {
	    int i;
		if (colunaSelecionada != null) {
	        for (i = 0; i < modelo.getColumnCount(); i++) {
	            if (modelo.getColumnName(i).equals(colunaSelecionada)) {
	            	return i;
	            }
	        }
	        
	    }
		return 0;
	}

	private void limpaTela() {
		view.getTxtFiltro().setText("");
		
	}

	public void listaProcessos(List<Processo> listaProcessos) {
		DefaultTableModel modelo = (DefaultTableModel) view.getTable().getModel();
		CemiterioDAO cemiterioDAO = new CemiterioDAO();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		modelo.setRowCount(0);
		for(Processo p: listaProcessos) {
			Object[] dados = {
				p.getNumeroProcesso(),
				p.getRequerente(),
				p.getFalecido(),
				p.getEndereco(),
				p.getBairro(),
				p.getQuadra(),
				p.getEstaca(),
				cemiterioDAO.findById(p.getCodigoCemiterio()),
				formato.format(p.getDataEntrada())
			};
			modelo.addRow(dados);
		}
		
	}

	public int obterValor() {
		int linha = view.getTable().getSelectedRow();
		int coluna = 0;
		int codigo = (int) view.getTable().getValueAt(linha, coluna);
		
		return codigo;
	}
	
}
