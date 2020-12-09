package com.luis.java8.tema5.Interfaces_Funcionales;

// La anotación @FunctionalInterface nos indica que la Interfaz
// será una Interfaz funcional, es decir, que solo tendrá un solo método.
@FunctionalInterface 
public interface Operacion {

	double calcular(double n1, double n2);
	// double calcular2();
}
