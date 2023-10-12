/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.business.service.annotations;

/**
 * {@code ExMap} auxilia na localização 
 * de implementações de {@code ExService}
 * anotadas com {@code ExMap}
 * em tempo de execução.
 *    
 * @author Fernando Bino Machado
 */
public @interface ExMap {

	/**
	 * Define um titulo para o {@code ExService}
	 * @return
	 */
	String titulo() default "";
	
	/**
	 * Define o tipo do {@code ExService}
	 * @return
	 */
	String tipoExercicio() default "EXERCICIO";
	
	/**
	 * Define o tipo de processamento do {@code ExService}
	 * 
	 * IMPLEMENTACAO, a execução dos métodos e saída 
	 * de retorno do exercício será feita
	 * pelas implementações filhas de {@code ExService}
	 * 
	 * FRAMEWORK, a execução dos métodos e saída de retorno
	 * do exercício será feita pelo framework por reflexão,
	 * com base nos metadados anotados em {@code ExService}
	 * 
	 * @return
	 */
	String tipoProcessamento() default "IMPLEMENTACAO";
	
	/**
	 * Define um número para o {@code ExService}.
	 * Ao usar double é possível versionar tópicos,
	 * 
	 * 1.1, 1.2, 1.3...
	 * 
	 * Além disso, podemos combinar o uso de tópicos versionados
	 * com a anotação {@code Assunto}
	 *  
	 * @return
	 */
	double numero();
	
}
