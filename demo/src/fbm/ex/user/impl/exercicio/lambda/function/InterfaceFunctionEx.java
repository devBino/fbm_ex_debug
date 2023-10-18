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
	protected Class<?> definirTipoRetorno() {
		return Object.class;
	}
	
	@Override
	protected void iniciarParametros() throws BusinessException {
		transformUpper = String::toUpperCase;
	}
	
	@Override
	protected void processarParametros() throws BusinessException {
		txtUpper = transformUpper.apply("fernando bino machado");
	}
	
	@Override
	protected void exibirSaida() throws BusinessException {
		System.out.println("Resultado do lambda transform to upper => " + txtUpper);
	}
	
}
