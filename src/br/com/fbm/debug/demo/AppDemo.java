/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.demo;

import br.com.fbm.debug.views.JApp;

/**
 * Fornece o método main para demonstrar
 * implementações de {@code ExService}
 * @author Fernando Bino Machado
 */
public class AppDemo {
	
	public static void main(String[] args) throws Exception {		
		demoTela();
	}
	
	private static void demoTela() {
		
		JApp app = new JApp();
		app.setVisible(true);
		
	}

}
