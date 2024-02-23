/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package fbm.ex.user.impl.exercicio.datas;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;
import br.com.fbm.debug.business.service.annotations.Repetir;

/**
 * Exercício simples, apenas para testar a anotação @Repetir
 * que define quantas vezes um exercício pode ser repetido.
 * 
 * @author Fernando Bino Machado
 */
@Repetir(10)
@ExMap(numero = 12, titulo = "Imprime DateTime apenas para testar anotação @Repetir")
public class ExDatasTesteRepeticao extends ExGeneric {

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
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Data Atual => " + LocalDateTime.now());
		}catch(final Exception exception) {
			exception.printStackTrace();
		}
	}
	
}
