package org.hmis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

	@ParameterizedTest
    @CsvSource({
            "Renault, Clio, 2001, 12000, Renault, Clio, 2001, 12000, true",
            "Renault, Clio, 2001, 12000, Seat, Clio, 2001, 12000, false",
            "Renault, Clio, 2001, 12000, Renault, Twingo, 2001, 12000, false",
            "Renault, Clio, 2001, 12000, Renault, Clio, 2003, 12000, false",
            "Renault, Clio, 2001, 12000, Renault, Clio, 2001, 16000, false",
            "Renault, Clio, 2001, 12000, '', '', 0, 0, false",
            "Renault, Clio, 2001, 12000, null, null, 0, 0, false"
    })
    void testEquals(String marca1, String modelo1, int año1, int precio1,
                    String marca2, String modelo2, int año2, int precio2, boolean resultadoEsperado) {
        Coche coche1 = new Coche(marca1, modelo1, año1, precio1);
        Coche coche2 = new Coche(marca2, modelo2, año2, precio2);

        assertEquals(resultadoEsperado, coche1.equals(coche2));
    }

    @Test
    void testToString() {
        Coche coche = new Coche("Renault", "Clio", 2001, 12000);
        String resultadoEsperado = "Coche [marca=Renault, modelo=Clio, año=2001, precio=12000]";

        assertEquals(resultadoEsperado, coche.toString());
    }

    @Test
    void testGetters() {
        Coche coche = new Coche("Renault", "Clio", 2001, 12000);
        assertEquals("Renault", coche.getMarca());
        assertEquals("Clio", coche.getModelo());
        assertEquals(2001, coche.getAño());
        assertEquals(12000, coche.getPrecio());
    }

}
