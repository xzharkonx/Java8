package com.luis.java8.tema6.Refetencias_de_Metodos__Method_References;

@FunctionalInterface
public interface IPersona {
	
	// Método crear que nos devolverá un Objeto de tipo persona y 
	// le psaremos 2 argumentos a los 2 parámetros que tiene.
	Persona crear (int id, String nombre);

}
