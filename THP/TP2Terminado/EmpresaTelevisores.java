/*
 * La empresa ORTTV vende televisores de diferentes caracteristicas
		LED y SMART de 32,40 y 50 pulgadas
		Debemos registrar las ventas de la siguiente manera
		Ingresamos Tipo de TV (LED-SMART-FIN)
		y a menos que pongamos FIN
		- Pedimos las pulgadas (32,40,50)
		el precio  de cada tv se calculas asi
		SMART = $500 por pulgada
		LED = $300 por pulgada

		Informar el precio de cada TV
		Al finalizar informar	
		Importe recaudado
		Porcentaje de LED vendidos
		Porcentaje de SMART vendidos
 */
package Ejercicios;

import java.util.Scanner;

public class EmpresaTelevisores {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tipoTv;
		int pulgadas;
		double precio;
		
		double totalVentas;
		int cantidadVentas;
		int cantidadLed;
		int cantidadSmart;
		
		final int SMART_COSTO_PULGADA;
		final int LED_COSTO_PULGADA;
		SMART_COSTO_PULGADA = 500;
		LED_COSTO_PULGADA = 300;
		
		totalVentas = 0;
		cantidadVentas = 0;
		cantidadLed = 0;
		cantidadSmart = 0;
		
		//Ingresar Tipo de TV (LED-SMART-FIN)
		tipoTv = ingresarTipoTV("Ingrese tipo de TV vendido [LED/SMART/FIN(para terminar)]:");
		
		//Terminar con FIN
		while (!tipoTv.equalsIgnoreCase("FIN")) {
			//Pedir pulgadas (32,40,50)
			pulgadas = solicitarPulgadas("Ingrese pulgadas [32/40/50]:");
			//Cantidad ventas
			cantidadVentas = cantidadVentas + 1;
			//Cantidad Tipo TV
			if (tipoTv.equalsIgnoreCase("SMART")) {
				//cantidadSmart = cantidadSmart + 1;
				cantidadSmart++;
				precio = calcularPrecio(pulgadas, SMART_COSTO_PULGADA);
			} else {
				//cantidadLed = cantidadLed + 1;
				cantidadLed++;
				precio = calcularPrecio(pulgadas, LED_COSTO_PULGADA);
			}
			//Mostrar precio SMART = $500 por pulgada y LED = $300 por pulgada
			//precio = calcularPrecio(tipoTv, pulgadas, SMART_COSTO_PULGADA, LED_COSTO_PULGADA);
			System.out.println("El precio del televisor es: $" + precio);
			//Importe recaudado
			totalVentas = totalVentas + precio;
			//Ingresar Tipo de TV (LED-SMART-FIN)
			tipoTv = ingresarTipoTV("Ingrese tipo de TV vendido [LED/SMART/FIN(para terminar)]:");
		}
		
		//MOSTRAR
		//Importe recaudado
		//Porcentaje de LED vendidos
		//Porcentaje de SMART vendidos
		mostrarResultados(totalVentas, cantidadVentas, cantidadLed, cantidadSmart);
	}
	
	public static String ingresarTipoTV(String mensaje) {
		String tipoTv;
		System.out.println(mensaje);
		tipoTv = input.nextLine();
		while (!validaTipoTv(tipoTv)) {
			System.out.println("ERROR. " + mensaje);
			tipoTv = input.nextLine();
		}
		return tipoTv;
	}
	
	public static boolean validaTipoTv(String tipoTv) {
		/*boolean valido;
		if (tipoTv.equalsIgnoreCase("LED") || tipoTv.equalsIgnoreCase("SMART") || tipoTv.equalsIgnoreCase("FIN")){
			valido = true;
		} else {
			valido = false;
		}
		return valido;*/
		return tipoTv.equalsIgnoreCase("LED") || tipoTv.equalsIgnoreCase("SMART") || tipoTv.equalsIgnoreCase("FIN");
	}

	public static int solicitarPulgadas(String mensaje) {
		int pulg;
		System.out.println(mensaje);
		pulg = Integer.parseInt(input.nextLine());
		while (!validaCantidadPulgadas(pulg)){
			System.out.println("ERROR. " + mensaje);
			pulg = Integer.parseInt(input.nextLine());
		}
		return pulg;
	}
	
	public static boolean validaCantidadPulgadas(int pulg) {
		/*boolean valido;
		if (pulg == 32 || pulg == 40 || pulg == 50){
			valido = true;
		} else {
			valido = false;
		}
		return valido;*/
		return (pulg == 32 || pulg == 40 || pulg == 50);
	}
	
	/*public static double calcularPrecio(String tipo, int tamaño, int pulgadaSmart, int pulgadaLed) {
		double resultado;
		if (tipo.equalsIgnoreCase("SMART")) {
			resultado = pulgadaSmart * tamaño;
		} else {
			resultado = pulgadaLed * tamaño;
		}
		return resultado;
	}*/
	
	public static double calcularPrecio(int tamaño, int valorPulgada) {
		return tamaño * valorPulgada;
	}
	
	public static void mostrarResultados(double ventas, int cantTV, int cantLed, int cantSmart) {
		double porcLed;
		double porcSmart;
		
		porcLed = calcularPorcentaje(cantTV, cantLed);
		porcSmart = calcularPorcentaje(cantTV, cantSmart);
		if (ventas != 0) {
			System.out.println("El total de ventas fue: $" + ventas);
			System.out.println("El porcentaje de Led vendidos fue: %" + porcLed);
			System.out.println("El porcentaje de Smart vendidos fue: %" + porcSmart);
		} else {
			System.out.println("No hubo ventas");
		}

	}
	
	public static double calcularPorcentaje(int total, int parcial) {
		double resultado;
		resultado = parcial * 100 / total;
		return resultado;
	}
}
