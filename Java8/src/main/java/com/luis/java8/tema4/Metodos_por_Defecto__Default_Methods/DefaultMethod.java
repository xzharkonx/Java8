package com.luis.java8.tema4.Metodos_por_Defecto__Default_Methods;
// Los Default Methods son una nueva funcionalidad que nos proporciona
// JAVA 8 para las Interfaces.

// Un método default es un método que está implementado en una interfaz
// para que cualquier Clase que implemente está interfaz ya tenga acceso
// al método definido (por defecto por obvias razones).
// Revisa como se hace esto en la Interfaz PersonaA.


// Implementamos la interfaz PersonaA
// Por obvias razones tenemos que implementar sus métodos.
public class DefaultMethod implements PersonaA, PersonaB{

	@Override
	public void caminar() {
		System.out.println("Hola programadores");
		
	}
	
	// ----------------------------------------------------------------------------------
	// Que pasaria si yo tuviera está otra interfaz y tuviera el
	// mismo método que la interfaz PersonaB.
	// Al implementar la otra Interfaz nos marca en rojo/error la Clase,
	// Esto es debido a que JAVA internamente no va a saber cuál método voy
	// a implementar por que ambos se llaman de la misma manera.
	
	// Entonces para poder invocar a un determinado proceso de una interfaz
	// lo que voy a hacer es hacer clic en el foquito de error y podemos ver
	// gracias al IDE podemos seleccionar que quiero la interfaz A o B.
	// En este caso utilizaremos la A
	
	// Podemos ver que nos ha sobreescrito el método hablar(), nos ha hecho un
	// @Override donde simplemente hace mención a la interfaz que quiero
	// utilizar PersonaA para poder emplear a travez del keyword super
	// el método hablar(). Con esto estoy indicando exactamente cuál es
	// la interfaz que necesito para implementar el método default.
	
	//	@Override
	//	public void hablar() {
	//		PersonaA.super.hablar();
	//		// PersonaB.super.hablar();
	//	}
	
	// O bien que pasaría si necesariamente necesito implementar esta interfaz
	// pero hay una Clase que como excepción necesita sobre escribir su propia
	// logica, entonces lo que haríamos seria volver a sobreescribir el metodo
	// en este caso hablar, colocandolo de la siguiente manera.
	@Override
	public void hablar() {
		 PersonaA.super.hablar();
		// PersonaB.super.hablar();
		//System.out.println("Método default sobreescrito");
	}
	
	// Cabe mencionar que puede cambiarse a que el método retorne algo, ya 
	// depende de nuestra logica.
	
	// --------------------------------------------------------------------------------

	public static void main(String[] args) {
		DefaultMethod app = new DefaultMethod();
		app.caminar();
		
		// Ahora llamamos al default method. Podemos ver que el IDE
		// nos muestra el método con una D, que representa el método
		// default.
		// Mira que con solo instanciar la Clase ya tenemos acceso al método.
		app.hablar();
		
		// En que momentos nos sería util utilizar este default method
		// que nos proporciona JAVA 8.
		
		// En un ambiente real de producción aveces tenemos que implementar
		// nuevas funcionalidades y en muchas ocaciones se trabaja orientado
		// a interfaces, ¿Para Que?, para tener un codigo desacoplado.
		
		// Entonces imaginemos que se nos pida como requerimiento que todas
		// las Clases que implemente una determinada Interfaz necesita tener
		// un comportamiento por defecto.
		// Entonces tenemos 2 opciones:
		// La primera es crear de la forma tradicional simplemente haciendo 
		// mención al método y sobreescribiendo en cada clase.
		// La segunda es utilizar un método por defecto Implementar la 
		// funcionalidad y que todas las clases que implementen la interfaz
		// ya tengan acceso al método con toda la lógica implementada.
		
		
	}


}
