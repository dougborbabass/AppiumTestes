package br.douglasborba.appium.page;

import br.douglasborba.appium.core.BasePage;

public class AccordionPage extends BasePage{
	
	public void selecionarPrimeiraOp��o() {
		clicarPorTexto("Op��o 1");
	}
	
	public boolean isPrimeiraOp��o() {
		return existeElementoPorTexto("Esta � a descri��o da op��o 1");
	}
}
