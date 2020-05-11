package Ejercicios;

import java.util.Scanner;

public class FuncionesUtiles {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//CALCULOS

	public static double cacularPorcentaje(int n1, int n2){
		double porcentaje = 0;
		if (n2 != 0){
			porcentaje = n1 * 100 / n2;
		} 
		return porcentaje;
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
	
	public static double calcularPromedio(int total, int cantidad) {
		return total / cantidad;
	}
	
	public static double calcularPromedioDouble(double total, int cantidad) {
		return total / cantidad;
	}
	
	public static int calcularMinimo(int num1, int num2) {
		int minimo;
		if (num1 < num2) {
			minimo = num1;
		} else {
			minimo = num2;
		}
		return minimo;
	}
	
	public static int calcularMaximo(int num1, int num2) {
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	//INGRESO DE DATOS
	
	public static int ingresaEntero(String mensaje) {
		int numero;
		System.out.println(mensaje);
		numero = Integer.parseInt(input.nextLine());
		return numero;
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
	
	public static int ingresaEnteroEntre(String mensaje, int minimo, int maximo) {
		int numero;
		System.out.println(mensaje);
		numero = Integer.parseInt(input.nextLine());
		while (numero < minimo || numero > maximo) {
			System.out.println("ERROR. " + mensaje);
			numero = Integer.parseInt(input.nextLine());
		}
		return numero;
	}
	
	public static char ingresaCaracterValido(String mensaje) {
		char caracter;
		String ingreso;
		System.out.println(mensaje);
		ingreso = input.nextLine();
		ingreso = ingreso.toUpperCase();
		caracter = ingreso.charAt(0);
		while (!caracteresValidos(caracter)) {
			System.out.println("ERROR. " + mensaje);
			ingreso = input.nextLine();
			ingreso = ingreso.toUpperCase();
			caracter = ingreso.charAt(0);
		}
		return caracter;
	}
	
	public static boolean caracteresValidos(char caracterAValidar) {
		return caracterAValidar == '+' || caracterAValidar == '-' || caracterAValidar == '*' || caracterAValidar == '/' || caracterAValidar == 'f';
	}
	
	public static String ingresaCadena(String mensaje) {
		System.out.println(mensaje);
		return input.nextLine();
	}
	
	public static String ingresaCadenaValida(String mensaje) {
		String cadena;
		System.out.println(mensaje);
		cadena = input.nextLine();
		//cadena = cadena.toUpperCase();
		while (!cadenaValidas(cadena.toUpperCase())) {
			System.out.println(mensaje);
			cadena = input.nextLine();
			//cadena = cadena.toUpperCase();
		}
		return cadena;
	}
	
	public static boolean cadenaValidas(String cadenaAValidar) {
		return cadenaAValidar.equalsIgnoreCase("CLASICO") || cadenaAValidar.equalsIgnoreCase("CELIACO") || cadenaAValidar.equalsIgnoreCase("KOSHER") || cadenaAValidar.equalsIgnoreCase("LIGHT") || cadenaAValidar.equalsIgnoreCase("FIN");
	}
}
