/*
 * 1) Crear una funcion que calcule el procentaje entre dos numeros entero, la misma debe recibir el valor parcial y el total.
public static (tipo de datos) porcentaje ( int n1, int n2) DEVUELVE, no muestra, el procentaje de que representa n1 en n2
por ejemplo, si n1 es 3 y n2 es 10, la funcion debe devolver 30
Deben hacer el main y llamar a dicha funcion correctamente
 */
package Ejercicios;

import java.util.Scanner;

public class EjercicioPracticarCalcularPorcentaje {
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numero1, numero2;
		
		System.out.println("Ingrese dos valores para calcular porcentaje:");
		numero1 = ingresaEntero("Ingrese 1er valor:");
		numero2 = ingresaEntero("Ingrese 2do valor:");
		System.out.println("El porcentaje del 1er numero sobre el segundo es: %" + porcentaje(numero1, numero2));
		input.close();
	}
	
	public static int ingresaEntero(String mensaje) {
		int numero;
		System.out.println(mensaje);
		numero = Integer.parseInt(input.nextLine());
		return numero;
	}
	
	public static double porcentaje(int n1, int n2){
		double porcentaje;
		if (n2 == 0){
			porcentaje = 0;
		} else {
			porcentaje = n1 * 100 / n2;			
		}
		return porcentaje;
	}
}
