/*
 * Realizar un programa en el cual se pida el ingreso de dos n�meros enteros num1 y num2 y el signo
de la operaci�n (�+� para sumar, �-� para restar, �/� para dividir, �*� para multiplicar y �%� para obtener el
resto o m�dulo). Mientras que la operaci�n no sea �f� (de �fin�) aplicar la operaci�n elegida a n1 y n2.
Tener en cuenta que la divisi�n por 0 es imposible. Realizar una funci�n para cada operaci�n, que
reciba por par�metros n1 y n2, y retorne el resultado de hacer la operaci�n entre los dos n�meros.
 */
package Ejercicios;

import java.util.Scanner;

public class Ejercicio12 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		int numero1, numero2;
		double resultado;
		char operador;
		
		operador = ingresaCaracterValido("Ingrese operador para realizar calculo [+ o - o * o / o f (para terminar)]:");
		while (!(operador == 'f')){
			numero1 = ingresaEntero("Ingrese 1er valor:");
			numero2 = ingresaEntero("Ingrese 2do valor:");
					
			resultado = realizarOperacion(numero1, numero2, operador);
			System.out.println("El resultado de: " + numero1 + " " + operador + " " + numero2 + " = " + resultado);
			
			operador = ingresaCaracterValido("Ingrese operador para realizar calculo [+ o - o * o / o f (para terminar)]:");
		}
		
		input.close();
	}

	public static int ingresaEntero(String mensaje) {
		int numero;
		System.out.println(mensaje);
		numero = Integer.parseInt(input.nextLine());
		return numero;
	}
	
	public static char ingresaCaracterValido(String mensaje) {
		char caracter;
		String ingreso;
		
		System.out.println(mensaje);
		ingreso = input.nextLine();
		caracter = ingreso.charAt(0);
		while (!caracteresValidos(caracter)) {
			System.out.println("ERROR. " + mensaje);
			ingreso = input.nextLine();
			caracter = ingreso.charAt(0);
		}
		return caracter;
	}
	
	public static boolean caracteresValidos(char caracterAValidar) {
		return caracterAValidar == '+' || caracterAValidar == '-' || caracterAValidar == '*' || caracterAValidar == '/' || caracterAValidar == 'f';
	}
	
	public static double realizarOperacion(int num1, int num2, char operador) {
		switch (operador) {
		case '+':
			return sumar(num1, num2);
		case '-':
			return  restar(num1, num2);
		case '*':
			return  producto(num1, num2);
		case '/':
			return  dividir(num1, num2);
		default: 
			System.out.println("Operador no valido!!!");
			return  0;
		}
	}
	
	public static double sumar(int num1, int num2) {
		return num1 + num2;
	}
	
	public static double restar(int num1, int num2) {
		return num1 - num2;
	}
	
	public static double producto(int num1, int num2) {
		return num1 * num2;
	}
	
	public static double dividir(int num1, int num2) {
		if (num2 == 0) {
			return 0;
		} else {
			return num1 / num2;
		}
	}
}

