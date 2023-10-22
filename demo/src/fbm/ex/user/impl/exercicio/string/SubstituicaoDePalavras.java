package fbm.ex.user.impl.exercicio.string;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;

@ExMap(
		numero = 8,
		titulo = "Substitui Letras e Palavras"
)
public class SubstituicaoDePalavras extends ExGeneric {

	String p1Temp, primeiraPalavra, trocaPrimeiraPalavra;
	String p2Temp, segundaPalavra, trocaSegundaPalavra;
	String p3Temp, terceiraPalavra, trocaTerceiraPalavra;
	
	@Override
	public void iniciarExercicio() throws BusinessException {

		primeiraPalavra = "o dia esta belo";
		segundaPalavra = "a tarde esta ensolarada";
		terceiraPalavra = "a noite esta quieta";
		
	}
 
	@Override
	public void processarExercicio() throws BusinessException {
		
		p1Temp = primeiraPalavra.replace("a", "o");
		p2Temp = segundaPalavra.toUpperCase().replace("A", "U");
		p3Temp = terceiraPalavra.toUpperCase().replace("A", "I");
		
		trocaPrimeiraPalavra = primeiraPalavra.replace(primeiraPalavra, "o dia esta feio");
		trocaSegundaPalavra = segundaPalavra.replace(segundaPalavra, "a tarde esta nublada");
		trocaTerceiraPalavra = terceiraPalavra.replace(terceiraPalavra, "a noite esta barulhenta");
	}

	@Override
	public void finalizarExercicio() throws BusinessException {

		saida 
		
		.append("A primeira palavra em seu estado normal é: ")
		.append(primeiraPalavra)
		.append("\n")
		.append("No primeiro caso de troca (letras) é: ")
		.append(p1Temp)
		.append("\n")
		.append("No caso de troca de palavra é: ")
		.append(trocaPrimeiraPalavra)
		.append("\n\n")		
		.append("A segunda palavra em seu estado normal é: ")
		.append(segundaPalavra)
		.append("\n")
		.append("No primeiro caso de troca (letras) é: ")
		.append(p2Temp)
		.append("\n")
		.append("No caso de troca de palavra é: ")
		.append(trocaSegundaPalavra)
		.append("\n\n")		
		.append("A terceira palavra em seu estado normal é: ")
		.append(terceiraPalavra)
		.append("\n")
		.append("No primeiro caso de troca (letras) é: ")
		.append(p3Temp)
		.append("\n")
		.append("No caso de troca de palavra é: ")
		.append(trocaTerceiraPalavra);
		
		exibirSaida();
	}

}
