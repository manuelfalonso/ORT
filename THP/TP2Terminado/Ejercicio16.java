/*
 * Una empresa de catering nos pide desarrollar un programa para calcular el precio que tendr� que
cobrar a sus clientes seg�n el men� elegido por los invitados de cada fiesta.
Las alternativas de cubierto ofrecidas y sus precios por persona son (poner como constantes) :
Opci�n 1. Men� cl�sico $300
Opci�n 2. Men� para cel�acos $310
Opci�n 3. Men� Kosher $430
Opci�n 4. Menu Light $290
A su vez, tenemos que tener en cuenta que se cobra $30 por persona para cubrir las bebidas,
indistintamente del men� elegido.
Al comenzar el programa, se le preguntar� al usuario si desea calcular el precio total del catering para
su fiesta (s/n - Validar). En caso afirmativo, se le solicitar� al usuario que ingrese la cantidad de invitados
total (validar que sea mayor a 0).
Una vez ingresada esa informaci�n, se le pedir� que ingres� el tipo de men�
(cl�sico/celiaco/kosher/light/fin - Validar) para luego cargar la cantidad de invitados que eligieron ese
cubierto. Estos dos datos se le pedir�n hasta que en el tipo de men� ingrese �fin�.
Una vez finalizado el ingreso de datos, se mostrar� por pantalla un resumen detallando lo ingresado y
el costo final calculado.

Obs: validar que concuerde la cantidad total de invitados y la cantidad total de Menues pedidos.
Recuerde modularizar haciendo uso de las funciones, utilizar constantes, realizar validaciones y ser
prolijo en el c�digo.
 */
package Ejercicios;

import java.util.Scanner;

public class Ejercicio16 {
	
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char ingresar;
		int cantidadInvitados, cantidadMenu, cantidadMenuTotal, costoFinal;
		int cantidadMenu1, cantidadMenu2, cantidadMenu3, cantidadMenu4;
		int sumaTotalMenu1, sumaTotalMenu2, sumaTotalMenu3, sumaTotalMenu4, sumaTotalBebidas;
		String menu;
		
		cantidadMenuTotal = 0;
		costoFinal = 0;
		cantidadInvitados = 0;
		cantidadMenu1 = 0;
		cantidadMenu2 = 0;
		cantidadMenu3 = 0;
		cantidadMenu4 = 0;
		sumaTotalMenu1 = 0;
		sumaTotalMenu2 = 0;
		sumaTotalMenu3 = 0;
		sumaTotalMenu4 = 0;
		sumaTotalBebidas = 0;
		
		final int MENU1, MENU2, MENU3, MENU4, ADICIONAL_BEBIDAS;
		
		MENU1 = 300;
		MENU2 = 310;
		MENU3 = 430;
		MENU4 = 290;
		ADICIONAL_BEBIDAS = 30;
		
