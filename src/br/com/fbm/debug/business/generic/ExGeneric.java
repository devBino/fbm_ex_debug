/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.business.generic;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.service.iface.ExService;

/**
 * {@code ExGeneric} define comportamento abstrato
 * para todos os exercícios.
 * @author Fernando Bino Machado
 */
public abstract class ExGeneric 
	implements ExService {

	/**
	 * Tipo de retorno do exercício
	 */
	protected Class<?> tipoRetorno; 
	protected Object valorRetorno;
	protected StringBuilder saida;
	
	/**
	 * Métodos comuns a todo exercício 
	 */
	
	@Override
	public void iniciarExercicio() throws BusinessException {
		
		saida = new StringBuilder();
		
		tipoRetorno = definirTipoRetorno();
		iniciarParametros();
		
	}
	
	@Override
	public void processarExercicio() throws BusinessException {
		processarParametros();
	}
	
	@Override
	public void finalizarExercicio() throws BusinessException {
		prepararSaida();
		exibirSaida();
	}
	
	/**
	 * Comportamentos esperados durante a execução
	 * dos métodos comuns de exercícios
	 */
	protected abstract Class<?> definirTipoRetorno();
	protected abstract void iniciarParametros() throws BusinessException;
	protected abstract void processarParametros() throws BusinessException;
	
	protected void prepararSaida() throws BusinessException {}
	
	protected void exibirSaida() throws BusinessException {
		
		saida.insert(0, "\n");
		saida.append("\n");
		
		System.out.println( saida.toString() );
		
	}
	
	/**
	 * Retorna a saida resultando do processamento do exercício
	 * @return
	 */
	public StringBuilder getSaida() {
		return saida;
	}
	
	
	
}
