package br.douglasborba.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.douglasborba.appium.core.BaseTest;
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
}
