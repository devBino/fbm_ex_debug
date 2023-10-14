/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.impl.exercicio.lambda.predicate;

import java.util.function.Predicate;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;
import br.com.fbm.debug.business.service.annotations.Flags;

/**
 * Simples exemplo de uso de lambda com interface funcional Predicate<T>
 * @author Fernando Bino Machado
 */
@Flags(flags = {"lambda"})
@ExMap(numero = 4)
public class InterfacePredicateEx extends ExGeneric{

	Predicate<Integer> testeNumPar;
	boolean numPar;
	
	@Override
	protected Class<?> definirTipoRetorno() {
		return Object.class;
	}
	
	@Override
	protected void iniciarParametros() throws BusinessException {
		testeNumPar = num -> num % 2 == 0;
	}
	
	@Override
	protected void processarParametros() throws BusinessException {
		numPar = testeNumPar.test(9);
	}
	
	@Override
	protected void exibirSaida() throws BusinessException {
		System.out.println("Resultado de teste numero par => " + numPar);
	}
	
}
