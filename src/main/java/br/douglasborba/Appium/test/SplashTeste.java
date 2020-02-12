package br.douglasborba.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.douglasborba.appium.core.BaseTest;
import br.douglasborba.appium.page.MenuPage;
import br.douglasborba.appium.page.SplashPage;

public class SplashTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
//	@Test
//	public void deveAguardarSplashSumir() {
//		// acessar menu splash
//		menu.acessarSplash();
//		
//		// verificar que o splash esta sendo exibido
//		page.isTelaSplashVisivel();
//		
//		// aguardar a saida do splash
//		page.aguardarSplashSumir();
//		
//		// verificar que o formulario esta aparecendo
//		Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
//	}

}
