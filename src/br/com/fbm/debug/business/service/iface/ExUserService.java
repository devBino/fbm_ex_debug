/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.business.service.iface;

import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.exception.BusinessException;

/**
 * {@code ExUserService} define uma interface para possibilitar
 * acesso as rotinas de processamento em tempo de execução na aplicação
 * do usuário
 * @author Fernando Bino Machado
 */
public interface ExUserService {

	void processar(final ExGeneric pExGeneric) throws BusinessException;
	
}
