package fbm.ex.user.impl.exercicio.lambda.function;

import java.util.function.Function;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.Assunto;
import br.com.fbm.debug.business.service.annotations.ExMap;

/**
 * Simples exemplo de uso de lambda com interface funcional Function<T, R>
 * @author Fernando Bino Machado
 */
@Assunto("lambda")
@ExMap(numero = 5)
public class InterfaceFunctionEx extends ExGeneric{

	Function<String, String> transformUpper;
	String txtUpper;
	
	@Override
	public void iniciarExercicio() throws BusinessException {
		transformUpper = String::toUpperCase;
	}
	
	@Override
	public void processarExercicio() throws BusinessException {
		txtUpper = transformUpper.apply("fernando bino machado");	
	}
	
	@Override
	public void finalizarExercicio() throws BusinessException {
		
		saida
			.append("Resultado do lambda transform to upper => ")
			.append(txtUpper);
		
		exibirSaida();
		
	}
	
	
}
