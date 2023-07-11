package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaBaixaProcesso {

	private JFrame frmBaixaProcesso;
	private JTextField txtAforamento;
	private JTextField txtLivro;
	private JTextField txtFolha;
	private JTable table;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBaixaProcesso = new JFrame();
		frmBaixaProcesso.setTitle("Baixa Processo");
		frmBaixaProcesso.setBounds(100, 100, 528, 548);
		frmBaixaProcesso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBaixaProcesso.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nº Processo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 39, 85, 14);
		frmBaixaProcesso.getContentPane().add(lblNewLabel);
		
		JComboBox cmbbxProcesso = new JComboBox();
		cmbbxProcesso.setBounds(102, 37, 85, 22);
		frmBaixaProcesso.getContentPane().add(cmbbxProcesso);
		
		JLabel lblNewLabel_1 = new JLabel("Nº Aforamento");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(246, 42, 106, 14);
		frmBaixaProcesso.getContentPane().add(lblNewLabel_1);
		
		txtAforamento = new JTextField();
		txtAforamento.setBounds(361, 39, 97, 20);
		frmBaixaProcesso.getContentPane().add(txtAforamento);
		txtAforamento.setColumns(10);
		
		JTextArea txtObservacao = new JTextArea();
		txtObservacao.setBounds(10, 104, 217, 101);
		frmBaixaProcesso.getContentPane().add(txtObservacao);
		
		JLabel lblNewLabel_2 = new JLabel("Observação");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 79, 85, 14);
		frmBaixaProcesso.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data do Aforamento");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(246, 82, 141, 14);
		frmBaixaProcesso.getContentPane().add(lblNewLabel_1_1);
		
		JDateChooser dataAforamento = new JDateChooser();
		dataAforamento.setBounds(392, 80, 108, 20);
		frmBaixaProcesso.getContentPane().add(dataAforamento);
		
		JLabel lblNewLabel_3 = new JLabel("Nome do Prefeito");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(246, 129, 121, 14);
		frmBaixaProcesso.getContentPane().add(lblNewLabel_3);
		
		JComboBox cmbbxPrefeito = new JComboBox();
		cmbbxPrefeito.setBounds(373, 127, 85, 22);
		frmBaixaProcesso.getContentPane().add(cmbbxPrefeito);
		
		JLabel lblNewLabel_3_1 = new JLabel("Livro");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(246, 165, 34, 14);
		frmBaixaProcesso.getContentPane().add(lblNewLabel_3_1);
		
		txtLivro = new JTextField();
		txtLivro.setColumns(10);
		txtLivro.setBounds(290, 164, 86, 20);
		frmBaixaProcesso.getContentPane().add(txtLivro);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Folha");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(246, 191, 37, 14);
		frmBaixaProcesso.getContentPane().add(lblNewLabel_3_1_1);
		
		txtFolha = new JTextField();
		txtFolha.setColumns(10);
		txtFolha.setBounds(290, 190, 86, 20);
		frmBaixaProcesso.getContentPane().add(txtFolha);
		
		JButton btnBaixa = new JButton("Baixa");
		btnBaixa.setBounds(10, 238, 89, 23);
		frmBaixaProcesso.getContentPane().add(btnBaixa);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(138, 238, 89, 23);
		frmBaixaProcesso.getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("Exluir");
		btnExcluir.setBounds(263, 238, 89, 23);
		frmBaixaProcesso.getContentPane().add(btnExcluir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(384, 238, 89, 23);
		frmBaixaProcesso.getContentPane().add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 266, 490, 232);
		frmBaixaProcesso.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"N\u00BA Processo", "N\u00BA Aforamento", "Data", "Livro", "Folha", "Situa\u00E7\u00E3o"
			}
		));
	}
}
