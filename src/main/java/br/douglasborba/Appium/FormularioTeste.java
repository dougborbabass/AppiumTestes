package br.douglasborba.appium;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.douglasborba.appium.core.DSL;
import br.douglasborba.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class FormularioTeste {

	private DSL dsl = new DSL();

	@Before
	public void InicializarAppium() throws MalformedURLException {

		// Selecionar a opção formulário
		dsl.clicarPorTexto("Formulário");

	}

	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {

		// Escrever nome
		dsl.escrever(MobileBy.AccessibilityId("nome"), "Douglas");

		// Checar nome escrito
		Assert.assertEquals("Douglas", dsl.obterTexto(MobileBy.AccessibilityId("nome")));

	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {

		// Clicar no combo
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
		
		// Verificar opção selecionada
		String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		Assert.assertEquals("Nintendo Switch", text);

	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {

		// Verificar status dos elementos
		Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

		// Clicar nos elementos
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(MobileBy.AccessibilityId("switch"));

		// Verificar estados alterados
		Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {

		// Preencher campos
		dsl.escrever(By.className("android.widget.EditText"), "Douglas Borba");
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(By.className("android.widget.Switch"));
		dsl.selecionarCombo(By.className("android.widget.Spinner"), "Nintendo Switch");

		// clicar no botão salvar
		dsl.clicarPorTexto("SALVAR");

		// Verificar
		Assert.assertEquals("Nome: Douglas Borba",
				dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Douglas Borba']")));
		Assert.assertEquals("Console: switch",
				dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Console:')]")));
		Assert.assertTrue(
				dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Switch:')]")).endsWith("Off"));
		Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Checkbox:')]"))
				.endsWith("Marcado"));

	}

}
