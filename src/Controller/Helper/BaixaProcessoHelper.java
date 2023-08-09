package Controller.Helper;

import java.awt.Desktop;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.PageRanges;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.Document;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.printing.PDFPageable;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrType;

import com.aspose.words.*;

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
	
	public boolean camposVazios() {
		
		Processo numeroProcesso = obterNumeroProcesso();
		String numeroAforamento = view.getTxtAforamento().getText();
		Date data = view.getDataAforamento().getDate();
		String observacao = view.getTxtObservacao().getText();
		Prefeito prefeito = obterCodigoPrefeito();
		String livro = view.getTxtLivro().getText();
		String folha = view.getTxtFolha().getText();
		
		if(numeroProcesso == null || numeroAforamento == null || 
				data == null || prefeito == null || livro == null || folha == null) {
			return true;
		}
		return false;
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
	
	public void escreveDocumento(Aforamento aforamento, Processo processo, Cemiterio cemiterio, Prefeito prefeito){
		
		
		XWPFDocument documento = null;
		String url = "C:\\Users\\josias.maldonado\\eclipse-workspace\\aforamento\\src\\dados.docx";
		
	
		try {
			documento = new XWPFDocument(new FileInputStream(url));
		} catch (FileNotFoundException e) {
			view.errorMensagem("Documento não encontrado", "File Not Found", JOptionPane.ERROR_MESSAGE);;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(documento);

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
		run.setFontFamily("Times New Roman");
		run.addBreak();
		run.addBreak();
		run.setText(paragrafo1);
		run.addBreak();
		run.addBreak();
		
		paragraphT.setAlignment(ParagraphAlignment.RIGHT);
		runT.setBold(true);
		runT.setFontSize(18);
		runT.setFontFamily("Times New Roman");
		runT.setText(Integer.toString(numeroAforamento));
		runT.addBreak();
		runT.addBreak();
		
		XWPFParagraph paragraph2 = documento.createParagraph();
		XWPFRun run2 = paragraph2.createRun();
		
		XWPFParagraph paragraphEspaco = documento.createParagraph();
		XWPFRun runEspaco = paragraphEspaco.createRun();
		
		XWPFParagraph paragraphEspaco2 = documento.createParagraph();
		XWPFRun runEspaco2 = paragraphEspaco2.createRun();
		
		XWPFParagraph paragraph3 = documento.createParagraph();
		XWPFRun run3 = paragraph3.createRun();
		
		XWPFParagraph paragraph4 = documento.createParagraph();
		XWPFRun run4 = paragraph4.createRun();
		
		XWPFParagraph paragraph5 = documento.createParagraph();
		XWPFRun run5 = paragraph4.createRun();
		
		XWPFParagraph paragraph6 = documento.createParagraph();
		XWPFRun run6 = paragraph6.createRun();
		
		XWPFParagraph paragraphEspaco3 = documento.createParagraph();
		XWPFRun runEspaco3 = paragraphEspaco3.createRun();
		
		XWPFParagraph paragraphEspaco4 = documento.createParagraph();
		XWPFRun runEspaco4 = paragraphEspaco4.createRun();
		
		XWPFParagraph paragraph7 = documento.createParagraph();
		XWPFRun run7 = paragraph7.createRun();
		
		XWPFParagraph paragraph8 = documento.createParagraph();
		XWPFRun run8 = paragraph8.createRun();
		
		XWPFParagraph paragraph9 = documento.createParagraph();
		XWPFRun run9 = paragraph9.createRun();
		
		XWPFParagraph paragraph10 = documento.createParagraph();
		XWPFRun run10 = paragraph10.createRun();
		
		XWPFParagraph paragraphEspaco5 = documento.createParagraph();
		XWPFRun runEspaco5 = paragraphEspaco5.createRun();
		
		XWPFParagraph paragraphEspaco6 = documento.createParagraph();
		XWPFRun runEspaco6 = paragraphEspaco4.createRun();
		
		XWPFParagraph paragraph11 = documento.createParagraph();
		XWPFRun run11 = paragraph11.createRun();
		
		XWPFParagraph paragraphEspaco7 = documento.createParagraph();
		XWPFRun runEspaco7 = paragraphEspaco7.createRun();
		
		XWPFParagraph paragraphEspaco8 = documento.createParagraph();
		XWPFRun runEspaco8 = paragraphEspaco8.createRun();
		
		XWPFParagraph paragraph12 = documento.createParagraph();
		XWPFRun run12 = paragraph12.createRun();
		
		XWPFParagraph paragraph13 = documento.createParagraph();
		XWPFRun run13 = paragraph13.createRun();
		
		
		
		String paragrafo2 = "O Prefeito do Município de Ponta Porã, pelo presente Título de Aforamento Perpétuo, concede a " + requerente;
		String paragrafo3 = "Em obediência a Lei Nº 535 de 12 de novembro de 1956 a área "+ medida + " na estaca "+ estaca +" da quadra "+ quadra +", no Cemitério Municipal, "+ nomeCemiterio;
		String paragrafo5 = ", para futuro sepultamento. ";
		String paragrafo6 = "Decorre esta concessão do processo Nº "+ numeroProcesso+ ", na Secretaria Geral, ocorreu o trâmite legal. ";
		String paragrafo8 = "Ponta Porã (MS), "+ sdf.format(data)+".";
		String paragrafo9 = "_____________________________________________";
		String paragrafo10 = nomePrefeito;
		String paragrafo11 = "Registrado à folha "+ folha + " do livro de Registro Nº "+livro;
		String paragrafo12 = "_____________________________________________";
		String paragrafo13 = "Secretário de Infra - Estrutura";
		

		run2.addTab();
		run2.setFontFamily("Times New Roman");
		run2.setText(paragrafo2,-50);

		runEspaco.setText("  ");
		
		runEspaco2.setText(" ");
		
		run3.addTab();
		run3.setFontFamily("Times New Roman");
		run3.setText(paragrafo3);
		run3.setText(paragrafo5);
	
		run6.addTab();
		run6.setFontFamily("Times New Roman");
		run6.setText(paragrafo6);
		
		runEspaco3.setText("  ");
		
		runEspaco4.setText(" ");
		
		paragraph7.setAlignment(ParagraphAlignment.CENTER);
		run7.addTab();
		run7.setFontFamily("Times New Roman");
		run7.setText(paragrafo8);

		paragraph9.setAlignment(ParagraphAlignment.CENTER);
		run9.setFontFamily("Times New Roman");
		run9.setText(paragrafo9);
		
		paragraph10.setAlignment(ParagraphAlignment.CENTER);
		run10.setFontFamily("Times New Roman");
		run10.setText(paragrafo10);
		
		runEspaco5.setText("  ");
		
		runEspaco6.setText(" ");

		paragraph11.setAlignment(ParagraphAlignment.CENTER);
		run11.setFontFamily("Times New Roman");
		run11.setText(paragrafo11);
		runEspaco7.setText("  ");
		
		runEspaco8.setText(" ");
		
		paragraph12.setAlignment(ParagraphAlignment.CENTER);
		run12.setFontFamily("Times New Roman");
		run12.setText(paragrafo12);
		
		paragraph13.setAlignment(ParagraphAlignment.CENTER);
		run13.setFontFamily("Times New Roman");
		run13.setText(paragrafo13);
		
		
		FileOutputStream out;
		try {
			out = new FileOutputStream(url);
			documento.write(out);
			out.close();
			imprimir(url);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	  }

	public void limpaArquivo() throws FileNotFoundException, IOException {
		String url = "C:\\Users\\josias.maldonado\\eclipse-workspace\\aforamento\\src\\dados.docx";
		
		 XWPFDocument documento = new XWPFDocument(new FileInputStream(url));

		    // Limpa todos os parágrafos do corpo do documento
		    for (int i = documento.getBodyElements().size() - 1; i >= 0; i--) {
		        IBodyElement element = documento.getBodyElements().get(i);
		        if (element instanceof XWPFParagraph) {
		            removeParagrafo((XWPFParagraph) element);
		        }
		    }
		    
		    // Salva o documento limpo
		    FileOutputStream out = new FileOutputStream(url);
		    documento.write(out);
		    out.close();
	}

	private static void removeParagrafo(XWPFParagraph paragrafo) {
        // Remove todos os runs (textos) do documento
        for (int i = paragrafo.getRuns().size() - 1; i >= 0; i--) {
            XWPFDocument document = paragrafo.getDocument();
            document.removeBodyElement(i);
        }
    }

	private void imprimir(String url){
		
		File doc = new File(url);
		Desktop desktop = Desktop.getDesktop();
		
		
		  //try { desktop.open(doc); } catch (IOException e) { e.printStackTrace(); }
		 
		  try { desktop.print(doc); } catch (IOException e) { e.printStackTrace(); }
		 
	}

	
	
}
	 
