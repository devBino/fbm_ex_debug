package fbm.ex.user.impl.exercicio.string;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;

@ExMap(numero = 6, titulo = "Strings, vendo tamanho de um texto")//anotação necessario
public class VerTamanhoTexto extends ExGeneric {

	//inicia os parametros do exercício
	String nomePessoa;
	int tamanho;
	
	@Override
	protected Class<?> definirTipoRetorno() {
		return null;
	}
	
	@Override
	protected void iniciarParametros() throws BusinessException {
		nomePessoa = "Felipe dos Reis Bino Machado";
	}
	
	@Override
	protected void processarParametros() throws BusinessException {
		tamanho = nomePessoa.length();
	}
	
	@Override
	protected void prepararSaida() throws BusinessException {
		
		saida
			.append("O nome ")
			.append(nomePessoa)
			.append(" tem ")
			.append(tamanho)
			.append(" caractere(s) ");
		
	}
	
	
}
