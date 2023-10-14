package br.com.fbm.debug.impl.exercicio.matematica;

import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;

/**
 * Abaixo um exemplo de implementação
 * aparentemente insignificante de cálculo de IMC.
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
	Double altura, peso;
	
	/**
	 * Definimos o tipo de retorno desse exercício
	 * para futuros processamentos por Reflection.
	 */
	@Override
	protected Class<?> definirTipoRetorno() {
		return Double.class;
	}
	
	/**
	 * Iniciamos os parametros
	 */
	@Override
	protected void iniciarParametros() {
		nome = "Tiburcio da silva";
		altura = 1.76;
		peso = 71.56;
	}
	
	/**
	 * Processamos os parametros com alguma lógica
	 * essa deve produzir o valorRetornado
	 */
	@Override
	protected void processarParametros() {
		valorRetorno = peso / (altura * altura);
	}
	
	/**
	 * Preparamos a saida, que é um StringBuilder 
	 * que será utilizado para printar o texto equivalente a saida
	 * preparada.
	 */
	@Override
	protected void prepararSaida() {
		
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
			
	}
	
	
}
