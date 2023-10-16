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

import br.com.fbm.debug.application.bo.ExInfoBO;
import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.factory.ExFactory;
import br.com.fbm.debug.business.generic.ExGeneric;

/**
 * {@code ExProcessor} é responsável por
 * processar as implementações de {@code ExGeneric} recebidas.
 * @author Fernando Bino Machado
 */
public class ExProcessor {

	/**
	 * Processa as implementações de {@code ExGeneric} recebidos
	 * @param pImplList
	 */
	public static void processarImplExercicios(final List<ExGeneric> pImplList)
		throws BusinessException {
		
		Iterator<ExGeneric> itExs = pImplList.iterator();
		
		while( itExs.hasNext() ) {

			ExGeneric ex = itExs.next();
			
			ex.iniciarExercicio();
			ex.processarExercicio();
			ex.finalizarExercicio();
			
		}
		
	}
	
	/**
	 * Processa as implementações de {@code ExGeneric} recebidos usando a lista de 
	 * metadados contendo a classe de referencia para instanciar os exercícios
	 * @param pImplList
	 */
	public static void processarImplExerciciosListaInfoBO(final List<ExInfoBO> pListInfoBO)
		throws BusinessException {
		
		Iterator<ExInfoBO> itInfo = pListInfoBO.iterator();
		
		while( itInfo.hasNext() ) {
			
			ExGeneric ex = ExFactory.getExInstance(itInfo.next().getClassImpl());
			
			ex.iniciarExercicio();
			ex.processarExercicio();
			ex.finalizarExercicio();
			
		}
		
	}
	
}
