/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.repository.converters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

import br.com.fbm.debug.application.bo.ExInfoBO;
import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.Assunto;
import br.com.fbm.debug.business.service.annotations.ExMap;
import br.com.fbm.debug.business.service.annotations.Flags;
import br.com.fbm.debug.repository.type.Erro;

/**
 * {@code ExInfoConverter} tem responsabilidade de converter metadados de uma 
 * {@code Class} de uma implementação de {@code ExGeneric} em um business object
 * {@code ExInfoBO}
 * @author Fernando Bino Machado
 */
public class ExInfoConverter {

	/**
	 * Recebe a classe referencia de uma implementação de {@code ExGeneric}
	 * e extrai os dados anotados em um {@code ExInfoBO}
	 * @param pClassImpl
	 * @return
	 * @throws BusinessException
	 */
	public static ExInfoBO toBO(Class<? extends ExGeneric> pClassImpl)
		throws BusinessException {
		
		final ExInfoBO bo = new ExInfoBO();
		
		bo.setClassImpl(pClassImpl);
		
		if( !pClassImpl.isAnnotationPresent(ExMap.class) ) {
			
			final StringBuilder msgCausa = new StringBuilder()
					.append("Adicionar Anotação @ExMap em ")
					.append("[")
					.append(pClassImpl)
					.append("]");
			
			throw new BusinessException(Erro.IMPL_NAO_ANOTADA, 
					new Exception( msgCausa.toString()));
			
		}
		
		try {
			
			extrairDadosAnnExMap(bo, pClassImpl);
			extrairDadosAnnAssunto(bo, pClassImpl);
			extrairDadosAnnFlags(bo, pClassImpl);
			
		}catch(final Exception exception) {
			throw new BusinessException(Erro.ERRO_CONVERTER_METADADOS_IMPL, 
					exception);
		}
		
		return bo;
		
	}
	
	/**
	 * Extrai dados da anotação {@code @ExMap}
	 * @param pBo
	 * @param pClassImpl
	 */
	private static void extrairDadosAnnExMap(final ExInfoBO pBo, 
			Class<? extends ExGeneric> pClassImpl) {
		
		ExMap exMap = pClassImpl.getAnnotation(ExMap.class);
		
		pBo.setNumero( new BigDecimal( String.valueOf(exMap.numero()) ) );
		pBo.setTitulo( exMap.titulo() );
		
	}
	
	/**
	 * Extrai dados da anotação {@code @Assunto}
	 * @param pBo
	 * @param pClassImpl
	 */
	private static void extrairDadosAnnAssunto(final ExInfoBO pBo, 
			Class<? extends ExGeneric> pClassImpl) {
		
		if( !pClassImpl.isAnnotationPresent(Assunto.class) ) {
			pBo.setAssunto("");
			return;
		}
		
		Assunto ass = pClassImpl.getAnnotation(Assunto.class);
		pBo.setAssunto(ass.value());
		
	}
	
	/**
	 * Extrai dados da anotação {@code @Flags}
	 * @param pBo
	 * @param pClassImpl
	 */
	private static void extrairDadosAnnFlags(final ExInfoBO pBo, 
			Class<? extends ExGeneric> pClassImpl) {
		
		if( !pClassImpl.isAnnotationPresent(Flags.class) ) {
			pBo.setFlags("");
			return;
		}
		
		Flags flags = pClassImpl.getAnnotation(Flags.class);
		
		String conteudoFlags = Arrays.stream(flags.flags())
				.collect(Collectors.joining(" "));
		
		pBo.setFlags(conteudoFlags);
		
	}
	
	
}
