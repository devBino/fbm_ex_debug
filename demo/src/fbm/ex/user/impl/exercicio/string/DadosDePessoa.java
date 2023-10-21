package fbm.ex.user.impl.exercicio.string;

import java.util.ArrayList;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;

/**
 * Exercício manipulando Strings em listas List<String>
 * @author Felipe Machado
 */
@ExMap(
		numero = 7,
		titulo = "Imprime Nomes e Dados de Pessoas"
)
public class DadosDePessoa extends ExGeneric {

	ArrayList<String> pessoas, dados, dadosEPessoas;
	
	@Override
	public void iniciarExercicio() throws BusinessException {

		//iniciando as List<String>
		pessoas = new ArrayList<String>();
		dados = new ArrayList<String>();
		dadosEPessoas = new ArrayList<String>();
		
		//populando as List<String>
		pessoas.add("Junior "); 
		dados.add("Email: juniorsouza@gmail.com / Telefone: 998801342");
		
		pessoas.add("Alexandre "); 
		dados.add("Email: alexandremota@gmail.com / Telefone: 997821342");
		
		pessoas.add("Ana "); 
		dados.add("Email: anajulia@outlook.com / Telefone: 998201434");
		
		pessoas.add("Julia "); 
		dados.add("Email: juliamoreira@outlook.com / Telefone: 991516542");
		
		pessoas.add("Maria "); 
		dados.add("Email: mariaelizabeth@gmail.com / Telefone: 995402263");
		
	}

	@Override
	public void processarExercicio() throws BusinessException {

		//percorrendo pessoas e populando dadosEPessoas
		//com base nos dados de pessoas e dados
		for(int ad = 0; ad < pessoas.size(); ad++) {
			dadosEPessoas.add("Nome: " + pessoas.get(ad) + "/ possui os dados de: " + dados.get(ad));
		}
	
	} 
	
	@Override
	public void finalizarExercicio() throws BusinessException {
	
		saida
			.append("Imprime Nomes e Dados de Pessoas")
			.append("\n");
		
		for(int ad=0; ad<dadosEPessoas.size(); ad++) {
			saida
				.append(dadosEPessoas.get(ad))
				.append("\n");
		}
		
		exibirSaida();
		
	}
	
	
}
