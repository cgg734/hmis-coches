package ual.hmis.sesion05cgg734;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Ejercicio2Test {

//	@Test
//    public void testLogin() {
//        Ejercicio2 ejercicio2 = new Ejercicio2();
//
//        // Caso de prueba: username y password válidos
//        assertTrue(ejercicio2.login("user", "pass"));
//
//        // Caso de prueba: username vacío
//        assertFalse(ejercicio2.login("", "pass"));
//
//        // Caso de prueba: password vacío
//        assertFalse(ejercicio2.login("user", ""));
//
//        // Caso de prueba: username y password vacíos
//        assertFalse(ejercicio2.login("", ""));
//
//        // Caso de prueba: username y password con longitud mayor a 30
//        assertFalse(ejercicio2.login("thisIsAUsernameWithMoreThan30Characters", "ThisIsAPasswordWithMoreThan30Characters"));
//
//        // Caso de prueba: password sin mayúscula, minúscula y dígito
//        assertFalse(ejercicio2.login("user", "password"));
//
//        // Caso de prueba: username y password válidos, pero falla en la comprobación de la base de datos
//        assertFalse(ejercicio2.login("user", "pass123"));
//
//        // Caso de prueba: username y password válidos, y éxito en la comprobación de la base de datos
//        assertTrue(ejercicio2.login("user", "pass"));
//        
//        
//     // Caso de prueba: username y password con longitud menor a 30
//        assertTrue(ejercicio2.login("user", "pass"));
//
//        // Caso de prueba: username con longitud mayor a 30
//        assertFalse(ejercicio2.login("usernameusernameusernameusernameusername", "pass"));
//
//        // Caso de prueba: password con longitud mayor a 30
//        assertFalse(ejercicio2.login("user", "passwordpasswordpasswordpasswordpassword"));
//
//        // Caso de prueba: password sin mayúscula, minúscula y dígito
//        assertFalse(ejercicio2.login("user", "password"));
//
//        // Caso de prueba: password solo con mayúscula
//        assertFalse(ejercicio2.login("user", "PASSWORD"));
//
//        // Caso de prueba: password solo con minúscula
//        assertFalse(ejercicio2.login("user", "password"));
//
//        // Caso de prueba: password solo con dígito
//        assertFalse(ejercicio2.login("user", "123456"));
//
//        // Caso de prueba: password con mayúscula, minúscula y dígito
//        assertTrue(ejercicio2.login("user", "Password123"));
//    
//    }
	
	@ParameterizedTest
    @CsvSource({
        "user, pass, true",
        " '' , pass, false",
        "user,'', false",
        "'','', false",
        "thisIsAUsernameWithMoreThan30Characters, ThisIsAPasswordWithMoreThan30Characters, false",
        "user, password, false",
        "user, pass123, false",
        "user, pass, true",
        "user, pass, true",
        "usernameusernameusernameusernameusername, pass, false",
        "user, passwordpasswordpasswordpasswordpassword, false",
        "user, password, false",
        "user, PASSWORD, false",
        "user, password, false",
        "user, 123456, false",
        "user, Password123, true"
    })
    void testLogin(String username, String password, boolean expected) {
        Ejercicio2 ejercicio2 = new Ejercicio2();
        boolean actual = ejercicio2.login(username, password);
        assertEquals(expected, actual);
    }
	


	 @ParameterizedTest
	    @CsvSource({
	        "abcDEF123, true",
	        "Password123, true",
	        "abcdefghi, false",
	        "123456789, false",
	        "ABCDEF, false",
	        "Abcdef, false",
	        "123456, false",
	        "$, false"
	    })
	    void testContieneMayusculaMinusculaDigito(String password, boolean expected) {
	        Ejercicio2 ejercicio2 = new Ejercicio2();
	        boolean actual = ejercicio2.contieneMayusculaMinusculaDigito(password);
	        assertEquals(expected, actual);
	    }
	
	
//	@Test
//    public void testCompruebaLoginEnBD() {
//        Ejercicio2 compruebaLoginEnBD = new Ejercicio2();
//
//        // Caso de prueba: username y password válidos
//        assertTrue(compruebaLoginEnBD.compruebaLoginEnBD("user", "pass"));
//
//        // Caso de prueba: username y password válidos pero en diferente orden
//        assertFalse(compruebaLoginEnBD.compruebaLoginEnBD("pass", "user"));
//
//        // Caso de prueba: username válido pero password inválido
//        assertFalse(compruebaLoginEnBD.compruebaLoginEnBD("user", "password"));
//
//        // Caso de prueba: username inválido pero password válido
//        assertFalse(compruebaLoginEnBD.compruebaLoginEnBD("username", "pass"));
//
//        // Caso de prueba: username y password inválidos
//        assertFalse(compruebaLoginEnBD.compruebaLoginEnBD("username", "password"));
//    }
	 
	 @ParameterizedTest
	    @CsvSource({
	        "user, pass, true",
	        "pass, user, false",
	        "user, password, false",
	        "username, pass, false",
	        "username, password, false"
	    })
	    void testCompruebaLoginEnBD(String username, String password, boolean expected) {
	        Ejercicio2 ejercicio2 = new Ejercicio2();
	        boolean actual = ejercicio2.compruebaLoginEnBD(username, password);
	        assertEquals(expected, actual);
	    }

}
