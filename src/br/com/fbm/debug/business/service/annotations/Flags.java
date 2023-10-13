/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.business.service.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code Flags} auxilia na localização 
 * de implementações de {@code ExService}
 * anotadas com {@code Flags}
 * em tempo de execução.
 *    
 * @author Fernando Bino Machado
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Flags {

	/**
	 * Define uma ou mais palavras chave para 
	 * associar as implementações de {@code ExService}
	 * @return
	 */
	String[] flags();
	
}
