package com.apiemp.apiemp.modelo;

public class Modelo implements ModeloInt {

	private int id_empresa;
	private String nombre;
	
	public void Model() {
		
	}
	
	public void Model(int id, String nombre) {
		this.id_empresa = id;
		this.nombre = nombre;
	}
	
	public int getId() {
		return id_empresa;
	}
	
	public void setId(int id) {
		this.id_empresa = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
