package br.douglasborba.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.douglasborba.appium.core.BaseTest;
import br.douglasborba.appium.page.CliquesPage;
import br.douglasborba.appium.page.MenuPage;

public class CliquesTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();

	@Test
	public void deveRealizarCliqueLongo() {
		// acessar menu
		menu.acessarCliques();

		// clique longo
		page.cliqueLong();

		// verificar texto
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}

}
