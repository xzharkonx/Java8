package com.luis.java8.tema5.Interfaces_Funcionales;
// Interfaces funcionales.
// Este concepto quizás lo hemos trabajado sin darnos cuenta
// pero en Java, en la versión especificamente 1.8 a querido
// formalizar con el uso de una anotación.
// En este tema lo trabajaremos un poco más formal.

public class FuncInterApp {
	
	// Definimos un método operar
	public double operar(double x, double y) {
		// Invocamos la Interfaz y le pasamos una expresión Lambda.
		Operacion op = (n1,n2) -> n1 + n2;
		// Por último utilizamos el método calcular() definido en
		// la interfaz.
		return op.calcular(x, y);
	}

	public static void main(String[] args) {
		
		FuncInterApp app = new FuncInterApp();
		double rpta = app.operar(2, 3);
		System.out.println(rpta);
		
		// Entonces ¿Como nos ayuda una Interfaz funcional al momento de
		// definir expresiones Lambda?
		// Analicemos lo siguiente:
		// Que pasaría si en la interfaz queremos definir un método adicional
		// por ejemplo el método calcular2() de la interfaz Operacion.
		// Al definirlo en nuestro método operar cuando invocamos la Interfaz
		// esta se marcará de rojo. ¿Que significa esto?
		// Vemos el mensaje que la expresión no apunta a una interfaz funcional. 
		// (The target type of this expression must be a functional interface)
		
		// ¿Que significa esto?
		// Una interfaz funcional es aquella que solamente define una única 
		// operación, un único método.
		// Es por eso que al momento de colocar más de un método tenía ese error.
		
		// Pero JAVA a querido formalizarlo de una manera práctica.
		// Es por eso que en está versión de la JDK 1.8 presentamos la siguiente
		// anotación conocida como @FunctionalInterface. Se la colocamos en la
		// Interfaz.
		
		// Está expresión básicamente lo que está diciendo es que la interfaz
		// que está debajo de la anotación debe ser una interfaz funcional.
		// Si colocamos un nuevo método vamos a ver que ahora tenemos un error
		// tanto en la Interfaz como en la Clase FuncInterApp en el método operar()
		
		// Entonces por recomendación cuando estamos haciendo codigo propio o 
		// elaborando nuestras aplicaciones y cuando queremos definir estándares
		// de programación se recomienda colocar la anotación @FunctionalInterface
		// a estás interfaces que lo requieran.

	}

}
