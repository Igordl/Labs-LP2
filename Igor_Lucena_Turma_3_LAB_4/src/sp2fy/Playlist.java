/* 115210412 - Igor Dantas Lucena: LAB 4 - Turma 3 */
package sp2fy;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
	private final String FIM_DE_LINHA = System.lineSeparator();
	private String nomePlaylist;
	private List<Musica> musicas;

	public Playlist(String nomePlaylist) throws Exception {

		verificanomePlaylistInvalido(nomePlaylist);
		this.nomePlaylist = nomePlaylist;
		this.musicas = new ArrayList<Musica>();
	}

	public boolean containsMusica(String nomeMusica) {
		for (Musica musica : musicas) {
			if (musica.getTitulo().equalsIgnoreCase(nomeMusica)) {
				return true;
			}
		}
		return false;
	}

	public String getNomePlaylist() {
		return nomePlaylist;
	}

	public void setNomePlaylist(String nomePlaylist) {
		this.nomePlaylist = nomePlaylist;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	public void addMusica(Musica musica) {
		if (!musicas.contains(musica)) {
			musicas.add(musica);
		}

	}

	public int tamanhoPlaylist() {
		return musicas.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((musicas == null) ? 0 : musicas.hashCode());
		result = prime * result + ((nomePlaylist == null) ? 0 : nomePlaylist.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Playlist) {
			Playlist outraPlaylist = (Playlist) objeto;
			if (outraPlaylist.getNomePlaylist().equals(this.getNomePlaylist())
					&& outraPlaylist.getMusicas().equals(this.getMusicas())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String retorno = nomePlaylist + FIM_DE_LINHA + FIM_DE_LINHA;
		int faixa = 1;
		for (Musica musica : musicas) {
			retorno += faixa + ". " + musica.toString();
			faixa += 1;
		}
		return retorno;
	}

	private void verificanomePlaylistInvalido(String nomePlaylist) throws Exception {
		if (nomePlaylist == null || nomePlaylist.trim().equals("")) {

			throw new Exception("Nome da playlist nao pode ser nulo ou vazio.");
		}
	}

}
