package com.luis.java8.tema16.NashApp;


// Nashorn, el motor que nos permite ejecutar sentencias JavaScript
// y también hacer referencia a código JAVA desde JavaScript.

// Primero necesitamos saber como podemos invocar al motor de JavaScript que viene en
// está versión de la JDK 1.8
// Para ello nos basaremos en 3 atributos.

// Estos atributos nos van a permitir levantar el motor de JavaScript en JAVA 8.
// Así que importamos del paquete javax.script

// Aquí lo único que haremos es inicializar estos valores.

// Hacemos referencia al motor

// ¿Como lo utilizaremos?
// Vamos a utilizar el método llamarFunciones()
// de manera simple. Llamamos a nuestra variable e
// y utilizamos el método eva() aquí podemos pasarle
// en formato String código enbebido desde JAVA.

// Y así de simple.

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashApp {

	private ScriptEngineManager m;
	private ScriptEngine e;
	private Invocable invocador;
	
	public NashApp() {
		m = new ScriptEngineManager();
		e = m.getEngineByName("nashorn");
		invocador = (Invocable)e;
	}

	public void llamarFunciones() throws Exception {
		//e.eval("print('JS desde Java')");
		e.eval(new FileReader("src/main/java/com/luis/java8/tema16/NashApp/archivo.js"));
		
		String rpta = (String) invocador.invokeFunction("calcular", "2", "3");		
		System.out.println(rpta);
		
		double rpta2 = (double) invocador.invokeFunction("calcular", 2, 3);
		System.out.println(rpta2);
	}

	public void implementarInterfaz() throws Exception {
		e.eval(new FileReader("src/main/java/com/luis/java8/tema16/NashApp/archivo.js"));
		
		Object implementacion = e.get("hiloImpl");
		Runnable r = invocador.getInterface(implementacion, Runnable.class);				
		
		Thread th1 = new Thread(r);
		th1.start();
		
		Thread th2 = new Thread(r);
		th2.start();
	}

	public static void main(String[] args) throws Exception {
		NashApp app = new NashApp();
		//app.llamarFunciones();
		app.implementarInterfaz();
	}

}
