package br.douglasborba.appium.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.douglasborba.appium.core.BaseTest;
import br.douglasborba.appium.core.DriverFactory;
import br.douglasborba.appium.page.FormularioPage;
import br.douglasborba.appium.page.MenuPage;

public class FormularioTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private FormularioPage formularioPage = new FormularioPage();

	@Before
	public void InicializarAppium(){
		menu.acessarFormulario();
	}
	
	

	@Test
	public void devePreencherCampoTexto(){

		formularioPage.escreverNome("Douglas");

		// Checar nome escrito
		Assert.assertEquals("Douglas", formularioPage.obterNome());

	}

	@Test
	public void deveInteragirCombo(){

		// Clicar no combo
		formularioPage.selecionarCombo("Nintendo Switch");

		// Verificar opção selecionada
		Assert.assertEquals("Nintendo Switch", formularioPage.obterValorCombo());

	}

	@Test
	public void deveInteragirSwitchCheckBox(){

		// Verificar status dos elementos
		Assert.assertFalse(formularioPage.isCheckMarcado());
		Assert.assertTrue(formularioPage.isSwitchMarcado());

		// Clicar nos elementos
		formularioPage.clicarCheck();
		formularioPage.clicarSwitch();

		// Verificar estados alterados
		Assert.assertTrue(formularioPage.isCheckMarcado());
		Assert.assertFalse(formularioPage.isSwitchMarcado());

	}

	@Test
	public void deveRealizarCadastro() {

		// Preencher campos
		formularioPage.escreverNome("Douglas Borba");
		formularioPage.clicarCheck();
		formularioPage.clicarSwitch();
		formularioPage.selecionarCombo("Nintendo Switch");

		// clicar no botão salvar
		formularioPage.salvar();

		// Verificar
		Assert.assertEquals("Nome: Douglas Borba", formularioPage.obterNomeCadastrado());
		Assert.assertEquals("Console: switch", formularioPage.obterConsoleCadastrado());
		Assert.assertTrue(formularioPage.obterCheckCadastrado().endsWith("Off"));
		Assert.assertTrue(formularioPage.obterSwitchCadastrado().endsWith("Marcado"));
	}
	
	// formas de scripts assincronos
	@Test
	public void deveRealizarCadastroDemorado() {
		
		// Preencher campos
		formularioPage.escreverNome("Douglas Borba");

		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		// clicar no botão salvar
		formularioPage.salvarDemorado();
//		esperar(10000);
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Douglas Borba']")));

		// Verificar
		Assert.assertEquals("Nome: Douglas Borba", formularioPage.obterNomeCadastrado());

	}
}
