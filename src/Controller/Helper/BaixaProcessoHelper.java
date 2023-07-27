package Controller.Helper;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import DAO.AforamentoDAO;
import DAO.PrefeitoDAO;
import Model.Aforamento;
import Model.Cemiterio;
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
		view.getCmbbxProcesso().setSelectedItem(null);
		view.getCmbbxPrefeito().setSelectedItem(null);
		
	}

	public void preencheTela(Aforamento aforamento, Prefeito prefeito, Processo processo) {
		String observação = aforamento.getObservacoes();
		int numeroAforamento = aforamento.getNumeroAforamento();
		Date data = aforamento.getDataAforamento();
		String folha = aforamento.getFolha();
		String livro = aforamento.getLivro();
		String situacao = aforamento.getSituacao();
		
		DefaultComboBoxModel comboBoxPrefeito = (DefaultComboBoxModel) view.getCmbbxPrefeito().getModel();
		DefaultComboBoxModel comboBoxProcesso = (DefaultComboBoxModel) view.getCmbbxProcesso().getModel();

		comboBoxProcesso.setSelectedItem(processo);
		comboBoxPrefeito.setSelectedItem(prefeito);
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

	public void setarTableSorter() {
		DefaultTableModel modelo = (DefaultTableModel) view.getTable().getModel();
		TableRowSorter<DefaultTableModel> tableSorter = new TableRowSorter<DefaultTableModel>(modelo);
		view.getTable().setRowSorter(tableSorter);
	}

	public String preparaString(){
		String texto = "TA MALUCO MANO";
		return texto;
	}
	
	public void imprimir(Aforamento aforamento, Processo processo, Cemiterio cemiterio, Prefeito prefeito){
		
		try {
			
		XWPFDocument documento = new XWPFDocument();
		XWPFHeaderFooterPolicy headerFooterPolicy = documento.createHeaderFooterPolicy();
		XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);
		String imagePath = "C:\\Users\\PMPP\\eclipse-workspace\\aforamento\\src\\Style\\PP_logo.png\"";
		XWPFParagraph headerParagraph = header.createParagraph();
		XWPFRun headerRun = headerParagraph.createRun();
			try {
				headerRun.addPicture(new FileInputStream(imagePath), XWPFDocument.PICTURE_TYPE_JPEG, imagePath, Units.toEMU(50), Units.toEMU(50));
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		XWPFParagraph paragraph = documento.createParagraph();
		XWPFParagraph paragraphT = documento.createParagraph();
		XWPFRun run = paragraph.createRun();
		XWPFRun runT = paragraphT.createRun();
		int numeroAforamento = aforamento.getNumeroAforamento();
		String requerente = processo.getRequerente();
		String medida = processo.getMedida();
		String estaca = processo.getEstaca();
		String quadra = processo.getQuadra();
		String nomeCemiterio = cemiterio.getNome();
		int numeroProcesso = processo.getNumeroProcesso();
		String nomePrefeito = prefeito.getNome();
		String folha = aforamento.getFolha();
		String livro = aforamento.getLivro();
		SimpleDateFormat sdf = new SimpleDateFormat("dd  MMMMMM  yyyy");
		Date data = new Date();
		
		
		
		
		String paragrafo1 = "TÍTULO DE AFORAMENTO";
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run.setBold(true);
		run.setFontSize(18);
		run.addBreak();
		run.addBreak();
		run.setText(paragrafo1);
		run.addBreak();
		run.addBreak();
		
		
		paragraphT.setAlignment(ParagraphAlignment.RIGHT);
		runT.setBold(true);
		runT.setFontSize(18);
		runT.setText(Integer.toString(numeroAforamento));
		runT.addBreak();
		runT.addBreak();
		
		
		XWPFParagraph paragraph2 = documento.createParagraph();
		XWPFRun run2 = paragraph2.createRun();
		
		XWPFParagraph paragraph3 = documento.createParagraph();
		XWPFRun run3 = paragraph3.createRun();
		
		XWPFParagraph paragraph4 = documento.createParagraph();
		XWPFRun run4 = paragraph4.createRun();
		
		String paragrafo2 = "O Prefeito do Município de Ponta Porã, pelo presente Título de Aforamento Perpétuo, concede a " + requerente;
		String paragrafo3 = "Em obediência a Lei Nº 535 de 12 de novembro de 1956 a área "+ medida;
		String paragrafo4 = " na estaca "+ estaca +" da quadra "+ quadra +", no cemitério municipal, "+ nomeCemiterio; 
		String paragrafo5 = " onde encontra-se sepultado os restos mortais de para futuro falecimento. ";
		String paragrafo6 = "Decorre esta concessão do processo Nº "+ numeroProcesso;
		String paragrafo7 = ", na Secretaria Geral, ocorreu o trâmite legal. ";
		String paragrafo8 = "Registrado à folha "+ folha + " do livro de Registro Nº "+livro;
		String paragrafo9 = "Ponta Porã (MS), "+ sdf.format(data)+".";
		String paragrafo10 = "_____________________________________________";
		String paragrafo11 = nomePrefeito;
		
		paragraph2.setWordWrap(true);
		run2.addTab();
		run2.setText(paragrafo2);
		run2.addBreak();
		run2.addBreak();
		run2.addBreak();
		run2.addBreak();
		
		//run3.addTab();
		
		run2.setText(paragrafo3);
		run2.setText(paragrafo4);
		run2.setText(paragrafo5);
		run2.addBreak();
		run2.addBreak();
		run2.addBreak();
		run2.addBreak();
		run2.setText(paragrafo6);
		run2.setText(paragrafo7);
		run2.addBreak();
		run2.addBreak();
		run2.addBreak();
		run2.addBreak();
		
		paragraph3.setAlignment(ParagraphAlignment.CENTER);
		run3.setText(paragrafo8);
		run3.addBreak();
		run3.addBreak();
		run3.addBreak();
		run3.addBreak();
		run3.setText(paragrafo9);
		run3.addBreak();
		
		paragraph4.setAlignment(ParagraphAlignment.CENTER);
		run4.setText(paragrafo10);
		run4.addBreak();
		run4.addBreak();
		run4.setText(paragrafo11);
		
		
		FileOutputStream out = new FileOutputStream("dados.docx");
		documento.write(out);
		out.close();
		
		}catch (IOException e) {
			// TODO: handle exception
		}
	  }
	 
	
}
