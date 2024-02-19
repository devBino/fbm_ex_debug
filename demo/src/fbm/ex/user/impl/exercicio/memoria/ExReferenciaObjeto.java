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
import br.com.fbm.debug.business.service.annotations.Assunto;
import br.com.fbm.debug.business.service.annotations.ExMap;
import fbm.ex.user.impl.exercicio.memoria.aux.Clube;

/**
 * Exercício de variáveis por referência x variáveis por instância
 * @author Fernando Bino Machado
 */
@Assunto("memória")
@ExMap(numero = 10, titulo = "Exercício de variáveis por referência x variáveis por instância")
public class ExReferenciaObjeto extends ExGeneric {

	Clube saoPauloMasculino, saoPauloFeminino, palmeiras;
	
	@Override
	public void iniciarExercicio() throws BusinessException {
		
		//criando nova instancia para o objeto clube
		saoPauloFeminino = new Clube("São Paulo", "Futebol");
		
		//passando valor da referencia na memória do objeto recém criado 
		//em saoPauloFeminino para saoPauloMasculino 
		saoPauloMasculino = saoPauloFeminino;

		//criando clube palmeiras passando objeto sao paulo para o construtor
		//mas dessa vez o novo objeto palmeiras realmente será um objeto novo cujo
		//endereço de memória será diferente do clube de são paulo acima
		palmeiras = new Clube(saoPauloMasculino);
		//ajustando nome do clube palmeiras, já que passamos o clube de são paulo para
		//o construtor
		palmeiras.setNome("Palmeiras");
		
	}
	
	@Override
	public void processarExercicio() throws BusinessException {
		//NA
	}
	
	@Override
	public void finalizarExercicio() throws BusinessException {
		
		saida
			.append("saoPauloFeminino => ")
			.append(saoPauloFeminino)
			.append("\n")
			.append("saoPauloMasculino => ")
			.append(saoPauloMasculino)
			.append("\n")
			.append("palmeiras => ")
			.append(palmeiras)
			.append("\n");
		
		exibirSaida();
		
	}
	
}
