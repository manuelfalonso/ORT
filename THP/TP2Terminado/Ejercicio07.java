/*
 * El ingreso a un sitio web se valida por nombre de usuario y contraseña. 
 * Realizar un programa que impida que el usuario ingrese hasta poner los datos correctos. 
 * Si intenta más de 3 veces erróneamente, se debe mostrar el mensaje “Se ha bloqueado su cuenta”, 
 * de lo contrario, mostrar “Ha ingresado correctamente”.
 */

package Ejercicios;

import java.util.Scanner;

public class Ejercicio07 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String usuario, password;
		int intentos = 0;
		
		boolean accesoConcedido = false;
		
		final String USUARIO_CORRECTO = "adminORT";
		final String PASSWORD_CORRECTA = "admin123456";
		final int INTENTOS_MAXIMO = 3;
		
		do {
			System.out.println("Ingrese usuario:");
			usuario = input.nextLine();
			System.out.println("Ingrese password:");
			password = input.nextLine();
		
			accesoConcedido = (usuario.equals(USUARIO_CORRECTO)) && (password.equals(PASSWORD_CORRECTA));
			intentos++;
		} while (!accesoConcedido && intentos < INTENTOS_MAXIMO);
		
		if (accesoConcedido) {
			System.out.println("Ha ingresado correctamente");
		} else {
			System.out.println("Se ha bloqueado su cuenta");
		}
		
		input.close();
	}

}
