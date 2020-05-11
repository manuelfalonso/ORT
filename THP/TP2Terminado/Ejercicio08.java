/*
 * Escribí la función booleana esMultiplo(int num1, int num2) 
 * que recibirá dos enteros y devolverá verdadero cuando el primero 
 * sea múltiplo de segundo (de lo contrario, devolverá falso). 
 * Para saber si un número es múltiplo de otro utilizá el operador % (módulo), 
 * que devuelve el resto de la división. Probá la función desde el main con los lotes de datos (5, 3) y (15, 3).
 */

package Ejercicios;

import java.util.Scanner;

public class Ejercicio08 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("esMultiplo(5,3)" + esMultiplo(5,3));
		System.out.println("esMultiplo(15,3)" + esMultiplo(15,3));
		
		input.close();
	}
	
	public static boolean esMultiplo(int num1, int num2) {
		boolean resultado;
		if (num1 % num2 == 0) {
			resultado = true;
		} else {
			resultado = false;
		}
		return resultado;
	}

}
