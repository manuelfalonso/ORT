/*
 * Una casa de empanadas, vende una determinada cantidad 
		 * de empanadas por dia, (Se debe ingresar al principio, mayor a 0) 
		 * Luego procesa las ventas, pidiendo código de cliente (string) y 
		 * cantidad >0 y menor o igual a las empanadas que le van quedando
		 * El ingreso finaliza con el código de cliente "FIN" o empanadas disponibles =0
		 * Puede no haber ventas 
		 * Por cada venta se debe obte 
		 * ner el importe, sabiendo que 
		 * cada empanada vale $50, pero hay descuento
		 * Para eso deben programar una función obtenerDescuento que devuelve 
		 * el % de descuento a aplicar según la cantidad de empanadas de la venta
		 * si se vendieron de 1 a 12 empanadas, devuelve 0
		 * si se vendieron de 13 a 24 empanadas, devuelve 10
		 * si se vendieron mas de 24 empanadas, devuelve 20
		 * El objetivo final del programa es mostrar, cuantas empanadas quedaron
		 * y cual fue la recaudacion. Esto debe realizarse con la funcion mostrar 
		 * que es void  */


package Ejercicios;

import java.util.Scanner;

public class FabricaEmpanadas {

	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int empanadasDisponibles;
		int cantidadVendidas;
		double descuento; //% descuento 
		double importeVenta;
		double recaudacion = 0;
		
		String codigoCliente;
		
		final double PRECIO_EMPANADA = 50;	
		final double DESCUENTO_12 = 0;
		final double DESCUENTO_24 = 10;
		final double DESCUENTO_MAX = 20;
		
		//inicializo empanadas disponibles
		empanadasDisponibles = dameNum("Ingrese stock actual de empanadas:", 1);
		//ingreso cliente
		codigoCliente = pedirString("Ingrese su codigo de cliente [FIN para salir]:");
		//mientras condicion
		while (!codigoCliente.equalsIgnoreCase("FIN") && empanadasDisponibles > 0) {
			//pido cantidad
			cantidadVendidas = dameNumValido("Ingrese la cantidad de empanadas vendidas:", 1, empanadasDisponibles);
			//calculo % descuento
			descuento = obtenerDescuento(cantidadVendidas, DESCUENTO_12, DESCUENTO_24, DESCUENTO_MAX);
			//obtengo precio venta
			importeVenta = cantidadVendidas * PRECIO_EMPANADA;
			importeVenta = importeVenta - (importeVenta * descuento / 100);
			System.out.println("El importe de la venta fue: $" + importeVenta);
			//sumo recaudacion
			recaudacion+=importeVenta;
			//resto empanadas disponibles
			empanadasDisponibles = empanadasDisponibles - cantidadVendidas;
			if(empanadasDisponibles > 0) {
				//ingreso cliente
				codigoCliente = pedirString("Ingrese su codigo de cliente [FIN para salir]:");
			} else {
				System.out.println("Vendimos todooo");
			}
		} //fin mientras
	
		//muestro totales
		mostrarTotales(recaudacion, empanadasDisponibles);
		input.close();
	}
	
	public static int dameNum(String mensaje, int minimo) {
		int resultado;
		System.out.println(mensaje);
		resultado = Integer.parseInt(input.nextLine());
		while (resultado < minimo) {
			System.out.println("ERROR. " + mensaje);
			resultado = Integer.parseInt(input.nextLine());
		}
		return resultado;
	}
	
	public static String pedirString(String mensaje) {
		String resultado;
		System.out.println(mensaje);
		resultado = input.nextLine();
		return resultado;
	}

	public static int dameNumValido(String mensaje, int minimo, int maximo) {
		int resultado;
		System.out.println(mensaje);
		resultado = Integer.parseInt(input.nextLine());
		while (resultado < minimo || resultado > maximo) {
			System.out.println("ERROR. " + mensaje);
			resultado = Integer.parseInt(input.nextLine());
		}
		return resultado;
	}
	
	public static double obtenerDescuento(int cantEmp, double descuento12, double descuento24, double descuentoMax) {
		double valor = 0;
		if (cantEmp <= 12) {
			valor = descuento12;
		} else if (cantEmp <= 24) {
			valor = descuento24;
		} else {
			valor = descuentoMax;
		}
		return valor;
	}
	
	public static void mostrarTotales(double recaudacion, int empDisponibles) {
		System.out.println("La recaudacion total fue de: $" + recaudacion);
		System.out.println("La cantidad de empanadas que sobraron: " + empDisponibles);
	}
	
}
