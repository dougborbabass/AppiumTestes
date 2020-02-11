package br.douglasborba.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTeste {
	

	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		
		  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		  desiredCapabilities.setCapability("platformName", "Android");
		  desiredCapabilities.setCapability("deviceName", "Tab_A_10.5_API_27");
		  desiredCapabilities.setCapability("automationName", "uiautomator2");
		  desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		  desiredCapabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		  
		  AndroidDriver<MobileElement> driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		  
		  MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("2");
		  el1.click();
		  MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Mais");
		  el2.click();
		  MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("2");
		  el3.click();
		  MobileElement el4 = (MobileElement) driver.findElementById("com.sec.android.app.popupcalculator:id/calc_tv_result");
		    
		    Assert.assertEquals("4", el4.getText());

		    System.out.println(el4.getText());
	
//		  driver.quit();
		  
	}

}
