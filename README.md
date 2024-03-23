# Micro Framework para Processamento de Exercícios <br>

Autor: Fernando Bino Machado <br><br>

<h2 id="h2-sumario">Sumario</h2>

<ul>
	<li><a href="#h2-introducao">1 - Introdução</a> </li>
	<li><a href="#h2-inicializacao-auto">2 - Inicialização Automática</a></li>
	<li><a href="#h2-inicializacao-manual">3 - Inicialização Manual</a></li>
	<li><a href="#h2-como-debugar">4 - Debugando Exercícios</a></li>
</ul>

<h2 id="h2-introducao">1 - Introdução</h2><br>

<p align="justify">Quem nunca começou um curso ou uma play-list no youtube sobre algum tema de programação, tal como, herança, interfaces, tipos primitivos, lambda etc. Enquanto assisitimos ao conteúdo é natural espalharmos um bilhão de classes com qualquer nome e um salvador método main. No momento inicial de conhecer os conceitos, essas classes milagrosas funcionam bem, mas as semanas passam e depois vamos precisar novamente daquele determinado tema. E agora, como encontrar essas classes milagrosas espalhadas em vários projetos sem padrão algum? A saída é recorrer ao mesmo video/conteúdo visto semanas antes e irônicamente produzir mais uma classe e mais um método main em qualquer lugar por acaso...</p>
<p align="justify">Não que isso seja errado, só é uma pratica ruim, principalmente quando estamos aprendendo algo novo. E que tal se pudessemos aprender esses temas importantes e formar nossa própria bibliotéca pessoal de classes, exemplos, e cases? Que tal se o aprendizado fosse documentado com comentários e explicações? Exemplos didáticos no próprio código fáceis de localizar, otimizando tempo no aprendizado e consolidando cada vez mais nosso conhecimento?</p>
<p align="justify">Refletindo muito sobre essa necessidade comum a todos, desenvolvi o presente projeto que consiste em um micro framework para processamento de exercícios chamado FBMEXDEBUG. Com ele podemos criar exercícios padronizados, com anotações do framework, permitindo filtrar facilmente os exercícios por titulo, tema ou numeração da aula. Esse projeto apresenta uma solução ao problema recorrente que todos passamos, pois organiza nosso aprendizado e permite que se apropriemos do que aprendemos, o aprendizado se torna nossa experiência pessoal documentada, e com propriedade vamos buscá-lo no futuro, não em um fórum, mas na nossa bibliotéca pessoal de exercícios.
</p>
<p align="justify">Existem algumas maneiras de utilizar o framework que envolvem desde baixar o jarfile e criar nosso projeto seguindo passo a passo, até mesmo utilizar um inicilializador automático de projeto no padrão do framework.</p>

<br>
<a href="#sumario">Voltar Sumário</a>
<br>


<h2 id="h2-inicializacao-auto">2 - Inicialização do Projeto com inicializador de Projetos</h2><br>

<p align="justify">É possível utilizar o gerador de projetos para iniciar um projeto de Exercícios nos padrões do framework, para isso basta baixar o jarfile na pasta generator. Após ter baixado o jarfile, execute o programa e siga os passos abaixo:</p>
<br>

<p align="justify">Preencha os campos de acordo com a necessidade do seu projeto</p>

![Preenchimento dos Campos](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/tela_campos.png)

<br>

<p align="justify">Em seguida uma barra de progresso e logs serão exibidos</p>

![Preenchimento dos Campos](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/clique_concluir.png)

<br>

<p align="justify">Aguarde até a conclusão tal como abaixo</p>

![Preenchimento dos Campos](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/confirmacao.png)

<br>
<a href="#sumario">Voltar Sumário</a>
<br>

<h2 id="h2-inicializacao-manual">3 - Inicialização Manual de Projeto</h2><br>

<p align="justify">A inicialização manual de um projeto é bem simples, basta seguir a sequência propósta abaixo:</p>
<br>
<h3>3.1 - Criar classe de inicialização no seu projeto</h3>

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
<h3>3.2 - Implementando a classe de processamento de exercícios</h3>

