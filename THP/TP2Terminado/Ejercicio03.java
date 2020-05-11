/*
 *  Realizar un programa que muestre los números del 1 al 100 utilizando la instrucción do while
 */

package Ejercicios;

public class Ejercicio03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 1;
		
		final int TOPE = 100;
		
		do {
			System.out.println(num);
			num++;
		} while (num <= TOPE);
	}

}
