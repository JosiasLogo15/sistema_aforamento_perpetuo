package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.MenuController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenuPrincipal {

	private JFrame frmMenuPrincipal;
	

	private JTextField txtNomeUsuario;
	private JTextField txtData;
	private JTextField txtHora;
	private JTextField txtSite;
	private JTextField txtVersao;
	private JTextField txtNivel;
	private MenuController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuPrincipal window = new TelaMenuPrincipal();
					window.frmMenuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frmMenuPrincipal.setTitle("Menu Principal");
		frmMenuPrincipal.setBounds(100, 100, 919, 490);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmMenuPrincipal.setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastros");
		mnCadastro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCadastroCemiterio = new JMenuItem("Cadastro de Cemitério");
		mntmCadastroCemiterio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastraCemiterio();
			}
		});
		mnCadastro.add(mntmCadastroCemiterio);
		
		JMenuItem mntmCadastroPrefeito = new JMenuItem("Cadastro de Prefeito");
		mntmCadastroPrefeito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastraPrefeito();
			}
		});
		mnCadastro.add(mntmCadastroPrefeito);
		
		JMenuItem mntmCadastroUsuario = new JMenuItem("Cadastro de Usuário");
		mntmCadastroUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastraUsuario();
			}
		});
		mnCadastro.add(mntmCadastroUsuario);
		
		JMenu mnProcessos = new JMenu("Processos");
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
		
		JMenu mnRelatorios = new JMenu("Relatórios");
		mnRelatorios.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnRelatorios);
		
		JMenuItem mntmRelatorio = new JMenuItem("Relatório");
		mntmRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.relatorio();
			}
		});
		mnRelatorios.add(mntmRelatorio);
		frmMenuPrincipal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de Aforamentos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(264, 49, 430, 35);
		frmMenuPrincipal.getContentPane().add(lblNewLabel);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setEditable(false);
		txtNomeUsuario.setText("Usuario Logado");
		txtNomeUsuario.setBounds(0, 405, 177, 20);
		frmMenuPrincipal.getContentPane().add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		txtData = new JTextField();
		txtData.setText("Data");
		txtData.setEditable(false);
		txtData.setBounds(362, 405, 118, 20);
		frmMenuPrincipal.getContentPane().add(txtData);
		txtData.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setText("Hora");
		txtHora.setEditable(false);
		txtHora.setBounds(479, 405, 111, 20);
		frmMenuPrincipal.getContentPane().add(txtHora);
		txtHora.setColumns(10);
		
		txtSite = new JTextField();
		txtSite.setEditable(false);
		txtSite.setText("Site Prefeitura");
		txtSite.setBounds(589, 405, 150, 20);
		frmMenuPrincipal.getContentPane().add(txtSite);
		txtSite.setColumns(10);
		
		txtVersao = new JTextField();
		txtVersao.setEditable(false);
		txtVersao.setText("info versão");
		txtVersao.setBounds(738, 405, 165, 20);
		frmMenuPrincipal.getContentPane().add(txtVersao);
		txtVersao.setColumns(10);
		
		JButton btnNewButton = new JButton("Logoff");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(768, 324, 105, 35);
		frmMenuPrincipal.getContentPane().add(btnNewButton);
		
		txtNivel = new JTextField();
		txtNivel.setText("nivel de acesso");
		txtNivel.setEditable(false);
		txtNivel.setBounds(176, 405, 187, 20);
		frmMenuPrincipal.getContentPane().add(txtNivel);
		txtNivel.setColumns(10);
	}
	
	public void fechaTela(JFrame frmMenuPrincipal) {
		this.frmMenuPrincipal.dispose();
	}
	
	public void mostraTela() {
		this.frmMenuPrincipal.setVisible(true);
	}
}
