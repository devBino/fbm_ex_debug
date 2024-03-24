package fbm.ex.user.impl.exercicio.alomundo;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;

@ExMap(numero = 0.1, titulo = "Alo Mundo Framework Exercícios")
public class AloMundoEx extends ExGeneric {

	private StringBuilder msg;
	
	/**
	 * Método responsável por iniciar atributos, instâncias de objetos, 
	 * ou estruturas de dados necessárias ao exercício
	 */
	@Override
	public void iniciarExercicio() throws BusinessException {
		msg = new StringBuilder();
	}
	
	/**
	 * Método responsável por processar os recuros iniciados em
	 * {@link this#iniciarExercicio()} transformando-os em uma
	 * saída útil desse exercício
	 */
	@Override
	public void processarExercicio() throws BusinessException {
		msg.append("Alô ");
		msg.append("Mundo!!");
	}
	
	/**
	 * Método responsável por exibir a saída do exercício 
	 * após o processamento de todas as entradas de recursos.
	 * Opcionalmente é possível utilizar {@link this#exibirSaida()}
	 * mas para isso precisa inputar o valor no {@code StringBuilder} saida
	 * de {@link ExGeneric#getSaida()}
	 */
	@Override
	public void finalizarExercicio() throws BusinessException {
		saida.append(msg.toString());
		exibirSaida();
	}
	
}
