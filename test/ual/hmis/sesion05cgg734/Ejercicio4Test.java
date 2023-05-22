package ual.hmis.sesion05cgg734;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class Ejercicio4Test {

//	@ParameterizedTest
//    @CsvFileSource(resources = "data/datos_diagonales.csv", numLinesToSkip = 1)
//    void testObtenerDiagonales(int[][] matriz, int[][] expected) {
//		Ejercicio4 ejer = new Ejercicio4();
//        int[][] actual = ejer.obtenerDiagonales(matriz);
//        assertArrayEquals(expected, actual);
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "data/datos_suma_columnas.csv", numLinesToSkip = 1)
//    void testSumarColumnas(double[][] matriz, double[] expected) {
//    	
//        double[] actual = sumarColumnas(matriz);
//        assertArrayEquals(expected, actual);
//    }
	
	double[][] darFormatoMatriz(String matrizCSV, int tipoDiagonal) {

        String[] elementos = matrizCSV.split(", ");
        int n, m;
        
        if (tipoDiagonal == 0) {
        	n = m = (int) Math.sqrt(elementos.length);
        } else {
        	n = 2;
        	m = elementos.length / 2;
        }
        
        double[][] matriz = new double[n][m];

        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matriz[i][j] = Double.parseDouble(elementos[index++]);
            }
        }
        
        return matriz;
	}
	
	@Test
	void claseEjercicio4(){
		Ejercicio4 ejer = new Ejercicio4();
		assertNotEquals(ejer, null);
	}

	@ParameterizedTest
	@CsvFileSource(files = "data/matriz-enteros.csv")
	void testObtenerDiagonales(String matricesCSV) {

		String[] arrayMatricesCSV = matricesCSV.split("; ");

		double[][] matriz = darFormatoMatriz(arrayMatricesCSV[0], 0);
		double[][] diagonales = darFormatoMatriz(arrayMatricesCSV[1], 1);

		assertArrayEquals(diagonales, Ejercicio4.obtenerDiagonales(matriz));
	}
	
	@ParameterizedTest
	@CsvFileSource(files = "data/matriz-enteros.csv")
	void testSumarColumnas(String matricesCSV) {

		String[] arrayMatricesCSV = matricesCSV.split("; ");

		double[][] matriz = darFormatoMatriz(arrayMatricesCSV[0], 0);

        String[] elementos = arrayMatricesCSV[2].split(", ");
		double[] resultado = new double[elementos.length];

        for (int i = 0; i < elementos.length; i++) {
			resultado[i] = Double.parseDouble(elementos[i]);
		}

		assertArrayEquals(resultado, Ejercicio4.sumarColumnas(matriz));
	}
    
//    @ParameterizedTest
//    @CsvSource({
//        "1.1; 2.2; 3.3; 4.4; 5.5, 1.1; 2.2; 3.3; 4.4; 5.5, 16.5",
//        "0.5; 1.5; 2.5; 3.5, 0.5; 1.5; 2.5; 3.5, 8.0"
//    })
//    void testSumarColumnas(double[][] matriz, double[] expectedSumaColumnas) {
//    	Ejercicio4 ejer = new Ejercicio4();
//        double[] actualSumaColumnas = ejer.sumarColumnas(matriz);
//        assertArrayEquals(expectedSumaColumnas, actualSumaColumnas);
//    }

}
