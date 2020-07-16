package javabasics;

import java.util.Scanner;


public class Estudiantes {
	public static void main(String[] ARGS) {

		Scanner obtener = new Scanner(System.in);
		int cantidadNotas, i, notaMayor, notaMenor, nota, sumaNotas;

		System.out.print("Ingrese la cantidad de Notas: ");
		cantidadNotas = obtener.nextInt();

		notaMayor = 0;
		notaMenor = 100;
		sumaNotas = 0;
		
		for (i = 1; i <= cantidadNotas; i++) {
			System.out.print("La nota numero: " + i + " : ");
			nota = obtener.nextInt();

			sumaNotas = sumaNotas + nota;
			if (nota > notaMayor) {
				notaMayor = nota;
			}//end if
			if (nota < notaMenor) {
				notaMenor = nota;
			}//end if
		}//end for

		
	
		System.out.print("La nota mayor es: " + notaMayor + "\n");
		System.out.print("La nota menor es: " + notaMenor + "\n");

		System.out.print("El promedio es: " + sumaNotas / cantidadNotas + "\n");
		if (sumaNotas / cantidadNotas < 70) {
			System.out.println("No aprobaste");
		}//end if 
		else {
			System.out.println("Aprobaste");
		}//end else
		
		
	}//end main
}//end class