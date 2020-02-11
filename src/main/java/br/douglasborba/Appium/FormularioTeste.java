package br.douglasborba.appium;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.douglasborba.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioTeste {

	private AndroidDriver<MobileElement> driver;

	@Before
	public void InicializarAppium() throws MalformedURLException {

		driver = DriverFactory.getDriver();

		// Selecionar a opção formulário
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();

	}

	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {

		// Escrever nome
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Douglas");

		// Checar nome escrito
		campoNome.getText();
		Assert.assertEquals("Douglas", campoNome.getText());

	}

	@Test
	public void deveInteragirCombom() throws MalformedURLException {

		// Clicar no combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();

		// Selecionar opção desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

		// Verificar opção selecionada
		String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		Assert.assertEquals("Nintendo Switch", text);

	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {

		// Verificar status dos elementos
		MobileElement checkBox = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement switchh = driver.findElement(MobileBy.AccessibilityId("switch"));

		// estado inicial dos elementos na tela
		Assert.assertTrue(checkBox.getAttribute("checked").equals("false"));
		Assert.assertTrue(switchh.getAttribute("checked").equals("true"));

		// Clicar nos elementos
		checkBox.click();
		switchh.click();

		// Verificar estados alterados
		Assert.assertFalse(checkBox.getAttribute("checked").equals("false"));
		Assert.assertFalse(switchh.getAttribute("checked").equals("true"));

	}

	@Test
	public void deveResolverDesafio() throws MalformedURLException {

		// Preencher campos
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Douglas Borba");
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.className("android.widget.Switch")).click();
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

		// clicar no botão salvar
		driver.findElement(By.xpath("//*[@text='SALVAR']")).click();

		// Verificar
		MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Douglas Borba']"));
		Assert.assertEquals("Nome: Douglas Borba", nome.getText());

		MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Console:')]"));
		Assert.assertEquals("Console: switch", combo.getText());

		MobileElement switchh = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Switch:')]"));
		Assert.assertTrue(switchh.getText().endsWith("Off"));

		MobileElement check = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Checkbox:')]"));
		Assert.assertTrue(check.getText().endsWith("Marcado"));

	}

}
