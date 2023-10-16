/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.repository.validators;

import java.util.Map;
import java.util.List;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import br.com.fbm.debug.application.bo.ExInfoBO;
import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.repository.type.Erro;

/**
 * {@code ExValidator} realiza validações em implementações
 * de {@code ExGeneric}
 * @author Fernando Bino Machado
 */
public class ExValidator {

	/**
	 * Recebe uma {@code List<ExInfoBO>} representando informações de uma lista
	 * de exercícios, e valida se existem numeros de exercicios repetidos
	 * @param pListExercicios
	 * @throws BusinessException
	 */
	public static void validarNumerosRepetidosExercicios(final List<ExInfoBO> pListExercicios)
		throws BusinessException {
		
		//se não forem encontradas implementações
		if( pListExercicios.isEmpty() ) {
			return;
		}
		
		//mapear todos os números em um List<BigDecimal>
		Map<Class<? extends ExGeneric>, BigDecimal> mapClassNumeros = pListExercicios
				.stream()
				.collect(Collectors.toMap(ExInfoBO::getClassImpl, ExInfoBO::getNumero));
		
		//percorre todos os exercícios, checando se existem numerações repetidas 
		for( final ExInfoBO exInfo : pListExercicios ) {
			
			//contagem das ocorrencias da numeração
			final int ocorrenciasNumExercicio = mapClassNumeros
					.entrySet()
					.stream()
					.filter(mapNum -> exInfo.getNumero().compareTo( mapNum.getValue() ) == 0)
					.mapToInt(mapNum -> 1)
					.sum();
			
			//identificação das classes
			final String classRepetidas = mapClassNumeros
					.entrySet()
					.stream()
					.filter(mapNum -> exInfo.getNumero().compareTo( mapNum.getValue()) == 0)
					.map(mapNum -> String.valueOf( mapNum.getKey() ))
					.collect(Collectors.joining("\n"));
			
			//dispara erro caso mais que uma ocorrencia do mesmo numero
			if( ocorrenciasNumExercicio > 1 ) {
				
				final StringBuilder msgErro = new StringBuilder()
						.append("Número: ")
						.append(exInfo.getNumero().toString())
						.append("\n")
						.append(classRepetidas);
				
				throw new BusinessException(Erro.ERRO_NUMERO_EXERCICIO_REPETIDO, 
						new Exception(msgErro.toString()));
						
			}
			
		}
		
	}
	
	
}
