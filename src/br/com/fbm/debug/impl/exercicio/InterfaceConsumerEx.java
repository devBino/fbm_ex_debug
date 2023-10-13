/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.impl.exercicio;

import java.util.function.Consumer;

import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.Assunto;
import br.com.fbm.debug.business.service.annotations.Flags;

/**
 * @author Fernando Bino Machado
 */
@Assunto("lambda")
@Flags(flags = {"lambda","consumer"})
public class InterfaceConsumerEx extends ExGeneric {

	Consumer<String> consumirFrase;
	String frase;
	
	@Override
	protected Class<?> definirTipoRetorno() {
		return Object.class;
	}
	
	@Override
	protected void iniciarParametros() {
		frase = "Exercicio com Interface Consumer<T>";
		consumirFrase = System.out::println;
	}
	
	@Override
	protected void processarParametros() {
		//NA
	}
	
	@Override
	protected void prepararSaida() {
		//NA
	}
	
	@Override
	protected void exibirSaida() {
		consumirFrase.accept(frase);
	}
	
	
}
