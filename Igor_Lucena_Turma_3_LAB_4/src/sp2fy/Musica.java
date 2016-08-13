/* 115210412 - Igor Dantas Lucena: LAB 4 - Turma 3 */
package sp2fy;

public class Musica {

	private String titulo;
	private int duracao;
	private String genero;

	public Musica(String titulo, int duracao, String genero) throws Exception {

		verificaTituloInvalido(titulo);
		verificaDuracaoInvalida(duracao);
		verificaGeneroInvalido(genero);
		this.titulo = titulo;
		this.duracao = duracao;
		this.genero = genero;

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws Exception {
		verificaTituloInvalido(titulo);
		this.titulo = titulo;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) throws Exception {
		verificaDuracaoInvalida(duracao);
		this.duracao = duracao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) throws Exception {
		verificaGeneroInvalido(genero);
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Musica) {
			Musica outraMusica = (Musica) objeto;
			if (outraMusica.getTitulo().equals(this.getTitulo()) && outraMusica.getDuracao() == this.getDuracao()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return titulo + " (" + genero + " - " + duracao + " minutos)";
	}

	private void verificaTituloInvalido(String titulo) throws Exception {
		if (titulo == null || titulo.trim().equals("")) {
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");
		}
	}

	private void verificaGeneroInvalido(String genero) throws Exception {
		if (genero == null || genero.trim().equals("")) {
			throw new Exception("Genero da musica nao pode ser nulo ou vazio.");
		}
	}

	private void verificaDuracaoInvalida(int duracao) throws Exception {
		if (duracao <= 0) {
			throw new Exception("Duracao da musica nao pode ser negativa.");
		}
	}
}
