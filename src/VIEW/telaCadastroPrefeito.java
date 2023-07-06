package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class telaCadastroPrefeito {

	private JFrame frmCadastroPrefeito;
	private JTextField txtNome;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaCadastroPrefeito window = new telaCadastroPrefeito();
					window.frmCadastroPrefeito.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public telaCadastroPrefeito() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroPrefeito = new JFrame();
		frmCadastroPrefeito.setTitle("Cadastro Prefeito");
		frmCadastroPrefeito.setBounds(100, 100, 386, 410);
		frmCadastroPrefeito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroPrefeito.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(27, 27, 60, 28);
		frmCadastroPrefeito.getContentPane().add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(80, 33, 268, 20);
		frmCadastroPrefeito.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JDateChooser dataInicio = new JDateChooser();
		dataInicio.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dataInicio.setBounds(142, 79, 125, 20);
		frmCadastroPrefeito.getContentPane().add(dataInicio);
		
		JLabel lblNewLabel_1 = new JLabel("Inicio da Gestão:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 83, 116, 14);
		frmCadastroPrefeito.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Final da Gestão:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(21, 133, 116, 14);
		frmCadastroPrefeito.getContentPane().add(lblNewLabel_1_1);
		
		JDateChooser dataFinal = new JDateChooser();
		dataFinal.setBounds(142, 132, 125, 20);
		frmCadastroPrefeito.getContentPane().add(dataFinal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 223, 350, 137);
		frmCadastroPrefeito.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Codigo", "Nome", "In\u00EDcio", "Final"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 185, 89, 23);
		frmCadastroPrefeito.getContentPane().add(btnCadastrar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(110, 185, 89, 23);
		frmCadastroPrefeito.getContentPane().add(btnDeletar);
	}
}
