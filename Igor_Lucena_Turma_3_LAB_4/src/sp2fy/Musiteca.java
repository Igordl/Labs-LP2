/* 115210412 - Igor Dantas Lucena: LAB 4 - Turma 3 */
package sp2fy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparadores.ArtistaComparator;
import comparadores.DuracaoTotalComparator;
import comparadores.MusicaTotalComparator;

public class Musiteca {

	private List<Album> meusAlbuns;
	private Map<String, Playlist> playlists;
	private List<Album> favoritos;

	public Musiteca() {
		this.playlists = new HashMap<String, Playlist>();
		this.meusAlbuns = new ArrayList<Album>();
		this.favoritos = new ArrayList<Album>();
	}

	public List<Album> getAlbuns() {
		return this.meusAlbuns;
	}

	public boolean containsAlbum(Album album) {
		for (Album album2 : meusAlbuns) {
			if (album.equals(album2)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsAlbum(String tituloAlbum) {
		for (Album album2 : meusAlbuns) {
			if (album2.getTitulo().equals(tituloAlbum)) {
				return true;
			}
		}
		return false;
	}

	public boolean addAlbum(Album album) {

		if (!containsAlbum(album)) {
			if (album != null) {
				meusAlbuns.add(album);
				return true;
			}
			return false;
		}

		return false;
	}

	public void addAlbum(String artista, String tituloAlbum, int ano) throws Exception {
		Album album = new Album(artista, tituloAlbum, ano);
		meusAlbuns.add(album);
	}

	public boolean removeAlbum(String titulo) {
		for (Album album : meusAlbuns) {
			if (album.getTitulo().equalsIgnoreCase(titulo)) {
				meusAlbuns.remove(album);
				return true;
			}

		}

		return false;
	}

	public boolean addMusicaToAlbum(String tituloAlbum, String tituloMusica, int duracao, String genero)
			throws Exception {
		for (Album album : meusAlbuns) {
			if (album.getTitulo().equals(tituloAlbum)) {
				Musica musica = new Musica(tituloMusica, duracao, genero);
				album.adicionaMusica(musica);
				return true;
			}
		}
		return false;
	}

	public boolean removeMusicaFromAlbum(String tituloAlbum, String tituloMusica) {
		for (Album album : meusAlbuns) {
			if (tituloAlbum.equalsIgnoreCase(tituloAlbum)) {
				for (Musica musica : album.getMusicas()) {
					if (musica.getTitulo().equalsIgnoreCase(tituloMusica)) {
						album.removeMusica(tituloMusica);
						return true;
					}

				}
			}

		}
		return false;
	}

	public Album getAlbum(String tituloAlbum) {
		for (Album album : meusAlbuns) {
			if (tituloAlbum.equalsIgnoreCase(tituloAlbum)) {
				return album;
			}
		}

		return null;
	}

	public boolean addPlaylist(String nomePlaylist, Playlist playlist) {
		if (!contemPlaylist(nomePlaylist)) {
			playlists.put(nomePlaylist, playlist);
			return true;
		}

		return false;
	}

	public boolean criaPlaylist(String nomePlaylist) throws Exception {
		if (!nomePlaylist.trim().equals("")) {
			if (!contemPlaylist(nomePlaylist)) {
				Playlist playlist = new Playlist(nomePlaylist);
				playlists.put(nomePlaylist, playlist);
				return true;
			}
		}
		return false;
	}

	public boolean addNaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) {
		for (Album album2 : meusAlbuns) {
			if (album2.getTitulo().equalsIgnoreCase(nomeAlbum)) {
				playlists.get(nomePlaylist).addMusica(album2.getMusica(faixa - 1));
				return true;
			}
		}

		return false;
	}

	public boolean contemPlaylist(String nomePlaylist) {
		if (playlists.keySet().contains(nomePlaylist)) {

			return true;
		}
		return false;
	}

	public int getTamPlaylist(String nomePlaylist) {
		Playlist playlistAUX = playlists.get(nomePlaylist);
		return playlistAUX.tamanhoPlaylist();
	}

	public boolean contemNaPaylist(String nomePlaylist, String nomeMusica) {
		if (playlists.containsKey(nomePlaylist)) {
			if (playlists.get(nomePlaylist).containsMusica(nomeMusica)) {

				return true;

			}
		}
		return false;
	}

	public boolean addAosFavoritos(Album album) {
		if (!favoritos.contains(album)) {
			favoritos.add(album);
			return true;
		}

		return false;
	}

	public boolean addAosFavoritos(String artista, String tituloAlbum, int ano) throws Exception {
		Album album = new Album(artista, tituloAlbum, ano);
		return addAosFavoritos(album);
	}

	public int getQtdFavoritos() {
		return favoritos.size();
	}

	public boolean contemAlbum(Album album) {
		return meusAlbuns.contains(album);
	}

	public List<Album> getMeusAlbuns() {
		return meusAlbuns;
	}

	public void setMeusAlbuns(List<Album> meusAlbuns) {
		this.meusAlbuns = meusAlbuns;
	}

	public Map<String, Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Map<String, Playlist> playlists) {
		this.playlists = playlists;
	}

	public List<Album> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Album> favoritos) {
		this.favoritos = favoritos;
	}

