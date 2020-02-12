package br.douglasborba.appium.page;

import br.douglasborba.appium.core.BasePage;

public class AccordionPage extends BasePage{
	
	public void selecionarPrimeiraOpção() {
		clicarPorTexto("Opção 1");
	}
	
	public boolean isPrimeiraOpção() {
		return existeElementoPorTexto("Esta é a descrição da opção 1");
	}
}
