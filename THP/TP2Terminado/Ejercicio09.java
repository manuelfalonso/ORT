/*
 * Realizar un programa que le pida al usuario que ingrese 5 veces 3 valores enteros cada vez. Emití el promedio 
 * de cada grupo.
 */

package Ejercicios;

import java.util.Scanner;

public class Ejercicio09 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numero1, numero2, numero3, total;
		final int CANTIDAD_NUMEROS, CANTIDAD_CICLOS;
		
		CANTIDAD_NUMEROS = 3;
		CANTIDAD_CICLOS = 5;
		
		System.out.println("Ingrese 3 valores para calcular su promedio 5 veces:");
		for (int i = 0; i < CANTIDAD_CICLOS; i++) {
			System.out.println("Tanda: " + (i + 1));
			numero1 = ingresaEntero("Ingrese 1er valor:");
			numero2 = ingresaEntero("Ingrese 2do valor:");
			numero3 = ingresaEntero("Ingrese 3er valor:");
			total = numero1 + numero2 + numero3;
			System.out.println("Su promedio es " + calcularPromedio(total, CANTIDAD_NUMEROS));
		}
	}
	
	public static int ingresaEntero(String mensaje) {
		int numero;
		System.out.println(mensaje);
		numero = Integer.parseInt(input.nextLine());
		return numero;
	}
	
	public static double calcularPromedio(int total, int cantidad) {
		double resultado;
		resultado = total / cantidad;
		return resultado;
	}

}
