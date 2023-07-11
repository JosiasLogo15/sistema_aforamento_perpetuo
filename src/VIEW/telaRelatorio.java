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
import javax.swing.JButton;

public class TelaRelatorio {

	private JFrame frmRelatrios;
	private JTextField txtBusca;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio window = new TelaRelatorio();
					window.frmRelatrios.setVisible(true);
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRelatrios = new JFrame();
		frmRelatrios.setTitle("Relatórios");
		frmRelatrios.setBounds(100, 100, 666, 444);
		frmRelatrios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRelatrios.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite a Busca");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 61, 96, 14);
		frmRelatrios.getContentPane().add(lblNewLabel);
		
		txtBusca = new JTextField();
		txtBusca.setBounds(112, 60, 237, 20);
		frmRelatrios.getContentPane().add(txtBusca);
		txtBusca.setColumns(10);
		
		JComboBox cmbbxFiltroBusca = new JComboBox();
		cmbbxFiltroBusca.setModel(new DefaultComboBoxModel(new String[] {"Nº de Processo", "Nº de Aforamento", "teste"}));
		cmbbxFiltroBusca.setBounds(132, 13, 115, 22);
		frmRelatrios.getContentPane().add(cmbbxFiltroBusca);
		
		JLabel lblNewLabel_1 = new JLabel("Filtro de Busca");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 15, 101, 14);
		frmRelatrios.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 630, 246);
		frmRelatrios.getContentPane().add(scrollPane);
		
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
		btnBuscar.setBounds(21, 106, 115, 32);
		frmRelatrios.getContentPane().add(btnBuscar);
		
		JButton btnImprimir = new JButton("Imprimir\r\n");
		btnImprimir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnImprimir.setBounds(504, 106, 124, 32);
		frmRelatrios.getContentPane().add(btnImprimir);
	}

}
