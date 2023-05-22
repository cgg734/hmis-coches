package ual.hmis.sesion05cgg734;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class Ejercicio3Test {
	
	@ParameterizedTest
    @CsvFileSource(
    		files = "data/ejercicio3.csv")
    void testEnmascararPassword(String password, String expected) {
        Ejercicio3 ejercicio = new Ejercicio3();
        String actual = ejercicio.enmascararPassword(password);
        assertEquals(expected, actual);
    }

}
