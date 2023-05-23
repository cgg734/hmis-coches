package org.hmis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CocheTest {

   
//    @Test
//    void testEquals() {
//        Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
//        Coche segundo = new Coche ("Renault", "Clio", 2001, 12000);
//        assertEquals(primero, segundo, "Los dos coches no son iguales");
//    }
//
//    @Test
//    void testToString() {
//        Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
//        assertEquals("Coche [marca=Renault, modelo=Clio, año=2001, precio=12000]", primero.toString());
//
//    }
//
//    // Test del metodo equals de la clase Coche
//    @Test
//    void testEquals2() {
//        Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
//        Coche segundo = null;
//        assertNotEquals(primero, segundo, "Los dos coches no son iguales");
//    }
//    
//    // Test del metodo equals de la clase Coche
//    @Test
//    void testEquals3() {
//        Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
//        Coche segundo = null;
//        assertEquals(primero, primero, "Los dos coches no son iguales");
//    }
//
//        // Test del método equals de la clase Coche
//        @Test
//        void testEquals4() {
//            Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
//            String segundo = "";
//            assertNotEquals(primero, segundo, "Los dos coches no son iguales");
//        }
//
//        @Test
//        void testEquals_att1() {
//            Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
//            Coche segundo = new Coche ("Renault", "Clio", 2001, 12000);
//
//            segundo.setAño(2003);
//            assertNotEquals(primero, segundo, "Los dos coches no son iguales");
//        }
//
//        @Test
//        void testEquals_att2() {
//            Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
//            Coche segundo = new Coche ("Renault", "Clio", 2001, 12000);
//
//            segundo.setMarca("Seat");
//            assertNotEquals(primero, segundo, "Los dos coches no son iguales");
//        }
//
//        @Test
//        void testEquals_att3() {
//            Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
//            Coche segundo = new Coche ("Renault", "Clio", 2001, 12000);
//            segundo.setModelo("Twingo");
//            assertNotEquals(primero, segundo, "Los dos coches no son iguales");
//        }
//
//        @Test
//        void testEquals_att4() {
//            Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
//            Coche segundo = new Coche ("Renault", "Clio", 2001, 12000);
//            segundo.setPrecio(16000);
//            assertNotEquals(primero, segundo, "Los dos coches no son iguales");
//        }
//
//        // test getters
//        @Test
//        void testGetters() {
//            Coche primero = new Coche ("Renault", "Clio", 2001, 12000);
//            assertEquals("Renault", primero.getMarca());
//            assertEquals("Clio", primero.getModelo());
//            assertEquals(2001, primero.getAño());
//            assertEquals(12000, primero.getPrecio());
//        }

//	@ParameterizedTest
//    @CsvSource({
//            "Renault, Clio, 2001, 12000, Renault, Clio, 2001, 12000, true",
//            "Renault, Clio, 2001, 12000, Seat, Clio, 2001, 12000, false",
//            "Renault, Clio, 2001, 12000, Renault, Twingo, 2001, 12000, false",
//            "Renault, Clio, 2001, 12000, Renault, Clio, 2003, 12000, false",
//            "Renault, Clio, 2001, 12000, Renault, Clio, 2001, 16000, false",
//            "Renault, Clio, 2001, 12000, '', '', 0, 0, false",
//            "Renault, Clio, 2001, 12000, null, null, 0, 0, false"
//    })
//    void testEquals(String marca1, String modelo1, int año1, int precio1,
//                    String marca2, String modelo2, int año2, int precio2, boolean resultadoEsperado) {
//        Coche coche1 = new Coche(marca1, modelo1, año1, precio1);
//        Coche coche2 = new Coche(marca2, modelo2, año2, precio2);
//
//        assertEquals(resultadoEsperado, coche1.equals(coche2));
//    }
//
//    @Test
//    void testToString() {
//        Coche coche = new Coche("Renault", "Clio", 2001, 12000);
//        String resultadoEsperado = "Coche [marca=Renault, modelo=Clio, año=2001, precio=12000]";
//
//        assertEquals(resultadoEsperado, coche.toString());
//    }
//
//    @Test
//    void testGetters() {
//        Coche coche = new Coche("Renault", "Clio", 2001, 12000);
//        assertEquals("Renault", coche.getMarca());
//        assertEquals("Clio", coche.getModelo());
//        assertEquals(2001, coche.getAño());
//        assertEquals(12000, coche.getPrecio());
//    }
	
	@SuppressWarnings("unlikely-arg-type")
	@ParameterizedTest
	@CsvFileSource(files = "data/equals.csv")
	void testEqualsObject(String cochesCSV) {

		Coche c1 = new Coche("Toyota", "Corolla", 2022, 22000);
		Coche c2_c = null;
		String c2_s = null;
		Boolean resultado;

		if (cochesCSV.split(", ")[0].equals("sameObject")) {
			c2_c = c1;
			resultado = Boolean.parseBoolean(cochesCSV.split(", ")[1]);
		} else if (cochesCSV.split(", ")[0].equals("nullObject")) {
			resultado = Boolean.parseBoolean(cochesCSV.split(", ")[1]);
		} else if (cochesCSV.split(", ")[0].equals("")) {
			c2_s = "";
			resultado = Boolean.parseBoolean(cochesCSV.split(", ")[1]);
		} else {
			String[] coche = cochesCSV.split(", ");

			String marca = coche[0];
			String modelo = coche[1];
			int anio = Integer.parseInt(coche[2]);
			int precio = Integer.parseInt(coche[3]);

			resultado = Boolean.parseBoolean(cochesCSV.split(", ")[4]);
			
			c2_c = new Coche(marca, modelo, anio, precio);
		}
		
		if (c2_c == null) {
			assertEquals(resultado, c1.equals(c2_s));
		} else {
			assertEquals(resultado, c1.equals(c2_c));
		}
	}

	@Test
	void testHashCode() {

		Coche c = new Coche();

		assertEquals((Object)c.hashCode(), c.hashCode());
	}

	/*
	@Test
	void testGetMarca() {

		String marca = "Toyota";
		Coche c = new Coche(marca, "", 0, 0);

		assertEquals(marca, c.getMarca());
	}
	*/
	
	@ParameterizedTest
	@ValueSource(strings = {"Toyota", "Ford", "Chevrolet", "Honda"})
	void testGetMarca(String marca) {

		Coche c = new Coche(marca, "", 0, 0);
		
		assertEquals(marca, c.getMarca());
	}

	/*
	@Test
	void testGetModelo() {

		String modelo = "Corolla";
		Coche c = new Coche("", modelo, 0, 0);

		assertEquals(modelo, c.getModelo());
	}
	*/

	@ParameterizedTest
	@ValueSource(strings = {"Corolla", "Mustang", "Camaro", "Civic"})
	void testGetModelo(String modelo){

		Coche c = new Coche("", modelo, 0, 0);

		assertEquals(modelo, c.getModelo());
	}

	/*
	@Test
	void testGetAnio() {

		int anio = 2022;
		Coche c = new Coche("", "", anio, 0);

		assertEquals(anio, c.getAnio());
	}
	*/
	
	@ParameterizedTest
	@ValueSource(ints = {2022, 2021, 2023, 2022})
	void testGetAnio(int anio) {

		Coche c = new Coche("", "", anio, 0);

		assertEquals(anio, c.getAño());
	}

	/*
	@Test
	void testGetPrecio() {

		int precio = 22000;
		Coche c = new Coche("", "", 0, precio);

		assertEquals(precio, c.getPrecio());
	}
	*/
	
	@ParameterizedTest
	@ValueSource(ints = {22000, 45000, 52000, 25000})
	void testGetPrecio(int precio) {

		Coche c = new Coche("", "", 0, precio);

		assertEquals(precio, c.getPrecio());
	}

	/*
	@Test
	void testSetMarca() {

		String marca = "Toyota";
		Coche c = new Coche();

		c.setMarca(marca);

		assertEquals(marca, c.getMarca());
	}
	*/
	
	@ParameterizedTest
	@ValueSource(strings = {"Toyota", "Ford", "Chevrolet", "Honda"})
	void testSetMarca(String marca) {

		Coche c = new Coche();

		c.setMarca(marca);

		assertEquals(marca, c.getMarca());
	}

	/*
	@Test
	void testSetModelo() {

		String modelo = "Corolla";
		Coche c = new Coche();

		c.setModelo(modelo);

		assertEquals(modelo, c.getModelo());
	}
	*/

	@ParameterizedTest
	@ValueSource(strings = {"Corolla", "Mustang", "Camaro", "Civic"})
	void testSetModelo(String modelo) {

		Coche c = new Coche();

		c.setModelo(modelo);

		assertEquals(modelo, c.getModelo());
	}

	/*
	@Test
	void testSetAnio() {

		int anio = 2022;
		Coche c = new Coche();

		c.setAnio(anio);

		assertEquals(anio, c.getAnio());
	}
	*/
	
	@ParameterizedTest
	@ValueSource(ints = {2022, 2021, 2023, 2022})
	void testSetAnio(int anio) {

		Coche c = new Coche();

		c.setAño(anio);

		assertEquals(anio, c.getAño());
	}

	/*
	@Test
	void testSetPrecio() {

		int precio = 2022;
		Coche c = new Coche();

		c.setPrecio(precio);

		assertEquals(precio, c.getPrecio());
	}
	*/

	@ParameterizedTest
	@ValueSource(ints = {22000, 45000, 52000, 25000})
	void testSetPrecio(int precio) {

		Coche c = new Coche();

		c.setPrecio(precio);

		assertEquals(precio, c.getPrecio());
	}

	/*
	@Test
	void testToString() {

		String marca = "Toyota";
		String modelo = "Corolla";
		int anio = 2022;
		int precio = 22000;

		String cadena = "Coche [marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", precio=" + precio + "]";

		Coche c = new Coche(marca, modelo, anio, precio);

		assertEquals(cadena, c.toString());
	}
	*/
	
	@ParameterizedTest
	@CsvFileSource(files = "data/cadenas.csv")
	void testToString(String cochesCSV) {

		String[] cocheCadena = cochesCSV.split("; ");
		String[] coche = cocheCadena[0].split(", ");
		
		String marca = coche[0];
		String modelo = coche[1];
		int anio = Integer.parseInt(coche[2]);
		int precio = Integer.parseInt(coche[3]);
		
		String resultado = cocheCadena[1];
		
		Coche c = new Coche(marca, modelo, anio, precio);
		
		assertEquals(resultado, c.toString());
	}

}
