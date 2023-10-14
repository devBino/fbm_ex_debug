/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.application.bo;

import java.math.BigDecimal;

import br.com.fbm.debug.business.generic.ExGeneric;

/**
 * {@code ExInfoBO} representa o conjunto de metadados anotados em uma implementação
 * de {@code ExGeneric}
 * @author Fernando Bino Machado
 */
public class ExInfoBO {

	/**
	 * Atributos
	 */
	private BigDecimal numero;
	private String titulo;
	private String assunto;
	private String flags;
	private Class<? extends ExGeneric> classImpl;
	
	/**
	 * Getters e Setters 
	 */
	
	public BigDecimal getNumero() {
		return numero;
	}
	
	public void setNumero(BigDecimal numero) {
		this.numero = numero;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAssunto() {
		return assunto;
	}
	
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
	public String getFlags() {
		return flags;
	}
	
	public void setFlags(String flags) {
		this.flags = flags;
	}
	
	public Class<? extends ExGeneric> getClassImpl() {
		return classImpl;
	}
	
	public void setClassImpl(Class<? extends ExGeneric> classImpl) {
		this.classImpl = classImpl;
	}
	
	
}
