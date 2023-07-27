package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controller.RelatorioController;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRelatorio {

	private JFrame frmRelatorios;
	private JTextField txtBusca;
	private JTable table;
	private RelatorioController controller;
	private JRadioButton rdbtnAforamento = new JRadioButton("Aforamento");
	private JRadioButton rdbtnProcesso = new JRadioButton("Processo");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio window = new TelaRelatorio();
					window.frmRelatorios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRelatorio() {
		initialize();
		controller = new RelatorioController(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRelatorios = new JFrame();
		frmRelatorios.setTitle("Relatórios");
		frmRelatorios.setBounds(100, 100, 666, 444);
		frmRelatorios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRelatorios.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite a Busca");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 61, 96, 14);
		frmRelatorios.getContentPane().add(lblNewLabel);
		
		txtBusca = new JTextField();
		txtBusca.setBounds(112, 60, 237, 20);
		frmRelatorios.getContentPane().add(txtBusca);
		txtBusca.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Filtro de Busca");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 15, 101, 14);
		frmRelatorios.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 630, 246);
		frmRelatorios.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"N\u00BA Processo", "N\u00BA Aforamento", "Data", "Folha", "Livro"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.buscar();
			}
		});
		btnBuscar.setBounds(21, 106, 115, 32);
		frmRelatorios.getContentPane().add(btnBuscar);
		
		JButton btnImprimir = new JButton("Imprimir\r\n");
		btnImprimir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnImprimir.setBounds(504, 106, 124, 32);
		frmRelatorios.getContentPane().add(btnImprimir);
		
		rdbtnProcesso.setBounds(123, 13, 109, 23);
		frmRelatorios.getContentPane().add(rdbtnProcesso);
		
		
		rdbtnAforamento.setBounds(245, 13, 109, 23);
		frmRelatorios.getContentPane().add(rdbtnAforamento);
	}

	public JTextField getTxtBusca() {
		return txtBusca;
	}

	public void setTxtBusca(JTextField txtBusca) {
		this.txtBusca = txtBusca;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JRadioButton getRdbtnAforamento() {
		return rdbtnAforamento;
	}

	public void setRdbtnAforamento(JRadioButton rdbtnAforamento) {
		this.rdbtnAforamento = rdbtnAforamento;
	}

	public JRadioButton getRdbtnProcesso() {
		return rdbtnProcesso;
	}

	public void setRdbtnProcesso(JRadioButton rdbtnProcesso) {
		this.rdbtnProcesso = rdbtnProcesso;
	}

	public void mostraTela() {
		frmRelatorios.setVisible(true);
	}
}
