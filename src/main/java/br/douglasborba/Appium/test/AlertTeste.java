package br.douglasborba.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.douglasborba.appium.core.BaseTest;
import br.douglasborba.appium.page.AlertaPage;
import br.douglasborba.appium.page.MenuPage;

public class AlertTeste extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();
	
	@Before
	public void setup() {
		menu.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAlerta() {
		// acessar menu alerta
		
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
	
	@Test
	public void deveClicarForaAlerta() {
		// acessar menu alerta
		
		// clicar alerta simples
		page.clicarAlertaSimples();
		
		// clicar fora da caixa
		esperar(1000);
		page.clicarForaCaixa();
		
		// verificar a mensagem
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}

}
