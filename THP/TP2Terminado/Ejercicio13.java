/*
 * Se desea realizar un programa para saber qué prioridad darle a cada materia en cuanto a clases
de apoyo de acuerdo a la necesidad de los alumnos.
Al comenzar el programa, se pedirá la cantidad de alumnos que desea cargar. Luego, por cada alumno,
se pedirá curso (a/b/c/d. Validar), y materia en la cual necesita clase de apoyo
(taller/fundamentos/matemática).
Una vez realizado el ingreso de datos, se deberá mostrar por pantalla cuál fue la materia más requerida
 */
package Ejercicios;

import java.util.Scanner;

public class Ejercicio13 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int cantidadAlumnos, contadorTaller, contadorFundamentos, contadorMatematica;
		char curso;
		String materia, materiaMasRequerida;
		
		contadorTaller = 0;
		contadorFundamentos = 0;
		contadorMatematica = 0;
		
		cantidadAlumnos = ingresaEntero("Ingrese cantidad de alumnos a calcular prioridad clases de apoyo:");
		
		for (int i = 0; i < cantidadAlumnos; i++) {
			curso = ingresaCaracterValido("Ingrese codigo curso [a/b/c/d]:");
			materia = ingresaCadenaValida("Ingrese materia que necsita clase de apoyo:");
			
			switch (materia) {
			case "TALLER":
				contadorTaller++;
				break;
			case "FUNDAMENTOS":
				contadorFundamentos++;
				break;
			case "MATEMATICA":
				contadorMatematica++;
				break;
			}
		}
		materiaMasRequerida = calcularMateriaMasRequerida(contadorTaller, contadorFundamentos, contadorMatematica);
		System.out.println("La materia mas requerida fue " + materiaMasRequerida);
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
		return caracterAValidar == 'a' || caracterAValidar == 'b' || caracterAValidar == 'c' || caracterAValidar == 'd';
	}
	
	public static String ingresaCadenaValida(String mensaje) {
		String cadena;
		System.out.println(mensaje);
		cadena = input.nextLine();
		while (!caendasValidas(cadena)) {
			System.out.println("ERROR. " + mensaje);
			cadena = input.nextLine();
		}
		return cadena.toUpperCase();
	}
	
	public static boolean caendasValidas(String cadena) {
		return cadena.equalsIgnoreCase("taller")  || cadena.equalsIgnoreCase("fundamentos") || cadena.equalsIgnoreCase("matematica");
	}
	
	public static String calcularMateriaMasRequerida(int contTaller, int contFundamentos, int contMatematica) {
		int maximo;
		maximo = calcularMaximo(contTaller, contFundamentos);
		maximo = calcularMaximo(maximo, contMatematica);
		if (maximo == contTaller) {
			return "Taller";
		} else if (maximo == contFundamentos) {
			return "Fundamentos";
		} else {
			return "Matematica";
		}
	}
	
	public static int calcularMaximo(int num1, int num2) {
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}
}
