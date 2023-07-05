package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;

public class telaEntradaProcesso {

	private JFrame frmEntradaProcesso;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaEntradaProcesso window = new telaEntradaProcesso();
					window.frmEntradaProcesso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public telaEntradaProcesso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEntradaProcesso = new JFrame();
		frmEntradaProcesso.setTitle("Entrada Processo");
		frmEntradaProcesso.setBounds(100, 100, 758, 413);
		frmEntradaProcesso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEntradaProcesso.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nº Processo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 46, 97, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(103, 45, 80, 20);
		frmEntradaProcesso.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Requerente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(210, 46, 86, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(303, 45, 163, 20);
		frmEntradaProcesso.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(548, 45, 184, 20);
		frmEntradaProcesso.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Falecido:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(476, 46, 66, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(609, 108, 108, 20);
		frmEntradaProcesso.getContentPane().add(dateChooser);
		
		JLabel lblDataDeEntrada = new JLabel("Data de Entrada:");
		lblDataDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDataDeEntrada.setBounds(484, 108, 124, 14);
		frmEntradaProcesso.getContentPane().add(lblDataDeEntrada);
		
		JLabel lblNewLabel_1_2 = new JLabel("Endereço:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(145, 77, 86, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(221, 77, 227, 20);
		frmEntradaProcesso.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Bairro:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(489, 77, 47, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(546, 77, 186, 20);
		frmEntradaProcesso.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Quadra:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(10, 109, 56, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(76, 108, 56, 20);
		frmEntradaProcesso.getContentPane().add(textField_5);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Estaca:");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1.setBounds(161, 111, 56, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(216, 108, 56, 20);
		frmEntradaProcesso.getContentPane().add(textField_6);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("RG:");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1_1.setBounds(10, 77, 66, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2_1_1_1_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(41, 76, 80, 20);
		frmEntradaProcesso.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(360, 108, 98, 20);
		frmEntradaProcesso.getContentPane().add(textField_8);
		
		JLabel lblNewLabel_1_2_1_1_1_2 = new JLabel("Medida:");
		lblNewLabel_1_2_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1_2.setBounds(294, 112, 56, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2_1_1_1_2);
		
		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("Nacionalidade:");
		lblNewLabel_1_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_2.setBounds(10, 143, 108, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2_1_1_2);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(115, 142, 102, 20);
		frmEntradaProcesso.getContentPane().add(textField_9);
		
		JLabel lblNewLabel_1_2_1_1_2_1 = new JLabel("Cemitério:");
		lblNewLabel_1_2_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_2_1.setBounds(272, 143, 78, 14);
		frmEntradaProcesso.getContentPane().add(lblNewLabel_1_2_1_1_2_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(349, 142, 102, 20);
		frmEntradaProcesso.getContentPane().add(textField_10);
		
		table = new JTable();
		table.setBounds(10, 201, 722, 162);
		frmEntradaProcesso.getContentPane().add(table);
	}
}
