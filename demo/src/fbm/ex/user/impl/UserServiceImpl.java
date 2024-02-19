/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package fbm.ex.user.impl;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.UserService;
import br.com.fbm.debug.business.service.iface.ExUserService;

/**
 * No pacote configurado como pacote das implementações dos exercícios,
 * deve possuir uma classe que implement ExUserService, e implementar
 * o método processar.
 * 
 * @author Fernando Bino Machado
 */
@UserService
public class UserServiceImpl implements ExUserService {

	@Override
	public void processar(ExGeneric pExGeneric) throws BusinessException {
		
		pExGeneric.iniciarExercicio();
		pExGeneric.processarExercicio();
		pExGeneric.finalizarExercicio();
		
	}
	
	@Override
	public void testeQuiz(ExGeneric pExGeneric, String pEnunciado, String[] pRespostas) throws BusinessException {

		ExUserService.super.testeQuiz(pExGeneric, pEnunciado, pRespostas);
		
	}
	
}
