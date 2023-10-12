/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.business.service.annotations;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * {@code Assunto} auxilia na localização 
 * de implementações de {@code ExService}
 * anotadas com {@code Assunto}
 * em tempo de execução.   
 * 
 * @author Fernando Bino Machado
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Assunto {

	/**
	 * Define o assunto para implementações de {@code ExService}
	 * @return
	 */
	String value();
	
}
