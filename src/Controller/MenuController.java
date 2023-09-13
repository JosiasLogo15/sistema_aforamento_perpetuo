package Controller;

import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Controller.Helper.MenuHelper;
import VIEW.TelaBaixaProcesso;
import VIEW.TelaCadastroCemiterio;
import VIEW.TelaCadastroPrefeito;
import VIEW.TelaCadastroUsuario;
import VIEW.TelaEntradaProcesso;
import VIEW.TelaMenuPrincipal;

public class MenuController {
	private final TelaMenuPrincipal view;
	private final MenuHelper helper;
	
	private TelaCadastroCemiterio cemiterioView;
	private TelaCadastroPrefeito prefeitoView;
	private TelaCadastroUsuario usuarioView;
	private TelaEntradaProcesso entradaProcessoView;
	private TelaBaixaProcesso baixaProcessoView;
	
	
	public MenuController(TelaMenuPrincipal view) {
		this.view = view;
		this.helper = new MenuHelper(view);
	}
	
	public void cadastraCemiterio() {

		if(cemiterioView == null) {
			this.cemiterioView = new TelaCadastroCemiterio();
			this.cemiterioView.getFrmCadastroDeCemiterios().setLocationRelativeTo(view.getFrmMenuPrincipal());
		}else {
				cemiterioView.getFrmCadastroDeCemiterios().setState(cemiterioView.getFrmCadastroDeCemiterios().NORMAL);
			}
			
			  cemiterioView.getFrmCadastroDeCemiterios().addWindowListener(new
			  WindowAdapter() {
			  
			  @Override public void windowClosed(WindowEvent e) {
			  
			  cemiterioView = null; } });
			 
		
	
		cemiterioView.mostraTela();
		
	}

	public void cadastraPrefeito() {
		
		if (prefeitoView == null) {
			this.prefeitoView = new TelaCadastroPrefeito();
			prefeitoView.getFrmCadastroPrefeito().setLocationRelativeTo(view.getFrmMenuPrincipal());
		}else {
			prefeitoView.getFrmCadastroPrefeito().setState(prefeitoView.getFrmCadastroPrefeito().NORMAL);
			
		}
		prefeitoView.getFrmCadastroPrefeito().addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				prefeitoView = null;
			}
		});
		prefeitoView.mostraTela();
	}

	public void cadastraUsuario() {
		if(usuarioView == null) {
			this.usuarioView = new TelaCadastroUsuario();
			usuarioView.getFrmCadastroDeUsurio().setLocationRelativeTo(view.getFrmMenuPrincipal());
		}else {
			usuarioView.getFrmCadastroDeUsurio().setState(usuarioView.getFrmCadastroDeUsurio().NORMAL);
		}
		usuarioView.getFrmCadastroDeUsurio().addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				usuarioView = null;
			}
		});
		
		usuarioView.mostraTela();
	}

	public void EntradaProcesso() {
		if (entradaProcessoView == null) {
			this.entradaProcessoView = new TelaEntradaProcesso();
			this.entradaProcessoView.getFrmEntradaProcesso().setLocationRelativeTo(view.getFrmMenuPrincipal());
		}else {
			entradaProcessoView.getFrmEntradaProcesso().setState(entradaProcessoView.getFrmEntradaProcesso().NORMAL);
		}
		entradaProcessoView.getFrmEntradaProcesso().addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				entradaProcessoView = null;
			}
		});
		entradaProcessoView.mostraTela();
	}

	public void BaixaProcesso() {
		if(baixaProcessoView == null) {
			this.baixaProcessoView = new TelaBaixaProcesso();
			this.baixaProcessoView.getFrmBaixaProcesso().setLocationRelativeTo(view.getFrmMenuPrincipal());
		}else {
			baixaProcessoView.getFrmBaixaProcesso().setState(baixaProcessoView.getFrmBaixaProcesso().NORMAL);
		}
		baixaProcessoView.getFrmBaixaProcesso().addWindowListener(new WindowAdapter() {
					
					@Override
					public void windowClosed(WindowEvent e) {
						
						baixaProcessoView = null;
					}
				});
		baixaProcessoView.mostraTela();
	}

	public void preencheInfo() {
		helper.preencheInfo();
	}

	public void abrirSite() {
		helper.abrirSite();
		
	}
	
}
