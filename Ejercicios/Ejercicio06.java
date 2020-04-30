/*
 * Realizá un programa en el cual se pida el nombre y el promedio de 10 alumnos.
Al finalizar, debe mostrar por pantalla el nombre y el promedio del mejor.
 */

package Ejercicios;

import java.util.Scanner;

public class Ejercicio06 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nombre, nombreMejor;
		double promedio, promedioMejor;
		
		final int CANTIDAD_ALUMNOS = 10;
		
		promedioMejor = 0;
		nombreMejor = "nadie";
		
		for (int i = 1; i < CANTIDAD_ALUMNOS; i++) {
			System.out.println("Ingrese nombre de alumno " + i + ":");
			nombre = input.nextLine();
			System.out.println("Ingrese promedio:");
			promedio = Double.parseDouble(input.nextLine());
			
			if (promedio > promedioMejor) {
				promedioMejor = promedio;
				nombreMejor = nombre;
			}
		}
		
		System.out.println("El primer mejor promedio fue " + promedioMejor + " del alumno " + nombreMejor);
		
		input.close();
	}

}
