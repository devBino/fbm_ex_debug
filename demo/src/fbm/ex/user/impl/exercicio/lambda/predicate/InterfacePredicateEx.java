package fbm.ex.user.impl.exercicio.lambda.predicate;

import java.util.function.Predicate;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.Assunto;
import br.com.fbm.debug.business.service.annotations.ExMap;

/**
 * Simples exemplo de uso de lambda com interface funcional Predicate<T>
 * 
 * A interface funcional Predicate<T> segue o mesmo raciocínio das demais interfaces
 * funcionais explicadas antes nos exercicios 3.01 e 3.02.
 * 
 * De igual modo possui um SAM (Single Abstract Method) e podemos passar 
 * uma expressão lambda para a interface funcional Predicate<T>, 
 * no caso dela, o SAM é o test(T t).
 * 
 * Esse SAM tem por objetivo retornar um booleano true ou false, que deve ser resultante
 * de um teste lógico dentro da expressão lambda recebida.
 * 
 * Existem outros metodos na interface Predicate<T>, mas nesse caso são default, 
 * tais como or, and e negate.
 * 
 * @author Fernando Bino Machado
 */
@Assunto("lambda")
@ExMap(numero = 3.03, titulo = "Lambda com Interface Funcional Predicate<T>")
public class InterfacePredicateEx extends ExGeneric{

	Predicate<Integer> testeNumPar;
	Predicate<Integer> testeMultiploTres;
	Predicate<Integer> testeMultiploTresEDez;
	
	boolean numPar, numImpar, numMultiploTres, numMultiploTresEDez;
	
	int numeroTeste;
	
	@Override
	public void iniciarExercicio() throws BusinessException {
		
		testeNumPar = num -> num % 2 == 0;
		testeMultiploTres = num -> num % 3 == 0;
		
		testeMultiploTresEDez = num -> {
			return num % 10 == 0; 
		};
		
		numeroTeste = 30;
	}
	
	@Override
	public void processarExercicio() throws BusinessException {
		
		//chamando método test(T t)
		numPar = testeNumPar.test( numeroTeste );
		
		numImpar = testeNumPar
				.negate() //usando negate() para inverter o resultado final de test(T t)
				.test( numeroTeste ); //chamando método test(T t)

		//usando metodo or para encadear dois ou mais predicates
		Predicate<Integer> localTestImparMultiploTres = testeNumPar
				.or( testeMultiploTres );
		
		//usando metodo and para encadear dois ou mais predicates
		Predicate<Integer> localTestMultiploTresEDez = testeMultiploTres
				.and( testeMultiploTresEDez );
		
		numMultiploTres = localTestImparMultiploTres.test(numeroTeste);
		numMultiploTresEDez = localTestMultiploTresEDez.test(numeroTeste);
		
	}
	
	@Override
	public void finalizarExercicio() throws BusinessException {
		
		saida
			.append("Sobre o numero ")
			.append(numeroTeste)
			.append("\nnumero par => ")
			.append(numPar)
			.append("\nnumero impar => ")
			.append(numImpar)
			.append("\nnumero multiploTres => ")
			.append(numMultiploTres)
			.append("\nnumero numMultiploTresEDez => ")
			.append(numMultiploTresEDez);
		
		exibirSaida();
		
	}
	
	
}
