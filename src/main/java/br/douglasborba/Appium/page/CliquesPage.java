package br.douglasborba.appium.page;

import org.openqa.selenium.By;

import br.douglasborba.appium.core.BasePage;
import br.douglasborba.appium.core.DriverFactory;
import io.appium.java_client.TouchAction;

public class CliquesPage extends BasePage {

	public void cliqueLong() {
		new TouchAction(DriverFactory.getDriver())
				.longPress(DriverFactory.getDriver().findElement(By.xpath("//*[@text='Clique Longo']"))).perform();
	}

	public String obterTextoCampo() {
		return DriverFactory.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
	
	public void cliqueDuplo() {
		clicarPorTexto("Clique duplo");
	}

}
