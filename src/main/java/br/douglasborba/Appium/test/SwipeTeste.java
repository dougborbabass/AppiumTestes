package br.douglasborba.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.douglasborba.appium.core.BaseTest;
import br.douglasborba.appium.page.MenuPage;

public class SwipeTeste extends BaseTest {

	private MenuPage menu = new MenuPage();

	@Test
	public void deveRealizarSwipe() {
		// acessar menu
		menu.acessarSwipe();

		// verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

		// swipe para direita
		menu.swipe(0.9, 0.1);

		// verificar texto 'E veja se'
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));

		// clicar botão direita
		menu.clicarPorTexto("›");

		// Verificar o texto 'chegar até o fim'
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));

		// swipe esquerda
		menu.swipe(0.1, 0.9);

		// clicar botão esquerda‹
		menu.clicarPorTexto("‹");

		// verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}

}
