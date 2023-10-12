/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.demo;

/**
 * Fornece o método main para demonstrar
 * implementações de {@code ExService}
 * 
 * @author Fernando Bino Machado
 */
public class AppDemo {

	public static void main(String[] args) {
		
		CalculoIMC calculoIMC = new CalculoIMC();
		
		calculoIMC.iniciarExercicio();
		calculoIMC.processarExercicio();
		calculoIMC.finalizarExercicio();
		
		CuriosidadeChar curiosidadeChar = new CuriosidadeChar();
		
		curiosidadeChar.iniciarExercicio();
		curiosidadeChar.processarExercicio();
		curiosidadeChar.finalizarExercicio();
		
	}

}