	@Override
	public String toString() {
		return "Musiteca [meusAlbuns=" + meusAlbuns + ", playlists=" + playlists + ", favoritos=" + favoritos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((favoritos == null) ? 0 : favoritos.hashCode());
		result = prime * result + ((meusAlbuns == null) ? 0 : meusAlbuns.hashCode());
		result = prime * result + ((playlists == null) ? 0 : playlists.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Musiteca) {
			Musiteca outraMusiteca = (Musiteca) objeto;
			if (outraMusiteca.getMeusAlbuns().equals(this.getMeusAlbuns())
					&& outraMusiteca.getFavoritos().equals(this.getFavoritos())
					&& outraMusiteca.getPlaylists().equals(this.getPlaylists())) {
				return true;
			}
		}
		return false;
	}

	public void sortedAlbuns(int opcao) {
		final int ORD_NOME_ARTISTA = 1;
		final int ORD_MUSICAS_TOTAL = 2;
		final int ORD_DURACAO_TOTAL = 3;
		ArrayList<Album> meusAlbunsOrdenados = (ArrayList<Album>) this.meusAlbuns;
		ArrayList<Album> albunsFavoritosOrdenados = (ArrayList<Album>) this.favoritos;
		switch (opcao) {
		case ORD_NOME_ARTISTA:
			Collections.sort(meusAlbunsOrdenados, new ArtistaComparator());
			Collections.sort(albunsFavoritosOrdenados, new ArtistaComparator());
			System.out.println(meusAlbunsOrdenados.toString());
			System.out.println(albunsFavoritosOrdenados.toString());
			break;

		case ORD_MUSICAS_TOTAL:
			Collections.sort(meusAlbunsOrdenados, new MusicaTotalComparator());
			Collections.sort(albunsFavoritosOrdenados, new MusicaTotalComparator());
			System.out.println(meusAlbunsOrdenados.toString());
			System.out.println(albunsFavoritosOrdenados.toString());
			break;
		case ORD_DURACAO_TOTAL:
			Collections.sort(meusAlbunsOrdenados, new DuracaoTotalComparator());
			Collections.sort(albunsFavoritosOrdenados, new DuracaoTotalComparator());
			System.out.println(meusAlbunsOrdenados.toString());
			System.out.println(albunsFavoritosOrdenados.toString());
		default:
			Collections.sort(meusAlbunsOrdenados);
			Collections.sort(albunsFavoritosOrdenados);
			System.out.println(meusAlbunsOrdenados.toString());
			System.out.println(albunsFavoritosOrdenados.toString());
		}
	}
}
