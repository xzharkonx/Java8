package com.luis.java8.tema14.Funciones_de_Alto_Orden;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// Las funciones de Alto Orden o High Order Function provienen del termino programación de alto orden.
// Que en su mayoría se enfoca al paso o devolución de funciones en nuestra programación.

// Para pensar en lo que es la programación de Alto Orden tenemos que acostumbrarnos a la programación
// entre pasos de funciones.

public class HighApp {
	
	// La Function es una Clase en está JDK 1.8, en el cuál en el Operador Diamante debemos colocar el
	// tipo de dato que va a tener está función como entrada y el tipo de salida que va a retornar 
	// está función. Importamos la Clase.
	
	// Vamos a tener 2 funciones una de convertir a minúsculas y otra de converir a mayúsculas 
	// las vamosa reutilizar apoyandonos en este concepto de High Order Function
	private Function<String, String> converirMayusculas = x -> x.toUpperCase();
	private Function<String, String> converirMinusculas = x -> x.toLowerCase();
	
	// Creamos un método para utilizar estás funciones que acabamos de crear.
	public void imprimir(Function<String, String> funcion, String valor) {
		// Hacemos una simple impreción en consola en la que nos apoyamos del parametro funcion
		// y vamos a utilizar el método apply. Esté método requiere como hemos definido como 
		// variable de entrada de tipo String en la salida un tipo de dato String, dependiendo
		// los valores que le coloquemos es como cambiará.
		
		// Es como si el método apply() ejecutará la función.
		System.out.println(funcion.apply(valor));
	}

	// Ejemplo adicional
	// Simplemente lo que realiza esta función es que al parametro de entrada le vas
	// a adicionar a tu salida el mensaje que viene como parámetro aquí.
	// Se continua explicando en la invocación a este método.
	
	public Function<String, String> mostrar(String mensaje){
		return (String x) -> mensaje + x;
	}
	
	
	// Otro ejemplo adicional
	public void filtrar(List<String> lista, Consumer<String> consumidor, int longitud, String cadena) {
		// Funcionalmente lo que vamos a hacer es pasarle una lógica o un criterio de filtro
		// y de acuerdo al criterio de filtro vamos a poder imprimir los resultados.
		// Entonces no vamos a pasar simplemente un dato primitivo como parámetro si no
		// una función.
		
		// Al hacer el predicado (que es básicamente una expresión Lambda) y lo vamos a proveer
		// mediante un método. Y como respuesta a esto puedo asociar un forEach y el forEach
		// nos esta pidiendo un consumer, así que el consumidor va a venir por parámetro de un método superior.
		
		// lista.stream().filter(this.establecerLogicaFiltro(longitud)).forEach(consumidor);
		
		// Analizando. Tenemos el método filtrar que recibe 3 parámetros, una lista, un consumidor y una variable
		// primitiva básica donde simplemente nos apoyamos en está lista que acabamos de recibir, utilizamos
		// stream().filter() y le pasamos una expresión lambda definida a travez de un método independiente y
		// luego aplicamos sobre este resultado un forEach() que necesita una lógica para mostrar que es un 
		// consumidor.

		// Se agrego un parámetro adicional String cadena, ahora en vez de longitud será cadena.
		// Cambiamos el criterio de busqueda simplemente, esto puede ponerse dentro de un if
		// para evaluar que parámetro ha sido colocado y ejecutar cualquiera de estas opciónes.
		lista.stream().filter(this.establecerLogicaFiltro(cadena)).forEach(consumidor);
		
		// Ahora haremos una sobrecarca de métodos utilizando el mismo nombre pero con diferente paramétro
	}
	
	// Creamos la función que retorna el predicado (una expresión lambda) e importamos lo que nos pide.
	public Predicate<String> establecerLogicaFiltro(int longitud){
		return texto -> texto.length() < longitud;
	}
	
	// Segunda función de sobrecarga, mira como con cambiar el parámetro se hace valida.
	public Predicate<String> establecerLogicaFiltro(String cadena){
		// Si contiene el elemento que viene aquí
		return texto -> texto.contains(cadena);
		
		// Para la sensibilidad de mayúsculas o minusculas, 
		// return texto -> texto.toLowerCase().contains(cadena.toLowerCase());
	}
	
	public static void main(String[] args) {
		HighApp app = new HighApp();
		// A esta le pasaremos la función y una cadena en minúsculas.
		app.imprimir(app.converirMayusculas, "luis eduardo");
		
		// Vemos que efectivamente sale la cadena convertida en Mayúsculas.

		app.imprimir(app.converirMinusculas, "LUIS");
		
		// Básicamente consiste en poder enviar y retornar funciones.
		
		// Continuamos con la explicación del méodo mostrar()
		// Aquí le pasaremos el mensaje que es la variable mensaje.
		// Pero este mostrar nos retorna una Function y si nos retorna eso entonces
		// podemos utilizar el método apply() y si utilizamos esté metodo entonces
		// este es como si invocara a la Function (que ejecuta la expresión Lambda)
		// y este nos solicita un dato (como lo definimos en la Function) en este caso la variable x
		// y como esta Function nos retorna un tipo de String entonces podemos recogerlo en una variable
		// y luego imprimirlo.
		
		String rpta = app.mostrar("Hola ").apply("Mundo");
		
		System.out.println(rpta);
		
		// Hemos podido pasarle un parámetro y la respuesta que es una función y hemos podido obtener su valor.
		
		// Invocamos al método filtrar.
		
		List<String> lista = new ArrayList<>();
		lista.add("Luis");
		lista.add("Eduardo");
		lista.add("Luis Eduardo");
		
		// Le pasamos la lista, el consumidor va a ser justamente la referencia a métodos, es decir una
		// función. Y la longitud vamos a pasarle un valor por defecto, un 7 por ejemplo.
		
		// Lo que le estamos diciendo es que me muestre de está lista aquellos elementos que tengan una 
		// longitud menor a 7
		// app.filtrar(lista, System.out::println, 7);
		
		// Podemos añadirle un parametro adicional String cadena para buscar por una sobrecarga de métodos
		// por una cadena en particular. Esto podría evaluarse en un if para saber
		// cual función de sobrecarga ejecutar.
		
		// app.filtrar(lista, System.out::println, 7, null);
		
		// Le pasamos 0 porque no nos importa la longitud, esto podría evaluarse en un if para saber
		// cual función de sobrecarga ejecutar.
		
		app.filtrar(lista, System.out::println, 0, "Luis");
		
		// Ahora vemos que justamente nos devuelve los elementos que tiene la palabra Luis
		
		// Para la sensibilidad de mayúsculas o minusculas.
		// app.filtrar(lista, System.out::println, 0, "LuIs");
		
		// RESUMEN: Vemos que podemos tener el paso de las funciones Function, como simples paramétros
		// también podemos retornar esas funciones y utilizarlas para obtener una respuesta gracias al
		// método apply().
	}

}
