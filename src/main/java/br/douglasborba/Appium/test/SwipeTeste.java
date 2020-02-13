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

		// clicar bot�o direita
		menu.clicarPorTexto("�");

		// Verificar o texto 'chegar at� o fim'
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar at� o fim!"));

		// swipe esquerda
		menu.swipe(0.1, 0.9);

		// clicar bot�o esquerda�
		menu.clicarPorTexto("�");

		// verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}

}
