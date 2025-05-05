package com.luis.java8.tema4.Metodos_por_Defecto__Default_Methods;

//Los Default Methods son una nueva funcionalidad que nos proporciona
//JAVA 8 para las Interfaces.

//Un método default es un método que está implementado en una interfaz
//para que cualquier Clase que implemente está interfaz ya tenga acceso
//al método definido (por defecto por obvias razones).

public interface PersonaA {

	public void caminar();
	
	// Para hacer un método default hacemos lo siguiente:
	// Utilizamos el keyword/palabra_reservada default, indicamos el ambito
	// y el tipo de método.
	// Y como es un método por defecto necesitamos implementarlo.
	default public void hablar() {
		System.out.println("Saludos Coders - PersonaA");
		
		// Invocando un método con su implementación dentro del default. 
		PersonaA p = ()-> System.out.println("Hola mundo");
		p.caminar();
	}
	
}
