package VIEW;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.UsuarioController;

public class TelaCadastroUsuario {

	private JFrame frmCadastroDeUsurio;
	private JTextField txtNome;
	private JPasswordField psswdSenha;
	private UsuarioController controller;
	
	private boolean estadoMinimizado;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { TelaCadastroUsuario window = new
	 * TelaCadastroUsuario(); window.frmCadastroDeUsurio.setVisible(true); } catch
	 * (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the application.
	 */
	public TelaCadastroUsuario() {
		initialize();
		controller = new UsuarioController(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeUsurio = new JFrame();
		frmCadastroDeUsurio.setResizable(false);
		frmCadastroDeUsurio.setTitle("Cadastro de Usuário");
		frmCadastroDeUsurio.setBounds(100, 100, 253, 256);
		frmCadastroDeUsurio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		lblNewLabel_1.setBounds(10, 115, 48, 14);
		frmCadastroDeUsurio.getContentPane().add(lblNewLabel_1);
		
		psswdSenha = new JPasswordField();
		psswdSenha.setBounds(65, 112, 142, 20);
		frmCadastroDeUsurio.getContentPane().add(psswdSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/Style/ICONS/Save_icon.png")));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.cadastrar();
			}
		});
		btnCadastrar.setBounds(48, 165, 142, 41);
		frmCadastroDeUsurio.getContentPane().add(btnCadastrar);
		
		
	}

	public JPasswordField getPsswdSenha() {
		return psswdSenha;
	}

	public void setPsswdSenha(JPasswordField psswdSenha) {
		this.psswdSenha = psswdSenha;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JFrame getFrmCadastroDeUsurio() {
		return frmCadastroDeUsurio;
	}

	public void setFrmCadastroDeUsurio(JFrame frmCadastroDeUsurio) {
		this.frmCadastroDeUsurio = frmCadastroDeUsurio;
	}

	public void mostraTela() {
		frmCadastroDeUsurio.setVisible(true);
	}
		
	public void fechaTela() {
		frmCadastroDeUsurio.dispose();
	}

	public void exibeMensagem(String string) {
		JOptionPane.showMessageDialog(frmCadastroDeUsurio, string);
	}
	
}
