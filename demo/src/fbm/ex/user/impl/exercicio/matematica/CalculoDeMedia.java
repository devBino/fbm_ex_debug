package fbm.ex.user.impl.exercicio.matematica;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.ExMap;

@ExMap(
		numero = 7,
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
			.append("\nNome do aluno: " + nome)
			.append("\nA média necessária para passar é de 50")
			.append("\nNo 1 trimestre tirou a nota de: " + nota1Trimestre)
			.append("\nNo 2 trimestre tirou a nota de: " + nota2Trimestre)
			.append("\nNo 3 trimestre tirou a nota de: " + nota3Trimestre)
			.append("\nNo 4 trimestre tirou a nota de: " + nota4Trimestre) 
			.append("\nPortanto, nesta somatória, a média final de " + nome + " é: " + calculaMedia + "\n");
		
		exibirSaida();
	
	}
	

}
