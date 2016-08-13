/* 115210412 - Igor Dantas Lucena: LAB 4 - Turma 3 */
package comparadores;

import java.util.Comparator;

import sp2fy.Album;

public class ArtistaComparator implements Comparator<Album> {

	@Override
	public int compare(Album album1, Album album2) {
		return album1.getArtista().compareTo(album2.getArtista());
	}

}
