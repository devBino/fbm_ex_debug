/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package fbm.ex.user.app;

import br.com.fbm.debug.StartApplication;

/**
 * Exemplo de inicialização da aplicação no projeto
 * do usuário.
 * 
 * Deve possuir uma class StartUserApplication que extend StartApplication
 * e possuir um método main.
 * 
 * @author Fernando Bino Machado
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
		setPackageExercicios("src","fbm","ex","user","impl");
		exibirWindow();
	}

}
