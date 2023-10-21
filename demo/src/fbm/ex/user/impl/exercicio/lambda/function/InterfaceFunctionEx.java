package fbm.ex.user.impl.exercicio.lambda.function;

import java.util.function.Function;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.Assunto;
import br.com.fbm.debug.business.service.annotations.ExMap;

/**
 * Simples exemplo de uso de lambda com interface funcional Function<T, R>
 * 
 * A interface funcional Function<T, R> segue a mesma lógica de lambda explicada em
 * {@code InterfaceConsumerEx} no tocante as expressões lambdas que são passadas 
 * como referência a um Single Abstract Method.
 * 
 * Nessa interface funcional T representa o tipo de entrada, 
 * e R representa o tipo de retorno. Então o Single Abstract Method de Function<T, R> é o
 * apply(T t) vai aplicar alguma lógica em T, e retornar R. 
 * 
 * Na pratica podemos utilizar uma Function<T, R> para passar uma String e retornar
 * um Integer, por exemplo podemos passar um nome e retornar desse nome o total
 * de caracteres.
 * 
 * Ex:
 * 
 * Function<String, Integer> fn = nome -> {
 * 	return nome.length();
 * }
 * 
 * @author Fernando Bino Machado
 */
@Assunto("lambda")
@ExMap(numero = 3.02, titulo = "Lambda com Interface Funcional Function<T, R>")
public class InterfaceFunctionEx extends ExGeneric {

	Function<String, String> transformUpper;
	Function<String, Integer> fnContarCaracteres;
	
	String txtUpper, nome;
	int totalLetrasNome;
	
	@Override
	public void iniciarExercicio() throws BusinessException {
		
		transformUpper = String::toUpperCase;
		fnContarCaracteres = lbNome -> lbNome.length();
		nome = "fernando bino machado";
		
	}
	
	@Override
	public void processarExercicio() throws BusinessException {

		/**
		 * chamando o método apply da interface funcional 
		 * Function<T, R> como explicado no inicio
		 */
		txtUpper = transformUpper.apply(nome);	
		totalLetrasNome = fnContarCaracteres.apply(nome);	
		
	}
	
	@Override
	public void finalizarExercicio() throws BusinessException {
		
		saida
			.append("Resultado do lambda transform to upper => ")
			.append(txtUpper)
			.append("\nTotal letras do nome ")
			.append(nome)
			.append(totalLetrasNome);
		
		exibirSaida();
		
	}
	
	
}
