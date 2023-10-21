package fbm.ex.user.impl.exercicio.lambda.consumer;

import java.util.function.Consumer;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.Assunto;
import br.com.fbm.debug.business.service.annotations.ExMap;

/**
 * Exercicio simples com uso de lambda 
 * na interface funcional Consumer<T>.
 * 
 * A interface funcional Consumer<T> possui um SAM (Single Abstract Method) 
 * accept(T t), que aceita um parâmetro T, que por sua vez é um Genéric tipado
 * na declaração do Consumer<T>.
 * 
 * Então para consumir strings precisamos declarar um consumer assim
 * 
 * Consumer<String> cons = texto -> {
 * 	//fazer alguma coisa com texto
 * };
 * 
 * de igual maneira pedemos ter diversos consumers de acordo com nossa 
 * necessidade por exemplo:
 * 
 * Consumer<Integer> cons = numero -> {
 * 	//fazer alguma coisa com numero
 * };
 * 
 * Consumer<Double> cons = numeroDecimal -> {
 * 	//fazer alguma coisa com numeroDecimal
 * };
 * 
 * Consumer<MeuObjeto> cons = meuObj -> {
 * 	//fazer alguma coisa com meuObj
 * 	//tipo, meuObj.invocaAlgumMetodo()
 * };
 * 
 * O fato é que depois do sinal de igual, estamos atribuindo uma expressão, 
 * e isso chamamos de lambda, essa expressão é um lambda. 
 * Quando o método accept da interface funcional Consumer<T> 
 * for invocado, na verdade o que será executado é essa expressão que passamos. 
 * 
 * Quando fazemos isso a referencia para o método accept de Consumer<T>
 * passa a ser essa expressão, em outras palavras é como se falassemos
 * que accept agora é essa expressão, portanto é ela que será executada.
 * 
 * Existem outros detalhes sobre expressões lambda, 
 * tais com expressões inline,
 * expressões multiline com uso de chaves, expressões onde precisamos 
 * declarar os tipos dos parametros recebidos, mas para o comentário não
 * ficar muito longo, paramos por aqui.
 * 
 * @author Fernando Bino Machado
 */
@Assunto("lambda")
@ExMap(numero = 3.01, titulo = "Lambda com Interface Funcional Consumer<T>")
public class InterfaceConsumerEx extends ExGeneric {

	Consumer<String> consumirFrase;
	Consumer<Character> consumirLetrasFrase;
	String frase;
	StringBuilder sbUsarDentroDeConsumers;
	
	@Override
	public void iniciarExercicio() throws BusinessException {
		
		frase = "projeto de exercicios";
		
		sbUsarDentroDeConsumers = new StringBuilder();
		
		consumirFrase = System.out::println;
		
		consumirLetrasFrase = letra -> {
			sbUsarDentroDeConsumers.append(letra);
		};
		
	}
	
	@Override
	public void processarExercicio() throws BusinessException {
		//NA
	}
	
	@Override
	public void finalizarExercicio() throws BusinessException {
	
		consumirFrase.accept(frase);
		
		for(int i=0; i<frase.length(); i++) {
			char letra = frase.charAt(i);
			consumirLetrasFrase.accept(letra);
		}
	
		saida
			.append(sbUsarDentroDeConsumers.toString());
		
		exibirSaida();
		
	}
	
	
}
