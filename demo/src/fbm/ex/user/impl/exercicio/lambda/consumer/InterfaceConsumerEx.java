package fbm.ex.user.impl.exercicio.lambda.consumer;

import java.util.function.Consumer;

import br.com.fbm.debug.business.exception.BusinessException;
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
	public void iniciarExercicio() throws BusinessException {
		frase = "Exercicio com Interface Consumer<T>";
		consumirFrase = System.out::println;	
	}
	
	@Override
	public void processarExercicio() throws BusinessException {
		//NA
	}
	
	@Override
	public void finalizarExercicio() throws BusinessException {
		
		saida
			.append("Enviado comando para interface Consumer<T> no seu método accept(T t)")
			.append("consumirFrase.accept(frase);");

		exibirSaida();
		
		consumirFrase.accept(frase);
		
	}
	
	
}
