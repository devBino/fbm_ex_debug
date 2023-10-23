package fbm.ex.user.impl.exercicio.string;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;

@ExMap(
		numero = 8,
		titulo = "Substitui Letras e Palavras"
)
public class SubstituicaoDePalavras extends ExGeneric {

	//Definindo atributos importantes como:
	
	/*
	 * p1Temp/p2Temp/p3Temp, onde ficará a frase com letras modificadas
	 * primeiraPalavra/segundaPalavra/terceiraPalavra, onde ficará a frase como foi definida no método 'iniciarExercicio'
	 * trocaPrimeiraPalavra/trocaSegundaPalavra/trocaTerceiraPalavra, onde ficará a frase modificada
	*/
	
	
	String p1Temp, primeiraPalavra, trocaPrimeiraPalavra;
	String p2Temp, segundaPalavra, trocaSegundaPalavra;
	String p3Temp, terceiraPalavra, trocaTerceiraPalavra;
	
	@Override
	public void iniciarExercicio() throws BusinessException {

		//Definindo as frases 'base', que serão modificadas posteriormente
		primeiraPalavra = "o dia esta belo";
		segundaPalavra = "a tarde esta ensolarada";
		terceiraPalavra = "a noite esta quieta";
		
	}
 
	@Override
	public void processarExercicio() throws BusinessException {
		
		/*
		 p1: repondo caracteres 'a' por 'o' formando palavras como 'dio'/'esto'
		 p2: repondo caracteres 'A' por 'U' uma vez que o texto base foi modificado para caracteres em 'caixa alta'
		 p3: repondo caracteres 'A' por 'I' da mesma maneira que a anterior 
		*/
		p1Temp = primeiraPalavra.replace("a", "o");
		p2Temp = segundaPalavra.toUpperCase().replace("A", "U");
		p3Temp = terceiraPalavra.toUpperCase().replace("A", "I");
		
		/*
		 trocando as palavras por versões contrárias ao sentido original 
		*/
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
