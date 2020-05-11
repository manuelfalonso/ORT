/*
 * Una empresa de telefonía nos pide escribir un programa que le brinde información sobre el
consumo de sus clientes residenciales. Para ello se ingresa, por cada una de las llamadas realizadas
en el último mes:
- Código de Cliente (int de 5 dígitos, entre 10001 y 99999, 0 = fin)
- Duración de la llamada nro. (int > 0).
- Tipo de abono (“a”, “b” o “c”).
Para calcular el importe de cada llamada, nos informan que el costo por minuto, de acuerdo al tipo de
abono, es el siguiente:
- Abono “a” => $2 el minuto
- Abono “b” => Hasta 5 minutos, $2 el minuto; Más de 5 minutos, $1,5 el minuto.
- Abono “c” => $1 el minuto con un máximo de $10 (Ej. si habla 15 minutos paga $10).
Se pide informar:
1. El importe acumulado a recaudar por cada tipo de abono.
2. La cantidad de minutos de la llamada más larga.
3. La cantidad de llamadas de menos de 6 minutos.
4. El precio promedio por llamada.
 */
package Ejercicios;

import java.util.Scanner;

public class Ejercicio15 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int codCli, dur, durMax, contMinTope, contLlam;
		String tipo;
		double acumA, acumB, acumC, acumTotal, prom;
		
		final int TOPE_MINUTOS;
		
		acumA = 0;
		acumB = 0;
		acumC = 0;
		
		durMax = 0;
		contLlam = 0;
		contMinTope = 0;

		TOPE_MINUTOS = 6;
		
		codCli = ingresarCodigoCliente();
		
		while (codCli != 0) {
			dur = ingresarDuracion();
			tipo = ingresarTipoAbono();
			
			switch (tipo) {
			case "A": acumA = acumA + calcularImporteA(dur);
			break;
			case "B": acumB = acumB + calcularImporteB(dur);
			break;
			case "C": acumC = acumC + calcularImporteC(dur);
			break;
			}
			
			durMax = compararMax(dur, durMax);
			contMinTope = contMinTope + contarMenoresTope(dur, TOPE_MINUTOS);
			contLlam = contLlam + 1;
			
			codCli = ingresarCodigoCliente();
		}
		
		acumTotal = acumA + acumB + acumC;
		prom = calcularProm(acumTotal, contLlam);

		mostrarResultados(acumA, acumB, acumC, durMax, contMinTope, prom, contLlam);
		
		input.close();
	}
		
	public static int ingresarCodigoCliente(){
		int codCli;
		do {
			System.out.println("Ingrese el codigo de cliente");
			codCli = Integer.parseInt(input.nextLine());
		} while (!esClienteValido(codCli));
		return codCli;
	}
	
	public static boolean esClienteValido(int codCli) {
		boolean esValido;
		final int MIN, MAX;
		MIN = 10001;
		MAX = 99999;
		
		esValido = ((codCli >= MIN && codCli <= MAX) || codCli == 0);
		return esValido;
	}

	public static int ingresarDuracion() {
		int duracion;
		System.out.println("Ingresa la duración de la llamada");
		duracion = Integer.parseInt(input.nextLine());
		while (duracion <= 0) {
			System.out.println("la duración tiene que ser mayor a 0");
			System.out.println("Ingresa la duración de la llamada");
			duracion = Integer.parseInt(input.nextLine());
		}
		return duracion;
	}

	public static String ingresarTipoAbono() {
		String tipoAbono;
		do {
			System.out.println("Ingrese el tipo de abono [A/B/C]");
			tipoAbono = input.nextLine();
			tipoAbono = tipoAbono.toUpperCase();
		} while (!esTipoValido(tipoAbono));
		return tipoAbono;
	}
	
	public static boolean esTipoValido(String tipo) {
		return tipo.equalsIgnoreCase("A")  || tipo.equalsIgnoreCase("B") || tipo.equalsIgnoreCase("C");
	}
	
	public static double calcularImporteA(int duracion) {
		final double VALOR_MIN;
		double importe;
		VALOR_MIN = 2;
		importe = duracion * VALOR_MIN;
		return importe;
	}
	
	public static double calcularImporteB(int duracion) {
		double importe, resto;
		final int TOPE_MINUTOS;
		final double VALOR_BASE, VALOR_ADICIONAL;
		
		TOPE_MINUTOS = 5;
		VALOR_BASE = 2;
		VALOR_ADICIONAL = 1.5;
		
		if (duracion <= TOPE_MINUTOS) {
			importe = duracion * VALOR_BASE;
		} else {
			resto = duracion - TOPE_MINUTOS;
			importe = (TOPE_MINUTOS * VALOR_BASE) + (resto * VALOR_ADICIONAL);
		}
		return importe;
	}
	
	public static double calcularImporteC(int duracion) {
		double importe;
		final double MAXIMO_IMPORTE, VALOR_MINUTO;
		
		MAXIMO_IMPORTE = 10;
		VALOR_MINUTO = 1;
		
		importe = VALOR_MINUTO * duracion;
		
		if (importe > MAXIMO_IMPORTE) {
			importe = MAXIMO_IMPORTE;
		}
		return importe;
	}

	public static int compararMax(int num1, int num2) {
		int max;
		
		if (num1 > num2) {
			max = num1;
		} else {
			max = num2;
		}
		return max;
	}
	
	public static double calcularProm(double suma, int cant) {
		double prom;
		prom = 0;
		if (cant != 0) {
			prom = suma / cant;
		}
		return prom;
	}
	
	public static void mostrarResultados(double acumA, double acumB, double acumC, int durMax, int contMinTope, double prom, int contLlam) {
		if (contLlam == 0) {
			System.out.println("No hubo llamados");
		} else {
			System.out.println("El importe acumulado para el tipo A es: $" + acumA);
			System.out.println("El importe acumulado para el tipo B es: $" + acumB);
			System.out.println("El importe acumulado para el tipo C es: $" + acumC);
			System.out.println();
			System.out.println("La llamada más larga duró " + durMax + " minutos");
			System.out.println();
			System.out.println("La cantidad de llamadas de menos de 6 minutos es de: " + contMinTope);
			System.out.println();
			System.out.println("El precio promedio por llamada es de: $" + prom);
		}
	}
	
	public static int contarMenoresTope(int duracion, int tope) {
		int cont;
		if (duracion < tope){
			cont = 1;
		} else {
			cont = 0;
		}
		return cont;
	}
}
