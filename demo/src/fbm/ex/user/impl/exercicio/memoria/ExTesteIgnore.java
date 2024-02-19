/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package fbm.ex.user.impl.exercicio.memoria;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;
import br.com.fbm.debug.business.service.annotations.Ignore;

/**
 * Exercício teste para anotação {@code Ignore}
 * @author Fernando Bino Machado
 */
@Ignore
@ExMap(numero = 10.01, titulo = "Exercício teste para anotação Ignore")
public class ExTesteIgnore extends ExGeneric {

	@Override
	public void iniciarExercicio() throws BusinessException {
		//NA
	}
	
	@Override
	public void processarExercicio() throws BusinessException {
		//NA		
	}
	
	@Override
	public void finalizarExercicio() throws BusinessException {
		//NA
	}
	
}
