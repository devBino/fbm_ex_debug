# Micro Framework para Processamento de Exercícios &#129299;<br>

<p align="justify">Autor: Fernando Bino Machado <br><br>O presente projeto consiste em um exemplo de uso do micro framework para processamento de exercícios, FBMEXDEBUG.</p>
<p align="justify">O framework pode ser localizado e baixado da pasta <b>jarfile</b>.</p>
<p align="justify">Com esse framework é possível mapear e agrupar as implementações de exercícios e as debugar de acordo com assuntos desejados.</p>

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
