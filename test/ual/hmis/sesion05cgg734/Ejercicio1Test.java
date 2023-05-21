package ual.hmis.sesion05cgg734;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio1Test {

	@Test
	void testTransformar() {
		Ejercicio1 ejercicio = new Ejercicio1();

		// Prueba con un número par
		assertEquals(1, ejercicio.transformar(8));

		// Prueba con un número divisible por 3
		assertEquals(1, ejercicio.transformar(9));

		// Prueba con un número divisible por 5
		assertEquals(1, ejercicio.transformar(25));

		// Prueba con un número que no es divisible por 2, 3 ni 5
		assertEquals(7, ejercicio.transformar(7));
	}

}
