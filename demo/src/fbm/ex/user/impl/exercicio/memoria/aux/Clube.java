/**
 * Micro Framework para Processamento de Exercícios.
 * 
 * Desenvolvido por: Fernando Bino Machado
 * Github: https://github.com/devBino
 * Projeto: https://github.com/devBino/fbm_ex_debug
 */
package fbm.ex.user.impl.exercicio.memoria.aux;

/**
 * {@code Clube} define objeto Pojo 
 * para representação de um clube esportivo
 * 
 * @author Fernando Bino Machado
 */
public class Clube {

	private String nome, tipo;
	
	public Clube(String nome, String tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public Clube(final Clube clube) {
		this.nome = clube.getNome();
		this.tipo = clube.getTipo();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
