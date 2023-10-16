/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.repository.type;

/**
 * {@code ExType} define os tipos de exercícios
 * suportados.
 * 
 * @author Fernando Bino Machado
 */
public enum ExType {

	EXERCICIO("exercicio"),
	QUIZ("quiz");
	
	String tipo;
	
	private ExType(final String pTipo) {
		tipo = pTipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	
}
