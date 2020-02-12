package br.douglasborba.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.douglasborba.appium.core.BaseTest;
import br.douglasborba.appium.page.AbasPage;
import br.douglasborba.appium.page.MenuPage;

public class AbasTeste extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private AbasPage page = new AbasPage();
	
	@Test
	public void deveInteragirComAmbas() {
		// acessar menu abas
		menu.acessarAbas();
		
		// verificar aba 1
		Assert.assertTrue(page.isPrimeiraAba());
		
		// acessar aba 2
		page.acessarSegundaAba();
		
		// verificar que esta na aba 2
		Assert.assertTrue(page.isSegundaAba());
	}

}
