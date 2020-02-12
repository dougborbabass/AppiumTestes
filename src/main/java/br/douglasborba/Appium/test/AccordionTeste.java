package br.douglasborba.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.douglasborba.appium.core.BaseTest;
import br.douglasborba.appium.page.AccordionPage;
import br.douglasborba.appium.page.MenuPage;

public class AccordionTeste extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() {
		// acessar menu
		menu.acessarAccordion();
		
		//clicar opção 1
		page.selecionarPrimeiraOpção();
		
		//verificar texto opção 1
		Assert.assertTrue(page.isPrimeiraOpção());
	}

}
