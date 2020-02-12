package br.douglasborba.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.douglasborba.appium.core.BaseTest;
import br.douglasborba.appium.page.AlertaPage;
import br.douglasborba.appium.page.MenuPage;

public class AlertTeste extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();
	
	@Test
	public void deveConfirmarAlerta() {
		// acessar menu alerta
		menu.acessarAlertas();
		
		// deve clicar em alert confirm
		page.clicarAlertaConfirm();
		
		// verificar textos
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
		
		// confirmar alerta
		page.confirmar();
		
		// verificar nova mensagem
		Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
		
		// sair
		page.sair();
	}

}
