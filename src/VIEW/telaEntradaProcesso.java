package VIEW;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Controller.EntradaProcessoController;

public class TelaEntradaProcesso {

	private JFrame frmEntradaProcesso;
	private JTextField txtNumeroProcesso;
	private JTextField txtRequerente;
	private JTextField txtFalecido;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtQuadra;
	private JTextField txtEstaca;
	private JTextField txtRg;
	private JTextField txtMedida;
	private JTextField txtNacionalidade;
	private JTable table;
	private EntradaProcessoController controller;
	private JDateChooser dataEntrada = new JDateChooser();
	private JComboBox cmbbxCemiterio = new JComboBox();
	private JTextField txtBusca;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { TelaEntradaProcesso window = new
	 * TelaEntradaProcesso(); window.frmEntradaProcesso.setVisible(true); } catch
	 * (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the application.
	 */
	public TelaEntradaProcesso() {
		initialize();
		controller = new EntradaProcessoController(this);
		controller.listaComboBox();
		controller.listaProcessos();
		controller.setarTableSorter();
		controller.limpaTela();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEntradaProcesso = new JFrame();
		frmEntradaProcesso.setResizable(false);
		frmEntradaProcesso.setTitle("Entrada Processo");
		frmEntradaProcesso.setBounds(100, 100, 758, 413);
		frmEntradaProcesso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEntradaProcesso.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nº Processo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 25, 97, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel);
		
		txtNumeroProcesso = new JTextField();
		txtNumeroProcesso.setBounds(103, 24, 80, 20);
		frmEntradaProcesso.getContentPane().add(txtNumeroProcesso);
		txtNumeroProcesso.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Requerente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(210, 25, 86, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1);
		
		txtRequerente = new JTextField();
		txtRequerente.setBounds(303, 24, 163, 20);
		 
		frmEntradaProcesso.getContentPane().add(txtRequerente);
		txtRequerente.setColumns(10);
		
		txtFalecido = new JTextField();
		txtFalecido.setBounds(548, 24, 184, 20);
		frmEntradaProcesso.getContentPane().add(txtFalecido);
		txtFalecido.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Falecido:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(476, 25, 66, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_1);
		dataEntrada.setDateFormatString("dd'/'MM'/'y");
		
		dataEntrada.setBounds(609, 87, 108, 20);
		frmEntradaProcesso.getContentPane().add(dataEntrada);
		
		JLabel lblDataDeEntrada = new JLabel("Data de Entrada:");
		lblDataDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDataDeEntrada.setBounds(484, 87, 124, 14);
		frmEntradaProcesso.getContentPane().add(lblDataDeEntrada);
		
		JLabel lblNewLabel_1_2 = new JLabel("Endereço:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(145, 56, 86, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(221, 56, 227, 20);
		frmEntradaProcesso.getContentPane().add(txtEndereco);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Bairro:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(489, 56, 47, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2_1);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(546, 56, 186, 20);
		frmEntradaProcesso.getContentPane().add(txtBairro);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Quadra:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(10, 88, 56, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2_1_1);
		
		txtQuadra = new JTextField();
		txtQuadra.setColumns(10);
		txtQuadra.setBounds(76, 87, 56, 20);
		frmEntradaProcesso.getContentPane().add(txtQuadra);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Estaca:");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1.setBounds(161, 90, 56, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		txtEstaca = new JTextField();
		txtEstaca.setColumns(10);
		txtEstaca.setBounds(216, 87, 56, 20);
		frmEntradaProcesso.getContentPane().add(txtEstaca);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("RG:");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1_1.setBounds(10, 56, 66, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2_1_1_1_1);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(41, 55, 80, 20);
		frmEntradaProcesso.getContentPane().add(txtRg);
		
		txtMedida = new JTextField();
		txtMedida.setColumns(10);
		txtMedida.setBounds(360, 87, 98, 20);
		frmEntradaProcesso.getContentPane().add(txtMedida);
		
		JLabel lblNewLabel_1_2_1_1_1_2 = new JLabel("Medida:");
		lblNewLabel_1_2_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1_2.setBounds(294, 91, 56, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2_1_1_1_2);
		
		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("Nacionalidade:");
		lblNewLabel_1_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_2.setBounds(7, 129, 108, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2_1_1_2);
		
		txtNacionalidade = new JTextField();
		txtNacionalidade.setColumns(10);
		txtNacionalidade.setBounds(112, 128, 102, 20);
		frmEntradaProcesso.getContentPane().add(txtNacionalidade);
		
		JLabel lblNewLabel_1_2_1_1_2_1 = new JLabel("Cemitério:");
		lblNewLabel_1_2_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_2_1.setBounds(269, 129, 78, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2_1_1_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 201, 722, 162);
		frmEntradaProcesso.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					controller.preencheTela();
					txtNumeroProcesso.setEditable(false);
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"N\u00BA Processos", "Requerente", "Falecido", "Endere\u00E7o", "Bairro", "Quadra", "Estaca", "Data de Entrada", "Cemiterio"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMaxWidth(70);
		scrollPane.setViewportView(table);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(TelaEntradaProcesso.class.getResource("/Style/ICONS/Save_icon.png")));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastrar();
			}
		});
		btnCadastrar.setBounds(10, 155, 138, 41);
		frmEntradaProcesso.getContentPane().add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(TelaEntradaProcesso.class.getResource("/Style/ICONS/Update_icon.png")));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.alterar();
				txtNumeroProcesso.setEditable(true);
			}
		});
		btnAlterar.setBounds(161, 155, 138, 41);
		frmEntradaProcesso.getContentPane().add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setIcon(new ImageIcon(TelaEntradaProcesso.class.getResource("/Style/ICONS/Erase_icon.png")));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.excluir();
			}
		});
		btnDeletar.setBounds(311, 155, 138, 41);
		frmEntradaProcesso.getContentPane().add(btnDeletar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(TelaEntradaProcesso.class.getResource("/Style/ICONS/Search_icon.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.buscar();
			}
		});
		btnBuscar.setBounds(461, 155, 138, 41);
		frmEntradaProcesso.getContentPane().add(btnBuscar);
		cmbbxCemiterio.setToolTipText("");
		cmbbxCemiterio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.listaComboBox();
			}
		});
		
		
		cmbbxCemiterio.setBounds(348, 127, 163, 22);
		frmEntradaProcesso.getContentPane().add(cmbbxCemiterio);
		
		txtBusca = new JTextField();
		txtBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				controller.buscar();
			}
		});
		txtBusca.setBounds(594, 127, 114, 20);
		frmEntradaProcesso.getContentPane().add(txtBusca);
		txtBusca.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1_2_1_1 = new JLabel("Busca:");
		lblNewLabel_1_2_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_2_1_1.setBounds(544, 129, 78, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2_1_1_2_1_1);
		
		JButton btnLimparCampo = new JButton("Limpar");
		btnLimparCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.limpaTela();
				txtNumeroProcesso.setEditable(true);
			}
		});
		btnLimparCampo.setToolTipText("Clique aqui para limpar os campos");
		btnLimparCampo.setIcon(new ImageIcon(TelaEntradaProcesso.class.getResource("/Style/ICONS/eraser.png")));
		btnLimparCampo.setBounds(609, 155, 123, 41);
		frmEntradaProcesso.getContentPane().add(btnLimparCampo);
	}

	public JDateChooser getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(JDateChooser dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public JTextField getTxtNumeroProcesso() {
		return txtNumeroProcesso;
	}

	public void setTxtNumeroProcesso(JTextField txtNumeroProcesso) {
		this.txtNumeroProcesso = txtNumeroProcesso;
	}

	public JTextField getTxtRequerente() {
		return txtRequerente;
	}

	public void setTxtRequerente(JTextField txtRequerente) {
		this.txtRequerente = txtRequerente;
	}

	public JTextField getTxtFalecido() {
		return txtFalecido;
	}

	public void setTxtFalecido(JTextField txtFalecido) {
		this.txtFalecido = txtFalecido;
	}

	public JTextField getTxtEndereco() {
		return txtEndereco;
	}

	public void setTxtEndereco(JTextField txtEndereco) {
		this.txtEndereco = txtEndereco;
	}

	public JTextField getTxtBairro() {
		return txtBairro;
	}

	public void setTxtBairro(JTextField txtBairro) {
		this.txtBairro = txtBairro;
	}

	public JTextField getTxtQuadra() {
		return txtQuadra;
	}

	public void setTxtQuadra(JTextField txtQuadra) {
		this.txtQuadra = txtQuadra;
	}

	public JTextField getTxtEstaca() {
		return txtEstaca;
	}

	public void setTxtEstaca(JTextField txtEstaca) {
		this.txtEstaca = txtEstaca;
	}

	public JTextField getTxtRg() {
		return txtRg;
	}

	public void setTxtRg(JTextField txtRg) {
		this.txtRg = txtRg;
	}

	public JTextField getTxtMedida() {
		return txtMedida;
	}

	public void setTxtMedida(JTextField txtMedida) {
		this.txtMedida = txtMedida;
	}

	public JTextField getTxtNacionalidade() {
		return txtNacionalidade;
	}

	public void setTxtNacionalidade(JTextField txtNacionalidade) {
		this.txtNacionalidade = txtNacionalidade;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JComboBox getCmbbxCemiterio() {
		return cmbbxCemiterio;
	}

	public void setCmbbxCemiterio(JComboBox cmbbxCemiterio) {
		this.cmbbxCemiterio = cmbbxCemiterio;
	}

	public JTextField getTxtBusca() {
		return txtBusca;
	}

	public void setTxtBusca(JTextField txtBusca) {
		this.txtBusca = txtBusca;
	}

	public JFrame getFrmEntradaProcesso() {
		return frmEntradaProcesso;
	}

	public void setFrmEntradaProcesso(JFrame frmEntradaProcesso) {
		this.frmEntradaProcesso = frmEntradaProcesso;
	}

	public void exibeMensage(String string) {
		JOptionPane.showMessageDialog(cmbbxCemiterio, string);
		
	}

	public void mostraTela() {
		frmEntradaProcesso.setVisible(true);
	}
	
	public void fechaTela() {
		frmEntradaProcesso.dispose();
	}
}
