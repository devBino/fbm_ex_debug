package fbm.ex.user.impl.exercicio.matematica;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;

/**
 * Abaixo um exemplo de implementação aparentemente insignificante de 
 * cálculo de IMC (Indice de Massa Corporal).
 * 
 * O objetivo é apenas mostrar o funcionamento e a praticidade
 * propósta pelo framework.
 * 
 * Se estamos aprendendo um curso e fazendo vários exercícios,
 * basta fazer várias implementações como a realizada abaixo
 * ao invés de criar vários projetos novos.
 * 
 * @author Fernando Bino Machado
 */
@ExMap(
		numero = 1,
		titulo = "Cálculo de IMC"
)
public class CalculoIMC extends ExGeneric {

	/**
	 * Definimos os atributos que desejamos trabalhar
	 */
	String nome;
	Double altura, peso, valorRetorno;
	
	/**
	 * Iniciamos o exercício, como no exemplo abaixo; nesse método podemos
	 * iniciar os parâmetros necessários para esse exercício, que no caso
	 * é um cálculo de IMC, então precisamos da altura e do peso, e adicionalmente
	 * estamos adicionando o nome do sujeito...
	 */
	@Override
	public void iniciarExercicio() throws BusinessException {
		nome = "Tiburcio da silva";
		altura = 1.76;
		peso = 71.56;
	}
	
	/**
	 * Processamos o exercício, nessa etapa processamos os parametros 
	 * com alguma lógica que deve produzir novas variaveis que poderão ser 
	 * usadas na saída do exercício
	 */
	@Override
	public void processarExercicio() throws BusinessException {
		valorRetorno = peso / (altura * altura);
	}
	
	/**
	 * Preparamos a saida, que é um StringBuilder 
	 * que será utilizado para printar o texto equivalente ao resultado do 
	 * processamento desse exercício.
	 */
	@Override
	public void finalizarExercicio() throws BusinessException {
	
		saida
			.append("Valor do Calculo de IMC do ")
			.append(nome)
			.append("\n")
			.append("IMC = ")
			.append(peso)
			.append(" / (")
			.append(altura)
			.append(" * ")
			.append(altura)
			.append(") = ")
			.append(valorRetorno);
		
		exibirSaida();
			
	}
	
	
}
