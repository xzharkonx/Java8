package com.luis.java8.tema2.Sintaxis_Lambda;

public class Sintaxis {
	
	public double probarSintaxis() {
		
		//Operacion operacion = (double x, double y) -> (x+y) /2;
		
		// Otra forma de ponerlo es englobandolo entre {} y colocarle la
		// palabra return y un ; 
		// Operacion operacion = (double x, double y) -> {return (x+y) /2;};
		
		// Pero que sentido tiene el caso de arriba, pues podemos hacer lo siguiente:
		//		Operacion operacion = (double x, double y) -> {
		//			double a = 2.0;
		//			System.out.println(a);
		//			return (x+y) /2 + a;
		//			};
			
		// Aquí se demuestra que es posible tenr esta sintaxis lambda de está manera.
		// Pero no se recomienda tenerla de está manera.
			
		
		// Tambien se puede indicar sin tipo de parámetro. JAVA implicitamente va a 
		// suponer que valor es el tipo de parámetro y la operacion va a ser de manera
		// normal.
		//Operacion operacion = (x, y) -> (x+y) /2;
		
		// Ahora que pasaría si no deseamos tener parametros. Cuando no lo deseamos vamos
		// a indicarlo con () vacios y a la mano derecha lo que gustemos hacer.
		
		// Por ejemplo, podemos devolver un 2, pero presenta un error por que en la interfaz
		// definimos la función con parametros, así que la definimos sin parámetros.
		//Operacion operacion = () -> 2;
		
		// Otro ejemplo:
		Operacion operacion = () -> {
			int x = 2;
			int y = 3;
			return x + y;
			
		};
			
		//return operacion.calcularPromedio(2,3);
		return operacion.calcularPromedio();
	}

	public static void main(String[] args) {
		Sintaxis app = new Sintaxis();
		System.out.println(app.probarSintaxis());

		// Podemos tener diferentes variaciones en sintaxis ya dependera de como trabajamos
		// a nuestro gusto, se recomeinda que las expresiones Lambda sean lo más legible posible.
	}

}
