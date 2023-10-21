/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package fbm.ex.user.impl.exercicio.lambda.biconsumer;

import java.util.function.BiConsumer;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.Assunto;
import br.com.fbm.debug.business.service.annotations.ExMap;

/**
 * Segue o mesmo raciocionio dos exercícios 3.01, 3.02 e 3.03 no tocante
 * a expressões lambda, ou seja, continuamos falando de interface funcional 
 * com um SAM, Single Abstract Method.
 * 
 * Além disso, como no exercício 3.04 de BiFunction<T, U, R> estamos falando de um
 * "Bi" Consumer, que logicamente também vai receber dois argumentos no seu 
 * Single Abstract Method. 
 * 
 * Que SAM é esse? É o accept(T t, U u). Esse método vai simplesmente receber
 * dois argumentos e consumí-los fazendo alguma coisa com eles.
 * 
 * @author Fernando Bino Machado
 */
@Assunto("lambda")
@ExMap(numero = 3.05, titulo = "Lambda com Interface Funcional BiConsumer<T, U>")
public class InterfaceBiConsumerEx extends ExGeneric {

	String nome, sobreNome, nomeCompletoDentroDoBiConsumer;
	BiConsumer<String, String> printNome;
	
	@Override
	public void iniciarExercicio() throws BusinessException {
		
		nome = "fernando";
		sobreNome = "bino machado";
		
		printNome = (argNome, argSobreNome) -> {
			
			StringBuilder localSb = new StringBuilder()
					.append(argNome)
					.append(" ")
					.append(argSobreNome);
			
			nomeCompletoDentroDoBiConsumer = localSb.toString();
			
		};
		
	}
	
	@Override
	public void processarExercicio() throws BusinessException {
		printNome.accept(nome, sobreNome);
	}
	
	@Override
	public void finalizarExercicio() throws BusinessException {
		
		saida
			.append("printNome.accept(nome, sobreNome); consumiu dois argumentos e \n")
			.append("dentro do BiConsumer, concatenamos o nome completo\n")
			.append(nomeCompletoDentroDoBiConsumer);
		
		exibirSaida();
		
	}
	
	
}
