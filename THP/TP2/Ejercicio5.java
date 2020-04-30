/*
 * Realizá un programa que lea una serie de números ingresados por el usuario mientras que el
promedio entre todos sea menor a 20. Informar la cantidad de valores leídos.
 */

package Ejercicios;

import java.util.Scanner;

public class Ejercicio5 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double numero, sumatoria = 0;
		int cantidadNumeros = 0;
		boolean menorA20;
		
		do {
			System.out.println("Ingrese numero hasta superar 20 en valor promedio");
			numero = Integer.parseInt(input.nextLine());
			
			cantidadNumeros++;
			sumatoria = sumatoria + numero;
			menorA20 = (sumatoria / cantidadNumeros) < 20;
					
			/*System.out.println(sumatoria / cantidadNumeros);
			System.out.println(sumatoria);*/
		} while (menorA20);
		
		System.out.println("La cantidad de numeros ingresados fue:" + cantidadNumeros + " y el promedio:" + sumatoria / cantidadNumeros);
		
		input.close();
	}

}
