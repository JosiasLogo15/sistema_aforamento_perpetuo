package Controller.Helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DAO.CemiterioDAO;
import Model.Cemiterio;
import Model.Processo;
import VIEW.TelaEntradaProcesso;

public class EntradaProcessoHelper {
	private TelaEntradaProcesso view;
	private CemiterioDAO cemiterioDAO = new CemiterioDAO();
	private int codigoCemiterio;
	
	public EntradaProcessoHelper(TelaEntradaProcesso view) {
		this.view = view;
	}

	public Processo obterModelo() {
		Processo processo = new Processo();
		Cemiterio cemiterio = new Cemiterio();
		int numeroProcesso = Integer.parseInt(view.getTxtNumeroProcesso().getText());
		String requerente = view.getTxtRequerente().getText().toUpperCase();
		String falecido = view.getTxtFalecido().getText().toUpperCase();
		String Rg = view.getTxtRg().getText().toUpperCase();
		String endereco = view.getTxtEndereco().getText().toUpperCase();
		String bairro = view.getTxtBairro().getText().toUpperCase();
		String quadra = view.getTxtQuadra().getText().toUpperCase();
		String estaca = view.getTxtEstaca().getText().toUpperCase();
		String medida = view.getTxtMedida().getText().toUpperCase();
		Date dataEntrada = view.getDataEntrada().getDate();
		String nacionalidade = view.getTxtNacionalidade().getText().toUpperCase();
		cemiterio = obterCodigoCemiterio();
		
		processo.setNumeroProcesso(numeroProcesso);
		processo.setRequerente(requerente);
		processo.setFalecido(falecido);
		processo.setRg(Rg);
		processo.setEndereco(endereco);
		processo.setBairro(bairro);
		processo.setQuadra(quadra);
		processo.setEstaca(estaca);
		processo.setMedida(medida);
		processo.setDataEntrada(dataEntrada);
		processo.setNacionalidade(nacionalidade);
		processo.setCodigoCemiterio(cemiterio.getCodigoCemiterio());
		
		
		return processo;
	}
	
	private Cemiterio obterCodigoCemiterio() {
		return (Cemiterio) view.getCmbbxCemiterio().getSelectedItem();
	}

	public void listaComboBox(List<Cemiterio> listaCemiterios) {
		DefaultComboBoxModel comboBoxCemiterio = (DefaultComboBoxModel) view.getCmbbxCemiterio().getModel();
		
		for (Cemiterio c : listaCemiterios) {
			comboBoxCemiterio.addElement(c);
		}
	}

	public void listaProcessos(List<Processo> processos) {
		
		DefaultTableModel table = (DefaultTableModel) view.getTable().getModel();
		table.setNumRows(0);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for(Processo p: processos) {
			Object[] dados = {
					p.getNumeroProcesso(),
					p.getRequerente(),
					p.getFalecido(),
					p.getEndereco(),
					p.getBairro(),
					p.getQuadra(),
					p.getEstaca(),
					sdf.format(p.getDataEntrada()),
					cemiterioDAO.findById(p.getCodigoCemiterio()).getNome()
			};
			table.addRow(dados);
		}
		
	}

	public void limpaTela() {
		view.getTxtNumeroProcesso().setText("");
		view.getTxtRequerente().setText("");
		view.getTxtFalecido().setText("");
		view.getTxtRg().setText("");
		view.getTxtEndereco().setText("");
		view.getTxtBairro().setText("");
		view.getTxtQuadra().setText("");
		view.getTxtEstaca().setText("");
		view.getTxtMedida().setText("");
		view.getDataEntrada().setDate(null);
		view.getTxtNacionalidade().setText("");
		view.getCmbbxCemiterio().setSelectedItem(null);
		
		if(view.getTxtNumeroProcesso().isEditable() == false) {
			view.getTxtNumeroProcesso().setEditable(true);
		}
	}

	public int capturaValor() {
		
		int linha = view.getTable().getSelectedRow();
		int coluna = 0;
		int valor = (int) view.getTable().getValueAt(linha, coluna);
		return valor;
	}

	public void preencheTela(Processo processo) {
		String numeroProcesso = Integer.toString(processo.getNumeroProcesso());
		String requerente = processo.getRequerente();
		String falecido = processo.getFalecido();
		String rg = processo.getRg();
		String endereco = processo.getEndereco();
		String bairro = processo.getBairro();
		String quadra = processo.getQuadra();
		String estaca = processo.getEstaca();
		String medida = processo.getMedida();
		Date dataEntrada = processo.getDataEntrada();
		String nacionalidade = processo.getNacionalidade();
		Cemiterio cemiterio = cemiterioDAO.findById(processo.getCodigoCemiterio());
		
		DefaultComboBoxModel comboBox = (DefaultComboBoxModel) view.getCmbbxCemiterio().getModel();
		
		view.getTxtNumeroProcesso().setText(numeroProcesso);
		view.getTxtRequerente().setText(requerente);
		view.getTxtFalecido().setText(falecido);
		view.getTxtRg().setText(rg);
		view.getTxtEndereco().setText(endereco);
		view.getTxtBairro().setText(bairro);
		view.getTxtQuadra().setText(quadra);
		view.getTxtEstaca().setText(estaca);
		view.getTxtMedida().setText(medida);
		view.getDataEntrada().setDate(dataEntrada);
		view.getTxtNacionalidade().setText(nacionalidade);
		comboBox.setSelectedItem(cemiterio);
		
	}

	public void setarTableSorter() {
		DefaultTableModel modelo = (DefaultTableModel) view.getTable().getModel();
		TableRowSorter<DefaultTableModel> tableSorter = new TableRowSorter<DefaultTableModel>(modelo);
		view.getTable().setRowSorter(tableSorter);
		
	}

	public void buscar() {
		DefaultTableModel modelo = (DefaultTableModel) view.getTable().getModel();
		TableRowSorter<DefaultTableModel> tableSorter = new TableRowSorter<DefaultTableModel>(modelo);
		view.getTable().setRowSorter(tableSorter);
		String texto = view.getTxtBusca().getText();
		tableSorter.setRowFilter(RowFilter.regexFilter(texto.toUpperCase()));
	}
}
