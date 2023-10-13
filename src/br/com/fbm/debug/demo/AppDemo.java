/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.demo;

import java.util.List;

import br.com.fbm.debug.business.factory.ExFactory;
import br.com.fbm.debug.impl.exercicio.CalculoIMC;
import br.com.fbm.debug.impl.exercicio.CuriosidadeChar;
import br.com.fbm.debug.impl.exercicio.InterfaceConsumerEx;
import br.com.fbm.debug.processor.ExProcessor;
import br.com.fbm.debug.views.JApp;

/**
 * Fornece o método main para demonstrar
 * implementações de {@code ExService}
 * @author Fernando Bino Machado
 */
public class AppDemo {
	
	public static void main(String[] args) {
		demoExercicios();
		demoFactory();
		demoProcessor();
		demoTela();
	}
	
	private static void demoProcessor() {
		try {
			ExProcessor.processarImplExercicios( 
					ExFactory.listarImplementacoesPorTipo("exercicio") );
		}catch(Exception exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
	}
	
	private static void demoFactory() {
		
		try {
			ExFactory.listarImplementacoesPorTipo("exercicio");
			ExFactory.listarTodasImplementacoes();
			ExFactory.listarImplementacoesPorTitulo("imc");
			ExFactory.listarImplementacoesPorTitulo("char");
			ExFactory.listarImplementacoesPorIntervalo(1, 2);
			ExFactory.listarImplementacoesPorAssunto("lambda");
			ExFactory.listarImplementacoesPorFlags("consumer","predicate");
			ExFactory.listarImplementacoesPorClassReferencia(
					List.of(
							CalculoIMC.class,
							InterfaceConsumerEx.class) );
			
			//forçando BusinessException
			ExFactory.listarImplementacoesPorTipo("exercicioooo");
			
		}catch(Exception exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
	}
	
	private static void demoExercicios() {
		
		try {
		
			CalculoIMC calculoIMC = new CalculoIMC();
			
			calculoIMC.iniciarExercicio();
			calculoIMC.processarExercicio();
			calculoIMC.finalizarExercicio();
			
			CuriosidadeChar curiosidadeChar = new CuriosidadeChar();
			
			curiosidadeChar.iniciarExercicio();
			curiosidadeChar.processarExercicio();
			curiosidadeChar.finalizarExercicio();
			
		}catch(Exception exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
		
	}
	
	private static void demoTela() {
		
		JApp app = new JApp();
		app.setVisible(true);
		
	}

}
