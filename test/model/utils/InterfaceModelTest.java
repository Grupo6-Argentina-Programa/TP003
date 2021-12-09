package model.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Usuario;

public class InterfaceModelTest {

	@Test
	public void calcularLaDistanciaEntreUsuariostest() {

		double distanciaEsperada;
		double distanciaObtenida;

		Usuario usuario1 = new Usuario("", "", 0, 0, 0, 0);
		Usuario usuario2 = new Usuario("", "", 0, 0, 2, 2);
		distanciaEsperada = 2.82;
		distanciaObtenida = usuario1.distance(usuario2);
		assertEquals(distanciaEsperada, distanciaObtenida, 0.01);

		Usuario usuario3 = new Usuario("", "", 0, 0, 3, 4);
		Usuario usuario4 = new Usuario("", "", 0, 0, 3, 6);
		distanciaEsperada = 2.00;
		distanciaObtenida = usuario3.distance(usuario4);
		assertEquals(distanciaEsperada, distanciaObtenida, 0.01);

		Usuario usuario5 = new Usuario("", "", 0, 0, 8, 0);
		Usuario usuario6 = new Usuario("", "", 0, 0, 0, 8);
		distanciaEsperada = 11.31;
		distanciaObtenida = usuario5.distance(usuario6);
		assertEquals(distanciaEsperada, distanciaObtenida, 0.01);
	}

}
