/*
 * Realizá un programa que al ingresar dos números enteros positivos llamados A y B se calcule el
producto de éstos a través de sumas sucesivas. Por ejemplo, si los números son 4 y 2, hacer 4 + 4; si
son 5 y 3, hacer 5 + 5 + 5.
¿Qué pasa si la diferencia entre los dos números es muy grande? ¿Influye cuál se usa para sumar y
cuál para contar la cantidad de sumas hechas?
 */

package Ejercicios;

import java.util.Scanner;

public class Ejercicio11 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numero1, numero2;
		
		System.out.println("Ingrese dos numeros para calcular su multiplicacion:");
		numero1 = ingresaEnteroPositivo("Ingrese 1er numero:");
		numero2 = ingresaEnteroPositivo("Ingrese 2do numero:");
		
		System.out.println(calcularProductoConSumas(numero1, numero2));
		//RTA: Para hacer mas optimo el programa conviene iniciar el FOR con el valor mas chico para evitar tantos ciclos.
		//System.out.println(calcularProductoOptimizadoConSumas(numero1, numero2));
				
		input.close();
	}

	public static int ingresaEnteroPositivo(String mensaje) {
		int numero;
		System.out.println(mensaje);
		numero = Integer.parseInt(input.nextLine());
		while (numero <= 0) {
			System.out.println("ERROR. " + mensaje);
			numero = Integer.parseInt(input.nextLine());
		}
		return numero;
	}

	public static int calcularProductoConSumas(int num1, int num2) {
		int resultado;
		resultado = num1;

		for (int i = 0; i < (num2-1); i++) {
			resultado = resultado + num1;
		}
		return resultado;
	}
	
	public static int calcularProductoOptimizadoConSumas(int num1, int num2) {
		int resultado;
		resultado = num1;
		
		if (num1 < num2) {
			for (int i = 0; i < (num2-1); i++) {
				resultado = resultado + num1;
			}
		} else {
			for (int i = 0; i < (num1-1); i++) {
				resultado = resultado + num2;
			}
		}
		
		for (int i = 0; i < (num2-1); i++) {
			resultado = resultado + num1;
		}
		return resultado;
	}
}