/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.application.window;

import java.awt.event.ActionListener;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Consumer;

import javax.swing.table.DefaultTableModel;

import br.com.fbm.debug.application.ExFilter;
import br.com.fbm.debug.application.bo.ExInfoBO;
import br.com.fbm.debug.processor.ExProcessor;
import br.com.fbm.debug.repository.type.ExType;
import br.com.fbm.debug.repository.type.MensagemUI;
import br.com.fbm.debug.views.JApp;

/**
 * {@code JAppUtils} provÊ métodos utilitários para eventos em 
 * {@code JApp}
 * @author Fernando Bino Machado
 */
public class JAppUtils {

	/**
	 * Popula Combobox e Tabela de {@code JApp}
	 * @param pApp
	 */
	public static void popularData(final JApp pApp) {
		popularComboBoxTipo(pApp);
		popularTbRegistros(pApp);
	}
	
	/**
	 * Adiciona eventos nos botões de {@code JApp}
	 * @param pApp
	 */
	public static void addEventosButtons(final JApp pApp) {
		
		addEventoBtnLocalizar(pApp);
		addEventoBtnReset(pApp);
		addEventoBtnDebugar(pApp);
		
	}
	
	/**
	 * Adiciona evento clique no botão Localizar
	 * @param pApp
	 */
	private static void addEventoBtnLocalizar(final JApp pApp) {
		
		ActionListener acaoBtnLocalizar = btn -> {
			
			try {
				
				if( pApp.getCbxTipo().getSelectedItem().toString().isEmpty() ) {
					MensagemUI.WARNING.show("Selecione o tipo de exercício.");
					pApp.getCbxTipo().requestFocus();
					return;
				}
				
				final Map<String, String> params = new HashMap<>();
				
				params.put("numIni", pApp.getTxtNumIni().getText());
				params.put("numFim", pApp.getTxtNumFim().getText());
				params.put("titulo", pApp.getTxtTitulo().getText());
				params.put("assunto", pApp.getTxtAssunto().getText());
				params.put("flags", pApp.getTxtFlags().getText());
				params.put("tipo", pApp.getCbxTipo().getSelectedItem().toString());
				
				pApp.getListInfoBO().clear();
				pApp.getListInfoBO().addAll( 
						ExFilter.getInfoExerciciosImplementados(params) );
				
				final StringBuilder msgLbResult = new StringBuilder()
						.append(pApp.getListInfoBO().size())
						.append(" Exercício(s) encontrado(s).");
				
				pApp.getLbTituloListagem().setText(msgLbResult.toString());
				
				popularTbRegistros(pApp);
				
			}catch(final Exception exception) {
				MensagemUI.ERROR.show(exception.getMessage());
			}
			
		};
		
		pApp.getBtnLocalizar().addActionListener(acaoBtnLocalizar);
		
	}

	/**
	 * Adiciona evento clique no botão Reset
	 * @param pApp
	 */
	private static void addEventoBtnReset(final JApp pApp) {

		ActionListener acaoBtnReset = btn -> {
			
			pApp.getTxtTitulo().setText("");
			pApp.getTxtAssunto().setText("");
			pApp.getTxtFlags().setText("");
			pApp.getTxtNumIni().setText("");
			pApp.getTxtNumFim().setText("");
			pApp.getLbTituloListagem().setText("");
			pApp.getCbxTipo().setSelectedItem("");
			
			limparTabelaRegistros( (DefaultTableModel) pApp.getTbExercicios().getModel() );
			
			pApp.getTxtAssunto().requestFocus();
			
		};
		
		pApp.getBtnReset().addActionListener(acaoBtnReset);
		
	}
	
	/**
	 * Adiciona evento clique no botão Debugar
	 * @param pApp
	 */
	private static void addEventoBtnDebugar(final JApp pApp) {
		
		ActionListener acaoBtnDebugar = btn -> {
			
			if( pApp.getListInfoBO().isEmpty() ) {
				MensagemUI.WARNING.show("Nenhum exercício selecionado");
				return;
			}
			
			try {
			
				List<ExInfoBO> listExProcessar = new ArrayList<>();
				
				listExProcessar.addAll( pApp.getListInfoBO() );
				
				ExProcessor.processarImplExerciciosListaInfoBO(listExProcessar);
				
			}catch(final Exception exception) {
				MensagemUI.ERROR.show(exception.getMessage());
			}
			
		};
		
		pApp.getBtnDebugar().addActionListener(acaoBtnDebugar);
				
	}
	
	/**
	 * Popula combobox tipo de exercício
	 * @param pApp
	 */
	private static void popularComboBoxTipo(final JApp pApp) {
		
		pApp.getCbxTipo().removeAll();
		pApp.getCbxTipo().addItem("");
		
		Arrays.stream(ExType.values())
			.forEach(t -> pApp.getCbxTipo().addItem(t.getTipo()));
		
	}
	
	/**
	 * Limpa tabela de exercícios
	 * @param model
	 */
	public static void limparTabelaRegistros(DefaultTableModel model) {
		if( model.getRowCount() > 0 ) {
			model.removeRow(0);
			limparTabelaRegistros(model);
		}
	}
	
	/**
	 * Popula tabela de exercícios
	 * @param pApp
	 */
	private static void popularTbRegistros(final JApp pApp) {
		
		final String[] colunas = new String[] {"NUMERO", "ASSUNTO", "TITULO", "TIPO"};
		
		pApp.getTbExercicios().setModel(new DefaultTableModel(colunas, 0));
		
		DefaultTableModel model = (DefaultTableModel) pApp
				.getTbExercicios().getModel();
		
		limparTabelaRegistros(model);
		
		Consumer<ExInfoBO> consExBO = ex -> {
			
			Object[] row = new Object[colunas.length];
			
			row[0] = ex.getNumero();
			row[1] = ex.getAssunto();
			row[2] = ex.getTitulo();
			row[3] = ex.getTipo();
			
			model.addRow(row);
			
		};
		
		pApp
			.getListInfoBO()
			.stream()
			.forEach(consExBO);
		
		pApp.getTbExercicios().setModel(model);
		
	}
	
}
