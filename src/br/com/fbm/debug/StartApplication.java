/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug;

import br.com.fbm.debug.business.factory.ExFactory;
import br.com.fbm.debug.repository.type.MensagemUI;
import br.com.fbm.debug.views.JApp;

/**
 * {@code StartApplication} define rotina de inicialização
 * da aplicação
 * @author Fernando Bino Machado
 */
public class StartApplication {

	/**
	 * Define pacote onde estarão as implementações dos exercícios
	 * no projeto do usuário
	 * @param pFolder
	 */
	protected static void setPackageExercicios(final String... pFolders) {
		ExFactory.setFolderExercicios(pFolders);
	}
	
	/**
	 * Exibe janela de busca e processamento de exercícios
	 */
	public static void exibirWindow() {
		
		if( ExFactory.getFolderExercicios() == null ) {
			MensagemUI.ERROR.show("O método setPackageExercicios(final String pFolder) deve ser executado...");
			return;
		}
		
		JApp app = new JApp();
		app.setVisible(true);
		
	}
	
}
