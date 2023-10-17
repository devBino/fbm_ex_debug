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
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.Assunto;
import br.com.fbm.debug.business.service.annotations.ExMap;
import br.com.fbm.debug.business.service.annotations.Flags;
import br.com.fbm.debug.business.service.annotations.UserService;
import br.com.fbm.debug.business.service.iface.ExUserService;
import br.com.fbm.debug.repository.type.Erro;
import br.com.fbm.debug.repository.type.ExType;

/**
 * {@code ExFactory} fornece instâncias de 
 * implementações de {@code ExGeneric}
 * @author Fernando Bino Machado
 */
public class ExFactory {

	/**
	 * Constante para identificar package e folder padrão
	 */
	private static String definedFolderExercicios = null;
	
	/**
	 * Define pacote padrão para conter as implementações de exercícios
	 * no projeto do usuário
	 * @param pFolders
	 */
	public static void setFolderExercicios(final String... pFolders) {
		
		String sinalBarra = "/";
		
		if( String.valueOf( System.getProperty("os.name") )
				.startsWith("Windows") ) {
			sinalBarra = "\\";
		}
		
		definedFolderExercicios = Arrays.stream(pFolders)
				.collect(Collectors.joining(sinalBarra));
		
	}
	
	public static String getFolderExercicios() {
		return definedFolderExercicios;
	}
	
	/**
	 * Retorna instancia de {@code ExUserService} definida pelo usuário
	 * no pacote de implementações de exercícios.
	 * @return
	 * @throws BusinessException
	 */
	public static ExUserService getUserServiceInstance() 
			throws BusinessException {
		
		ExUserService userService = null;
		
		try {
			
			File dirUserImpl = new File(definedFolderExercicios);
			
			for(File file : dirUserImpl.listFiles()) {
				
				if( file.isDirectory() ) {
					continue;
				}
				
				final String pathClass = getPathClassImpl(file.getPath());
				final Class<?> cl = Class.forName(pathClass);
				
				if( !cl.isAnnotationPresent(UserService.class) ) {
					continue;
				}
				
				userService = (ExUserService) cl.getConstructor().newInstance();
				
				break;
				
			}
			
			if( userService == null ) {
				throw new BusinessException(Erro.IMPL_USER_SERVICE_NAO_ENCONTRADA);
			}
			
		}catch(final ClassNotFoundException exception) {
			throw new BusinessException(Erro.IMPL_NAO_ENCONTRADA, exception);
		}catch(final BusinessException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw new BusinessException(Erro.ERRO_DESCONHECIDO);
		}
		
		return userService;
		
	}
	
	/**
	 * Recebe a classe referencia de um exercicio e retorna uma nova instância de
	 * uma implementação de {@code ExGeneric}
	 * @param pClass
	 * @return
	 * @throws BusinessException
	 */
	public static ExGeneric getExInstance(Class<? extends ExGeneric> pClass)
		throws BusinessException {
		
		try {
		
			return pClass.getDeclaredConstructor().newInstance();
		
		}catch(final Exception exception) {
			throw new BusinessException(Erro.ERRO_CRIAR_INSTANCIA_REFLECTION, 
					exception);
		}
		
		
	}
	
	/**
	 * Recebe uma ou mais {@code Class<? extends ExGeneric>} e retorna instancias 
	 * dessas classes recebidas.
	 * @param pImplList
	 * @return
	 * @throws Exception
	 */
	public static List<ExGeneric> listarImplementacoesPorClassReferencia(
			final List<Class<? extends ExGeneric>> pImplList)
					throws BusinessException {
	
		Function<Class<?>, ExGeneric> fnMap = cl -> {
			try {
				return (ExGeneric) cl.getDeclaredConstructor().newInstance();
			}catch(Exception exceptio) {
				return null;
			}
		};
		
		final List<ExGeneric> listaExercicios = pImplList
				.stream()
				.map(fnMap)
				.filter(ex -> ex != null)
				.collect(Collectors.toList());
		
		if( listaExercicios.size() < pImplList.size() ) {
			throw new BusinessException(Erro.IMPL_NAO_ENCONTRADA);
		}
		
		return listaExercicios;
		
	}
	
