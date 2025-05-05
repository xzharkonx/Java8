package com.luis.java8.tema6.Refetencias_de_Metodos__Method_References;

import java.util.Arrays;
import java.util.Comparator;

// Referencia a métodos
// Los cuales nos permiten tener un código legible, facil de leer y tener
// menos líneas de codigo.

// Existen 4 tipos:
// referenciarMetodoStatic
// referenciarMetodoInstanciaObjetoParticular
// referenciarMetodoInstanciaObjetoParticular
// referenciarConstructor

public class MeRefApp {
	
	public static void referenciarMetodoStatic() {
		System.out.println("Método Referido Static");
	}

	
	public void referenciarMetodoInstanciaObjetoArbitrario() {
		System.out.println("Método Referido de Instancia de Objeto Arbitrario");
		String[] nombres = {"Mito", "Code", "Jaime"};
		
		// 1ra manera para implementar esta lógica de comparar para ordenar un Array. JDK 1.7. ----------
		// Si lo hacemos asi sería un poco verboso, por eso lo
		// haremos con lambda. (Paradigma Imperativo)
		
		/*Arrays.sort(nombres, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
			
		});*/
		
		// 2da manera para implementar esta lógica de comparar para ordenar un Array. JDK 1.8. ----------
		// Programación Declarativo/con tipo paradigma Funcional.
		// Nos apoyamos de la expresión Lambda y evitamos la Clase anonima.
		
		// Arrays.sort(nombres, (s1, s2) -> s1.compareToIgnoreCase(s2));
		
		// 3ra manera para implementar esta lógica de comparar para ordenar un Array. JDK 1.8. ----------
		// Pero esto de arriba sigue siendo un poco vervoso, como podríamos reducirlo
		// con la referencia a métodos.
		// Se haría de la siguiente manera:
		// Le pasamos los nombres y como segundo parametro indicamos String (porque es
		// la Clase que voy a comparar la del Array) e invocamos con :: al método
		// compareToIgnoreCase
		
		Arrays.sort(nombres, String::compareToIgnoreCase);
		
		// Lo que hacemos aqui arrba es simplemente apoyarnos de la Clase Arrays, el método
		// sort, le pasamos la lista y aquí se invoco un método compareToIgnoreCase.
		// ¿Porque se dice que es un metodo de Instancia y no Estático?.
		// Porque estoy llamando al método que es prácticamente de la instancia de la variable
		// que viene en el array (nombres), es decir, el Array internamente se va a recorrer y cuando
		// llegue elemento por elemento eso ya es una instancia y de ese elemento se va a utilizar
		// el método compareToIgnoreCase.
		
		// Imprimimos el resultado comvirtiendo el array a String.
		System.out.println(Arrays.toString(nombres));
		
	}
	
	public void referenciarMetodoInstanciaObjetoParticular() {
		System.out.println("Método Referido Instancia de un Objeto en particular");
		System.out.println(this.getClass().getSimpleName());
	}
	
	public void referenciarConstructor() {
		System.out.println("Método Referido por Constructor");
		// 
		// 1.- Llamada a esta intefaz funcional pero esto es muy excesivo, Clase anónima. -------------
		/* IPersona iper = new IPersona() {

			@Override
			public Persona crear(int id, String nombre) {
				return new Persona(id, nombre);
			}
		
		}; */
		
		// Finalmente utilizamos la interfaz, su método crear y
		// le pasamos los argumentos correspondientes.
		
		// Persona  per1 = iper.crear(1, "Luis Eduardo");

		// 2.- Con expresión Lambda. -----------------------------------------------------------------
		//IPersona iper2 = (x,y) -> (new Persona(x,y));
		// O así:
		IPersona iper2 = (x,y) -> new Persona(x,y);
		
		// Finalmente utilizamos la interfaz, su método crear y
		// le pasamos los argumentos correspondientes.
		Persona  per2 =iper2.crear(1, "Luis Eduardo");
		
		System.out.println(per2);
		
		// 3.- Con un método a referencia. ---------------------------------------------------------
		// Recuerda que los métodos de referencia siempre se apoyan de interfaces funcionales
		// Declaramos la instancia de la Interfaz, pero ¿Cuál es el Objetivo de está interfaz 
		// funcional?, es devolver una nueva instancia de Persona, entonces colocamos 
		// Persona :: new; 
		// Y Listo.
		IPersona iper3 = Persona::new;
		Persona  per3 =iper3.crear(1, "Luis Eduardo");
		System.out.println(per3);
		
		
		
	}
	
