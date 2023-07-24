package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaBuscar {

	private JFrame frmBuscar;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscar window = new TelaBuscar();
					window.frmBuscar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBuscar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscar = new JFrame();
		frmBuscar.setTitle("Buscar");
		frmBuscar.setResizable(false);
		frmBuscar.setBounds(100, 100, 264, 297);
		frmBuscar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuscar.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite os dados à buscar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(24, 43, 204, 14);
		frmBuscar.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(24, 90, 202, 20);
		frmBuscar.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(77, 166, 89, 23);
		frmBuscar.getContentPane().add(btnBuscar);
	}
}
