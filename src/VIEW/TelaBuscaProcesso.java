package VIEW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.BuscaProcessoController;

public class TelaBuscaProcesso extends JFrame {
	private JTable table;
	private JTextField txtFiltro;
	private final BuscaProcessoController controller;
	private JFrame frmBuscaProcesso = new JFrame();
	private JComboBox cmbbxProcesso;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnNumeroProcesso = new JRadioButton("Nº Processo");
	private JRadioButton rdbtnRequerente = new JRadioButton("Requerente");
	private JRadioButton rdbtnDataEntrada = new JRadioButton("Data de Entrada");
	private JRadioButton rdbtnFalecido = new JRadioButton("Falecido");
	private JButton btnSelecionar = new JButton("Selecionar");
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { TelaBuscaProcesso frame = new
	 * TelaBuscaProcesso(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	
	

	/**
	 * Create the frame.
	 */
	
	public TelaBuscaProcesso(JComboBox cmbbxProcesso) {
		initialize();
		controller = new BuscaProcessoController(this);
		controller.setarTableSorter();
		controller.listaProcessos();
		this.cmbbxProcesso = cmbbxProcesso;
	}
	
	
	
	private void initialize() {
		frmBuscaProcesso.setResizable(false);
		
		
		frmBuscaProcesso.setTitle("Busca Processos");
		frmBuscaProcesso.setBounds(100, 100, 755, 416);
		frmBuscaProcesso.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 119, 719, 247);
		frmBuscaProcesso.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					controller.obterValor();
					frmBuscaProcesso.dispose();
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"N\u00BA Processo", "Requerente", "Falecido", "Endere\u00E7o", "Bairro", "Quadra", "Estaca", "Cemiterio", "Data de Entrada"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(table);
		
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(TelaBuscaProcesso.class.getResource("/Style/ICONS/Search_icon.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.buscar();
				frmBuscaProcesso.dispose();
			}
		});
		btnBuscar.setBounds(274, 62, 126, 41);
		frmBuscaProcesso.getContentPane().add(btnBuscar);
		
		txtFiltro = new JTextField();
		/*
		 * txtFiltro.addKeyListener(new KeyAdapter() {
		 * 
		 * @Override public void keyReleased(KeyEvent e) { if(txtFiltro.getText() !=
		 * null) { controller.buscar(); controller.listaProcessos(); } }
		 * 
		 * });
		 */
		txtFiltro.setBounds(274, 28, 184, 23);
		frmBuscaProcesso.getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);
		
		
		btnSelecionar.setIcon(new ImageIcon(TelaBuscaProcesso.class.getResource("/Style/ICONS/check_sign_icon.png")));
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.obterValor();
				frmBuscaProcesso.dispose();
			}
		});
		btnSelecionar.setBounds(413, 62, 126, 41);
		frmBuscaProcesso.getContentPane().add(btnSelecionar);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(null, "Selecione a Opção de Busca", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(16, 20, 247, 84);
		frmBuscaProcesso.getContentPane().add(panel);
		panel.setLayout(null);
		
		rdbtnNumeroProcesso.setSelected(true);
		rdbtnNumeroProcesso.setBounds(6, 16, 109, 23);
		panel.add(rdbtnNumeroProcesso);
		buttonGroup.add(rdbtnNumeroProcesso);
		
		
		rdbtnRequerente.setBounds(6, 55, 109, 23);
		panel.add(rdbtnRequerente);
		buttonGroup.add(rdbtnRequerente);
		
		
		rdbtnDataEntrada.setBounds(132, 55, 109, 23);
		panel.add(rdbtnDataEntrada);
		buttonGroup.add(rdbtnDataEntrada);
		
		
		rdbtnFalecido.setBounds(132, 16, 109, 23);
		panel.add(rdbtnFalecido);
		buttonGroup.add(rdbtnFalecido);
		

	}



	public JTextField getTxtFiltro() {
		return txtFiltro;
	}



	public void setTxtFiltro(JTextField txtFiltro) {
		this.txtFiltro = txtFiltro;
	}



	public JTable getTable() {
		return table;
	}



	public void setTable(JTable table) {
		this.table = table;
	}



	public JFrame getFrame() {
		return frmBuscaProcesso;
	}



	public void setFrame(JFrame Frame) {
		this.frmBuscaProcesso = Frame;
	}



	public JComboBox getCmbbxProcesso() {
		return cmbbxProcesso;
	}



	public void setCmbbxProcesso(JComboBox cmbbxProcesso) {
		this.cmbbxProcesso = cmbbxProcesso;
	}



	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}



	public JRadioButton getRdbtnNumeroProcesso() {
		return rdbtnNumeroProcesso;
	}



	public JRadioButton getRdbtnRequerente() {
		return rdbtnRequerente;
	}



	public JRadioButton getRdbtnDataEntrada() {
		return rdbtnDataEntrada;
	}



	public JRadioButton getRdbtnFalecido() {
		return rdbtnFalecido;
	}



	public void mostraTela() {
		getFrame().setVisible(true);
	}



	public void exibeMensagem(String mensagem) {
		JOptionPane.showMessageDialog(frmBuscaProcesso, mensagem);
		
	}
}
