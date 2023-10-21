package fbm.ex.user.impl.exercicio.matematica;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;

@ExMap(
		numero = 6,
		titulo = "Cálculo de Média Escolar"
)
public class CalculoDeMedia extends ExGeneric {
	
	String nome;
	int nota1Trimestre, nota2Trimestre;
	int nota3Trimestre, nota4Trimestre;
	float calculaMedia;
	
	@Override
	public void iniciarExercicio() throws BusinessException {
		nome = "Juliano";
		nota1Trimestre = 45;
		nota2Trimestre = 50;
		nota3Trimestre = 80;
		nota4Trimestre = 30;
	}

	@Override
	public void processarExercicio() throws BusinessException {
		calculaMedia = (nota1Trimestre + nota2Trimestre + nota3Trimestre + nota4Trimestre) / 4;
	}
	
	@Override
	public void finalizarExercicio() throws BusinessException {
		
		saida
			.append("Cálculo de Média Escolar")
			.append("\n")
			.append("Nome do aluno: " + nome)
			.append("\n")
			.append("A média necessária para passar é de 50")
			.append("\n")
			.append("No 1 trimestre tirou a nota de: " + nota1Trimestre)
			.append("\n")
			.append("No 2 trimestre tirou a nota de: " + nota2Trimestre)
			.append("\n")
			.append("No 3 trimestre tirou a nota de: " + nota3Trimestre)
			.append("\n")
			.append("No 4 trimestre tirou a nota de: " + nota4Trimestre)
			.append("\n")
			.append("Portanto, nesta somatória, a média final de " + nome + " é: " + calculaMedia);
		
		exibirSaida();
	
	}
	

}
