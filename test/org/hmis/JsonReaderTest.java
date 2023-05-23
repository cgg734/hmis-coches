package org.hmis;


import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.google.gson.JsonIOException;

class JsonReaderTest {

//	@Test
//	void testLeerCochesJSON() {
//		String ruta = "data/coches.json";
//		Coche [] coches = JsonReader.leerCochesJSON(ruta);
//		assertEquals (4, coches.length);
//	}
//
//	@Test
//	void testLeerCochesJSONprimero() {
//		String ruta = "data/coches.json";
//		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
//		Coche [] coches = JsonReader.leerCochesJSON(ruta);
//		assertEquals(primero, coches[0]);
//		assertTrue (primero.equals(coches[0]));
//		assertTrue (coches[0].equals(primero));
//	}
//
//	@Test
//	void testLeerCochesException() {
//		String ruta = "data/coches.json";
//		Coche [] coches = JsonReader.leerCochesJSON(ruta);
//		assertThrows(ArrayIndexOutOfBoundsException.class, () -> coches[4].equals(null));
//	}
//	
//	@Test
//	public void testLeerCochesJSON_ArchivoVacio() {
//		// Preparación
//		String archivoVacio = "ruta_archivo_vacio.json";
//		crearArchivoVacio(archivoVacio);
//
//		// Ejecución
//		Coche[] coches = JsonReader.leerCochesJSON(archivoVacio);
//
//		// Verificación
//		assertNull(coches);
//	}
//
//	@Test
//	public void testLeerCochesJSON_ArchivoMalformado() {
//		// Preparación
//		String archivoMalformado = "ruta_archivo_malformado.json";
//		crearArchivoMalformado(archivoMalformado);
//
//		// Ejecución
//		Coche[] coches = JsonReader.leerCochesJSON(archivoMalformado);
//
//		// Verificación
//		assertNull(coches);
//	}
//
//	private void crearArchivoVacio(String ruta) {
//		try {
//			FileWriter writer = new FileWriter(ruta);
//			writer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void crearArchivoMalformado(String ruta) {
//		try {
//			FileWriter writer = new FileWriter(ruta);
//			writer.write("Esto no es un JSON válido");
//			writer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	@Test
//    public void testJsonReaderInstantiation() {
//        // Ejecución
//        JsonReader jsonReader = new JsonReader();
//
//        // Verificación
//        assertNotNull(jsonReader);
//    }
	
	
	@ParameterizedTest
	@CsvSource({"data/coches.json, 4",
				"data/cochesNuevo.json, 3",
				"data/Nuevo2.json, 2",
				"data/Nuevo3.json, 1"})
	void testLeerCochesJSON(String ruta, int numCoches) {

		Coche[] coches = JsonReader.leerCochesJSON(ruta);

		assertEquals(numCoches, coches.length);
	}

	/*
	@Test
	void testLeerCochesJSONprimero() {

		String ruta = "data/coches1.json";
		Coche[] coches = JsonReader.leerCochesJSON(ruta);

		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);

		assertEquals(primero, coches[0]);
		assertTrue(primero.equals(coches[0]));
		assertTrue(coches[0].equals(primero));
	}
	*/
	
	@ParameterizedTest
	@CsvSource({"data/coches.json, Toyota, Corolla, 2022, 22000",
				"data/cochesNuevo.json, Chevrolet, Camaro, 2023, 52000",
				"data/Nuevo2.json, Honda, Civic, 2022, 25000",
				"data/Nuevo3.json, Ford, Mustang, 2021, 45000"})
	void testLeerCochesJSONprimero(String ruta, String marca, String modelo, int anio, int precio) {

		Coche[] coches = JsonReader.leerCochesJSON(ruta);

		Coche primero = new Coche (marca, modelo, anio, precio);

		assertEquals(primero, coches[0]);
		assertTrue(primero.equals(coches[0]));
		assertTrue(coches[0].equals(primero));
	}

	@Test
	void testObjectNotNull() {

		JsonReader jsonReader = new JsonReader();

		assertNotEquals(jsonReader, null);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"data/automoviles.json", "data/autos.json", "data/carros.json"})
	void testExcepcionLeerCochesJSON(String rutaMala) {

		assertDoesNotThrow(() -> JsonReader.leerCochesJSON(rutaMala));
	}

}
