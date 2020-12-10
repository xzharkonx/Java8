package com.luis.java8.tema9.Optional;

import java.util.Optional;

// La Clase Optional.

// Está clase que viene en la JDK 1.8 es muy importante porque
// nos va a permitir poder lidiar con estos famosos errores
// conocidos como nullPointerException.

public class OptionalApp {
	
	public void probar(String valor) {
				
		// Para evitar el error de  java.lang.NullPointerException
		// al encontrar valores nulos podemos hacer lo siguiente.
		
		// Estamos creando un objeto Optional vacio.
		// Importamos lo que nos pide.
		
		// Optional op = Optional.empty();
		
		// Este Optional es como un envoltorio, sale en amarrillo 
		// porque (opcional) tenemos que indicarle el tipo de dato.
		
		// Y si queremos optener el contenido de este envoltorio
		// tenemos que apoyarnos del método get()
		// Este retorma el valor que se indico como dato en el generio.
		// Si lo dejamos sin nada nos devolvera un tipo Object
		
		// op.get();

		// Si colocamos uno de tipo String, get() retornaría un tipo String.
		// Optional<String> op = Optional.empty();
		
		// System.out.println(valor.contains("luis"));

		// Si comentamos la línea de arriba nos saldrá un error
		// de tipo:  java.util.NoSuchElementException
		// ¿Que quiere decir esto?
		// Que el contenido de está variable Optional no ha
		// sido inicializado, por lo tanto al momento de optenerlo
		// no tenemos ningún elemento.
		// Y esto lo podríamos gestionar en un bloque try catch
		
		try {
			
			Optional op = Optional.empty();
			op.get();
			
		} catch (Exception e) {
			System.out.println("No hay elemento");
		}
		
		// Entonces el error ha sido gestionado de manera adecuada.
	}
	
	public void orElse(String valor) {
		// Pero ya no lo inicializaremos vacio, si no vamos a depender
		// de un valor que venga por parámetro.
		
		// Optional<String> op = Optional.of(valor);
		
		// Si yo quisiera obtener el contenido tendría que apoyarme de
		// el método get()
		
		// String x = op.get();
		// System.out.println(x);
		
		// Entonces con orElse nosotros indicaremos lo siguiente, si el valor
		// es nulo vamos a indicar un valor por defecto y de está manera
		// vamos a evitar este famoso error.
		
		// nos apoyaremos del método orNullable
		// Y en la instancia (la variable op) utilzamos el método orElse,
		// y dentro le pasaremos el valor por defecto que vamos a indicar.
		
		Optional<String> op = Optional.ofNullable(valor);
		
		String x = op.orElse("Valor predeterminado");
		System.out.println(x);
		
	}
	
	public void orElseThrow(String valor) {
		
		// Básicamente va a tener una función muy similar pero en está ocación que si el
		// valor es nulo, vamos a poder tener la facultad de arrojar una excepción.
		
		Optional<String> op = Optional.ofNullable(valor);
		
		// Dentro podemos indicar cualquier tipo de excepción que gustemos.
		// Por defecto sería un nullPointerException, pero para el ejemplo indicamos un
		// NumberFormatException y llamamos por un método de referencia al constructor
		// de está clase
		
		// Lo podemos encerrar dentro de un bloque try catch para manejar el error
		
		try {			
			String x = op.orElseThrow(NumberFormatException::new);
			System.out.println(x);
		} catch (Exception e) {
			System.out.println("El error es: " + e);
		}
	}
	
	public void isPresent(String valor) {
		
		// Es para verificar si el valor ha sido inicializado o no.
		
		Optional<String> op = Optional.ofNullable(valor);
		System.out.println(op.isPresent());
	}

	public static void main(String[] args) {
		OptionalApp app = new OptionalApp();
		// app.probar(null);
		
		// A este método le pasaremos un valor null.
		// Mira que al correr la aplicación veremos el famoso error
		// de:  java.lang.NullPointerException

		// Está Clase Optional presenta unos métodos muy importantes
		// al momento de encontrar si es que una variable esta nula
		// o no está inicializada.
		
		// Uno de estos métodos es orElse ----------------------------------------------
		System.out.println("El método orElse --------------------------");
		// app.orElse("Luis");
		
		// Al correr la aplicación vemos que efectivamente tenemos "Luis"
		// Pero hasta aquí no hemos hecho la funcionalidad de orElse.
		// ¿Que pasaría si nosotros colocamos null?
		
		// app.orElse(null);
		
		// Obtendríamos el famoso: java.lang.NullPointerException
		
		// Entonces con orElse nosotros indicaremos lo siguiente, si el valor
		// es nulo vamos a indicar un valor por defecto y de está manera
		// vamos a evitar este famoso error.
		
		// Entonces si le mandamos null nos sale el valor predeterminado.
		app.orElse(null);
		// Si le mandamos el valor, entonces tomará este valor.
		app.orElse("Luis");
		
		System.out.println("\nEl método orElseThrow ---------------------");
		
		// El método orElseThrow -------------------------------------------------------
		// Básicamente va a tener una función muy similar pero en está ocación que si el
		// valor es nulo, vamos a poder tener la facultad de arrojar una excepción.
		
		app.orElseThrow(null);

		// Vemos que tenemos ahora la excepción de: NumberFormatException
		// Si le pasamos un valor veremos que no nos dará un error porque si realmente
		// tenemos un valor.
		
		app.orElseThrow("Eduardo");
		
		// Podríamos colocarlo dentro de un bloque try catch para manejar el error.
		
		System.out.println("\nEl método isPresent -----------------------");
		
		// El método isPresent -------------------------------------------------------
		// Es para verificar si el valor ha sido inicializado o no.
		
		app.isPresent(null);
		
		// Y como el valor que le pasamos es null, entonces no ha sido inicializado
		// por lo que nos devuelve un false
		// Si le pasamos un valor, entonces ya estára inicializado y nos devolvera un true.
		
		app.isPresent("Luis Eduardo");
		
		// Con esto es una manera muy básica de poder controlar nuestros famosos nullPointerException
		// Optional tiene muchos más métodos a su disposición. Podríamos ver la implementación de esa Clase.
		
		// En algunas situaciones no es muy recomendable utilizar esto especifícamente si nosotros
		// queremos tener aplicaciones criticas en rendimiento, puesto que utilizar está Clase es un poco
		// costoso para la memoria.
		
		// Resumen: Si esperas que NO exista o mejor dicho "aparezca una respuesta Null" para cualquier 
		// instancia o respuesta de algo que estés programando, lo mejor es usar Optional, pero con 
		// excepciones del manejo.
	}

}
