package com.luis.java8.tema12.Anotaciones_de_Repeticion;

public @interface AnnotacionCustom {

	String nombre();
	boolean habilitado() default true;
}
