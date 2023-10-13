/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.processor;

import java.util.List;
import java.util.Iterator;

import br.com.fbm.debug.business.generic.ExGeneric;

/**
 * {@code ExProcessor} é responsável por
 * processar as implementações de {@code ExGeneric} recebidas.
 * 
 * @author Fernando Bino Machado
 */
public class ExProcessor {

	/**
	 * Processa as implementações de {@code ExGeneric} recebidos
	 * 
	 * @param pImplList
	 */
	public static void processarImplExercicios(final List<ExGeneric> pImplList) {
		
		Iterator<ExGeneric> itExs = pImplList.iterator();
		
		while( itExs.hasNext() ) {
			
			ExGeneric ex = itExs.next();
			
			ex.iniciarExercicio();
			ex.processarExercicio();
			ex.finalizarExercicio();
			
		}
		
	}
	
}
