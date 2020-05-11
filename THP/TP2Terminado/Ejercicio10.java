/*
 * 10. El club de corredores nos pide un programa para obtener estadísticas de la carrera de 10
km. El mismo consiste en ingresar, por teclado, el número de corredor, las
horas, los minutos y los segundos que tardo en realizar la carrera. Tener en cuenta que al ingresar 0
como el número de corredor, finaliza el programa y debe mostrar por pantalla:
a) El ganador
b) El promedio en segundos de los corredores.
c) El porcentaje de corredores que realizaron la carrera en menos de una hora.
Programar y utilizar la función devolverSegundos que recibe como parámetros horas, minutos y
segundos.
 */

package Ejercicios;

import java.util.Scanner;

public class Ejercicio10 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nroCorredor, horasCarrera, minutosCarrera, segundosCarrera, tiempoTotal;
		int tiempoGanador, numeroGanador, cantidadCorredores, tiempoTodosCorredores, cantidadMenosDeUnaHora;
		double promedioCorredores, porcentajeMenosUnaHora;
		
		tiempoGanador = 999999999;
		numeroGanador = 0;
		cantidadCorredores = 0;
		tiempoTodosCorredores = 0;
		cantidadMenosDeUnaHora = 0;
		
		nroCorredor = ingresaEntero("-->Ingrese numero de corredor: ");
		//Termina con 0
		while (nroCorredor != 0) {
			horasCarrera = ingresaEnteroEntre("Ingrese las horas de carrera: ", 0, 59);
			minutosCarrera = ingresaEnteroEntre("Ingrese las minutos de carrera: ", 0, 59);
			segundosCarrera = ingresaEnteroEntre("Ingrese las segundos de carrera: ", 0, 59);
			
			tiempoTotal = devolverSegundos(horasCarrera, minutosCarrera, segundosCarrera);
			
			if (tiempoTotal < tiempoGanador) {
				numeroGanador = nroCorredor;
				tiempoGanador = tiempoTotal;
			}
			cantidadCorredores++;
			tiempoTodosCorredores = tiempoTodosCorredores + tiempoTotal;
			if (tiempoTotal < 3600) {
				cantidadMenosDeUnaHora++;
			}
			//BORRAR PRUEBA
			System.out.println("El corredor tardo " + tiempoTotal + " segundos.");
			nroCorredor = ingresaEntero("Ingrese su numero de corredor: ");
		}
		
		promedioCorredores = calcularPromedio(tiempoTodosCorredores, cantidadCorredores);
		porcentajeMenosUnaHora = cacularPorcentaje(cantidadMenosDeUnaHora, cantidadCorredores);
		mostrarResultados(numeroGanador, promedioCorredores, porcentajeMenosUnaHora);
		input.close();
	}
	
	public static int ingresaEntero(String mensaje) {
		int numero;
		System.out.println(mensaje);
		numero = Integer.parseInt(input.nextLine());
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
	
	public static double calcularPromedio(int total, int cantidad) {
		double resultado;
		resultado = total / cantidad;
		return resultado;
	}
	
	public static double cacularPorcentaje(int n1, int n2){
		double porcentaje;
		if (n2 == 0){
			porcentaje = 0;
		} else {
			porcentaje = n1 * 100 / n2;			
		}
		return porcentaje;
	}
	
	public static int devolverSegundos(int horas, int minutos, int segundos) {
		int tiempoTotal;
		tiempoTotal = segundos;
		tiempoTotal = tiempoTotal + (minutos * 60);
		tiempoTotal = tiempoTotal + (horas * 60 * 60);
		return tiempoTotal;
	}
	
	public static void mostrarResultados(int ganador, double promedio, double porcMenosHora) {
		System.out.println("El ganador es: " + ganador);
		System.out.println("El promedio en segundos de los corredores fue: " + promedio);
		System.out.println("El porcentaje de corredores que realizaron la carrera en menos de una hora: %" + porcMenosHora);
	}
}
