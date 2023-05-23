package org.hmis;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

	private final ByteArrayOutputStream salida = new ByteArrayOutputStream();
	private final PrintStream salidaOriginal = System.out;
	
	@Test
	void testObjectNotNull() {

		Main main = new Main();

		assertNotEquals(main, null);
	}

	@BeforeEach
	void configurarStream() {

		// Configurar que la salida se guarde en un array
		System.setOut(new PrintStream(salida));
	}

	@AfterEach
	void reestablecerInicial() {

		// Configurar que la salida vuelva a mostrarse por consola
		System.setOut(salidaOriginal);
	}

	@Test
	void testMain() {

    	String ruta = "data/coches.json";
    	Coche[] coches = JsonReader.leerCochesJSON(ruta);

    	String c = "";

    	for (Coche coche : coches) {
            c = c + coche + System.lineSeparator();
        }

    	// Ejecuta la función main
    	Main.main(null);

		assertEquals(c, salida.toString());
	}

}