		ingresar = ingresaCaracterValido("�Desea calcular el precio total del catering de su fiesta [S/N]?");
		if (ingresar == 'S') {
			cantidadInvitados = ingresaEnteroPositivo("Ingrese cantidad de invitados:");
			menu = ingresaCadenaValida("Ingrese Menu [CLASICO/CELIACO/KOSHER/LIGHT/FIN para terminar]");
			while (!menu.equalsIgnoreCase("FIN")) {
				cantidadMenu = ingresaEnteroEntre("Ingrese cantidad de invitados que eligieron ese cubierto:", 0, cantidadInvitados - cantidadMenuTotal);
				switch (menu.toUpperCase()) {
				case "CLASICO":
					cantidadMenu1 = cantidadMenu1 + cantidadMenu;
					sumaTotalMenu1 = sumaTotalMenu1 + cantidadMenu * MENU1;
					sumaTotalBebidas = sumaTotalBebidas + cantidadMenu * ADICIONAL_BEBIDAS;
					costoFinal = costoFinal + cantidadMenu * MENU1 + cantidadMenu * ADICIONAL_BEBIDAS;
					//System.out.println(sumaTotalMenu1 + "+" + sumaTotalBebidas + "=" + costoFinal);
					break;
				case "CELIACO":
					cantidadMenu2 = cantidadMenu2 + cantidadMenu;
					sumaTotalMenu2 = sumaTotalMenu2 + cantidadMenu * MENU2;
					sumaTotalBebidas = sumaTotalBebidas + cantidadMenu * ADICIONAL_BEBIDAS;
					costoFinal = costoFinal + cantidadMenu * MENU2 + cantidadMenu * ADICIONAL_BEBIDAS;
					//System.out.println(sumaTotalMenu2 + "+" + sumaTotalBebidas + "=" + costoFinal);
					break;
				case "KOSHER":
					cantidadMenu3 = cantidadMenu3 + cantidadMenu;
					sumaTotalMenu3 = sumaTotalMenu3 + cantidadMenu * MENU3;
					sumaTotalBebidas = sumaTotalBebidas + cantidadMenu * ADICIONAL_BEBIDAS;
					costoFinal = costoFinal + cantidadMenu * MENU3 + cantidadMenu * ADICIONAL_BEBIDAS;
					//System.out.println(sumaTotalMenu3 + "+" + sumaTotalBebidas + "=" + costoFinal);
					break;
				case "LIGHT":
					cantidadMenu4 = cantidadMenu4 + cantidadMenu;
					sumaTotalMenu4 = sumaTotalMenu4 + cantidadMenu * MENU4;
					sumaTotalBebidas = sumaTotalBebidas + cantidadMenu * ADICIONAL_BEBIDAS;
					costoFinal = costoFinal + cantidadMenu * MENU4 + cantidadMenu * ADICIONAL_BEBIDAS;
					//System.out.println(sumaTotalMenu4 + "+" + sumaTotalBebidas + "=" + costoFinal);
					break;
				}
				cantidadMenuTotal = cantidadMenuTotal + cantidadMenu;

				menu = ingresaCadenaValida("Ingrese Menu [CLASICO/CELIACO/KOSHER/LIGHT/FIN para terminar]");				
			}
		}
		
		if (cantidadInvitados == 0) {
			System.out.println("Decidio no calcular el precio total de catering.");
		} else {
			mostrarResultados(cantidadMenu1, cantidadMenu2, cantidadMenu3, cantidadMenu4, 
					sumaTotalMenu1, sumaTotalMenu2, sumaTotalMenu3, sumaTotalMenu4, sumaTotalBebidas,
					costoFinal, cantidadInvitados);
		}
		
		input.close();
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
		return caracterAValidar == 'S' || caracterAValidar == 'N';
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
	
	public static void mostrarResultados(int cantidadMenu1, int cantidadMenu2, int cantidadMenu3, int cantidadMenu4, 
			int sumaTotalMenu1, int sumaTotalMenu2, int sumaTotalMenu3, int sumaTotalMenu4, int sumaTotalBebidas, 
			int costoFinal, int cantidadInvitados) {
		System.out.println("Usted ha invitado " + cantidadInvitados + " personas.");
		System.out.println("Opci�n 1. Men� cl�sico $300:");
		System.out.println("  Cantidad: " + cantidadMenu1);
		System.out.println("  Valor subTotal: $" + sumaTotalMenu1);
		System.out.println("Opci�n 2. Men� para cel�acos $310:");
		System.out.println("  Cantidad: " + cantidadMenu2);
		System.out.println("  Valor subTotal: $" + sumaTotalMenu2);
		System.out.println("Opci�n 3. Men� Kosher $430:");
		System.out.println("  Cantidad: " + cantidadMenu3);
		System.out.println("  Valor subTotal: $" + sumaTotalMenu3);
		System.out.println("Opci�n 4. Menu Light $290:");
		System.out.println("  Cantidad: " + cantidadMenu4);
		System.out.println("  Valor subTotal: $" + sumaTotalMenu4);
		System.out.println("El costo de comida es de $" + (sumaTotalMenu1 + sumaTotalMenu2 + sumaTotalMenu3 + sumaTotalMenu4));
		System.out.println("El costo de bebida es de $" + sumaTotalBebidas);
		System.out.println("El costo total es de $" + costoFinal);
	}
}
