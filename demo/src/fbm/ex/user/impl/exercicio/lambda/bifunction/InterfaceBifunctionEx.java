/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package fbm.ex.user.impl.exercicio.lambda.bifunction;

import java.util.function.BiFunction;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.Assunto;
import br.com.fbm.debug.business.service.annotations.ExMap;

/**
 * BiFunction<T, U, R> no tocante a lambda, segue o mesmo raciocinio dos exercícios 
 * 3.01, 3.02 e 3.03.
 * 
 * A questão aqui é que BiFunction<T, U, R> como próprio nome diz, por ser "Bi" Function, 
 * recebe dois argumentos como parametros e especifica
 * o tipo de retorno desejado, onde 
 * 
 * T representa o tipo do primeiro argumento,
 * U representa o tipo do segundo argumento, e
 * R representa o tipo de retorno
 * 
 * O entendimento ficará claro no exemplo desse exercício onde vamos
 * executar uma concatenação de duas strings para formar um nome completo
 * 
 * No caso, o SAM(Single Method Abstract)
 * é o apply(T t, U u), que irá receber os dois argumentos e realizar alguma lógica 
 * neles, e no fim, deve retornar um objeto do tipo especificado em R
 * 
 * @author Fernando Bino Machado
 */
@Assunto("lambda")
@ExMap(numero = 3.04, titulo = "Lambda com Interface Funcional BiFunction<T, U, R>")
public class InterfaceBifunctionEx extends ExGeneric {
	
	String primeiroNome, sobreNome, nomeCompleto;
	BiFunction<String, String, String> funcaoNomeCompleto;
	
	@Override
	public void iniciarExercicio() throws BusinessException {
		
		//argumentos para o BiFunction
		primeiroNome = "fernando";
		sobreNome = "bino machado";
		
		//o BiFunction
		funcaoNomeCompleto = (argNome, argSobreNome) -> {
			
			StringBuilder localSb = new StringBuilder()
					.append(argNome)
					.append(" ")
					.append(argSobreNome);
			
			return localSb.toString();
			
		};
		
	}
	
	@Override
	public void processarExercicio() throws BusinessException {
		
		//chamando o SAM apply(T t, U u)
		nomeCompleto = funcaoNomeCompleto.apply(primeiroNome, sobreNome);
		
	}
	
	@Override
	public void finalizarExercicio() throws BusinessException {
		
		saida
			.append("Resultado de\n")
			.append("nomeCompleto = funcaoNomeCompleto.apply(primeiroNome, sobreNome); = ")
			.append(nomeCompleto);
		
		exibirSaida();
		
	}
	
	
}
