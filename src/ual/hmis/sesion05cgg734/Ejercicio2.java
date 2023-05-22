package ual.hmis.sesion05cgg734;

public class Ejercicio2 {
	
	public boolean login(String username, String password) {
		
	    // Comprobar que sean distintos de vacío
		if (username.isEmpty() || password.isEmpty()) {
	        return false;
	    }
	    // Comprobar que la longitud sea < 30
	    else if (username.length() > 30 || password.length() > 30) {
	        return false;
	    }
	    // Comprobar que contiene una mayúscula, minúscula y dígito
	    else if (contieneMayusculaMinusculaDigito(password)) {
	    	return true;
	    }
	    else
	    	return compruebaLoginEnBD(username, password);
	}
	
	public boolean contieneMayusculaMinusculaDigito(String password) {
	    boolean contieneMayuscula = false;
	    boolean contieneMinuscula = false;
	    boolean contieneDigito = false;

	    for (int i = 0; i < password.length(); i++) {
	        char c = password.charAt(i);

	        if (Character.isUpperCase(c)) {
	            contieneMayuscula = true;
	        } else if (Character.isLowerCase(c)) {
	            contieneMinuscula = true;
	        } else if (Character.isDigit(c)) {
	            contieneDigito = true;
	        }
	        

	        // Si ya se cumple la condición de tener una mayúscula, una minúscula y un dígito, podemos salir del bucle
	        if (contieneMayuscula && contieneMinuscula && contieneDigito) {
	            break;
	        }
	    }

	    return contieneMayuscula && contieneMinuscula && contieneDigito;
	}

	public boolean compruebaLoginEnBD(String username, String password) {
		// método mock (simulado)
		if (username.equals("user") && password.equals("pass"))
			return true;
		else
			return false;
	}

}
