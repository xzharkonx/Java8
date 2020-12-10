package com.luis.java8.tema8.Stream;

// El Api Stream va a darle un Plus al desarrollador.
// Va a permitir poder programar de manera un poco más legible
// si se apoya conjuntamente con las expresiones Lambda.

// Vamos a poder realizar operaciones como filtros, contar,
// ordenamientos, etc. De una forma muy declarativa, es decir,
// evitando mucho la implementación línea por línea.

import java.util.ArrayList;
import java.util.List;

public class StreamsApp {

	private List<String> lista;		
	private List<String> numeros;		
	
	public StreamsApp() {
		
		lista = new ArrayList<>();
		lista.add("Luis");
		lista.add("Eduardo");
		lista.add("Luis Eduardo");
		lista.add("Developer");
		
		numeros = new ArrayList<>();
		numeros.add("1");
		numeros.add("2");
	}
	
	public void filtrar() {
		// Vamos a filtrar de la lista todos aquellos
		// elementos que empiecen con la letra L
		
		// Llamamos a la lista, luego al método stream()
		// y aqui vamos a tener muchos métodos a nuestra disposición.
		// Uno de ellos es filter, que necesita un predicate que
		// básicamente es una expresión Lambda que vamos a evaluar aquí.
		
		// Quiero de la lista todos aquellos que inicien con la letra "L".
		// Pero también yo quiero imprimirlos, para ello nos apollamos
		// de otra función del tema pasado forEach y aquí utilizamos un 
		// método de referencia para invocar el print o println.
		
		lista.stream().filter(x -> x.startsWith("L")).forEach(System.out::println);
		
		// Podemos ver que en 1 línea lo que hemos hecho es filtrar los elementos
		// que empiezan con la letra L y los imprimo en consola.
		
		// Este método por referencia que está dentro del forEach puede ser reemplazado
		// también por una expresión lambda
		
		// lista.stream().filter(x -> x.startsWith("L")).forEach(x -> System.out.println(x));
		
		// Por legibilidad se prefiere utilizar el con el método de referencia.
	}
	
	public void ordenar() {
		// Para el método ordenar lo haremos prácticamente de la misma manera.
		// Pero nos apoyaremos del método sorted() y lo imprimimos en pantalla.
		
		// lista.stream().sorted().forEach(System.out::println);
		
		// Pero que pasaría si quiero hacerlo de manera ascendente.
		// Lo que haremos es que en sorted() le pasaremos una expresión Lambda
		// para indicarle esa lógica.
		lista.stream().sorted((x,y) -> y.compareTo(x)).forEach(System.out::println);
		
		// El ordenamiento ha sido en el orden inverso.
		
		// OBSERVACIONES:
		
		//		PREGUNTA: ¿Cuál es la diferencia de lista.sort(...) y sorted con el stream?
		//		RESPUESTA: Uno se apoya en una interfaz Comparator y el otro se basa en el 
		//		framework stream (en temas de rendimiento a veces la forma imperativa
		//		puede ser mejor).
		
		//		OBSERVACION ADICIONAL: lista.sort orden la propia lista, sin embargo si tu
		//		haces un sorted no te actualiza tu lista para proximos usos.
		
		
	}
	
	public void transformar() {
		// Vamos a utilizar lo siguiente.
		// Esta función map() es una función de transformación, es decir, lo que vas
		// a colocar aquí, el elemento de cada lista va a ser transformado con la 
		// expresión que se indiques en este caso. 
		// Por ejemplo, que pasaría si todos los elementos quiero convertirlos a 
		// mayúscula, entonces haríamos lo siguiente. Nos apoyamos en un método de
		// referencia y del método toUpperCase. Y lo recorremos con el forEach nuevamente.
		
		lista.stream().map(String::toUpperCase).forEach(System.out::println);
		
		// Vemos que ahora nos sale en mayúsculas.
		
		System.out.println("Transformando números --------------");
		
		// Ahora probaremos con la lista de números.
		// Vemos que la lista es de tipo String.
		// Entonces queremos convertir cada elemento a entero y de ese elemento entero
		// sumarle un número adicional.
		
		// Forma tradicional imperativa.
		/*
		 
			 	for (String x : numeros) {
				int num = Integer.parseInt(x) + 1;
				System.out.println(num);
			}
		 
		 */
		
		// Vemos que hemos utilizado 3 líneas de código para hacer este ejercicio.
		
		// Ahora lo haremos de 1 sola línea apoyandonos de la Api Stream.
		// Dentro del método map le pasaremos una Lambda donde le indicamos
		// que queremos cambiar el parametro a entero y que le sumaremos 1.
		
		numeros.stream().map(x -> Integer.parseInt(x) + 1).forEach(System.out::println);
		
		// Vemos que es el mismo resultado que el de arriba pero se ha hecho en una sola
		// línea de codigo.
		
		// OBSERVACIONES.
		
		//		 PREGUNTA: ¿Map genera una nueva lista del tamaño de la original luego de su invocación o 
		//		 stream hace "algo" interno para eficientar el uso de la memoria?
		//		 RESPUESTA: map transforma elementos de acuerdo a un criterio, en este caso genera una nueva
		//		 lista, y stream api de java 8 permite el manejo simple de estas
		
	}
	
	public void limitar() {
		// Este método es mucho más simple aún.
		// Utilizaremos el método limit() y le pasaremos un
		// número en particular (de elementos que mostrará) y por último recorremos
		// la colección.
		
		lista.stream().limit(2).forEach(System.out::println);
		
		// Está se limitará a los 2 primeros elementos que hemos indicado en el 
		// método limit(2).
		
	}
	
	public void contar() {
		// Este método es mucho más simple aún.
		// Utilizaremos el método count, vemos que nos devuelve un método
		// de tipo long, por lo que lo almacenaremos en una variable de ese tipo.
		long x = lista.stream().count();
		
		// Haremos una impresión de esa variable.
		
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		StreamsApp app = new StreamsApp();
		System.out.println("Filtrando --------------------------");
		app.filtrar();
		System.out.println("\nOrdenando --------------------------");
		app.ordenar();
		System.out.println("\nTransformando ----------------------");
		app.transformar();
		System.out.println("\nLimitando --------------------------");
		app.limitar();
		System.out.println("\nContando ---------------------------");
		app.contar();

		// Estás operaciones son las más comunes y practicascuando 
		// estamos desarrollando en Java.
	}

}
