package com.luis.java8.tema11.Map;

// En esta versión de la JDK 1.8 ha presentado
// algunas mejoras.

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class App {

	private Map<Integer, String> map;
	
	public void poblar() {
		map = new HashMap<>();
		map.put(1, "Luis");
		map.put(2, "Eduardo");
		map.put(3, "Luis Eduardo");
		
	}
	
	public void imprimir_v7() {
		for (Entry<Integer, String> e : map.entrySet()) {
			System.out.println("Llave: " + e.getKey() + " Valor: " + e.getValue());
		}
	}
	
	public void imprimir_v8() {
		// Forma más declarativa
		
		// map.forEach((k,v) -> System.out.println("Llave: " + k + " Valor: " + v));
		
		// Gracias al uso de forEach podemos hacer también lo siguiente,
		// utilizando ahora podemos obtener el entrySet() nosotros podemos apoyarnos
		// del framework stram() para poder seguir unsando estos métodos uno de ellos
		// es forEach y con el podríamos usar nuestros métodos a referencia.
		
		map.entrySet().stream().forEach(System.out::println);

		// También se podría usar una expresión Lambda de está manera.
		
		// map.entrySet().stream().forEach(x -> System.out.println(x));
	}
	
	public void recolectar() {
		
		// Como broche de ORO se explicará esta funcionalidad de recolectar
		// que es como un plus o algo que se utiliza muy común en algunas
		// operaciones con listas o con mapas.
		
		// Imaginemos tener un conjunto de elementos en un mapa y queremos
		// filtrar esos elementos bajo un criterio. Si este criterio 
		// obedece o se respeta extraeremos esos elementos a otra lista
		// o a otro mapa.

		// Ejemplo: Vamos a evaluar el mapa, aplicar una lógica de filtrado
		// y extraer esos filtros a un mapa nuevo.
		// Nos apoyararemos del método entrySet() y usamos el Framework stream().
		
		// Y en el método filter le indicamos el predicado que necesitamos para el filtrado,
		// obtenemos el valor con getValue() e indicamos con contains() que se filtre por
		// una cadena String que le pasemos.
		
		// Y al final nos apoyamos del método collect() le pasamos la Clase Collectors.toMap().
		// Y este Collectors.toMap() va a necesitar evaluar como armar este nuevo mapa en base
		// a la colección filtrada, para ello le indicaremos con una expresión Lambda estamos 
		// armando llave (key) y valor (value) del nuevo elemento.
		
		Map<Integer, String> mapaRecolectado = map.entrySet().stream()
				.filter(e -> e.getValue().contains("Lu"))
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		
		// Y como ya tenemos este mapa recolectado ahora lo imprimiremos.
		// Así:
		
		// mapaRecolectado.entrySet().stream().forEach(System.out::println);
		
		// O así:
		
		mapaRecolectado.forEach((k,v) -> System.out.println("Llave: " + k + " Valor: " + v));
		
		// Vemos que en el nuevo mapa se han recolectado los valores por los que hemos filtrado. 
		
	}
	
	public void insertarSiAusente() {
		// Si esta ausente lo insertara si no, no.
		
		// Utilizaremos de map el método putIfAbsent, este metodo lo
		// que nos provee es agregar un valor que le vamos a indicar si
		// no se encuentra.
		
		map.putIfAbsent(4, "Programador");
		
		// Corremos la aplicación y vermos que se a insertado porque
		// falta ese dato.
		// Pero que pasaría si ahora insertamos de nuevo un valor ya colocado
		
		map.putIfAbsent(2, "Programador");
		
		// Miramos que no a agregado ese valor 2 por que solamente este método
		// agrega un elemento si está ausente.
		
		// Ya que si agregamos un método put() va a sobreescribirlo.
	}
	
	public void operarSiPresente() {
		
		// Utilizaremos de map el método computaIfPresent, este metodo lo
		// que nos provee es que si el dato (key) esta presente podemos
		// hacer una determinada operación que definamos aquí.
		
		// Por ejemplo, unir la key con el value como una cadena String
		map.computeIfPresent(3, (k,v) -> k + v);
		System.out.println(map.get(3));
	}
	
	public void obtenerOrPredeterminado() {
		
		// Obtendremos lo que le hemos colocado en la cadena, ¿porque?
		// Si el número 5 (key) vemos que no tiene un valor asociado
		// le podemos indicar este valor por defecto.
		// colocaremos una llave que no está, en este ejemplo la 5.
		
		String valor = map.getOrDefault(5, "Valor por defecto");
		System.out.println(valor);
		
		// Si por ejemplo colocamos un valor que si esta, pues tomará
		// el valor del que si está en vez de este que le hemos puesto.

		String valor2 = map.getOrDefault(2, "Valor por defecto");
		System.out.println(valor2);
	}
	
	public static void main(String[] args) {
		App app = new App();
		app.poblar();
		// app.imprimir_v7();
		// app.insertarSiAusente();
		// app.imprimir_v8();
		// app.operarSiPresente();
		// app.obtenerOrPredeterminado();
		app.recolectar();

	}

}
