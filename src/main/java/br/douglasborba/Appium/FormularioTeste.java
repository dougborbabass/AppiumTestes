package br.douglasborba.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTeste {

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Tab_A_10.5_API_27");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\douglas.borba\\Documents\\automator_tests\\AppiumTest\\src\\main\\resources\\CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Selecionar a opção formulário
		// "FindElements" busca todos os elementos contento a opção requerida
		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));

		elementosEncontrados.get(1).click();

		// Escrever nome
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Douglas");

		// Checar nome escrito
		campoNome.getText();
		Assert.assertEquals("Douglas", campoNome.getText());

//		  driver.quit();
	}

	@Test
	public void deveInteragirCombom() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Tab_A_10.5_API_27");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\douglas.borba\\Documents\\automator_tests\\AppiumTest\\src\\main\\resources\\CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Selecionar a opção formulário
		// "FindElements" busca todos os elementos contento a opção requerida
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

		// Clicar no combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();

		// Selecionar opção desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

		// Verificar opção selecionada
		String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		Assert.assertEquals("Nintendo Switch", text);
//		  driver.quit();
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Tab_A_10.5_API_27");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\douglas.borba\\Documents\\automator_tests\\AppiumTest\\src\\main\\resources\\CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Selecionar a opção formulário
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();

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

//		  driver.quit();
	}

	@Test
	public void deveResolverDesafio() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Tab_A_10.5_API_27");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\douglas.borba\\Documents\\automator_tests\\AppiumTest\\src\\main\\resources\\CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Selecionar a opção formulário
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();
		
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
