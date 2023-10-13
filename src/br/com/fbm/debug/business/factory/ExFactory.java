/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package br.com.fbm.debug.business.factory;

import java.io.File;

import java.math.BigDecimal;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;

import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.Assunto;
import br.com.fbm.debug.business.service.annotations.ExMap;
import br.com.fbm.debug.business.service.annotations.Flags;

/**
 * {@code ExFactory} fornece instâncias de 
 * implementações de {@code ExGeneric}
 * 
 * @author Fernando Bino Machado
 */
public class ExFactory {

	/**
	 * Constantes para identificar package e folder padrão
	 */
	private static final String FOLDER_EXERCICIOS = "src/br/com/fbm/debug/impl";
	private static final String PACKAGE_EXERCICIOS = "br.com.fbm.debug.impl";
	
	/**
	 * Recebe uma ou mais {@code Class<? extends ExGeneric>}
	 * e retorna instancias dessas classes recebidas.
	 * 
	 * @param pImplClass
	 * @return
	 * @throws Exception
	 */
	public static List<ExGeneric> listarImplementacoesPorClassReferencia(Class<? extends ExGeneric>... pImplClass)
		throws Exception {
	
		Function<Class<?>, ExGeneric> fnMap = cl -> {
			try {
				return (ExGeneric) cl.getDeclaredConstructor().newInstance();
			}catch(Exception exceptio) {
				return null;
			}
		};
		
		return Arrays.stream(pImplClass)
				.map(fnMap)
				.collect(Collectors.toList());
		
	}
	
	/**
	 * Retorna uma {@code List<?>} tipado com {@code ExGeneric}
	 * de todos os tipos de exercicios suportados
	 * de acordo com uma ou mais flags recebidas
	 * 
	 * @param pFlags
	 * @return
	 * @throws Exception
	 */
	public static List<ExGeneric> listarImplementacoesPorFlags(String... pFlags)
			throws Exception {
		
		List<ExGeneric> listaExercicios = new ArrayList<>();
		
		for( Class<?> classImpl : recuperarTodasRefClassesImpl() ) {
			
			//listar e instanciar apenas implementações anotadas
			//com Flag.class
			if( !classImpl.isAnnotationPresent(Flags.class) ) {
				continue;
			}
			
			Flags ann = classImpl.getAnnotation(Flags.class);
			
			//listar e instanciar apenas implementações 
			//com uma ou mais flags compativeis com as flags recebidas
			Predicate<String> predFlags = flag -> {
				
				return Arrays.stream(pFlags)
						.filter(iFlag -> flag.toLowerCase().equals(iFlag.toLowerCase()))
						.mapToInt(iFlag -> 1)
						.sum() > 0;
						
			};
			
			int qtdeFlagsMatch = Arrays.stream(ann.flags())
				.filter(predFlags)
				.mapToInt(flag -> 1)
				.sum();
			
			if( qtdeFlagsMatch == 0 ) {
				continue;
			}
			
			//finalmente adicionar uma instancia da implementação 
			//do exercicio na lista de retorno
			ExGeneric instancia = (ExGeneric) classImpl
					.getDeclaredConstructor()
					.newInstance(); 
			
			listaExercicios.add(instancia);
			
		}
		
		return listaExercicios;
	}
	
	/**
	 * Retorna uma {@code List<?>} tipado com {@code ExGeneric}
	 * de todos os tipos de exercicios suportados
	 * de acordo com assunto recebido
	 * 
	 * @param pAssunto
	 * @return
	 * @throws Exception
	 */
	public static List<ExGeneric> listarImplementacoesPorAssunto(final String pAssunto)
		throws Exception {
	
		List<ExGeneric> listaExercicios = new ArrayList<>();
		
		for( Class<?> classImpl : recuperarTodasRefClassesImpl() ) {
			
			//listar e instanciar apenas implementações anotadas
			//com Assunto.class
			if( !classImpl.isAnnotationPresent(Assunto.class) ) {
				continue;
			}
			
			Assunto ann = classImpl.getAnnotation(Assunto.class);
			
			//listar e instanciar apenas implementações 
			//com valor da anotação assunto igual ao pAssunto recebido
			if( !ann.value().toLowerCase().equals(pAssunto.toLowerCase()) ) {
				continue;
			}
			
			//finalmente adicionar uma instancia da implementação 
			//do exercicio na lista de retorno
			ExGeneric instancia = (ExGeneric) classImpl
					.getDeclaredConstructor()
					.newInstance(); 
			
			listaExercicios.add(instancia);
			
		}
		
		return listaExercicios;
		
	}
	
	/**
	 * Recebe um intervalo numerico nos parametros
	 * pNumIni e pNumFim e retorna uma {@code List<?>}
	 * tipada com {@code ExGeneric} cuja anotação
	 * {@code ExMap} contenha o membro numero dentro 
	 * do intervalo recebido nos parametros.
	 * 
	 * @param pNumIni
	 * @param pNumFim
	 * @return
	 * @throws Exception
	 */
	public static List<ExGeneric> listarImplementacoesPorIntervalo(final Integer pNumIni, 
			final Integer pNumFim) throws Exception {
		
		List<ExGeneric> listaExercicios = new ArrayList<>();
		
		final BigDecimal bigNumIni = new BigDecimal( String.valueOf(pNumIni) );
		final BigDecimal bigNumFim = new BigDecimal( String.valueOf(pNumFim) );
		
		for( Class<?> classImpl : recuperarTodasRefClassesImpl() ) {
			
			//listar e instanciar apenas implementações anotadas
			//com ExMap.class
			if( !classImpl.isAnnotationPresent(ExMap.class) ) {
				continue;
			}
			
			ExMap ann = classImpl.getAnnotation(ExMap.class);
			
			BigDecimal numAnn = new BigDecimal(String.valueOf(ann.numero()));
			
			if( numAnn.compareTo( bigNumIni ) >= 0
				  && numAnn.compareTo( bigNumFim ) <= 0	) {
			
				//finalmente adicionar uma instancia da implementação 
				//do exercicio na lista de retorno
				ExGeneric instancia = (ExGeneric) classImpl
						.getDeclaredConstructor()
						.newInstance(); 
				
				listaExercicios.add(instancia);
				
			}
			
		}
		
		return listaExercicios;
		
	}
	