	public void operar() {
		// Mira como se sobreescribe el método de Instancia de saludar
		// por el de referenciarMetodoStatic.
		Operacion op = () -> MeRefApp.referenciarMetodoStatic();
		op.saludar();
		
		// Referencia a un método estático ---------------------------------------------------
		// Ahora hacemos lo siguiente:
		// Indicamos la interfaz, luego el nombre de la Clase y acá viene
		// como podemos sustituir está expresión lambda por una referencia 
		// de un método, para ello nos apoyamos en este operador de los 4 puntitos
		// o 2 puntos 2 veces "::" y simplemente mira como hacemos la llamada a 
		// ese método Estático (el que tenemos llamando arriba), mira que al final
		// del método ya no lleva los 2 parentesis ().
		Operacion op2 = MeRefApp::referenciarMetodoStatic;
		op2.saludar();
		
		// Veremos que tenemos el mismo resultado pero en la 2 opción hemos utilizado la
		// referencia a metodo. Como es estático colocamos la Clase MeRefApp y con el
		// operador de los 2 puntitos :: invocamos al método, ya solo colocamos el 
		// nombre del método referenciado.

		// OJO: Los métodos referenciados no pueden enviarse paramétros hasta el momento.
		// JAVA no lo permite porque no implementa un tema conocido como "Currificación".
		// ----------------------------------------------------------------------------------
		
		// Ahora ya hemos visto la referencia a un método estático

		// referencia a un método de instancia ---------------------------------------------
		// Vamos a ver la referencia a un método de instancia de un objeto de una Clase en
		// particular (un Objeto arbitrario).
	}
	
	public static void main(String[] args) {
		
		MeRefApp app = new MeRefApp();
		app.operar();
		app.referenciarMetodoInstanciaObjetoArbitrario();
		
		// Para invocar la referencia a un metodo de instancia de un Objeto en particular
		// Como invocar este método referenciarMetodoInstanciaObjetoParticular que no es estatico
		// ¿Que estamos haciendo?
		// Esto de los métodos a referencia se apoya mucho en lo que son las interfaces funcionales.
		// Lo que hacemos aquí es que esta Interfaz funcional tiene un único método que es el 
		// método saludar() y la estamos implementando con la expresión que tenemos a la derecha
		// es por eso que este es un método de Instancia de este Objeto app en particular. 
		// Con app nos apoyamos del operador ::  y le indico el método que va a implementar
		// el método saludar() de la interfaz operación.
		// Esto practimente es una función app::referenciarMetodoInstanciaObjetoParticular 
		// que se la estoy manando como implementación a mi método saludar()
		// Es por eso que implicitamente JAVA utiliza los métodos como si fueran parámetros
		// para poder implementar otros métodos.
		Operacion op = app::referenciarMetodoInstanciaObjetoParticular;
		op.saludar();
		
		// Referencia al Constructor --------------------------------------------------------------------
		app.referenciarConstructor();
		

		// Resumiendo: Con esto hemos logrado aprender la referencia a métodos.
		// Tenemos 4 tipos.
		// Referencia a métodos estáticos.
		// A métodos de instancia de un Objeto arbitrario.
		// A métodos de instancia de un Objeto en particular.
		// A la referencia de un Constructor.
		
		// Ve que es muy legible poder emplear está forma de trabajo cuando estamos programando.
		// Lo que hay que recordar es que siempre debemos de apoyarnos de una Interfaz funcional
		// y los métodos a referencias no aceptan el paso de parámetros.
		
	}

}
