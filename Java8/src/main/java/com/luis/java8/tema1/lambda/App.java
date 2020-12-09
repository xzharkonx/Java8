package com.luis.java8.tema1.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Tema 1. Lambda.
 *
 */
public class App 
{
	// Enfoque Imperativo
	public void ordenar() {
		List<String> lista = new ArrayList<>();
		lista.add("Luis");
		lista.add("Eduardo");
		lista.add("Luis Eduardo");
		
		// Aquí estamos trabajando bajo un enfoque Imperativo,
		// es decir, que indicamos línea por línea que necesitamos.
		// Todo esto es un poco verboso, es decir, se emplea más de
		// tres líneas simplemente para una comparación.
		Collections.sort(lista, new Comparator<String>() {
			@Override
			public int compare(String ol, String o2) {
				return ol.compareTo(o2);
			}
		});
		
		for (String elemento : lista) {
			System.out.println(elemento);
		}
		
	}
	
	// En JDK 8 Existe este concepto de lambdas.
	// Recuerd que cuando trabajamos en Lambdas es importante cambia tu
	// forma de pensar y es centrarte básicamente en que es lo que necesito
	// que el programa me devuelva, es decir, ¿Que es lo que necesito?
	// y NO ¿Como lo necesito?.
	// Entonces para apoyarnos en Lambda vamos a hacer lo siguiente:
	public void ordenarConLambda() {
		List<String> lista = new ArrayList<>();
		lista.add("Luis");
		lista.add("Eduardo");
		lista.add("Luis Eduardo");
		
		// Lambda.
		// Aquí le pasamos la lista y también la pasamos nuestro Lambda.
		// Recuerda que Lambda tiene 3 partes.
		// A la izquierda los parámetros, en medio el operador, 
		// y la derecha la expresión a evaluar.
		// Entonces colocamos el parámetro 1, el parámetro 2,
		// el Operador, luego el parámetro uno lo vamos a comparar con
		// el segundo.
		
		// Mira entonces como se simplificaron las líneas con una simple expresión Lambda.
		Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));
		
		for (String elemento : lista) {
			System.out.println(elemento);
		}
		
	}
	
	// Ahora iremos un poco más allá y nos apoyaremos de una interfaz.
	// Aqui crearemos un método para poder trabajar con ella.
	public void calcular() {
		
		// Llamamos a la interfaz.
		// Recuerda que las interfaces no se puede insanciar por lo que
		// tenemos que crear una Clase anonima para implementarla.
		// Y por lo tanto tenemos que sobreescribir el método que trae.
		Operacion operacion = new Operacion() {

			// Así que simplemente detallamos el método.
			@Override
			public double calcularPromedio(double n1, double n2) {
				return (n1 + n2)/2 ;
			}
		
		}; // Cerramos la Clase anonima.
		
		// Invocamos al método y como nos devuelve un valor lo envolvemos
		// en un sysout.
		System.out.println(operacion.calcularPromedio(2,3));
	
		// Esto es bajo un enfoque imperativo por que tengo una interfaz
		// y estoy creando una clase anonima para implementar los métodos
		// de esa interfaz.
		// Pero esto se puede hacer con lambdas
	}
	
	// Con el enfoque Lambda.
	public void calcularConLambda() {
		
		// Necesitamos una implementación
		// Le pasamos 2 parámetros
		Operacion operacion = (double x, double y) -> (x+y)/2;
		// Aunque podriamos obviar las declaraciones de las variables y el resultado sería el mismo.
		// Operacion operacion = (x, y) -> (x+y)/2;
		// Y Simplemente utilizamos la función.
		// Invocamos al método y como nos devuelve un valor lo envolvemos
		// en un sysout.
		System.out.println(operacion.calcularPromedio(2,3));
	}
	
    public static void main( String[] args )
    {
        App app = new App();
        // app.ordenar();
        // app.ordenarConLambda();
        
        // Ahora nos apoyamos de la interfaz (bajo un enfoque Imperativo).
        // app.calcular();
        // Ahora nos apoyamos de la interfaz (bajo un enfoque Lambda).
        app.calcularConLambda();
        // Podemos ver que tenemos el mismo resultado utilizando una expresión lambda
        
        // Vean la reducción considerable de codigo simplemente apoyandonos del 
        // enfoque declarativo.
        
        // Aqui le decimos, quiero 2 variables, las sumas y divides. Es lo que necesita el promedio.
        // Operacion operacion = (double x, double y) -> (x+y)/2;
        // Aunque podriamos obviar las declaraciones de las variables y el resultado sería el mismo.
        // Operacion operacion = (x, y) -> (x+y)/2;
    }
}
