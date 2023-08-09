package Controller.Helper;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Model.Cemiterio;
import VIEW.TelaMenuPrincipal;

public class MenuHelper {
	private TelaMenuPrincipal view;
	
	public MenuHelper(TelaMenuPrincipal view) {
		this.view = view;
	}
	
	public Cemiterio obterModelo() {
		Cemiterio cemiterio = new Cemiterio();
		
		return cemiterio;
	}

	public void preencheInfo() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYY");
		
		String usuario = view.getUsuario();
		Date data = new Date();
		String nivel = "Administrador";
		String site = "pontapora.ms.gov.br/v2/";
		String versao = "1.0.0";
		Relogio relogio = new Relogio(view.getTxtHora());
		
		view.getTxtNomeUsuario().setText(usuario);
		view.getTxtNivel().setText(nivel);
		view.getTxtData().setText(formato.format(data));
		view.getTxtHora().setText(Integer.toString(data.getHours()));
		view.getTxtSite().setText(site);
		view.getTxtVersao().setText(versao);
		
	}

	public void abrirSite() {
		try {
			Desktop.getDesktop().browse(new URI("https://pontapora.ms.gov.br/v2/"));
		}catch(IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		
	}
}