	/**
	 * Retorna uma {@code List<?>} tipado com {@code ExGeneric} de todos os tipos 
	 * de exercicios suportados de acordo com uma ou mais flags recebidas
	 * @param pFlags
	 * @return
	 * @throws Exception
	 */
	public static List<ExGeneric> listarImplementacoesPorFlags(String... pFlags)
			throws BusinessException {
		
		List<ExGeneric> listaExercicios = new ArrayList<>();
		
		try {
			
			for( Class<? extends ExGeneric> classImpl : recuperarTodasRefClassesImpl() ) {
				
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
		
		}catch(final BusinessException exception) {
			
			throw exception;
			
		}catch(final Exception exception) {
			throw new BusinessException(Erro.ERRO_CRIAR_INSTANCIA_REFLECTION, 
					exception);
		}
		
		return listaExercicios;
	}
	
	/**
	 * Retorna uma {@code List<?>} tipado com {@code ExGeneric} de todos os tipos 
	 * de exercicios suportados de acordo com assunto recebido
	 * @param pAssunto
	 * @return
	 * @throws Exception
	 */
	public static List<ExGeneric> listarImplementacoesPorAssunto(final String pAssunto)
		 throws BusinessException {
	
		List<ExGeneric> listaExercicios = new ArrayList<>();
		
		try {
		
			for( Class<? extends ExGeneric> classImpl : recuperarTodasRefClassesImpl() ) {
				
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
			
		}catch(final BusinessException exception) {
			
			throw exception;
			
		}catch(final Exception exception) {
			throw new BusinessException(Erro.ERRO_CRIAR_INSTANCIA_REFLECTION,
					exception);
		}
		
		return listaExercicios;
		
	}
	
	/**
	 * Recebe um intervalo numerico nos parametros pNumIni e pNumFim e retorna 
	 * uma {@code List<?>} tipada com {@code ExGeneric} cuja anotação {@code ExMap}
	 * contenha o membro numero dentro do intervalo recebido nos parametros.
	 * @param pNumIni
	 * @param pNumFim
	 * @return
	 * @throws Exception
	 */
	public static List<ExGeneric> listarImplementacoesPorIntervalo(final Integer pNumIni, 
			final Integer pNumFim) throws BusinessException {
		
		List<ExGeneric> listaExercicios = new ArrayList<>();
		
		final BigDecimal bigNumIni = new BigDecimal( String.valueOf(pNumIni) );
		final BigDecimal bigNumFim = new BigDecimal( String.valueOf(pNumFim) );
		
		try {
		
			for( Class<? extends ExGeneric> classImpl : recuperarTodasRefClassesImpl() ) {
				
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
		
		}catch(final BusinessException exception) {
			
			throw exception;
			
		}catch(final Exception exception) {
			throw new BusinessException(Erro.ERRO_CRIAR_INSTANCIA_REFLECTION, 
					exception);
		}
		
		return listaExercicios;
		
	}
	
	/**
	 * Retorna uma {@code List<?>} tipado com {@code ExGeneric}
	 * de todos os tipos de exercicios suportados de acordo com titulo
	 * @param pTitulo
	 * @return
	 * @throws Exception
	 */
	public static List<ExGeneric> listarImplementacoesPorTitulo(final String pTitulo)
			 throws BusinessException {
		
		List<ExGeneric> listaExercicios = new ArrayList<>();
		
		try {
		
			for( Class<? extends ExGeneric> classImpl : recuperarTodasRefClassesImpl() ) {
			
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
			
		}catch(final BusinessException exception) {
			
			throw exception;
			
		}catch(final Exception exception) {
			throw new BusinessException(Erro.ERRO_CRIAR_INSTANCIA_REFLECTION, 
					exception);
		}
		
		return listaExercicios;
		
	}
	
	/**
	 * Retorna uma {@code List<?>} tipado com {@code ExGeneric}
	 * de todos os tipos de exercicios suportados.
	 * @return
	 * @throws Exception
	 */
	public static List<ExGeneric> listarTodasImplementacoes()
		throws BusinessException {
		
		List<ExGeneric> listaTodosExercicios = new ArrayList<>();
		
		for( ExType exType : ExType.values() ) {			
			listaTodosExercicios.addAll( listarImplementacoesPorTipo(
					exType.getTipo()) );
		}
		
		return listaTodosExercicios;
		
	}
	
	/**
	 * Recebe a identificação de um tipo de exercicio
	 * e retorna uma lista de implementações de {@code ExGeneric}
	 * @param pTipo
	 * @return
	 * @throws Exception
	 */
	public static List<ExGeneric> listarImplementacoesPorTipo(final String pTipo)
		throws BusinessException {
		
		List<ExGeneric> listaExercicios = new ArrayList<>();
		
		try {
			
			for( Class<? extends ExGeneric> classImpl : recuperarRefClassesImpl(pTipo) ) {
				
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
			
		}catch(final BusinessException exception) {
			
			throw exception;
			
		}catch(final Exception exception) {
			
			throw new BusinessException(Erro.ERRO_CRIAR_INSTANCIA_REFLECTION,
					exception);
			
		}
		
		return listaExercicios;
		
	}
	
	/**
	 * Recupera uma {@code List<?>} tipada como {@code Class<?>}
	 * referentes às implementações de {@code ExGeneric}
	 * @return
	 * @throws Exception
	 */
	public static List<Class<? extends ExGeneric>> recuperarTodasRefClassesImpl()
		throws BusinessException {
		
		List<Class<? extends ExGeneric>> listaRefClasses = new ArrayList<>();
		
		for( ExType exType : ExType.values() ) {			
			listaRefClasses.addAll( recuperarRefClassesImpl(
					exType.getTipo()) );
		}
		
		return listaRefClasses;
				
	}
	
	/**
	 * Recupera uma {@code List<?>} tipada como {@code Class<?>}
	 * referentes às implementações de {@code ExGeneric}
	 * de acordo com tipo de exercicio recebido
	 * @param pTipo
	 * @return
	 * @throws Exception
	 */
	public static List<Class<? extends ExGeneric>> recuperarRefClassesImpl(final String pTipo)
		 throws BusinessException {
		
		final List<Class<? extends ExGeneric>> listaClasses = new ArrayList<>();
		
		File folderExs = new File(new StringBuilder()
				.append(definedFolderExercicios)
				.append("/")
				.append(pTipo.toLowerCase())
				.toString()); 
		
		scanDefinedPacakgesImpl(listaClasses, folderExs.listFiles());
		
		return listaClasses;
		
	}
	
	/**
	 * Varre o diretório padrão onde estão as implementações dos exercícios e todos 
	 * os sub pacotes, listando todas as classes Class<? extends ExGeneric> 
	 * referencias das implementações de exercicios
	 * @param pListaClasses
	 * @param pFiles
	 * @throws BusinessException
	 * TODO Definir algum mecanismo que permita o usuário escolher onde será o pacote base
	 * para buscar as classes de exercícios
	 */
	private static void scanDefinedPacakgesImpl(final List<Class<? extends ExGeneric>> pListaClasses,
			final File[] pFiles) throws BusinessException {
		
		try {
		
			if(pFiles == null) {
				return;
			}
			
			for( File file : pFiles ) {
				
				if( !file.isDirectory() ) {
					
					final String classPackage = getPathClassImpl(file.getPath());
					final Class<?> classImpl = Class.forName(classPackage);
					pListaClasses.add( (Class<? extends ExGeneric>) classImpl);
					
					continue;
					
				}
				
				scanDefinedPacakgesImpl(pListaClasses, file.listFiles());
				
			}
			
		}catch(final ClassNotFoundException exception) {
			throw new BusinessException(Erro.IMPL_NAO_ENCONTRADA, exception);
		}catch(final Exception exception) {
			throw new BusinessException(Erro.ERRO_DESCONHECIDO);
		}
		
	}
	
	/**
	 * Recebe um {@code File} arquivo, uma {@code String} tipo de arquivo,
	 * e retorna uma {@code String} representando o package completo 
	 * referenciando a classe desse arquivo 
	 * @param file
	 * @param tipo
	 * @return
	 */
	private static String getPathClassImpl(String pFilePath) {
		
		pFilePath = pFilePath.replace("src/", "");
		pFilePath = pFilePath.replace(".java", "");
		
		String candidatePackage = pFilePath.replaceAll("\\/", ".");
		
		return candidatePackage;
		
	}
	
	
}
