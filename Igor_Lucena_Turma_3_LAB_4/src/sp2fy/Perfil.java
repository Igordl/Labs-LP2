/* 115210412 - Igor Dantas Lucena: LAB 4 - Turma 3 */
package sp2fy;

public class Perfil {

	private String nomeUsuario;
	private Musiteca musiteca;

	public Perfil(String nomeUsuario) throws Exception {
		verificaNomeInvalido(nomeUsuario);
		this.nomeUsuario = nomeUsuario;

	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) throws Exception {
		verificaNomeInvalido(nomeUsuario);
		this.nomeUsuario = nomeUsuario;
	}

	public Musiteca getMusiteca() {
		return this.musiteca;
	}

	public void getAlbum(String tituloAlbum) {
		try {
			musiteca.getAlbum(tituloAlbum);
		} catch (Exception excecao) {
			System.out.println("Erro na busca do album");
			System.out.println(excecao.getMessage());
		}
	}

	public void contemAlbum(Album album) {
		try {
			musiteca.containsAlbum(album);
		} catch (Exception excecao) {
			System.out.println(excecao.getMessage());
		}
	}

	public void contemAlbum(String tituloAlbum) {
		try {
			musiteca.containsAlbum(tituloAlbum);
		} catch (Exception excecao) {
			System.out.println(excecao.getMessage());
		}
	}

	public void adicionaAlbum(Album album) {
		try {
			musiteca.addAlbum(album);
		} catch (Exception excecao) {
			System.out.println("Erro na adicao do album");
			System.out.println(excecao.getMessage());

		}
	}

	public void adicionaAlbum(String tituloAlbum, String artista, int ano) {
		try {

			musiteca.addAlbum(tituloAlbum, artista, ano);

		} catch (Exception excecao) {
			System.out.println("Erro na adicao do album");
			System.out.println(excecao.getMessage());

		}
	}

	public void removeAlbum(String titulo) {
		try {
			musiteca.removeAlbum(titulo);
		} catch (Exception excecao) {
			System.out.println("Erro na remocao do album");
			System.out.println(excecao.getMessage());

		}
	}

	public void adicionaMusicaNoAlbum(String tituloAlbum, String tituloMusica, int duracao, String genero) {
		try {
			musiteca.addMusicaToAlbum(tituloAlbum, tituloMusica, duracao, genero);
		} catch (Exception excecao) {
			System.out.println("Erro na adicao de musica no album");
			System.out.println(excecao.getMessage());
		}
	}

	public void removeMusicaDoAlbum(String tituloAlbum, String tituloMusica) {
		try {
			musiteca.removeMusicaFromAlbum(tituloAlbum, tituloMusica);
		} catch (Exception excecao) {
			System.out.println("Erro na remocao de musica no album");
			System.out.println(excecao.getMessage());
		}
	}

	public void adicionaPlaylist(String tituloPlaylist, Playlist playlist) {
		try {
			musiteca.addPlaylist(tituloPlaylist, playlist);
		} catch (Exception excecao) {
			System.out.println("Erro na adicao da Playlist");
			System.out.println(excecao.getMessage());
		}
	}

	public void criaPlaylist(String nomePlaylist) {
		try {
			musiteca.criaPlaylist(nomePlaylist);
		} catch (Exception excecao) {
			System.out.println("Erro na criacao da Playlist");
			System.out.println(excecao.getMessage());
		}
	}

	public void adicionaNaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) {
		try {
			musiteca.addNaPlaylist(nomePlaylist, nomeAlbum, faixa);
		} catch (Exception excecao) {
			System.out.println("Erro na adicao de musica na Playlist");
			System.out.println(excecao.getMessage());
		}
	}

	public void contemPlaylist(String nomePlaylist) {
		try {
			musiteca.contemPlaylist(nomePlaylist);
		} catch (Exception excecao) {
			System.out.println("Erro na busca da Playlist");
			System.out.println(excecao.getMessage());
		}
	}

	public void getTamanhoPlaylist(String nomePlaylist) {
		try {
			musiteca.getTamPlaylist(nomePlaylist);
		} catch (Exception excecao) {
			System.out.println("Erro na captura do tamanho da Playlist");
			System.out.println(excecao.getMessage());
		}
	}

	public void contemNaPlaylist(String nomePlaylist, String nomeMusica) {
		try {
			musiteca.contemNaPaylist(nomePlaylist, nomeMusica);
		} catch (Exception excecao) {
			System.out.println("Erro na busca da musica na Playlist");
			System.out.println(excecao.getMessage());
		}
	}

	public void adicionaAosFavoritos(Album album) {
		try {
			musiteca.addAosFavoritos(album);
		} catch (Exception excecao) {
			System.out.println("Erro ao favoritar album");
			System.out.println(excecao.getMessage());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((musiteca == null) ? 0 : musiteca.hashCode());
		result = prime * result + ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Perfil) {
			Perfil outroPerfil = (Perfil) objeto;
			if (outroPerfil.getNomeUsuario().equals(this.getNomeUsuario())
					&& outroPerfil.getMusiteca().equals(this.getMusiteca())) {
				return true;
			}
		}
		return false;
	}

	public void adicionaAosFavoritos(String artista, String tituloAlbum, int ano) {
		try {
			musiteca.addAosFavoritos(artista, tituloAlbum, ano);
		} catch (Exception excecao) {
			System.out.println("Erro ao favoritar album");
			System.out.println(excecao.getMessage());
		}
	}

	public void getQntFavoritos() {
		try {
			musiteca.getQtdFavoritos();
		} catch (Exception excecao) {
			System.out.println("Erro ao capturar a quantidade de albuns favoritos");
			System.out.println(excecao.getMessage());
		}
	}

	private void verificaNomeInvalido(String nome) throws Exception {
		if (nome == null || nome.trim().equals("")) {
			throw new Exception("Nome do usuario nao pode ser nulo ou vazio.");
		}
	}
}
