package br.com.fbm.debug.application.filter;

import java.math.BigDecimal;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import br.com.fbm.debug.application.bo.ExInfoBO;
import br.com.fbm.debug.business.exception.BusinessException;
import br.com.fbm.debug.business.factory.ExFactory;
import br.com.fbm.debug.business.generic.ExGeneric;
import br.com.fbm.debug.business.service.annotations.Assunto;
import br.com.fbm.debug.business.service.annotations.ExMap;
import br.com.fbm.debug.business.service.annotations.Flags;
import br.com.fbm.debug.repository.converters.ExInfoConverter;
import br.com.fbm.debug.repository.type.Erro;
import br.com.fbm.debug.repository.type.ExType;
import br.com.fbm.debug.repository.validators.ExValidator;

/**
 * {@code ExFilter} tem a responsabilidade de receber os parametros vindos 
 * de {@code JApp} e devolver uma listagem de matadados das implementações de exercícios
 * representadas por {@code ExInfoBO}
 * @author Fernando Bino Machado
 */
public class ExFilter {

	/**
	 * Retorna de acordo com os parametros recebidos uma {@code List<?>} 
	 * tipada como {@code ExInfoBO} referente as {@code Class} que 
	 * representam as implementações de {@code ExGeneric}
	 * @param pParams
	 * @return
	 * @throws BusinessException
	 */
	public static List<ExInfoBO> getInfoExerciciosImplementados(final Map<String, String> pParams)
			throws BusinessException {
		
		//recupera lista de Class<? extends ExGeneric>
		final List<Class<? extends ExGeneric>> listRefImpl = tratarParamsERecuperarListaClassRef(pParams);
		
		//converte os itens para ExInfoBO baseado nas anotações
		//de Class<? extends ExGeneric>
		final List<Object> listaInfoBOs = listRefImpl 
				.stream()
				.map(cl ->{
					try {
						return ExInfoConverter.toBO(cl);
					}catch(Exception ex) {
						return ex;
					}
				})
				.collect(Collectors.toList());
		
		//verifica se no escopo da interface funcional
		//Function<T,R> na etapa intermediária map do Stream<Object>
		//existe alguma business exception
		Optional<BusinessException> except = listaInfoBOs
				.stream()
				.filter(bo -> bo instanceof BusinessException)
				.map(bo -> (BusinessException) bo)
				.findFirst();
				
		if( except.isPresent() ) {
			throw except.get();
		}
		
		final List<ExInfoBO> exercicios = listaInfoBOs
				.stream()
				.map(bo -> (ExInfoBO) bo)
				.collect(Collectors.toList());
		
		ExValidator.validarNumerosRepetidosExercicios(exercicios);
		
		//finalmente, se tudo ok retorna uma List<ExInfoBO>
		return exercicios;
		
	}
	
	/**
	 * Trata os parametros recebidos retornando uma {@code List<?>} tipada como
	 * {@code Class<? extends ExGeneric>}
	 * @param pParams
	 * @return
	 * @throws BusinessException
	 */
	private static List<Class<? extends ExGeneric>> tratarParamsERecuperarListaClassRef(final Map<String, String> pParams)
		throws BusinessException {
		
		final List<Class<? extends ExGeneric>> listRefImpl = new ArrayList<>();
		
		tratarParamTipo(listRefImpl, pParams.get("tipo"));
		//TODO revisar concorrência nos filtros de campos de texto, titulo versus assunto e flags
		final Predicate<Class<?>> filtroCamposTexto = getFiltroParamTitulo( pParams.get("titulo") )
				.or( getFiltroParamAssunto( pParams.get("assunto")) )
				.or( getFiltroParamFlags( pParams.get("flags")) );
		
		return listRefImpl
				.stream()
				.filter(getFiltroParamsIntervalo( pParams.get("numIni"), pParams.get("numFim") ))
				.filter(filtroCamposTexto)
				.collect(Collectors.toList());
		
	}
	
	/**
	 * Adiciona os exercicios na lista de acordo com tipo de exercicios recebido
	 * @param pListRefImpl
	 * @param pTipoEx
	 * @throws BusinessException
	 */
	private static void tratarParamTipo(final List<Class<? extends ExGeneric>> pListRefImpl, 
			final String pTipoEx) throws BusinessException {
		
		for( ExType ex : ExType.values() ) {
			
			if( pTipoEx == null ) {
				pListRefImpl.addAll( ExFactory.recuperarRefClassesImpl( ex.getTipo() ) );
				continue;
			}
			
			if( ex.getTipo().toLowerCase().equals( pTipoEx.toLowerCase() ) ) {
				pListRefImpl.addAll( ExFactory.recuperarRefClassesImpl(pTipoEx) );
				continue;
			}
			
		}

	}
	
