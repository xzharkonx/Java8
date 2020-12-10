package com.luis.java8.tema7.ForEach_RemoveIF_Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ColeccionApp {

	private List<String> lista;
	
	public void llenarLista() {
		lista = new ArrayList<>();
		
		lista.add("Luis");
		lista.add("Eduardo");
		lista.add("Luis Eduardo");
	}
	
	public void usarForEach() {
		// El ForEach común de la JDK 1.7
		/*for (String elemento : lista) {
			System.out.println(elemento);
		}*/
		
		// Aquí podemos usar las Lambdas.
		// Escribimos el nombre de nuestra Colección en este caso la lista
		// y nos apoyamos de un método llamado forEach(), este método me
		// está pidiendo un "Consumer <? super String> action" que prácticamente
		// es una interfaz funcional que tiene un único método llamado accept y este
		// método va a poder recibir una lógica que nosotros implementemos en una
		// expresión lambda o en un método de referencia.
		
		// Podemos revisa la Interfaz Consumer, podemos observar que tiene un método
		// void accept(T t); que simplemente está nombrado no implementado y un
		// método por default que si está implementado.
		
		// Entonces esté forEach() necesita implementar este Consumer.
		// Le vamos a decir que para cada elemento x vamos a hacer -> una impreción
		// de este elemento System.out.println(x).
		
		// Lambda.
		// lista.forEach(x -> System.out.println(x));
		// Añadiendo una pequeña lógica:
		
		/*		
		 	lista.forEach(x -> { 
				if (x == "Luis") {
					System.out.println("Hola " + x);
					
				}else {
					System.out.println(x);
					}
			});
		*/
		
		// Aquí podemos usar los Métodos de referencia.
		lista.forEach(System.out::println);
		
		// Podemos ver que es prácticamente lo mismo.
		
	}
	
	public void usarRemoveIf() {
		// Como su nombre textualmente lo indica vamos a poder quitar un elemento
		// cuando exista una lógica
		// Ateriormente lo que haciamos sería recorrer una lista y preguntabamos
		// si el elemento es igual a algo adicionabamos una lógica de eliminación.
		
		/*
			for (String elemento : lista) {
				if (elemento.equalsIgnoreCase("Eduardo")) {
					// Pero recuerda que nosotros no podemos eliminar en un ciclo for
					// porque nos saldría el error de ConcurrentModificationException
					// Pero en está versión parece que ya lo arreglaron.
					lista.remove(elemento);
				}
			}
		
		*/
		
		// O lo común sería usar un Iterator y preguntar si el elemento siguiente
		// se asemeja o es igual al termino que le estamos colocando "Eduardo"
		// lo removemos.
		
		/*
		Iterator<String> it = lista.iterator();
		while(it.hasNext()) {
			if(it.next().equalsIgnoreCase("Eduardo")) {
				it.remove();
			}
		}
		*/
		
		// Mira que con lo de arriba se definieron muchas líneas de código
		// Ahora usaremos el paradigma funcional de la siguiente manera.
		// Utilizamos el método remove() y aquí tenemos a 
		// "Predicate <? super String> filter" que es una Clase muy importante
		// para poder armar predicados "Instrucciones que representan una lógica
		// como eliminación, agregacion, condicionales que básicamente nos va a
		// permitir ahorrar mucho código.
		// Entonces le indicaremos una expresión lambda.
		
		lista.removeIf(x -> x.equals("Eduardo"));

		// Así de simple.
	}
	public void usarSort() {
		// Si queremos ordenar está lista mayormente nos apoyamos de Collections
		// utilizabamos el método sort() y le pasabamos la lista y un Comparator
		// implementabamos la lógica de comparación y se ordenaba la lista.

		//Collections.sort(lista, (x, y) -> x.compareTo(y));
		
		// Pero podemos apoyarno exclusivamente en el método sort() de la propia
		// lista
		lista.sort((x,y) -> x.compareTo(y));
		
		// Podemos ver que es prácticamente lo mismo.
	}
	
	public static void main(String[] args) {
		ColeccionApp app = new ColeccionApp();
		app.llenarLista();
		// app.usarRemoveIf();
		app.usarSort();
		app.usarForEach();

	}

}
