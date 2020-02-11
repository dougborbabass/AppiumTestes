package br.douglasborba.appium.page;

import br.douglasborba.appium.core.DSL;

public class MenuPage {
	
	private DSL dsl = new DSL();
	
	public void acessarFormulario() {
		dsl.clicarPorTexto("Formulário");
	}

}
