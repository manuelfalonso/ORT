/*
 * Escrib� la funci�n booleana esMultiplo(int num1, int num2) 
 * que recibir� dos enteros y devolver� verdadero cuando el primero 
 * sea m�ltiplo de segundo (de lo contrario, devolver� falso). 
 * Para saber si un n�mero es m�ltiplo de otro utiliz� el operador % (m�dulo), 
 * que devuelve el resto de la divisi�n. Prob� la funci�n desde el main con los lotes de datos (5, 3) y (15, 3).
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
