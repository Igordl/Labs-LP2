package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import sp2fy.Album;
import sp2fy.Musica;

public class TestAlbum {

	Album thisIsActing;
	Album mariliaMendoncaAudioDVD;

	@Before
	public void setUp() throws Exception {

		thisIsActing = new Album("This is Acting", "Sia", 2015);
		mariliaMendoncaAudioDVD = new Album("Marilia Mendonca- Audio DVD", "Marilia Mendoca", 2015);

	}

	@Test
	public void testConstrutorWithException() {

		// Test Artista Vazio/Null
		try {

			Album album = new Album("  ", "AoVivo", 2012);
			fail("Lancamento de Exception com Artista vazio");

		} catch (Exception e) {

			assertEquals("Artista do album nao pode ser nulo ou vazio.", e.getMessage());

		}

		try {

			Album album1 = new Album(null, "AoVivo", 2012);
			fail("Lancamento de Exception com Artista null");

		} catch (Exception e) {

			assertEquals("Artista do album nao pode ser nulo ou vazio.", e.getMessage());

		}

		// Test Titulo Vazio/Null

		try {

			Album album = new Album("Sia", "", 2015);
			fail("Lancamento de Exception com Titulo Vazio");

		} catch (Exception e) {

			assertEquals("Titulo do album nao pode ser nulo ou vazio.", e.getMessage());

		}
		try {

			Album album2 = new Album("Marilia Mendonca", null, 2015);
			fail("Lancamento de Exception com Titulo null");

		} catch (Exception e) {

			assertEquals("Titulo do album nao pode ser nulo ou vazio.", e.getMessage());

		}

		// Test Ano de Lancamento Inferior ao esperado/Nulo

		try {

			Album album = new Album("Sia", "This is Acting", 1899);
			fail("Exception com Ano de Lancamento Inferior ao esperado");

		} catch (Exception e) {

			assertEquals("Ano de lancamento do album nao pode ser inferior a 1900.", e.getMessage());

		}
		try {

			Album album1 = new Album("Marilia Mendonca", "Marilia Mendonca - Audio DVD", 0);
			fail("Exception com ano de Lancamento nulo");

		} catch (Exception e) {

			assertEquals("Ano de lancamento do album nao pode ser inferior a 1900.", e.getMessage());

		}

	}

	@Test
	public void testAddFaixa() throws Exception {

		Musica alive = new Musica("Alive", 3, "Power Pop");
		Musica cheapThrills = new Musica("Cheap thrills", 3, "Power Pop");

		thisIsActing.adicionaMusica(alive);
		thisIsActing.adicionaMusica(cheapThrills);

		Musica infiel = new Musica("Infiel", 3, "Sertanejo");
		Musica comoFazComEla = new Musica("Como faz com ela", 3, "Sertanejo");

		mariliaMendoncaAudioDVD.adicionaMusica(infiel);
		mariliaMendoncaAudioDVD.adicionaMusica(comoFazComEla);

		assertTrue(thisIsActing.pesquisarMusica("Alive"));
		assertTrue(thisIsActing.pesquisarMusica("Cheap thrills"));
		assertTrue(mariliaMendoncaAudioDVD.pesquisarMusica("Infiel"));
		assertTrue(mariliaMendoncaAudioDVD.pesquisarMusica("Como faz com ela"));

	}

	@Test
	public void testRemoveFaixa() throws Exception {

		Musica birdSetFree = new Musica("Bird set free", 3, "Power Pop");

		Musica aloPorteiro = new Musica("Alo porteiro", 5, "Sertanejo");

		thisIsActing.adicionaMusica(birdSetFree);

		mariliaMendoncaAudioDVD.adicionaMusica(aloPorteiro);

		thisIsActing.removeMusica(1);
		mariliaMendoncaAudioDVD.removeMusica(1);

		assertFalse(thisIsActing.pesquisarMusica("Bird set free"));
		assertFalse(mariliaMendoncaAudioDVD.pesquisarMusica("Alo porteiro"));

	}

	@Test
	public void testNumeroDeFaixas() throws Exception {

		Musica oneMillionBullets = new Musica("One million bullets", 3, "Power Pop");

		Musica sentimentoLouco = new Musica("Sentimento Louco", 2, "Sertanejo");

		thisIsActing.adicionaMusica(oneMillionBullets);
		mariliaMendoncaAudioDVD.adicionaMusica(sentimentoLouco);

		assertEquals(1, thisIsActing.quantidadeFaixas());
		assertEquals(1, mariliaMendoncaAudioDVD.quantidadeFaixas());

	}

	@Test
	public void testGetMusica() throws Exception {

		Musica houseOnFire = new Musica("House on fire", 4, "Power Pop");

		Musica oQueFaltaEmVoceSouEu = new Musica("O que falta em voce sou eu", 4, "Sertanejo");

		thisIsActing.adicionaMusica(houseOnFire);
		mariliaMendoncaAudioDVD.adicionaMusica(oQueFaltaEmVoceSouEu);

		assertEquals(houseOnFire, thisIsActing.getMusica("House on fire"));
		assertEquals(oQueFaltaEmVoceSouEu, mariliaMendoncaAudioDVD.getMusica("O que falta em voce sou eu"));

	}

	@Test
	public void testDuracaoTotal() throws Exception {

		Musica reaper = new Musica("reaper", 4, "Power Pop");

		Musica folgado = new Musica("Folgado", 3, "Sertanejo");
		Musica esseCaraAquiDoLado = new Musica("Esse cara aqui do lado", 5, "Sertanejo");

		thisIsActing.adicionaMusica(reaper);
		mariliaMendoncaAudioDVD.adicionaMusica(folgado);
		mariliaMendoncaAudioDVD.adicionaMusica(esseCaraAquiDoLado);

		assertEquals(4, thisIsActing.getDuracaoTotal());
		assertEquals(8, mariliaMendoncaAudioDVD.getDuracaoTotal());

	}

	@Test
	public void testEquals() throws Exception {

		Musica spaceBetween = new Musica("Space between", 4, "Power Pop");

		Musica meuCupidoEhGari = new Musica("Meu cupido eh gari", 5, "Sertanejo");

		thisIsActing.adicionaMusica(spaceBetween);

		mariliaMendoncaAudioDVD.adicionaMusica(meuCupidoEhGari);

		Album thisIsActing2 = new Album("This is Acting", "Sia", 2015);
		Album mariliaMendoncaAudioDVD2 = new Album("Marilia Mendonca- Audio DVD", "Marilia Mendoca", 2015);

		assertTrue(thisIsActing.equals(thisIsActing2));
		assertTrue(mariliaMendoncaAudioDVD.equals(mariliaMendoncaAudioDVD2));

	}

}
