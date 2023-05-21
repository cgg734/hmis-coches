package ual.hmis.sesion05cgg734;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio2Test {

	@Test
    public void testLogin() {
		Ejercicio2 login = new Ejercicio2();

		// Prueba con datos de inicio de sesión válidos
		assertTrue(login.login("user", "pass"));
		
		// Prueba con datos de inicio de sesión válidos
        assertTrue(login.compruebaLoginEnBD("user", "pass"));

        // Prueba con datos de inicio de sesión inválidos (nombre de usuario incorrecto)
        assertFalse(login.compruebaLoginEnBD("invalid", "pass"));

        // Prueba con datos de inicio de sesión inválidos (contraseña incorrecta)
        assertFalse(login.compruebaLoginEnBD("user", "invalid"));

        // Prueba con datos de inicio de sesión inválidos (nombre de usuario y contraseña incorrectos)
        assertFalse(login.compruebaLoginEnBD("invalid", "invalid"));

		// Prueba con datos de inicio de sesión inválidos
		assertFalse(login.login("invalid", "password"));

		// Prueba con un nombre de usuario vacío
		assertFalse(login.login("", "password"));

		// Prueba con una contraseña vacía
		assertFalse(login.login("user", ""));

		// Prueba con datos de inicio de sesión inválidos (nombre de usuario con más de
		// 30 caracteres)
		assertFalse(login.login("thisIsAUsernameWithMoreThan30Characters", "pass"));

		// Prueba con datos de inicio de sesión inválidos (contraseña con más de 30
		// caracteres)
		assertFalse(login.login("user", "thisIsAPasswordWithMoreThan30Characters"));

		// Prueba con datos de inicio de sesión inválidos (nombre de usuario y
		// contraseña con más de 30 caracteres)
		assertFalse(login.login("thisIsAUsernameWithMoreThan30Characters", "thisIsAPasswordWithMoreThan30Characters"));

	}

}
