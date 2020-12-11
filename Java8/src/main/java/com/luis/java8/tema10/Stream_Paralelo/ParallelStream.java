package com.luis.java8.tema10.Stream_Paralelo;

// Vamos a vr un ejemplo muy sencillo para entender como
// se utiliza el Stream paralelo.

// 

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
	
	private List<Integer> numeros;
	
	public void llenar() {
		
		numeros = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			numeros.add(i);
		}
	}
	
	public void probarStream() {
		numeros.stream().forEach(System.out::println);
		
		// Podemos ver que sale 0 al 9 de una manera secuencial
		// debido a que el uso de Stream es secuencial.
	}
	
	public void probarParalelo() {
		// Si nosotros queremos un procesamiento con hilos nos
		// vamos a tener que apoyar en el aprallel Stream
		
		// Para ello en vez de usar Stream utilizaremos
		// parallelStream, esto cambia ya la aplicación

		numeros.parallelStream().forEach(System.out::println);

		// Y de manera implicita va utilizar el framework ForJoin
		// que está disponible desde JDK 1.7
		// Va a emplezarse en un Pool de este tipo y va a crear un
		// procesamiento con hilos.
	}

	public static void main(String[] args) {
		
		ParallelStream app = new ParallelStream();
		
		app.llenar();
		// app.probarStream();
		
		app.probarParalelo();
		
		// vemos que justamente como es un procesamiento asincrono con
		// hilos no sabemos cuál es el comportamiento real, volvemos a 
		// provar y los números varian en la impresión.
		// Es un comportamiento aleatorio.
		
		// Esto del stream paralelo puede aliviar o puede mejorar el
		// rendimiento en algunas aplicaciones, pero no todo es color de rosa
		// hay documentación o hay algunos casos de estudio donde indican 
		// que abisar de este tipo de parallel stream no es tan recomendable
		// especificamente si trabajamos en aplicaciones con Java EE container.
		
		// ¿Porque?, imaginemos tener un ambiente donde ya de por si utilizamos 
		// muchas peticiones, muchos request y estamos en un ambiente asincrono
		// podemos saturarlo un poco más y justamente este caso de estudio:
		
		// https://www.overops.com/blog/benchmark-how-java-8-lambdas-and-streams-can-make-your-code-5-times-slower/
		
		// han hecho un benchmark de cómo afecta al rendimiento cuando utilizamos
		// Streams Paralelos, este estudio o este caso en algunas ocaciones mide  de
		// la forma Imperactiva y otra de la forma Declarativa.
		
		// Y otro articulo que parece interesante es lo que se mencionaba, esto de los
		// Streams paralelos se apoya mucho en un ForJoinPool, es decir, en un Pool de
		// hilos que implementa en este Framework ForJoin provisto en la funcionalidad
		// de JDK 1.7. Aquí cita el ejemplo:
		
		// https://dzone.com/articles/whats-wrong-java-8-part-iii
		
		// Y como conclucion lo que se menciona que no es recomendable utilizar esto en 
		// ambientes de Java EE container.
		// Por ejemplo, servidores de aplicaciones que tengan interacción con JPA y JB
		// Todo lo que contiene el container propiode Java Enterprise.
		
		// RECOMENDACIÓN: Si utilizamos Streams Paralelos, hay que hacerlo con moderación, no abusar
		// todo con Streams paralelos y de preferencia en procesos de tipo bach o aplicaciones
		// de escritorio.
	}

}
