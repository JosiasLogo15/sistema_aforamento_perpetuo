package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class TelaCadastroUsuario {

	private JFrame frmCadastroDeUsurio;
	private JTextField txtNome;
	private JPasswordField psswdSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario window = new TelaCadastroUsuario();
					window.frmCadastroDeUsurio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeUsurio = new JFrame();
		frmCadastroDeUsurio.setTitle("Cadastro de Usuário");
		frmCadastroDeUsurio.setBounds(100, 100, 253, 256);
		frmCadastroDeUsurio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeUsurio.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 55, 46, 14);
		frmCadastroDeUsurio.getContentPane().add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(65, 54, 142, 20);
		frmCadastroDeUsurio.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 131, 48, 14);
		frmCadastroDeUsurio.getContentPane().add(lblNewLabel_1);
		
		psswdSenha = new JPasswordField();
		psswdSenha.setBounds(65, 128, 142, 20);
		frmCadastroDeUsurio.getContentPane().add(psswdSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(73, 183, 89, 23);
		frmCadastroDeUsurio.getContentPane().add(btnCadastrar);
	}
}
