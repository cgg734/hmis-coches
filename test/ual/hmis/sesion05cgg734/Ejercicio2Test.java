package ual.hmis.sesion05cgg734;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio2Test {

	@Test
    public void testLogin() {
        Ejercicio2 ejercicio2 = new Ejercicio2();

        // Caso de prueba: username y password válidos
        assertTrue(ejercicio2.login("user", "pass"));

        // Caso de prueba: username vacío
        assertFalse(ejercicio2.login("", "pass"));

        // Caso de prueba: password vacío
        assertFalse(ejercicio2.login("user", ""));

        // Caso de prueba: username y password vacíos
        assertFalse(ejercicio2.login("", ""));

        // Caso de prueba: username y password con longitud mayor a 30
        assertFalse(ejercicio2.login("thisIsAUsernameWithMoreThan30Characters", "ThisIsAPasswordWithMoreThan30Characters"));

        // Caso de prueba: password sin mayúscula, minúscula y dígito
        assertFalse(ejercicio2.login("user", "password"));

        // Caso de prueba: username y password válidos, pero falla en la comprobación de la base de datos
        assertFalse(ejercicio2.login("user", "pass123"));

        // Caso de prueba: username y password válidos, y éxito en la comprobación de la base de datos
        assertTrue(ejercicio2.login("user", "pass"));
        
        
     // Caso de prueba: username y password con longitud menor a 30
        assertTrue(ejercicio2.login("user", "pass"));

        // Caso de prueba: username con longitud mayor a 30
        assertFalse(ejercicio2.login("usernameusernameusernameusernameusername", "pass"));

        // Caso de prueba: password con longitud mayor a 30
        assertFalse(ejercicio2.login("user", "passwordpasswordpasswordpasswordpassword"));

        // Caso de prueba: password sin mayúscula, minúscula y dígito
        assertFalse(ejercicio2.login("user", "password"));

        // Caso de prueba: password solo con mayúscula
        assertFalse(ejercicio2.login("user", "PASSWORD"));

        // Caso de prueba: password solo con minúscula
        assertFalse(ejercicio2.login("user", "password"));

        // Caso de prueba: password solo con dígito
        assertFalse(ejercicio2.login("user", "123456"));

        // Caso de prueba: password con mayúscula, minúscula y dígito
        assertTrue(ejercicio2.login("user", "Password123"));
    
    }
	
	
	@Test
    public void testContieneMayusculaMinusculaDigito() {
        Ejercicio2 contieneMayusculaMinusculaDigito = new Ejercicio2();

        // Caso de prueba: cadena vacía
        assertFalse(contieneMayusculaMinusculaDigito.contieneMayusculaMinusculaDigito(""));

        // Caso de prueba: cadena sin mayúscula, sin minúscula y sin dígito
        assertFalse(contieneMayusculaMinusculaDigito.contieneMayusculaMinusculaDigito("password"));

        // Caso de prueba: cadena con una mayúscula
        assertFalse(contieneMayusculaMinusculaDigito.contieneMayusculaMinusculaDigito("Password"));

        // Caso de prueba: cadena con una minúscula
        assertFalse(contieneMayusculaMinusculaDigito.contieneMayusculaMinusculaDigito("PASSWORD"));

        // Caso de prueba: cadena con un dígito
        assertFalse(contieneMayusculaMinusculaDigito.contieneMayusculaMinusculaDigito("12345"));

        // Caso de prueba: cadena con una mayúscula, una minúscula y un dígito
        assertTrue(contieneMayusculaMinusculaDigito.contieneMayusculaMinusculaDigito("Password1"));

        // Caso de prueba: cadena con una mayúscula, una minúscula y un dígito, pero en diferente orden
        assertTrue(contieneMayusculaMinusculaDigito.contieneMayusculaMinusculaDigito("1pAssword"));

        // Caso de prueba: cadena con más de una mayúscula, más de una minúscula y más de un dígito
        assertTrue(contieneMayusculaMinusculaDigito.contieneMayusculaMinusculaDigito("Pass1Word"));
        
        //Contiene dígito
        assertFalse(contieneMayusculaMinusculaDigito.contieneMayusculaMinusculaDigito("Aa"));
        
        //todo minúscula y dígito
        assertFalse(contieneMayusculaMinusculaDigito.contieneMayusculaMinusculaDigito("aghd2"));
        
    }
	
	
	@Test
    public void testCompruebaLoginEnBD() {
        Ejercicio2 compruebaLoginEnBD = new Ejercicio2();

        // Caso de prueba: username y password válidos
        assertTrue(compruebaLoginEnBD.compruebaLoginEnBD("user", "pass"));

        // Caso de prueba: username y password válidos pero en diferente orden
        assertFalse(compruebaLoginEnBD.compruebaLoginEnBD("pass", "user"));

        // Caso de prueba: username válido pero password inválido
        assertFalse(compruebaLoginEnBD.compruebaLoginEnBD("user", "password"));

        // Caso de prueba: username inválido pero password válido
        assertFalse(compruebaLoginEnBD.compruebaLoginEnBD("username", "pass"));

        // Caso de prueba: username y password inválidos
        assertFalse(compruebaLoginEnBD.compruebaLoginEnBD("username", "password"));
    }

}
