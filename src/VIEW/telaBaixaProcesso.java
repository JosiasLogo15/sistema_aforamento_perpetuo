package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

import Controller.BaixaProcessoController;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class TelaBaixaProcesso {

	private JFrame frmBaixaProcesso;
	private JTextField txtAforamento;
	private JTextField txtLivro;
	private JTextField txtFolha;
	private JTable table;
	private BaixaProcessoController controller;
	private JDateChooser dataAforamento = new JDateChooser();
	private JComboBox cmbbxProcesso = new JComboBox();
	private JComboBox cmbbxPrefeito = new JComboBox();
	private JTextArea txtObservacao = new JTextArea();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBaixaProcesso window = new TelaBaixaProcesso();
					window.frmBaixaProcesso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBaixaProcesso() {
		initialize();
		controller = new BaixaProcessoController(this);
		controller.listaCmbBoxProcessos();
		controller.listaCmbBoxPrefeitos();
		controller.listaAforamentos();
		controller.limpaTela();
		controller.setarTableSorter();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBaixaProcesso = new JFrame();
		frmBaixaProcesso.setTitle("Baixa Processo");
		frmBaixaProcesso.setBounds(100, 100, 528, 548);
		frmBaixaProcesso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBaixaProcesso.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nº Processo");
		lblNewLabel.setBounds(10, 39, 85, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmBaixaProcesso.getContentPane().add(lblNewLabel);
		cmbbxProcesso.setToolTipText("Selecione o Nº de Processo");
		cmbbxProcesso.setBounds(102, 37, 85, 22);
		frmBaixaProcesso.getContentPane().add(cmbbxProcesso);
		
		JLabel lblNewLabel_1 = new JLabel("Nº Aforamento");
		lblNewLabel_1.setBounds(246, 42, 106, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmBaixaProcesso.getContentPane().add(lblNewLabel_1);
		
		txtAforamento = new JTextField();
		txtAforamento.setToolTipText("Digite o Nº de Aforamento");
		txtAforamento.setBounds(361, 39, 97, 20);
		frmBaixaProcesso.getContentPane().add(txtAforamento);
		txtAforamento.setColumns(10);
		txtObservacao.setBounds(10, 104, 217, 101);
		txtObservacao.setLineWrap(true);
		txtObservacao.setColumns(1);
		frmBaixaProcesso.getContentPane().add(txtObservacao);
		
		JLabel lblNewLabel_2 = new JLabel("Observação");
		lblNewLabel_2.setBounds(10, 79, 85, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmBaixaProcesso.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data do Aforamento");
		lblNewLabel_1_1.setBounds(246, 82, 141, 14);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmBaixaProcesso.getContentPane().add(lblNewLabel_1_1);
		dataAforamento.setToolTipText("Digite ou selecione a data do Aforamento");
		dataAforamento.setDateFormatString("dd'/'MM'/'y");
		dataAforamento.setBounds(392, 80, 108, 20);
		frmBaixaProcesso.getContentPane().add(dataAforamento);
		
		JLabel lblNewLabel_3 = new JLabel("Nome do Prefeito");
		lblNewLabel_3.setBounds(246, 129, 121, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmBaixaProcesso.getContentPane().add(lblNewLabel_3);
		cmbbxPrefeito.setToolTipText("Selecione o Prefeito");
		cmbbxPrefeito.setBounds(373, 127, 127, 22);
		frmBaixaProcesso.getContentPane().add(cmbbxPrefeito);
		
		JLabel lblNewLabel_3_1 = new JLabel("Livro");
		lblNewLabel_3_1.setBounds(246, 165, 34, 14);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmBaixaProcesso.getContentPane().add(lblNewLabel_3_1);
		
		txtLivro = new JTextField();
		txtLivro.setToolTipText("Digite o Livro do Aforamento");
		txtLivro.setBounds(290, 164, 86, 20);
		txtLivro.setColumns(10);
		frmBaixaProcesso.getContentPane().add(txtLivro);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Folha");
		lblNewLabel_3_1_1.setBounds(246, 191, 37, 14);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmBaixaProcesso.getContentPane().add(lblNewLabel_3_1_1);
		
		txtFolha = new JTextField();
		txtFolha.setToolTipText("Digite a Folha do Aforamento");
		txtFolha.setBounds(290, 190, 86, 20);
		txtFolha.setColumns(10);
		frmBaixaProcesso.getContentPane().add(txtFolha);
		
		JButton btnBaixa = new JButton("Baixa");
		btnBaixa.setToolTipText("Clique aqui para dar baixa no Processo de Aforamento");
		btnBaixa.setIcon(new ImageIcon(TelaBaixaProcesso.class.getResource("/Style/ICONS/Save_icon.png")));
		btnBaixa.setBounds(10, 226, 121, 35);
		btnBaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.baixaProcesso();
			}
		});
		frmBaixaProcesso.getContentPane().add(btnBaixa);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setToolTipText("Clique aqui para alterar algum dado do Aforamento");
		btnAlterar.setIcon(new ImageIcon(TelaBaixaProcesso.class.getResource("/Style/ICONS/Update_icon.png")));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.atualizar();
			}
		});
		btnAlterar.setBounds(141, 226, 106, 35);
		frmBaixaProcesso.getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setToolTipText("Clique aqui para Excluir o aforamento selecionado");
		btnExcluir.setIcon(new ImageIcon(TelaBaixaProcesso.class.getResource("/Style/ICONS/Erase_icon.png")));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.excluir();
			}
		});
		btnExcluir.setBounds(256, 226, 116, 35);
		frmBaixaProcesso.getContentPane().add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 266, 490, 232);
		frmBaixaProcesso.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					controller.preencheTela();
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"N\u00BA Aforamento", "N\u00BA Processo", "Data", "Livro", "Folha", "Situa\u00E7\u00E3o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btnImprimir = new JButton("");
		btnImprimir.setToolTipText("Clique aqui para imprimir o aforamento");
		btnImprimir.setIcon(new ImageIcon(TelaBaixaProcesso.class.getResource("/Style/ICONS/Scan_icon.png")));
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.imprimir();
			}
		});
		btnImprimir.setBounds(417, 176, 56, 29);
		frmBaixaProcesso.getContentPane().add(btnImprimir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.limpaTela();
			}
		});
		btnLimpar.setIcon(new ImageIcon(TelaBaixaProcesso.class.getResource("/Style/ICONS/eraser.png")));
		btnLimpar.setToolTipText("Clique aqui para Excluir o aforamento selecionado");
		btnLimpar.setBounds(384, 226, 116, 35);
		frmBaixaProcesso.getContentPane().add(btnLimpar);
	}

	public JTextField getTxtAforamento() {
		return txtAforamento;
	}

	public JTextField getTxtLivro() {
		return txtLivro;
	}

	public JTextField getTxtFolha() {
		return txtFolha;
	}

	public JTable getTable() {
		return table;
	}

	public void setTxtAforamento(JTextField txtAforamento) {
		this.txtAforamento = txtAforamento;
	}

	public void setTxtLivro(JTextField txtLivro) {
		this.txtLivro = txtLivro;
	}

	public void setTxtFolha(JTextField txtFolha) {
		this.txtFolha = txtFolha;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JDateChooser getDataAforamento() {
		return dataAforamento;
	}

	public void setDataAforamento(JDateChooser dataAforamento) {
		this.dataAforamento = dataAforamento;
	}

	public JComboBox getCmbbxProcesso() {
		return cmbbxProcesso;
	}

	public JComboBox getCmbbxPrefeito() {
		return cmbbxPrefeito;
	}

	public void setCmbbxProcesso(JComboBox cmbbxProcesso) {
		this.cmbbxProcesso = cmbbxProcesso;
	}

	public void setCmbbxPrefeito(JComboBox cmbbxPrefeito) {
		this.cmbbxPrefeito = cmbbxPrefeito;
	}

	public JTextArea getTxtObservacao() {
		return txtObservacao;
	}

	public void setTxtObservacao(JTextArea txtObservacao) {
		this.txtObservacao = txtObservacao;
	}

	public void mostraTela() {
		frmBaixaProcesso.setVisible(true);
	}

	public void exibeMensagem(String mensagem) {
		JOptionPane.showMessageDialog(frmBaixaProcesso, mensagem);
	}
	public int mensagemConfirmacao(String mensagem, String titulo, int tipoMensagem) {
		return JOptionPane.showConfirmDialog(frmBaixaProcesso, mensagem, titulo, tipoMensagem);
	}
	
	public void errorMensagem(String mensagem, String titulo, int tipoMensagem) {
		JOptionPane.showMessageDialog(frmBaixaProcesso, mensagem, titulo, tipoMensagem);
	}
}
