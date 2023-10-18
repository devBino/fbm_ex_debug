# Micro Framework para Processamento de Exercícios &#129299;<br>

<p align="justify">Autor: Fernando Bino Machado <br><br>O presente projeto consiste em um exemplo de uso do micro framework para processamento de exercícios, FBMEXDEBUG. O framework pode ser localizado e baixado da pasta <b>jarfile</b>. Com esse framework é possível implementar exercícios, mapear e os grupar e debugar de acordo com assuntos desejados.</p>
<br>
<p align="justify">A utilização é bem simples, basta seguir a sequência propósta abaixo:</p>
<br>
<h2>1 - Criar classe de inicialização no seu projeto</h2>

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
<h2>2 - Criar implementações de exercícios como no exemplo abaixo</h2>

```java

/**
 * dentro do pacote definido como pacote dos execícios
 * deve existir dois sub pacotes, um chamado "exercicio" e outro chamado "quiz"
 * e dentro de cada um desses sub pacotes, podemos ter nossos pacotes separando os exercícios
 *
 * O exercício abaixo está nessa hierarquia, considerando que
 * "br.com.demo.impl" foi o pacote definido como base na classe
 * de inicialização do projeto
 * 
 * br.com.demo.impl
 * 		exercicio
 * 			matematica
 * 		quiz
 */ 
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

<br>
<h2>3 - Implementando a classe de processamento de exercícios</h2>

```java

package br.com.demo.impl;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.UserService;
import br.com.fbm.debug.business.service.iface.ExUserService;

/**
 * O pacote configurado como pacote das implementações dos exercícios,
 * deve possuir uma classe que implemente ExUserService, e implementar
 * o método processar.
 * 
 * @author Fernando Bino Machado
 */
@UserService //deve ser anotada com @UserService
public class UserServiceImpl implements ExUserService { //deve extender ExUserService

	@Override
	public void processar(ExGeneric pExGeneric) throws BusinessException {

		//deve implementar o método processar
		//e chamar os métodos abaixo do parametro exercício
		//recebido do framework		
		pExGeneric.iniciarExercicio();
		pExGeneric.processarExercicio();
		pExGeneric.finalizarExercicio();
		
	}
	
}

```

<br>

<p align="justify">Agora basta adicionar um <b>break point</b> dentro do método processar, e todas as implementações de ExGeneric recebidas pelo framework, passaram por esse método, e nesse momento você terá a chance de debugar todos os seus exercícios.</p>
<br>
<p align="justify">Talvez isso não pareça grande coisa se olhar somente para esse exemplo, mas considere que você pode implementar seus exercicios adicionando anotações @Assunto, @Flags além de @ExMap e através dessas anotações pode sistematicamente organizar seus exercícios dispensando a criação de inúmeros projetos e usando a organização que o framework provê, para sistematicamente localizar e debugar seus exercícios.</p>
