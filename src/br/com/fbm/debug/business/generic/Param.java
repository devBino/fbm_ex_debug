/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.business.generic;

/**
 * {@code Param} é um generic para 
 * possibilitar a iniciação de parametros
 * durante processamento de implementação de {@code ExService} 
 * de forma que o usuário tenha controle dos tipos
 * que quer parametrizar nos exercícios.
 * 
 * @author Fernando Bino Machado
 */
public class Param <T> {

	T param;
	
	public Param(T param) {
		this.param = param;
	}
	
	public T getValorParam() {
		return param;
	}
	
}