```java

package br.com.demo.impl;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.UserService;
import br.com.fbm.debug.business.service.iface.ExUserService;

/**
 * O pacote configurado como pacote base das implementações dos exercícios,
 * deve possuir uma classe que implemente ExUserService
 * 
 * @author Fernando Bino Machado
 */
@UserService //deve ser anotada com @UserService
public class UserServiceImpl implements ExUserService { //deve implementar ExUserService

	@Override
	public void processar(ExGeneric pExGeneric) throws BusinessException {

		//deve implementar o método processar
		//e chamar os métodos abaixo pertencentes ao parametro pExGeneric
		//recebido do framework
		pExGeneric.iniciarExercicio();
		pExGeneric.processarExercicio();
		pExGeneric.finalizarExercicio();
		
	}
	
}

```

<br>
<h3>3.3 - Criar implementações de exercícios como no exemplo abaixo</h3>

```java

/**
 * Dentro do pacote definido como pacote base dos execícios
 * devem existir dois sub pacotes, um chamado "exercicio" e outro chamado "quiz"
 * e dentro de cada um desses sub pacotes, podemos ter nossos pacotes separando os exercícios
 * de acordo com nossa necessidade.
 *
 * O exercício abaixo está nessa hierarquia, considerando que
 * "br.com.demo.impl" foi o pacote definido como base dos exercícios na classe
 * de inicialização do projeto:
 * 
 * br.com.demo.impl (pacote base)
 * 		exercicio (sub pacote)
 * 			matematica (minha organização de pacotes)
 *				CalculoIMC.java (meu exercício)
 * 		quiz (sub pacote)
 */ 
package br.com.demo.impl.exercicio.matematica;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;

/**
 * Abaixo um exemplo de implementação aparentemente insignificante de 
 * cálculo de IMC (Indice de Massa Corporal).
 * 
 * O objetivo é apenas mostrar o funcionamento e a
 * propósta de organização framework.
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
	 * estamos tendo o nome do sujeito...
	 */
	@Override
	public void iniciarExercicio() throws BusinessException {
		nome = "Tiburcio da silva";
		altura = 1.76;
		peso = 71.56;
	}
	
	/**
	 * Processamos o exercício, nessa etapa processamos os parametros 
	 * com alguma lógica que deve produzir novas variáveis que poderão ser 
	 * usadas na saída do exercício
	 */
	@Override
	public void processarExercicio() throws BusinessException {
		valorRetorno = peso / (altura * altura);
	}
	
	/**
	 * Preparamos a saida, que é um StringBuilder herdado de {@code ExGeneric}
	 * que será utilizado para printar o texto equivalente ao resultado do 
	 * processamento desse exercício.
	 */
	@Override
	public void finalizarExercicio() throws BusinessException {

		//buildando a string para saida
		//saida é um atributo StringBuilder herdado de ExGeneric
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

```
<br>

<br>
<a href="#sumario">Voltar Sumário</a>
<br>

<h2 id="h2-como-debugar">4 - Debugando Exercícios</h2>

<p align="justify">Agora basta adicionar um <b>break point</b> dentro do método processar, e todas as implementações de ExGeneric recebidas pelo framework, passaram por esse método, e nesse momento você terá a chance de debugar todos os seus exercícios. Aqui é importante dizer que quando sua aplicação iniciar, será exibida um janela padrão de pesquisa de exercícios implementados no pacote base definido. </p>
<br>
<p align="justify">Nessa Janela, logo após você ter localizado seus exercícios, ao clicar em <b>Debugar</b> o framework irá processar todos os exercícios localizados e passará um por um como parâmetro para esse método processar da classe UserServiceImpl exemplificada acima. Dessa forma, você terá organização e controle, e poderá consultar sua "<b>bibliotéca de exercícios</b>".</p>

<br>
<p align="justify">Talvez isso não pareça grande coisa se olhar somente para esse exemplo, mas considere que você pode implementar seus exercicios adicionando anotações @Assunto, @Flags além de @ExMap e através dessas anotações pode sistematicamente organizar seus exercícios dispensando a criação de inúmeros projetos e usando a organização que o framework provê, para sistematicamente localizar e debugar seus exercícios.</p>

<br>
<a href="#sumario">Voltar Sumário</a>
<br>

