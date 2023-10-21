package fbm.ex.user.impl.exercicio.lambda.predicate;

import java.util.function.Predicate;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;
import br.com.fbm.debug.business.service.annotations.Flags;

/**
 * Simples exemplo de uso de lambda com interface funcional Predicate<T>
 * @author Fernando Bino Machado
 */
@Flags(flags = {"lambda"})
@ExMap(numero = 4)
public class InterfacePredicateEx extends ExGeneric{

	Predicate<Integer> testeNumPar;
	boolean numPar;
	
	@Override
	public void iniciarExercicio() throws BusinessException {
		testeNumPar = num -> num % 2 == 0;
	}
	
	@Override
	public void processarExercicio() throws BusinessException {
		numPar = testeNumPar.test(9);
	}
	
	@Override
	public void finalizarExercicio() throws BusinessException {
		
		saida
			.append("Resultado de teste numero par => ")
			.append(numPar);
		
		exibirSaida();
		
	}
	
	
}
