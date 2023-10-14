/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fbm.debug.application.ExFilter;
import br.com.fbm.debug.application.bo.ExInfoBO;
import br.com.fbm.debug.processor.ExProcessor;
import br.com.fbm.debug.views.JApp;

/**
 * Fornece o método main para demonstrar
 * implementações de {@code ExService}
 * @author Fernando Bino Machado
 */
public class AppDemo {
	
	public static void main(String[] args) throws Exception {

		Map<String, String> params = new HashMap<>();
		
		params.put("tipo", "exercicio");
		params.put("numIni", "1");
		params.put("numFim", "10");
		params.put("titulo", "lambda");
		params.put("assunto", "lambda");
		params.put("flags", "lambda");
		
		final List<ExInfoBO> listExInfo = ExFilter.getInfoExerciciosImplementados(params);
		
		ExProcessor.processarImplExerciciosListaInfoBO(listExInfo);
		
	}
	
	private static void demoTela() {
		
		JApp app = new JApp();
		app.setVisible(true);
		
	}

}