	/**
	 * Remove da lista de exercicios exercicios com numero fora do intervalo 
	 * parametrizado no filtro  
	 * @param pListRefImpl
	 * @param pNumIni
	 * @param pNumFim
	 * @throws BusinessException
	 */
	private static Predicate<Class<?>> getFiltroParamsIntervalo(final String pNumIni, final String pNumFim) 
			throws BusinessException {
	
		Predicate<Class<?>> filtro = cl -> true;
		
		//caso não tenha recebido numero inicial e numero final
		if( pNumIni == null || pNumIni.isEmpty() ) {
			return filtro;
		}
		
		if( pNumFim == null || pNumFim.isEmpty() ) {
			return filtro;
		}
		
		try {
			
			//Filtro para verificar se numero anotado para o 
			//exercício está dentro do intervalo solicitado
			filtro = cl -> {

				//valores para comparação
				final BigDecimal bigNumIni = new BigDecimal(pNumIni);
				final BigDecimal bigNumFim = new BigDecimal(pNumFim);
				
				if( !cl.isAnnotationPresent(ExMap.class) ) {
					return false;
				}
				
				ExMap ann = cl.getAnnotation(ExMap.class);
				
				final BigDecimal numAnn = new BigDecimal(
						String.valueOf(ann.numero()) );

				boolean intervaloValido = numAnn.compareTo( bigNumIni ) >= 0
						&& numAnn.compareTo( bigNumFim ) <= 0;
					
				return intervaloValido;
				
			};
			
			return filtro;
			
		}catch(final Exception exception) {
			throw new BusinessException(Erro.ERRO_EXECUTAR_FILTRO, 
					exception);
		}
		
	}
	
	/**
	 * Remove da lista exercicios cujos titulos não contenham o titulo parametrizado
	 * no filtro
	 * @param pListRefImpl
	 * @param pTitulo
	 */
	private static Predicate<Class<?>> getFiltroParamTitulo(final String pTitulo) {
		
		Predicate<Class<?>> filtro = cl -> true;
		
		if( pTitulo == null || pTitulo.isEmpty() ) {
			return filtro;
		}
		
		filtro = cl -> {
			
			if( !cl.isAnnotationPresent(ExMap.class) ) {
				return false;
			}
			
			ExMap ann = cl.getAnnotation(ExMap.class);
			
			return !ann.titulo().isEmpty() 
					&& ann.titulo().toLowerCase().contains(pTitulo.toLowerCase());
			
		};
		
		return filtro;
		
	}
	
	/**
	 * Remove da lista os exercicios cujo assunto não seja o parametrizazdo no filtro
	 * @param pListRefImpl
	 * @param pAssunto
	 */
	private static Predicate<Class<?>> getFiltroParamAssunto(final String pAssunto) {
	
		Predicate<Class<?>> filtro = cl -> false;
		
		if( pAssunto == null || pAssunto.isEmpty() ) {
			return filtro;
		}
		
		filtro = cl -> {
			
			if( !cl.isAnnotationPresent(Assunto.class) ) {
				return false;
			}
			
			Assunto ann = cl.getAnnotation(Assunto.class);
			
			return !ann.value().isEmpty() 
					&& ann.value().toLowerCase().equals(pAssunto.toLowerCase());
			
		};
		
		return filtro;
		
	}
	
	/**
	 * Remove da lista exercicios que não possuam ao menos uma das flags parametrizadas
	 * @param pListRefImpl
	 * @param pFlags
	 */
	private static Predicate<Class<?>> getFiltroParamFlags(final String pFlags) {
	
		Predicate<Class<?>> filtro = cl -> false;
		
		//valida apenas se existir flags recebidas
		if( pFlags == null || pFlags.isEmpty() ) {
			return filtro;
		}
		
		//divide as flags recebidas
		String[] arrFlagsRecebidas = pFlags.split("\\s");
		
		//encpsula rotina de validação, que confere
		//se as flags da anotação possuem ao menos uma
		//flag recebida no parametro
		filtro = cl -> {
			
			if( !cl.isAnnotationPresent(Flags.class) ) {
				return false;
			}
			
			//recupera flags da anotação e testa se existe ao menos uma
			//flag recebida nas flags anotadas
			Flags ann = cl.getAnnotation(Flags.class);
			
			int qtdeFlagsMatch = Arrays.stream(ann.flags())
					.filter(flagAnn -> List.of(arrFlagsRecebidas).contains(flagAnn))
					.mapToInt(flagAnn -> 1)
					.sum();
			
			return qtdeFlagsMatch > 0;
			
		};
		
		return filtro;
		
	}
	
	
}
 