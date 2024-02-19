package fbm.ex.user.impl.exercicio;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;

/**
 * O exemplo abaixo, é um exercicio que traz uma curiosidade sobre o tipo
 * primitivo char, podemos fazer um cálculo com letras e resultar em um 
 * valor numérico
 * 
 * @author Fernando Bino Machado
 */
@ExMap(
		numero = 2,
		titulo = "Curiosidade sobre o tipo char"
)
public class CuriosidadeChar extends ExGeneric {

	char letraA, letraB;
	Integer numeroLetraTeste, valorRetorno;
	
	@Override
	public void iniciarExercicio() throws BusinessException {

		//atribuindo letras ou numeros temos uma variavel do tipo char
		letraA = 'A';
		letraB = 66;
		
	}
	
	@Override
	public void processarExercicio() throws BusinessException {
		
		//char possui uma representação numérica na 
		//tabela ASCII, por isso podemos até 
		//somar duas letras e ter um número final resultante
		valorRetorno = letraA + letraB;
		
		//podemos inclusive iniciar um inteiro com
		//a representação numérica de um char
		numeroLetraTeste = Integer.valueOf('A');
		
	}
	
	@Override
	public void finalizarExercicio() throws BusinessException {
		
		saida
			.append("Resultado de ")
			.append(letraA)
			.append(" + ")
			.append(letraB)
			.append(" = ")
			.append(valorRetorno)
			.append("\nO resultado de ")
			.append("numeroLetraTeste = Integer.valueOf('A'); = ")
			.append(numeroLetraTeste);
		
		exibirSaida();
		
	}
	
	
}
