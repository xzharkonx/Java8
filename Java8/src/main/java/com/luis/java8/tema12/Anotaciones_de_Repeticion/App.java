package com.luis.java8.tema12.Anotaciones_de_Repeticion;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// En este tema veremos sobre las anotaciones de repetición
// que nos ofrece la JDK 1.8.

// ¿En que nos beneficia esto?, ¿Como puedo utilizarlo?

// Este concepto esta muy ligado al Api Reflection de JAVA
// Este API Reflection básicamente te permite tener operaciones
// de manipulación con Objetos o Clases, atributos o métodos un 
// Objeto o una Clase Particular si mayormente es utilizado en
// tiempo de ejecución.

// En este tema veremos como crear estás anotaciones y utilizar
// básicamente el API reflection para manipular las anotaciones.

// Entonces vamos a hacer una anotación customizable.


public class App {

	// Para crear una anotación en JAVA tenemos que usar el keyword
	// @interface y el nombre de tu anotación.
	
	@Retention(RetentionPolicy.RUNTIME) // Al final se explica esta anotación.
	public @interface Lenguajes{
		// Básicamente vamos a indicarle un array que va a ser llenado más adelante.
		
		// Pero mira lo que sale, aquí estamos haciendo referencia a que nos sale un arreglo
		// de una anotación llamada lenguaje (en el foquito rojo), nos dice, no existe la
		// anotación llamada Lenguaje "Creala" (La creamos abajo), veremos que ya no tenemos
		// ningun error en sintaxis.
		Lenguaje[] value() default{
			
		};
		
	}
	
	// Para crearla hacemos lo siguiente
	@Repeatable(value = Lenguajes.class) // Al final se explica esta anotación.
	public @interface Lenguaje{
		String value();
		
		// Ejemplo que se explica hasta abajo.
		// OJO las anotaciones no presentan parametros (los métodos)
		String nombreUsuario() default "Luis Eduardo";
	}
	
	// Ahora nos vamos a apoyar en una interface simple
	// Y le voy a indicar algunos elementos decriptivos que nos va a decir que tipo de 
	// lenguaje es. Para las vesiones de la JDK 1.7 hacia abajo era de esta manera:
	// Colocabamos Lenguajes, habriamos y cerrabamos parentesís e indicabamos en llaves
	// las anotaciones básicamente que implementaban este grupo de anotación.

	/*	
	 
	  	@Lenguajes({
		@Lenguaje("Java"),
		@Lenguaje("Python")
	})
	public interface LenguajeProgramacion{
		
	}
	
	*/
	
	// JDK 1.8, solo declaramos las anotaciones.
	@Lenguaje("Java")
	@Lenguaje("Python")
	public interface LenguajeProgramacion{
		
	}
	public static void main(String[] args) {

		// Entonces en nuestro método main vamos a utilizar el API Reflection para poder manipular y 
		// consultar estas anotaciones.
		
		// Invocamos un Arreglo de esta anotación, un arreglo de anotaciones.
		// Le pasamos el nombre de nuestra interfaz y luego .class
		// Muy importante, el API Reflection se basa en nuestras Clases, es por eso que aquí
		// colocaremos luego get pero para esta ocación se indica de una Clase en particular
		// que sería la que creamos Lenguaje.class
		
		// Entonces tengo un arreglo de anotaciones llamada Lenguaje
		
		Lenguaje[] lenguajeArray = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
		
		// Y aquí imprimiremos la cantidad de anotaciones que presentamos.
		
		System.out.println("Se tiene " + lenguajeArray.length + " anotaciones en Lenguaje");
		
		// Pero nos saldrá 0, esto es por que por default el scope de la retención es decir, el ambito
		// de está anotación es class, pero hay un ambito que debemos especificar cuando estamos
		// ejecutando el código y este ambito es runtime, es por eso que a la primera interfaz
		// de Lenguajes le colocamos la anotación de @Retention y entre parentesís colocamos el tipo
		// de retención que sera: RetentionPolicy.RUNTIME que se importan del paqueta java.lang.annotation
		
		// Entonces volvemos a correr la aplicación y vemos que nuevamente se tienen 0 anotaciones.
		
		// Ahora lo que vamos a hacer es agregar una anotación adicional para indicar que las anotaciones
		// repetidas sean leidas por la JVM (Java Virtual Machine), entonces vamos a indicar en la interfaz
		// Lenguaje la anotación de Repeatable y dentro de el vamos a indicar que anotación es la que 
		// se va a repetir en este caso será la de Lenguajes y quedaría como @Repeatable(value = Lenguajes.class)
		// La de Lenguajes se repite porque esta es la que va a contener varios subtipos de Lenguaje.
		
		// Ahora corremos la aplicación nuevamente y vemos que tenemos 2 anotaciones.
		
		// Ahora esto es en la versión 1.7.
		
		// En la verción 1.8 ha mejorado para que sea más legible. 
		// Simplemente vamos a indicar las anotaciones
		// que vamos a repetir.
		
		// Volvemos a correr la aplicación y vemos sale la misma cantidad de 2 anotaciones.
		
		// Y si yo quisiera saber cuales son esas anotaciones tendría que apoyarme en el API Reflection
		// y haríamos lo siguiente.
		// Colocamos la anotación de Lenguajes, le pasamos la interfaz LenguajeProgramacion.class y 
		// utilizamos el método de getAnnotation() y le indicamos que Clase, en este caso será Lenguajes.class
		
		Lenguajes len = LenguajeProgramacion.class.getAnnotation(Lenguajes.class);
		
		// Ahora vamos a iterar la anotación.
		
		for (Lenguaje elemento : len.value()) {
			System.out.println(elemento.value());
		}

		// Esto es básicamente el uso de la api reflection.
		// Podemos ve que nos sale Java y Python
		
		// ¿Esto de que me es util?
		
		// Muchos Frameworks, especialmente que hacen test o pruebas se basan en el uso de API Reflection
		// y en el uso de anotaciones customizables.
		
		// ¿Para que puede servir una anotación customizable?
		// Para indicar también metadatos.
		
		// ¿Que es un metadato?
		// Es un dato de un dato.
		// Lo que quiere decir es que en las anotaciones customizables tu puedes colocar información en lugar
		// de un simple comentario, información más adicional.
		
		// Por ejemplo en Lenguaje definimos un método de la siguiente forma
		// String nombreUsuario() default "Luis Eduardo";
		// Y listo, con esto ya tenemos la anotación ya creada y podemos volver a utilizarla.
		
		// Ahora, lo que aquí se ha hcho es crearla en forma lineal, nostros podriamos crear una anotación
		// de nuestra preferencia yendo al paquete, clic derecho y seleccionando annotation, aquí le colocaremos
		// el nombre que querramos y la crearemos.
		
		// Podríamos colocarle lo que nosotros gustemos. Los datos que creamos convenientes.
	}

}
