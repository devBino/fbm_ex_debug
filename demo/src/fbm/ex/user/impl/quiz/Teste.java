/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package fbm.ex.user.impl.quiz;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.Assunto;
import br.com.fbm.debug.business.service.annotations.ExMap;

/**
 * @author Fernando Bino Machado
 *
 */
@Assunto("teste")
@ExMap(numero = 1, titulo = "Teste user")
public class Teste extends ExGeneric {

	@Override
	protected Class<?> definirTipoRetorno() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void iniciarParametros() throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void processarParametros() throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	
	
}
