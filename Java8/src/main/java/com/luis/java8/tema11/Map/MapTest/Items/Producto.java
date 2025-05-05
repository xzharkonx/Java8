package com.luis.java8.tema11.Map.MapTest.Items;

public class Producto {
	
	private String nombre;
	private Double precio;
	private String marca;
	private String modelo;
	private String descripcion;
	private String tamanio;
	private String peso;
	public Producto() {
		super();
	}
	public Producto(String nombre, Double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	public Producto(String nombre, Double precio, String descripcion) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	public Producto(String nombre, Double precio, String marca, String descripcion) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.descripcion = descripcion;
	}
	public Producto(String nombre, Double precio, String marca, String modelo, String descripcion, String tamanio,
			String peso) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.modelo = modelo;
		this.descripcion = descripcion;
		this.tamanio = tamanio;
		this.peso = peso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTamanio() {
		return tamanio;
	}
	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Productos [nombre=" + nombre + ", precio=" + precio + ", marca=" + marca + ", modelo=" + modelo
				+ ", descripcion=" + descripcion + ", tamanio=" + tamanio + ", peso=" + peso + "]";
	}
	
	

}
