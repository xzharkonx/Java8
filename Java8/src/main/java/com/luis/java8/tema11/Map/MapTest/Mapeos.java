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
	

	public static void main(String[] args) {
		
		Mapeos mapeos = new Mapeos();
		mapeos.poblar();
		mapeos.mapeoLista();
		mapeos.mapeoMapa();
		

	}

}
