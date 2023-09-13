package VIEW;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Controller.PrefeitoController;

public class TelaCadastroPrefeito {

	private JFrame frmCadastroPrefeito;
	private JTextField txtNome;
	private JTable table;
	private PrefeitoController controller;
	private Date dataInicio;
	private Date dataFinal;
	private JDateChooser cldrInicio = new JDateChooser();
	private JDateChooser cldrFinal = new JDateChooser();
	
	private boolean estadoMinimizado;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { TelaCadastroPrefeito window = new
	 * TelaCadastroPrefeito(); window.frmCadastroPrefeito.setVisible(true); } catch
	 * (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the application.
	 */
	public TelaCadastroPrefeito() {
		initialize();
		controller = new PrefeitoController(this);
		controller.listaPrefeitos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroPrefeito = new JFrame();
		frmCadastroPrefeito.setResizable(false);
		frmCadastroPrefeito.addWindowListener(new WindowAdapter() {
			@Override
			public void windowIconified(WindowEvent e) {
				estadoMinimizado = true;
			}
		});
		frmCadastroPrefeito.setTitle("Cadastro Prefeito");
		frmCadastroPrefeito.setBounds(100, 100, 403, 410);
		frmCadastroPrefeito.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroPrefeito.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(27, 27, 60, 28);
		frmCadastroPrefeito.getContentPane().add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(80, 33, 268, 20);
		frmCadastroPrefeito.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		cldrInicio.setDateFormatString("d'/'M'/'y");
		
	
		cldrInicio.setBounds(142, 79, 125, 20);
		frmCadastroPrefeito.getContentPane().add(cldrInicio);
		
		JLabel lblNewLabel_1 = new JLabel("Inicio da Gestão:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 83, 116, 14);
		frmCadastroPrefeito.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Final da Gestão:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(21, 133, 116, 14);
		frmCadastroPrefeito.getContentPane().add(lblNewLabel_1_1);
		cldrFinal.setDateFormatString("d'/'M'/'y");
		
		
		cldrFinal.setBounds(142, 132, 125, 20);
		frmCadastroPrefeito.getContentPane().add(cldrFinal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 223, 367, 137);
		frmCadastroPrefeito.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					controller.preencheTela();
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Codigo", "Nome", "In\u00EDcio", "Final"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(26);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(137);
		table.getColumnModel().getColumn(2).setPreferredWidth(59);
		table.getColumnModel().getColumn(3).setPreferredWidth(55);
		scrollPane.setViewportView(table);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(TelaCadastroPrefeito.class.getResource("/Style/ICONS/Save_icon.png")));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataInicio = cldrInicio.getDate();
				dataFinal = cldrFinal.getDate();
				controller.cadastrar();
			}
		});
		btnCadastrar.setBounds(10, 167, 116, 41);
		frmCadastroPrefeito.getContentPane().add(btnCadastrar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setIcon(new ImageIcon(TelaCadastroPrefeito.class.getResource("/Style/ICONS/Erase_icon.png")));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.excluir();
			}
		});
		btnDeletar.setBounds(136, 167, 116, 41);
		frmCadastroPrefeito.getContentPane().add(btnDeletar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(TelaCadastroPrefeito.class.getResource("/Style/ICONS/Update_icon.png")));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.alterar();
			}
		});
		btnAlterar.setBounds(268, 167, 109, 41);
		frmCadastroPrefeito.getContentPane().add(btnAlterar);
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	
	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JDateChooser getCldrInicio() {
		return cldrInicio;
	}

	public void setCldrInicio(JDateChooser cldrInicio) {
		this.cldrInicio = cldrInicio;
	}

	public JDateChooser getCldrFinal() {
		return cldrFinal;
	}

	public void setCldrFinal(JDateChooser cldrFinal) {
		this.cldrFinal = cldrFinal;
	}

	public JFrame getFrmCadastroPrefeito() {
		return frmCadastroPrefeito;
	}

	public void setFrmCadastroPrefeito(JFrame frmCadastroPrefeito) {
		this.frmCadastroPrefeito = frmCadastroPrefeito;
	}

	public void mostraTela() {
		frmCadastroPrefeito.setVisible(true);
		
	}
	
	public void fechaTela() {
		frmCadastroPrefeito.dispose();
	}

	public void exibeMensagem(String string) {
		JOptionPane.showMessageDialog(frmCadastroPrefeito, string);
	}
	
	public void errorMensagem(String mensagem, String titulo, int tipoMensagem) {
		JOptionPane.showMessageDialog(frmCadastroPrefeito, mensagem, titulo, tipoMensagem);
	}
}
