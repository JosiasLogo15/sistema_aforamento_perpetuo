package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class telaCadastroCemiterio {

	private JFrame frmCadastroDeCemitrios;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JButton btnCadastrar;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaCadastroCemiterio window = new telaCadastroCemiterio();
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
	public telaCadastroCemiterio() {
		initialize();
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
		
		textField = new JTextField();
		textField.setBounds(66, 41, 404, 20);
		frmCadastroDeCemitrios.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndereco.setBounds(10, 95, 70, 14);
		frmCadastroDeCemitrios.getContentPane().add(lblEndereco);
		
		textField_1 = new JTextField();
		textField_1.setBounds(87, 94, 383, 20);
		frmCadastroDeCemitrios.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBairro.setBounds(10, 149, 52, 14);
		frmCadastroDeCemitrios.getContentPane().add(lblBairro);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 148, 404, 20);
		frmCadastroDeCemitrios.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
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
		btnCadastrar.setBounds(10, 192, 89, 23);
		frmCadastroDeCemitrios.getContentPane().add(btnCadastrar);
		
		btnExcluir = new JButton("Deletar");
		btnExcluir.setBounds(109, 192, 89, 23);
		frmCadastroDeCemitrios.getContentPane().add(btnExcluir);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(208, 192, 89, 23);
		frmCadastroDeCemitrios.getContentPane().add(btnAlterar);
	}
}
