package com.luis.java8.tema4.Metodos_por_Defecto__Default_Methods;
// Que pasaria si yo tuviera está otra interfaz y tuviera el
// mismo método que la interfaz PersonaB.

public interface PersonaB {
	
	default public void hablar() {
		System.out.println("Saludos Coders - PersonaB");
	}

}
