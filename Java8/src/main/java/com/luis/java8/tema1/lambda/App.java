package com.luis.java8.tema1.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Tema 1. Lambda.
 *
 */
public class App 
{
	
	public void ordenar() {
		List<String> lista = new ArrayList<>();
		lista.add("Luis");
		lista.add("Eduardo");
		lista.add("Luis Eduardo");
		
		Collections.sort(lista, new Comparator<String>() {
			@Override
			public int compare(String ol, String o2) {
				return ol.compareTo(o2);
			}
		});
		
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
