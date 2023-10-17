package fbm.ex.user.impl.exercicio;

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
	Integer numeroLetraTeste;
	
	@Override
	protected Class<?> definirTipoRetorno() {
		return Integer.class;
	}
	
	@Override
	protected void iniciarParametros() {
		
		//atribuindo letras ou numeros temos
		//um char
		letraA = 'A';
		letraB = 66;
		
	}
	
	@Override
	protected void processarParametros() {
		
		//char possui uma representação numérica na 
		//tabela ASCII, por isso podemos até 
		//somar duas letras e ter um número final resultante
		valorRetorno = letraA + letraB;
		
		//podemos inclusive iniciar um inteiro com
		//a representação numérica de um char
		numeroLetraTeste = Integer.valueOf('A');
		
	}
	
	@Override
	protected void prepararSaida() {
		
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
		
	}
	
	
}
