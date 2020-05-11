/*
 * Una empresa dedicada al transporte de documentación necesita procesar su facturación mensual
a partir de los resúmenes de viajes realizados para cada uno de sus clientes.
Quieren saber también cuál es el promedio pagado por empresa y el valor de la factura más cara. Para
el cálculo de cada factura se sabe que por mes cada empresa tiene derecho a dos viajes diarios libres
con un abono de $8500, cobrando además por cada viaje adicional $100. En caso de que la empresa
supere los 30 viajes adicionales, por promoción, se le hará un descuento del 10% sobre el total mensual
facturado. Por cada empresa nos informan el nombre de la misma y la cantidad de viajes adicionales
(entero >=0, siempre menor a 1000), y nosotros debemos mostrar en pantalla su nombre y el importe
total de la factura.

Por ejemplo: La empresa “Los Nenes”, que necesitó hacer 18 viajes adicionales en el mes, deberá
pagar una factura de $10300 (Precio base + viajes adicionales * $100 = $8500 + $1800). Por pantalla,
entonces, debe mostrarse: La empresa Los Nenes debe abonar $10300 En cambio, la empresa
“Software Industrial SRL”, que realizó 150 viajes adicionales, deberá pagar una factura de $21150
(Precio base + viajes adicionales * 100 - bonificación 10% = $8500 + $15000 - $2350). Aquí debe
mostrarse: La empresa Software Industrial SRL debe abonar $21150 Si éstas fueran todas las
empresas, al finalizar se mostrará el promedio (acumulado / cantidad de empresas = 34150 / 2): El
promedio pagado por empresa en el pasado mes fue de $15725 La mayor factura es por un total de
$21150
 */
package Ejercicios;

import java.util.Scanner;

public class Ejercicio14 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombreEmpresa;
		double abonoEmpresa;
		int cantidadViajesAdicionales;
		
		//promedio pagado por empresa
		//factura mas cara
		double promedioPagado;
		double totalAbonoEmpresa = 0;
		int cantidadEmpresas = 0;
		double facturaMasCara = 0;
		
		//abono mensual 8500
		//viaje adicional +100
		final int ABONO_MENSUAL = 8500;
		final int ADICIONAL_VIAJE = 100;

		//max cantidad viajes promocion 30
		//descuento por promocion mensual 10%
		final int PROMOCION_MIN_VIAJES = 30;
		final double PROMOCION_PORCENTAJE = 10;
		
		//Ingresar nombre empresa
		nombreEmpresa = ingresaCadena("Ingrese nombre empresa [FIN para temrinar]:");
		while (!nombreEmpresa.equalsIgnoreCase("FIN")) {
			//Ingresar cantidad de viajes adicionales (entero >=0, siempre menor a 1000)
			cantidadViajesAdicionales = ingresaEnteroEntre("Ingrese la cantidad de viajes adicionales: ", 0, 1000);
			
			abonoEmpresa = calcularAbono(cantidadViajesAdicionales, ABONO_MENSUAL, ADICIONAL_VIAJE, PROMOCION_MIN_VIAJES, PROMOCION_PORCENTAJE);
			//Mostrar por cada uno nombre y total factura
			System.out.println("La empresa " + nombreEmpresa + " debe abonar: $" + abonoEmpresa);
					
			cantidadEmpresas++;
			totalAbonoEmpresa = totalAbonoEmpresa + abonoEmpresa;
			if (abonoEmpresa > facturaMasCara) {
				facturaMasCara = abonoEmpresa;
			}
			
			nombreEmpresa = ingresaCadena("Ingrese nombre empresa [FIN para temrinar]:");
		}
		
		promedioPagado = calcularPromedioDouble(totalAbonoEmpresa, cantidadEmpresas);
		mostrarResultados(promedioPagado, facturaMasCara);
		
		input.close();
	}
	
	public static String ingresaCadena(String mensaje) {
		System.out.println(mensaje);
		return input.nextLine();
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
	
	public static double calcularAbono(int cantViajesAdic, int abonoMensual, int adicViaje, int minCantViajePromo, double porcViajePromo) {
		if (cantViajesAdic <= minCantViajePromo) {
			return abonoMensual + cantViajesAdic * adicViaje;
		} else {
			return (abonoMensual + cantViajesAdic * adicViaje) * (1.00 - porcViajePromo / 100);
		}
	}
	
	public static double calcularPromedioDouble(double total, int cantidad) {
		return total / cantidad;
	}
	
	public static void mostrarResultados(double promAbono, double abonoMasCaro) {
		System.out.println("El promedio de las facturas fue: $" + promAbono);
		System.out.println("La factura mas cara fue de: $" + abonoMasCaro);
	}
}
