package br.douglasborba.appium.page;

import br.douglasborba.appium.core.BasePage;

public class AbasPage extends BasePage {

	public boolean isPrimeiraAba() {
		return existeElementoPorTexto("Este � o conte�do da Aba 1");
	}
	
	public boolean isSegundaAba() {
		return existeElementoPorTexto("Este � o conte�do da Aba 2");
	}
	
	public void acessarSegundaAba() {
		clicarPorTexto("ABA 2");
	}

}
