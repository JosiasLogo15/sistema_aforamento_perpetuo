package VIEW;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.MenuController;

public class TelaMenuPrincipal {

	private JFrame frmMenuPrincipal;
	

	

	private JTextField txtNomeUsuario;
	private JTextField txtData;
	private JTextField txtHora;
	private JTextField txtSite;
	private JTextField txtVersao;
	private JTextField txtNivel;
	private MenuController controller;
	
	private String nivelAcesso;
	private String usuario;
	private String infoVersão;
	

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) {
	 * 
	 * EventQueue.invokeLater(new Runnable() { public void run() { try {
	 * TelaMenuPrincipal window = new TelaMenuPrincipal();
	 * window.frmMenuPrincipal.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the application.
	 */
	public TelaMenuPrincipal() {
		initialize();
		controller = new MenuController(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuPrincipal = new JFrame();
		frmMenuPrincipal.setResizable(false);
		frmMenuPrincipal.setTitle("Menu Principal");
		frmMenuPrincipal.setBounds(100, 100, 919, 501);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(7, 0, 0, 0));
		frmMenuPrincipal.setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastros");
		mnCadastro.setIcon(new ImageIcon(TelaMenuPrincipal.class.getResource("/Style/ICONS/Add_icon.png")));
		mnCadastro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnCadastro.setAlignmentX(1);
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCadastroCemiterio = new JMenuItem("Cadastro de Cemitério");
		mntmCadastroCemiterio.setIcon(null);
		mntmCadastroCemiterio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastraCemiterio();
			}
		});
		mnCadastro.add(mntmCadastroCemiterio);
		
		JMenuItem mntmCadastroPrefeito = new JMenuItem("Cadastro de Prefeito");
		mntmCadastroPrefeito.setIcon(null);
		mntmCadastroPrefeito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastraPrefeito();
			}
		});
		mnCadastro.add(mntmCadastroPrefeito);
		
		JMenuItem mntmCadastroUsuario = new JMenuItem("Cadastro de Usuário");
		mntmCadastroUsuario.setIcon(null);
		mntmCadastroUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastraUsuario();
			}
		});
		mnCadastro.add(mntmCadastroUsuario);
		
		JMenu mnProcessos = new JMenu("Processos");
		mnProcessos.setIcon(new ImageIcon(TelaMenuPrincipal.class.getResource("/Style/ICONS/Notes_icon.png")));
		mnProcessos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnProcessos);
		
		JMenuItem mntmEntradaProcesso = new JMenuItem("Entrada Processo");
		mntmEntradaProcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.EntradaProcesso();
			}
		});
		mnProcessos.add(mntmEntradaProcesso);
		
		JMenuItem mntmBaixaProcesso = new JMenuItem("Baixa Processo");
		mntmBaixaProcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.BaixaProcesso();
			}
		});
		mnProcessos.add(mntmBaixaProcesso);
		frmMenuPrincipal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de Aforamentos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(236, 11, 430, 35);
		frmMenuPrincipal.getContentPane().add(lblNewLabel);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setEditable(false);
		txtNomeUsuario.setText("Usuario Logado");
		txtNomeUsuario.setBounds(-3, 425, 185, 24);
		frmMenuPrincipal.getContentPane().add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		txtData = new JTextField();
		txtData.setText("Data");
		txtData.setEditable(false);
		txtData.setBounds(347, 425, 135, 24);
		frmMenuPrincipal.getContentPane().add(txtData);
		txtData.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setText("Hora");
		txtHora.setEditable(false);
		txtHora.setBounds(475, 425, 115, 24);
		frmMenuPrincipal.getContentPane().add(txtHora);
		txtHora.setColumns(10);
		
		txtSite = new JTextField();
		txtSite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.abrirSite();
			}
		});
		txtSite.setEditable(false);
		txtSite.setText("Site Prefeitura");
		txtSite.setBounds(585, 425, 155, 24);
		txtSite.setForeground(Color.BLUE.darker());
		txtSite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frmMenuPrincipal.getContentPane().add(txtSite);
		txtSite.setColumns(10);
		
		txtVersao = new JTextField();
		txtVersao.setEditable(false);
		txtVersao.setText("info versão");
		txtVersao.setBounds(735, 425, 180, 24);
		frmMenuPrincipal.getContentPane().add(txtVersao);
		txtVersao.setColumns(10);
		
		txtNivel = new JTextField();
		txtNivel.setHorizontalAlignment(SwingConstants.LEFT);
		txtNivel.setText("nivel de acesso");
		txtNivel.setEditable(false);
		txtNivel.setBounds(176, 425, 177, 24);
		frmMenuPrincipal.getContentPane().add(txtNivel);
		txtNivel.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaMenuPrincipal.class.getResource("/Style/Brasão cortado.png")));
		lblNewLabel_1.setBounds(298, 67, 307, 290);
		frmMenuPrincipal.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Desenvolvido por: ");
		lblNewLabel_2.setBounds(690, 408, 118, 22);
		frmMenuPrincipal.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Josias de Oliveira");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(787, 408, 118, 22);
		frmMenuPrincipal.getContentPane().add(lblNewLabel_2_1);
	}
	
	public void preencheInfo() {
		controller.preencheInfo();
	}
	
	public JTextField getTxtNomeUsuario() {
		return txtNomeUsuario;
	}

	public void setTxtNomeUsuario(JTextField txtNomeUsuario) {
		this.txtNomeUsuario = txtNomeUsuario;
	}

	public JTextField getTxtData() {
		return txtData;
	}

	public void setTxtData(JTextField txtData) {
		this.txtData = txtData;
	}

	public JTextField getTxtHora() {
		return txtHora;
	}

	public void setTxtHora(JTextField txtHora) {
		this.txtHora = txtHora;
	}

	public JTextField getTxtSite() {
		return txtSite;
	}

	public void setTxtSite(JTextField txtSite) {
		this.txtSite = txtSite;
	}

	public JTextField getTxtVersao() {
		return txtVersao;
	}

	public void setTxtVersao(JTextField txtVersao) {
		this.txtVersao = txtVersao;
	}

	public JTextField getTxtNivel() {
		return txtNivel;
	}

	public void setTxtNivel(JTextField txtNivel) {
		this.txtNivel = txtNivel;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	public String getInfoVersão() {
		return infoVersão;
	}

	public void setInfoVersão(String infoVersão) {
		this.infoVersão = infoVersão;
	}

	public JFrame getFrmMenuPrincipal() {
		return frmMenuPrincipal;
	}


	public void exibeMensagem(String mensagem) {
		JOptionPane.showMessageDialog(frmMenuPrincipal, mensagem);
	}
	
	public void fechaTela(JFrame frmMenuPrincipal) {
		this.frmMenuPrincipal.dispose();
	}
	
	public void mostraTela() {
		frmMenuPrincipal.setLocationRelativeTo(null);
		this.frmMenuPrincipal.setVisible(true);
	}
	

}
