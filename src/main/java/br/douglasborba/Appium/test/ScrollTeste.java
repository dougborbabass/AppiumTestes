package br.douglasborba.appium.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.douglasborba.appium.core.BaseTest;
import br.douglasborba.appium.core.DriverFactory;
import br.douglasborba.appium.page.MenuPage;

public class ScrollTeste extends BaseTest {

	private MenuPage menu = new MenuPage();

	@Test
	public void deveEncontrarOpcaoEscondida() {
		// scroll down
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
		menu.scroll(0.9, 0.1);

		// clicar menu
		menu.clicarPorTexto("Op��o bem escondida");

		// verificar alerta
		Assert.assertEquals("Voc� achou essa op��o", menu.obterMensagemAlerta());

		// sair alerta
		menu.clicarPorTexto("OK");
	}

}
