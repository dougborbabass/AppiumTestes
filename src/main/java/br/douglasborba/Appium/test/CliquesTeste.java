package br.douglasborba.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.douglasborba.appium.core.BaseTest;
import br.douglasborba.appium.page.CliquesPage;
import br.douglasborba.appium.page.MenuPage;

public class CliquesTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();

	@Before
	public void setup() {
		// acessar menu
		menu.acessarCliques();
	}

	@Test
	public void deveRealizarCliqueLongo() {
		// clique longo
		page.cliqueLong();

		// verificar texto
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}

	@Test
	public void deveRealizarCliqueDuplo() {
		page.cliqueDuplo();
		page.cliqueDuplo();
		
		Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
	}

}
