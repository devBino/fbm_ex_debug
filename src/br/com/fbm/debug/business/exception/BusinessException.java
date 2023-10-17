/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.business.exception;

import br.com.fbm.debug.repository.type.Erro;

/**
 * {@code BusinessException} provê um tratamento personalizado
 * para Exceptions recebendo um código de erro
 * para composição da mensagem
 * 
 * @author Fernando Bino Machado
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 8856021026306007432L;

	/**
	 * Define o codigo e a mensagem de erro
	 * para compilar a mensagem personalizada
	 */
	Erro erro;
	
	/**
	 * Define a causa da Exception
	 */
	Throwable throwable;
	
	/**
	 * Inicia {@code BusinessException} recebendo
	 * o parametro:
	 * @param pErro
	 */
	public BusinessException(final Erro pErro) {
		erro = pErro;
		throwable = new Exception(Erro.ERRO_DESCONHECIDO.getMensagem());
		this.initCause(throwable);
	}
	
	/**
	 * Inicia {@code BusinessException} recebendo
	 * os parametros:
	 * @param pErro
	 * @param pThrowable
	 */
	public BusinessException(final Erro pErro, 
			final Throwable pThrowable) {
		
		erro = pErro;
		throwable = pThrowable;
		this.initCause(throwable);
		
	}
	
	public Erro getErro() {
		return erro;
	}
	
	/**
	 * Recupera mensagem personalizada dessa BusinessException
	 */
	@Override
	public String getMessage() {
		return erro.getMensagemErro(throwable.getMessage());
	}
	
}
