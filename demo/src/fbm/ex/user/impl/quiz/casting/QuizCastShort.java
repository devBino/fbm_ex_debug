/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package fbm.ex.user.impl.quiz.casting;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.Assunto;
import br.com.fbm.debug.business.service.annotations.ExMap;
import br.com.fbm.debug.business.service.annotations.ExRespostas;

/**
 * {@code QuizCastShort} exemplifica como utilizar {@code ExGeneric}
 * para implementação de quiz.
 * 
 * No exemplo abaixo estamos tentando converter via cast um int em short.
 * 
 * Mas existe uma pegadinha ai...
 * 
 * @author Fernando Bino Machado
 */
@Assunto("cast")
@ExRespostas({"-30211","-31768","-32768","33768","-33768"})
@ExMap(numero = 1.0, titulo = "Pegadinha sobre casting", tipoExercicio = "quiz")
public class QuizCastShort extends ExGeneric {

	
	short numConvertido, argSoma;
	int numBase;
	int soma;
	
	@Override
	public void iniciarExercicio() throws BusinessException {
		numBase = 32767;
		argSoma = 1000;
	}
	
	@Override
	public void processarExercicio() throws BusinessException {
		numConvertido = (short) ++numBase;
		soma = argSoma + numConvertido;
	}
	
	@Override
	public void finalizarExercicio() throws BusinessException {
		saida.append(soma);
	}
	
	
}
