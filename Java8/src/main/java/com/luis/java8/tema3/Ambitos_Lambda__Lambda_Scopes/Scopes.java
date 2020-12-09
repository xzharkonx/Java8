package com.luis.java8.tema3.Ambitos_Lambda__Lambda_Scopes;

// Veremos como se comportan las expresiones Lambda con variables
// locales, globales, estáticas y no estáticas.
// Nos referimos a su alcanse (Scope).

public class Scopes {
	
	private static double atributo1;
	private double atributo2;

	public double probarLocalVariable() {
		double n3 = 3;
		double n4 = 3;
		//final double n3 = 3;
		Operacion op = new Operacion() {

			@Override
			public double calcular(double n1, double n2) {
				// Vemos que la variable n3 tiene un error, esto es porque
				// está variable debe tener un scope "final", ¿Porque?,
				// por que cuando nosotros trabajamos en una Clase anoníma
				// y necesitamos hacer referencia a una variable local (n3)
				// es necesario que está variable local tenga la palabra
				// reservada (o keyword) final. Con final estamos indicando
				// que está variable no va a cambiar su valor, por lo tanto
				// yo no podría hacer esa operación.
				// n3 = n1 + n2;
				// return n3;
				
				// Y simplemente podríamos decir:
				return n1 + n2 +n3;
				// Aquí si ya no daría error.
			}
			
		};
		
		// Con ambito Imperativo.
		// return op.calcular(1, 1);
		
		// Con ambito Lambda.--------------------------------------
		// Puede ser así:
		// Operacion operacion = (x,y) -> x + y + n3;
		
		// O así:
		Operacion operacion = (x,y) -> {
				return x + y + n3;
			};
		
		// Si nosotros quisieramos asignar n4 nos dirá lo mismo que está mal y
		// que debe ser una variable estatica.
		//		Operacion operacion2 = (x,y) -> {
		//			n4 = x + y; // Aquí señala error.
		//			return n4;
		//		};
			
			
		return operacion.calcular(1, 1);
		
		// Entonces el concepto de una variable local en un scope Lambda permanece
		// tan igual para una Clase anónima que para una Lambda. Por lo tanto yo
		// podría utilizar las variables más no alterar su valor.
		
		// Recapitulando: Cuando estamos en una expresión Lambda y utilizamos una variable local
		// es opcional colocar el identificador final a esa variable, si no lo colocas se va a
		// comportar como un solo valor estático (dará error si lo cambiamos por otro valor) y
		// es opcional colocar el identificador final (si no la variable se comportará como si
		// lo fuera), y tener cuidado porque solo podemos utilizar el valor y no reasignarlo.
	}
	
	
	
	// Aquí vamos a probar como se comporta cuando definimos
	// variables globales, estáticas y no estáticas (fuera de esté método).
	public double probarAtributosStaticVariables() {
		
		// Cuando estamos en una expresión Lambda y queremos hacer referencia a
		// nuestros atributos de Clase uno estático o uno que no sea estático
		// nosotros vamos a poder tener la capacidad de lectura y escritura
		// de esos atributos en nuestra expresión Lambda
		
		Operacion operacion = (x,y) -> {
			// Mira como aquí si podemos utilizar y asignar/cambiar el valor de este
			// atributo global no estático.
			atributo1 = x + y;
			
			// De la misma manera para el atributo2 que es global y estático.
			atributo2 = atributo1;
			
			return atributo2;
		};
		
		return operacion.calcular(3, 2);
	}
	
	// Probando con Objetos anonimos, funcionará de la misma manera.
	// Enfoque Imperativo.
	public double probarAtributosStaticVariablesObjetosAnonimos() {
		
		
		Operacion operacion = new Operacion() {
			@Override
			public double calcular(double n1, double n2) {
				atributo1 = n1 + n2;
				// De la misma manera para el atributo2 que es global y estático.
				atributo2 = atributo1;
				return atributo2;
			}
			
		};
		return operacion.calcular(3, 2);
	}


	
	public static void main(String[] args) {
		Scopes app = new Scopes();
		// Utilizando variables locales no pueden cambiar su valor, solo se utilizadas.
		// System.out.println(app.probarLocalVariable());
		// Utilizando variables globales (estáticas y no estáticas) pueden cambiar su valor,
		// o ser asignadas.
		System.out.println(app.probarAtributosStaticVariables());
		
		// Este comportamiento funcionará igual para los Objetos anónimos.
		System.out.println(app.probarAtributosStaticVariablesObjetosAnonimos());

	}

}
