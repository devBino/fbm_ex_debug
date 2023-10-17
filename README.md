# Micro Framework para Processamento de Exercícios &#129299;<br>

<p align="justify">Autor: Fernando Bino Machado <br><br>O presente projeto consiste em um exemplo de uso do micro framework para processamento de exercícios, FBMEXDEBUG. O framework pode ser localizado e baixado da pasta <b>jarfile</b>. Com esse framework é possível implementar exercícios, mapear e aos grupar e debugar de acordo com assuntos desejados.</p>
<br>
<h2>Abaixo um exemplo de inicialização do framework</h2>

```java
package br.com.demo.app;

import br.com.fbm.debug.StartApplication;

/**
 * Exemplo de inicialização da aplicação.
 * 
 * Deve possuir uma class StartUserApplication que extenda StartApplication
 * e possuir um método main. 
 */
public class StartUserApplication extends StartApplication {
	
	/**
	 * No método main, deve chamar os dois métodos setPackageExercicios 
	 * e exibirWindow.
	 * 
	 * @see br.com.fbm.debug.StartApplication#setPackageExercicios(String...);
	 * @see br.com.fbm.debug.StartApplication#exibirWindow();
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		//define passando um var args de String, qual é o package base para agrupar os exercícios
		setPackageExercicios("src","br","com","demo","impl");

		//exibe a janela padrão para procurar exercícios implementados no package definido acima    
		exibirWindow();


	}

}
```

<br>
<h2>Abaixo um exemplo de implementação de exercício</h2>

```java

package br.com.demo.impl.exercicio.matematica;

import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;

/**
 * Abaixo um exemplo de implementação de cálculo de IMC.
 * 
 * O objetivo é apenas mostrar um exemplo de implementação de
 * {@code ExGeneric} que representa os exercícios.
 * 
 * Se estamos aprendendo um curso e fazendo vários exercícios,
 * basta fazer várias implementações como a realizada abaixo
 * ao invés de criar vários projetos novos.
 * 
 * @author Fernando Bino Machado
 */
@ExMap(numero = 1, titulo = "Cálculo de IMC") //anotação para mapear o exercício
public class CalculoIMC extends ExGeneric { //a classe deve extender ExGeneric

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

```
