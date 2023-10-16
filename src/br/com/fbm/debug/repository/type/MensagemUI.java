/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.repository.type;

import javax.swing.JOptionPane;

/**
 * {@code MensagemUI} provê diferentes implementações
 * para exibir mensagens ao usuário de acordo com o tipo de
 * mensagem.
 * @author Fernando Bino Machado
 */
public enum MensagemUI {

	INFO{
		@Override
		public void show(String pMensagem) {
			JOptionPane.showMessageDialog(null, pMensagem, 
					"Informação", JOptionPane.INFORMATION_MESSAGE);
		}
	},
	WARNING{
		@Override
		public void show(String pMensagem) {
			JOptionPane.showMessageDialog(null, pMensagem, 
					"Aviso", JOptionPane.WARNING_MESSAGE);
		}
	},
	ERROR{
		@Override
		public void show(String pMensagem) {
			JOptionPane.showMessageDialog(null, pMensagem, 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	};
	
	public abstract void show(final String pMensagem);
	
}
