package com.luis.java8.tema11.Map.MapTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.luis.java8.tema11.Map.MapTest.Items.Producto;

public class Mapeos {
	
	List<Producto> lp;
	Map<Integer, String> map;
	static Map<String, String> mapTest;
	
	public void poblar() {
		lp = new ArrayList<>();
		lp.add(new Producto("Monster", 35.0));
		lp.add(new Producto("Sabritas", 45.0));
		lp.add(new Producto("Cocholate Hersey's", 42.0));
		lp.add(new Producto("Salsa Magge", 60.0));
		lp.add(new Producto("Papel Higienico", 55.0));
		
		map = new HashMap<>();
		map.put(1, "Luis");
		map.put(2, "Eduardo");
		map.put(3, "Luis Eduardo");
		
	}
	
	public void mapeoLista() {
		
		lp = new ArrayList<>();
		lp.add(new Producto("Monster", 35.0));
		lp.add(new Producto("Sabritas", 45.0));
		lp.add(new Producto("Cocholate Hersey's", 42.0));
		lp.add(new Producto("Salsa Magge", 60.0));
		lp.add(new Producto("Papel Higienico", 55.0));
		Double precioObjetivo = 50.00d;
		Double descuento = 0.8d;
		
		// Guarda los valores en otra instancia.
		List<Producto> lp2 = lp.stream().filter(p -> (p.getPrecio() < precioObjetivo))
				.map(e-> {
					e.setPrecio(e.getPrecio()*0.8);
					return e;
				})
				.collect(Collectors.toList());
		
		lp2.stream().forEach(System.out::println);
		
	}
	
	public void mapeoLista2() {
		
		lp = new ArrayList<>();
		lp.add(new Producto("Monster", 35.0));
		lp.add(new Producto("Sabritas", 45.0));
		lp.add(new Producto("Cocholate Hersey's", 42.0));
		lp.add(new Producto("Salsa Magge", 60.0));
		lp.add(new Producto("Papel Higienico", 55.0));
		Double precioObjetivo = 50.00d;
		Double descuento = 0.8d;
		
		// Sustituye los valores de su propia instancia.
		lp = lp.stream().filter(p -> (p.getPrecio() < precioObjetivo))
				.map(e-> {
					e.setPrecio(e.getPrecio()*0.8);
					return e;
				})
				.collect(Collectors.toList());
		
		lp.stream().forEach(System.out::println);
		
	}
	
	public void mapeoMapa() {
		
		Map<Integer, String> mapaRecolectado = map.entrySet().stream()
				.filter(e -> e.getValue().contains("Lu"))
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		
		// Y como ya tenemos este mapa recolectado ahora lo imprimiremos.
		// Así:
		
		// mapaRecolectado.entrySet().stream().forEach(System.out::println);
		
		// O así:
		
		mapaRecolectado.forEach((k,v) -> System.out.println("Llave: " + k + " Valor: " + v));
	}
	
	static void mapeoTest() {
		
		mapTest = new HashMap<>();
		mapTest.put("1", "Luis");
		mapTest.put("2", "Eduardo");
		mapTest.put("3", "Luis Eduardo");
		mapTest.put("canal", "123");
		mapTest.put("token", "abc");
		
		mapTest.putIfAbsent("4", "cuatro");
		mapTest.putIfAbsent("4", "cinco");
	}
	

	public static void main(String[] args) {
		
		Map<String, String> mapeo = new HashMap();
		mapeo.put("id", "000");
		
		Mapeos mapeos = new Mapeos();
		mapeos.poblar();
		mapeos.mapeoLista();
		mapeos.mapeoMapa();
		
		System.out.println("--------------");
		
		mapeoTest();
		mapTest.putIfAbsent("canal", "12345");
		mapTest.putIfAbsent("5", "5");
		mapTest.putIfAbsent("1", "51");

		mapTest.forEach((k,v) -> System.out.println("Llave: " + k + " Valor: " + v));
		
		System.out.println("-----Llenando Mapa---------");
		
		// Se extren unos valores de un mapa y se extraen en otro mapa.
		
		mapTest.forEach((k,v) -> {
			if(k.equalsIgnoreCase("canal")) {
				mapeo.putIfAbsent(k, v);
			} else if(k.equalsIgnoreCase("token")) {
				mapeo.putIfAbsent(k, v);
			}
		});
		
		mapeo.forEach((k,v) -> System.out.println("Llave: " + k + " Valor: " + v));
		
		
		System.out.println("-----Validar contenido de Mapa---------");
		
		Map<String, String> mapeoVacio = new HashMap();
		// mapeoVacio.put("1", "Hola mundo");
		mapeoVacio.put("2", "Hola mundo");
		if(mapeoVacio!=null && mapeoVacio.size()>0) {
			System.out.println("No es nulo");
			System.out.println("Y tiene contenido");
			mapeoVacio.entrySet().stream().forEach(System.out::println);
		} else {
			System.out.println("Es nulo o no tiene contenido.");
		}
		
		System.out.println("Tamaño del mapa: "+mapeoVacio.size());
		
		
	}

}