	/**
	 * Retorna uma {@code List<?>} tipado com {@code ExGeneric}
	 * de todos os tipos de exercicios suportados
	 * de acordo com titulo
	 * 
	 * @param pTitulo
	 * @return
	 * @throws Exception
	 */
	public static List<ExGeneric> listarImplementacoesPorTitulo(final String pTitulo)
			throws Exception {
		
		List<ExGeneric> listaExercicios = new ArrayList<>();
		
		for( Class<?> classImpl : recuperarTodasRefClassesImpl() ) {
			
			//listar e instanciar apenas implementações anotadas
			//com ExMap.class
			if( !classImpl.isAnnotationPresent(ExMap.class) ) {
				continue;
			}
			
			ExMap ann = classImpl.getAnnotation(ExMap.class);
			
			//listar e instanciar apenas implementações 
			//com titulo preenchido na anotação
			if( ann.titulo().isEmpty() ) {
				continue;
			}
			
			//listar e instanciar apenas implementações 
			//com titulo preenchido na anotação
			//e que contenha o trecho de titulo recebido em pTitulo
			if( !ann.titulo().toLowerCase().contains( pTitulo.toLowerCase() ) ) {
			 	continue;
			}
			
			//finalmente adicionar uma instancia da implementação 
			//do exercicio na lista de retorno
			ExGeneric instancia = (ExGeneric) classImpl
					.getDeclaredConstructor()
					.newInstance(); 
			
			listaExercicios.add(instancia);
			
		}
		
		return listaExercicios;
		
	}
	
	/**
	 * Retorna uma {@code List<?>} tipado com {@code ExGeneric}
	 * de todos os tipos de exercicios suportados.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<ExGeneric> listarTodasImplementacoes()
		throws Exception {
		
		List<ExGeneric> listaTodosExercicios = new ArrayList<>();
		
		listaTodosExercicios.addAll( listarImplementacoesPorTipo("exercicio") );
		listaTodosExercicios.addAll( listarImplementacoesPorTipo("quiz") );
		
		return listaTodosExercicios;
		
	}
	
	/**
	 * Recebe a identificação de um tipo de exercicio
	 * e retorna uma lista de implementações de {@code ExGeneric}
	 * 
	 * @param pTipo
	 * @return
	 * @throws Exception
	 */
	public static List<ExGeneric> listarImplementacoesPorTipo(final String pTipo)
		throws Exception {
		
		List<ExGeneric> listaExercicios = new ArrayList<>();
		
		for( Class<?> classImpl : recuperarRefClassesImpl(pTipo) ) {
			
			//listar e instanciar apenas implementações anotadas
			//com ExMap.class
			if( !classImpl.isAnnotationPresent(ExMap.class) ) {
				continue;
			}
			
			ExGeneric instancia = (ExGeneric) classImpl
					.getDeclaredConstructor()
					.newInstance(); 
			
			listaExercicios.add(instancia);
			
		}
		
		return listaExercicios;
		
	}
	
	/**
	 * Recupera uma {@code List<?>} tipada como {@code Class<?>}
	 * referentes às implementações de {@code ExGeneric}
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<Class<?>> recuperarTodasRefClassesImpl()
		throws Exception {
		
		List<Class<?>> listaRefClasses = new ArrayList<>();
		
		listaRefClasses.addAll( recuperarRefClassesImpl("exercicio") );
		listaRefClasses.addAll( recuperarRefClassesImpl("quiz") );
		
		return listaRefClasses;
				
	}
	
	/**
	 * Recupera uma {@code List<?>} tipada como {@code Class<?>}
	 * referentes às implementações de {@code ExGeneric}
	 * de acordo com tipo de exercicio recebido
	 * 
	 * @param pTipo
	 * @return
	 * @throws Exception
	 */
	public static List<Class<?>> recuperarRefClassesImpl(final String pTipo)
		throws Exception {
		
		List<Class<?>> listaClasses = new ArrayList<>();
		
		File folderExs = new File(new StringBuilder()
				.append(FOLDER_EXERCICIOS)
				.append("/")
				.append(pTipo.toLowerCase())
				.toString()); 
		
		for(File file : folderExs.listFiles()) {
			
			//listar apenas arquivos
			if(file.isDirectory()) {
				continue;
			}
			
			final String packageImplName = getPathClassImpl(file, pTipo);
			
			Class<?> classImpl = Class.forName(packageImplName);
			
			listaClasses.add(classImpl);
			
		}
		
		return listaClasses;
		
	}
	
	/**
	 * Recebe um {@code File} arquivo, uma {@code String} tipo de arquivo,
	 * e retorna uma {@code String}
	 * representando o package completo referenciando 
	 * a classe desse arquivo 
	 * 
	 * @param file
	 * @param tipo
	 * @return
	 */
	private static String getPathClassImpl(final File file, final String tipo) {
		
		String[] arrDirs = file.getPath().split("/");
		String nomeImpl = arrDirs[ arrDirs.length - 1 ].replace(".java", "");
		
		return PACKAGE_EXERCICIOS
				.concat(".")
				.concat(tipo.toLowerCase())
				.concat(".")
				.concat(nomeImpl);
		
	}
	
	
}
