package VIEW;

import java.awt.EventQueue;
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

import com.formdev.flatlaf.IntelliJTheme;

import Controller.LoginController;

public class TelaLogin {

	private JFrame frmLogin;
	private JTextField txtNome;
	private JPasswordField psswdSenha;
	private LoginController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		    //UIManager.setLookAndFeel( new FlatLightLaf() );
			//FlatArcIJTheme.setup();
			IntelliJTheme.setup( TelaLogin.class.getResourceAsStream( "/arc-theme.theme.json" ) );
		} catch( Exception ex ) {
		    ex.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
		controller = new LoginController(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("LOGIN");
		frmLogin.setBounds(100, 100, 369, 347);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(151, 11, 52, 20);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(25, 97, 59, 14);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(94, 96, 190, 20);
		frmLogin.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(25, 168, 59, 14);
		frmLogin.getContentPane().add(lblNewLabel_2);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/Style/ICONS/Login_icon.png")));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.login();
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEntrar.setBounds(108, 237, 151, 29);
		frmLogin.getContentPane().add(btnEntrar);
		
		psswdSenha = new JPasswordField();
		psswdSenha.setBounds(94, 167, 190, 20);
		frmLogin.getContentPane().add(psswdSenha);
	}
	
	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JPasswordField getPsswdSenha() {
		return psswdSenha;
	}

	public void setPsswdSenha(JPasswordField psswdSenha) {
		this.psswdSenha = psswdSenha;
	}
	
	public void dispose() {
		this.frmLogin.dispose();
	}
	public void exibeMensagem(String mensagem) {
		JOptionPane.showMessageDialog(frmLogin, mensagem);
	}
}
