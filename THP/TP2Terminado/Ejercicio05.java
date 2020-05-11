/*
 * Realizá un programa que lea una serie de números ingresados por el usuario mientras que el
promedio entre todos sea menor a 20. Informar la cantidad de valores leídos.
 */

package Ejercicios;

import java.util.Scanner;

public class Ejercicio05 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double numero, sumatoria = 0;
		int cantidadNumeros = 0;
		boolean promedioMenor;
		
		final int LIMITE = 20;
		
		do {
			System.out.println("Ingrese numero hasta superar " + LIMITE + " en valor promedio");
			numero = Integer.parseInt(input.nextLine());
			
			cantidadNumeros++;
			sumatoria = sumatoria + numero;
			promedioMenor = (sumatoria / cantidadNumeros) < LIMITE;
		} while (promedioMenor);
		
		System.out.println("La cantidad de numeros ingresados fue:" + cantidadNumeros + " y el promedio:" + sumatoria / cantidadNumeros);
		
		input.close();
	}

}
