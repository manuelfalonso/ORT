/*
 * Realizar un programa que muestre los n�meros del 1 al 100 utilizando la instrucci�n while
 */

package Ejercicios;

public class Ejercicio02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 1;
		
		final int TOPE = 100;
		
		while (num <= TOPE) {
			System.out.print(num + " ");
			num++;
		}
	}

}
