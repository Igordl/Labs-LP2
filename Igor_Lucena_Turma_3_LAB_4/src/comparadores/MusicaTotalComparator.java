/* 115210412 - Igor Dantas Lucena: LAB 4 - Turma 3 */
package comparadores;

import java.util.Comparator;

import sp2fy.Album;

public class MusicaTotalComparator implements Comparator<Album> {

	@Override
	public int compare(Album album1, Album album2) {
		if (album1.getTamanhoAlbum() > album2.getTamanhoAlbum()) {
			return 1;
		} else if (album1.getTamanhoAlbum() < album2.getTamanhoAlbum()) {
			return -1;
		}

		return 0;
	}

}
