package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.CemiterioController;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroCemiterio {

	private JFrame frmCadastroDeCemitrios;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTable table;
	private JButton btnCadastrar;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JScrollPane scrollPane;
	private CemiterioController controller;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCemiterio window = new TelaCadastroCemiterio();
					window.frmCadastroDeCemitrios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroCemiterio() {
		initialize();
		controller = new CemiterioController(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeCemitrios = new JFrame();
		frmCadastroDeCemitrios.setTitle("Cadastro de Cemitérios");
		frmCadastroDeCemitrios.setBounds(100, 100, 605, 392);
		frmCadastroDeCemitrios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeCemitrios.getContentPane().setLayout(null);
		
		JLabel lblNomeCemiterio = new JLabel("Nome:");
		lblNomeCemiterio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomeCemiterio.setBounds(10, 42, 52, 14);
		frmCadastroDeCemitrios.getContentPane().add(lblNomeCemiterio);
		
		txtNome = new JTextField();
		txtNome.setBounds(66, 41, 404, 20);
		frmCadastroDeCemitrios.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndereco.setBounds(10, 95, 70, 14);
		frmCadastroDeCemitrios.getContentPane().add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(87, 94, 383, 20);
		frmCadastroDeCemitrios.getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBairro.setBounds(10, 149, 52, 14);
		frmCadastroDeCemitrios.getContentPane().add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(66, 148, 404, 20);
		frmCadastroDeCemitrios.getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 239, 569, 103);
		frmCadastroDeCemitrios.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Codigo", "Nome", "Endere\u00E7o", "Bairro"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(52);
		table.getColumnModel().getColumn(1).setPreferredWidth(162);
		table.getColumnModel().getColumn(2).setPreferredWidth(245);
		table.getColumnModel().getColumn(3).setPreferredWidth(170);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastrar();
			}
		});
		btnCadastrar.setBounds(10, 192, 89, 23);
		frmCadastroDeCemitrios.getContentPane().add(btnCadastrar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(109, 192, 89, 23);
		frmCadastroDeCemitrios.getContentPane().add(btnExcluir);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(208, 192, 89, 23);
		frmCadastroDeCemitrios.getContentPane().add(btnAlterar);
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
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

	public void fechaTela() {
		frmCadastroDeCemitrios.dispose();
	}
	
	public void mostraTela() {
		frmCadastroDeCemitrios.setVisible(true);
	}
}
