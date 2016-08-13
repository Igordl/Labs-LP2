/* 115210412 - Igor Dantas Lucena: LAB 4 - Turma 3 */
package sp2fy;

import java.util.ArrayList;
import java.util.List;

public class Album implements Comparable<Album> {
	private final String FIM_DE_LINHA = System.lineSeparator();
	private List<Musica> album;
	private String artista;
	private String titulo;
	private int ano;

	public Album(String artista, String titulo, int ano) throws Exception {

		verificaArtistaInvalido(artista);
		verificaTituloInvalido(titulo);
		verificaAnoInvalido(ano);

		this.artista = artista;
		this.titulo = titulo;
		this.ano = ano;
		this.album = new ArrayList<Musica>();
	}

	public int quantidadeFaixas() {
		return album.size();
	}

	public void adicionaMusica(String titulo, int duracao, String genero) throws Exception {
		Musica musica = new Musica(titulo, duracao, genero);
		album.add(musica);
	}

	public boolean adicionaMusica(Musica musica) {
		if (musica != null) {
			for (Musica outraMusica : album) {
				if (musica.equals(outraMusica)) {
					if (musica.getGenero().equals(outraMusica.getGenero())) {
						return false;
					} else {
						album.add(musica);
						return true;
					}
				}
			}
			album.add(musica);
			return true;
		}
		return false;

	}

	public void removeMusica(int index) {
		album.remove(index - 1);
	}

	public boolean removeMusica(String titulo) {
		for (Musica musica : album) {
			if (musica.getTitulo().equals(titulo)) {
				album.remove(musica);
				return true;
			}
		}
		return false;
	}

	public boolean pesquisarMusica(String titulo) {
		for (Musica musica : album) {
			if (musica.getTitulo().equals(titulo)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Musica> getMusicas() {
		return (ArrayList<Musica>) album;
	}

	public void setMusicas(List<Musica> musicas) {
		this.album = musicas;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getDuracaoTotal() {
		int duracaoTotal = 0;
		for (Musica musica : album) {
			duracaoTotal += musica.getDuracao();

		}
		return duracaoTotal;
	}

	public Musica getMusica(String titulo) {
		for (Musica musica : album) {
			if (musica.getTitulo().equalsIgnoreCase(titulo)) {
				return musica;
			}
		}
		return null;
	}

	public Musica getMusica(int indice) {
		for (int i = 0; i < album.size(); i++) {
			if (indice == i) {
				return album.get(i);
			}

		}
		return null;
	}

	public int getTamanhoAlbum() {
		return this.album.size();
	}

	public boolean contemMusica(String nomeMusica) {
		for (Musica musica : album) {
			if (musica.getTitulo().equalsIgnoreCase(nomeMusica))
				return true;
		}
		return false;
	}

	private void verificaTituloInvalido(String titulo) throws Exception {
		if (titulo == null || titulo.equals("")) {
			throw new Exception("Titulo do album nao pode ser nulo ou vazio.");
		}
	}

	private void verificaArtistaInvalido(String artista) throws Exception {
		if (artista == null || artista.trim().equals("")) {
			throw new Exception("Artista do album nao pode ser nulo ou vazio.");
		}
	}

	private void verificaAnoInvalido(int ano) throws Exception {
		if (ano <= 1900) {
			throw new Exception("Ano de lancamento do album nao pode ser inferior a 1900.");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (ano != other.ano)
			return false;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String retorno = this.getTitulo() + ", " + this.getArtista() + " (" + this.ano + ")" + FIM_DE_LINHA
				+ FIM_DE_LINHA;
		int faixa = 1;
		for (Musica musica : album) {

			retorno += faixa + ". " + musica.toString() + FIM_DE_LINHA;
			faixa += 1;
		}
		return retorno;

	}

	@Override
	public int compareTo(Album outroAlbum) {
		if (outroAlbum.getAno() < this.ano) {
			return 1;
		} else if (outroAlbum.getAno() > this.ano) {
			return -1;
		}
		return 0;
	}

}
