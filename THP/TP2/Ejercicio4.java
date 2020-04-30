/*
 * Realizar un programa en el cual se pida al usuario el ingreso de dos n�meros enteros num1 y num2,
cuya relaci�n de valores es que el primero es menor o igual al segundo y mostrar por pantalla la
secuencia de n�meros que existe entre ambos:
a) Incluy�ndolos;
b) Excluy�ndolos.
Obs: Validar que el primer n�mero sea menor o igual al segundo. Pedir el ingreso de ambos n�meros
las veces que sea necesario hasta que se cumpla dicha condici�n.
�Qu� pasar�a si esta validaci�n no la realiz�ramos y el ingreso es incorrecto? 
 */

package Ejercicios;

import java.util.Scanner;

public class Ejercicio4 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1, num2, aux;
		
		System.out.println("Ingrese valor de numero 1:");
		num1 = Integer.parseInt(input.nextLine());
		do {
			System.out.println("Ingrese valor de numero 2 (debe ser mayor o igual al primero):");
			num2 = Integer.parseInt(input.nextLine());
		} while (num1 > num2);
		
		aux = num1;
		
		System.out.println("Secuencia de numeros incluyendolos:");
		while (num1 <= num2) {
			System.out.println(num1);
			num1++;
		}
		
		System.out.println("Secuencia de numeros excluyendolos:");
		num1 = aux;
		num1++;
		while (num1 < num2) {
			System.out.println(num1);
			num1++;
		}
		
		input.close();
	}

}
