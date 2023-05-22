package ual.hmis.sesion05cgg734;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Ejercicio1Test {

//	@Test
//	void testTransformar() {
//		Ejercicio1 ejercicio = new Ejercicio1();
//
//		// Prueba con un número par
//		assertEquals(1, ejercicio.transformar(8));
//
//		// Prueba con un número divisible por 3
//		assertEquals(1, ejercicio.transformar(9));
//
//		// Prueba con un número divisible por 5
//		assertEquals(1, ejercicio.transformar(25));
//
//		// Prueba con un número que no es divisible por 2, 3 ni 5
//		assertEquals(7, ejercicio.transformar(7));
//	}
	
	@ParameterizedTest
    @CsvSource({
        "8, 1",
        "9, 1",
        "25, 1",
        "7, 7"
    })
    void testTransformar(int number, int expected) {
        Ejercicio1 ejercicio = new Ejercicio1();
        int actual = ejercicio.transformar(number);
        assertEquals(expected, actual);
    }

}
