/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.business.service.iface;

/**
 * {@code ExService} define regras para implementar exercícios.
 * 
 * @author Fernando Bino Machado
 */
public interface ExService {

	/**
	 * Método inicia o exercício, 
	 * recolhendo os parametros necessários e preparando
	 * o exercicio
	 */
	void iniciarExercicio();
	
	/**
	 * Método processa as entradas do exercício
	 */
	void processarExercicio();
	
	/**
	 * Método finaliza o exercício, preparando a saida 
	 * resultante do processamento
	 */
	void finalizarExercicio();
	
	/**
	 * Método recebe um {@code Class} com um tipo definido para 
	 * ser o tipo de retorno do exercício
	 * 
	 * @param pClass
	 */
	default void setTipoRetorno(final Class<?> pClass) {
		//NA
	}
	
}
