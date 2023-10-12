/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.business.generic;

import java.util.Map;
import java.util.HashMap;

import br.com.fbm.debug.business.service.iface.ExService;

/**
 * {@code ExGeneric} define comportamento abstrato
 * para todos os exercícios.
 * 
 * @author Fernando Bino Machado
 */
public abstract class ExGeneric 
	implements ExService {

	/**
	 * Tipo de retorno do exercício
	 */
	protected Class<?> tipoRetorno; 
	private Map<String, Param<?>> mapParams;
	
	/**
	 * Métodos comuns a todo exercício 
	 */
	
	@Override
	public void iniciarExercicio() {
		
		mapParams = new HashMap<>();
		
		tipoRetorno = definirTipoRetorno();
		iniciarParametros();
		
	}
	
	@Override
	public void processarExercicio() {
		processarParametros();
	}
	
	@Override
	public void finalizarExercicio() {
		prepararSaidas();
		exibirSaidas();
	}

	/**
	 * Retorna o map contendo os parâmetros definidos
	 * pelo usuário.
	 * 
	 * @return
	 */
	public Map<String, Param<?>> getMapParams() {
		return mapParams;
	}
	
	/**
	 * Adiciona parametros para processamento do exercício
	 * 
	 * @param pNomeParam
	 * @param pParam
	 */
	public void addParam(final String pNomeParam, final Param<?> pParam) {
		mapParams.put(pNomeParam, pParam);
	}
	
	/**
	 * Comportamentos esperados durante a execução
	 * dos métodos comuns de exercícios
	 */
	
	abstract Class<?> definirTipoRetorno();
	abstract void iniciarParametros();
	abstract void processarParametros();
	
	protected void prepararSaidas() {
		//NA
	}
	
	abstract void exibirSaidas();
	
	
}
