package com.luis.java8.tema115.RxJava;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;

// Java Rx

// Obedece al principio de la programación reactiva y esto es causa y efecto.
// Existe un ejemplo ampliamente utilizando en las redes que lo que dice es lo siguiente:
// Si nosotros establecemos alguna formula en alguna celda y está celda depende de otras
// es deci, tiene otras a su disposición, si cambiamos el valor también va a cambiar el
// contenido de las otras

// Entonces esto de la programación reactiva obedece mucho a lo que son entes que son
// observados y entes que van a observar y notificarse cuando suceda alguna acción.

// Para poder utilizar RxJava, iremos a nuestro pom.xml y descargamos la dependencia necesaria.
// Este ejemplo será con RxJava 1.2.6

public class RxApp {
	
	List<Integer> lista1;
	List<Integer> lista2;
	public RxApp() {
		lista1 = new ArrayList<>();
		lista2 = new ArrayList<>();
		this.llenarListas();
	}
	
	public void llenarListas() {
		
		// Aquí lo único que vamos a hacer es dejar ambas listas del 0 al 9
		
		// for (int i = 0; i < 10; i++) {
		for (int i = 0; i < 10000; i++) {
			lista1.add(i);
			lista2.add(i);
		}
		
	}
	
	public void buscar() {
		
		// En este método vamos a hacer aquí nuestra lógica y definir  los Observables,
		// es decir, los objetos observados.
		// El objetivo funcional es el siguiente, vamos a tener que buscar todos aquellos
		// números que empiecen con 1. Para ello nos vamos a apoyar en un filter, hacemos
		// la lógica de filtrado y mostramos los números que coincidieron bajo ese criterío.
		// Y esto se va a hacer tanto para la lista1 como para la lista2 de manera asincrona
		
		Observable<Integer> obs1 = Observable.from(lista1);
		Observable<Integer> obs2 = Observable.from(lista2);
		
		// Ahora nos apoyamos del método merge() lo que nos va a permitir unir 2 observables
		// para obtener un único resultado.
		
		/*
		Observable.merge(obs1, obs2).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer numero) {

				// Entonces dentro de este método vamos a hacer esa lógica
				// Si el número es igual a 1 simplemente vamos a imprimir ese numero
				if(numero == 1) {
					System.out.println(numero);
				}
				
			}
			
		});	
		*/
		
		// Este Action1 viene a ser una interfaz funcional y como tal puedo representar la lógica
		//  de este merge de manera de apoyarme en una expresión Lambda.
		
		// EL suscribe necesita la implementación a esta interfaz funcional "Action1" y como
		// es una interfaz funcional podemos establecerle un método de referencia o una
		// expresión Lambda. En este caso es un método a referencia.
		
		// Observable.merge(obs1, obs2).filter(x->x==1).subscribe(System.out::println);
		
		// Veremos que tenemos el mismo resultado.
		
		// Que pasaría si tenemos una lógica más compleja de x==1, podríamos hacer lo siguiente.
		
		Observable.merge(obs1, obs2).filter(x->x==1).subscribe(x -> {
			if (x == 1) {
				System.out.println(x);
			}
		});
	}

	public static void main(String[] args) {
		
		List<String> lista = new ArrayList<>();
		lista.add("Luis");
		lista.add("Eduardo");
		lista.add("Luis Eduardo");
		
		// Aquí vamos a utilizar uno de los principios báscos que se apoya RxJAVA
		// que son los observables.
		
		// Concepto de Observable.
		// Esto puede parecer un poco redundante, viene a ser un Objeto que tiene que ser
		// observado por Observadores (Observers), entonces cuando este Observable suscribe a varios
		// Observadores los elementos o el contenido que existe en este observable va a notificar a cada 
		// uno de sus observadores, es básicamente lo que se apoya en el patrón Observer.
		
		// Entonces lo que hacemos en está linea de código es crear el Observable, es decir, mi Objeto
		// que tiene que ser observado de una lista.
		Observable<String> obs = Observable.from(lista);
		// ¿Y que vamos a hacer?
		// Vamos a suscribir a un Observador, nos apoyamos de interfaces que ya vienen por defecto en RxJAVA,
		// como el Observable es de tipo String también tenemos que definir algo String aquí en Action1
		// Importamos lo que nos pide.
		// Como las interfaces no se pueden instanciar tenemos que implementar sus métodos.
		obs.subscribe(new Action1<String>() {

			@Override
			public void call(String elemento) {
				// Aquí va a resibir cada elemento el contenido que tiene este observable y lo único
				// que vamos a hacer es una impresión.
				
				System.out.println(elemento);
				
				// Vemos que sale el contenido de la lista, ¿Pero de que nos sirve esto?
				// RxJAVA básicamente te permite hacer el manejo de procesamiento asíncrono de una
				// manera muy legible evitandote el uso de futures, collables y todo el callback cuando
				// programabamos con Java 1.7 de esa manera. Y para evitarte toda esa verbosidad
				// está librería te permite hacer ese tipo de procesamiento asíncrono de una manera
				// más amigable.
				
				// El concepto de un Observable es que crea un suscriptor y simplemente estoy indicando
				// que a a pasar en la lógica dentro de este método suscriptor (suscribe())
				
				
				
				
			}
			
		});

		// Para ver el procesamiento de un proceso asincrono vamos a ver el siguiente ejercicio.
		
		RxApp app = new RxApp();
		app.buscar();
		
		// Veremos que nos está buscando es 1 y 1.
		// Efectivamente lo que estoy haciendo aquí es definiendo una lógica de buscado dentro de
		// mis observables, va a buscarse eso dentro de mis 2 listas y nos va a dar los resultados
		// de manera asíncrona.
		
		// Imaginemos tener las listas con más datos.
		// Vemos que obtenemos el mismo resultado.
		// Esto es de manera asíncrona.
		
		// Si esto no lo hicieramos de esta forma posiblemente tendríamos que hacerlo de manera
		// secuencial es decir, recorrer la lista, empezar a hacer el buscar si empieza con 1
		// y luego recorrer la otra lista y esto podría demandar más tiempo, si queremos hacerlo
		// de manera asincrona usando Futures, Collables y Excecutors y tendriamos que utilizar
		// estas Clases, hacer un submit en un Excecutor y esperar a que salga el procesamiento
		// pero de esta manera es un poco más legible.
		
	}

}
