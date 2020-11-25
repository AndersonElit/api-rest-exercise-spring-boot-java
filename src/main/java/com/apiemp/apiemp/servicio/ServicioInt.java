package com.apiemp.apiemp.servicio;

import java.util.List;

import com.apiemp.apiemp.modelo.Modelo;

public interface ServicioInt {
	
	public void insertarEmpresa(Modelo mod);
	
	public void eliminarEmpresa(int id);
	
	public void editarEmpresa(int id, String nuevoNombre);
	
	public List<Modelo> listarEmpresas();

}
