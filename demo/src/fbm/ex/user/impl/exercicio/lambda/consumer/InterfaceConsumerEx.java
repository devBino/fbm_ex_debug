package fbm.ex.user.impl.exercicio.lambda.consumer;

import java.util.function.Consumer;

import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;

/**
 * Exercicio simples com uso de lambda 
 * na interface funcional Consumer<T>.
 * 
 * @author Fernando Bino Machado
 */
@ExMap(numero = 3, titulo = "Simples exercicio com lambda na interface consumer")
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
