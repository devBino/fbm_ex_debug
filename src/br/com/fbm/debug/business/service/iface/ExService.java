/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.business.service.iface;

import br.com.fbm.debug.business.exception.BusinessException;

/**
 * {@code ExService} define regras para implementar exercícios.
 * @author Fernando Bino Machado
 */
public interface ExService {

	/**
	 * Método inicia o exercício, recolhendo os parametros 
	 * necessários e preparando o exercicio
	 */
	void iniciarExercicio() throws BusinessException;
	
	/**
	 * Método processa as entradas do exercício
	 */
	void processarExercicio() throws BusinessException;
	
	/**
	 * Método finaliza o exercício, preparando a saida 
	 * resultante do processamento
	 */
	void finalizarExercicio() throws BusinessException;
	
	/**
	 * Método recebe um {@code Class} com um tipo definido para 
	 * ser o tipo de retorno do exercício
	 * @param pClass
	 */
	default void setTipoRetorno(final Class<?> pClass) {}
	
}
