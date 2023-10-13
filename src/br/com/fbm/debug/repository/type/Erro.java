/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.repository.type;

/**
 * {@code Erro} define os tipos de erro
 * para construir uma {@code BusinessException}
 * 
 * @author Fernando Bino Machado
 */
public enum Erro {

	/**
	 * Tipos de erros personalizados
	 */
	ERRO_DESCONHECIDO( (byte)1, "Erro desconhecido."),
	IMPL_NAO_ENCONTRADA( (byte)2, "Implementação não encontrada."),
	ERRO_AO_CRIAR_INSTANCIA_REFLECTION( (byte)3, "Erro ao tentar criar uma instância via reflection");
	
	/**
	 * Codigo e mensagem
	 */
	byte codigo;
	String mensagem;
	
	/**
	 * Inicia um tipo de {@code Erro}
	 * @param pCodigo
	 * @param pMensagem
	 */
	Erro(final byte pCodigo, final String pMensagem) {
		codigo = pCodigo;
		mensagem = pMensagem;
	}
	
	/**
	 * Retorna o valor do codigo
	 * @return
	 */
	public byte getCodigo() {
		return codigo;
	}
	
	/**
	 * Retorna o valor da mensagem
	 * @return
	 */
	public String getMensagem() {
		return mensagem;
	}
	
	/**
	 * Recupera mensagem de erro personalizada
	 * para {@code BusinessException}
	 * @param pMensagemExterna
	 * @return
	 */
	public String getMensagemErro(final String pMensagemExterna) {
		
		return new StringBuilder()
				.append("[")
				.append(codigo)
				.append("]")
				.append(" - ")
				.append(mensagem)
				.append("\n")
				.append(pMensagemExterna)
				.toString();
		
	}
	
	
}
