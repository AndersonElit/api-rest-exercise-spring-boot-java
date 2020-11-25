package com.apiemp.apiemp.repositorio;

import java.util.List;

import com.apiemp.apiemp.modelo.Modelo;

public interface RepositorioInt {
	
	public void insertarEmpresa(Modelo mod);
	
	public void eliminarEmpresa(int id);
	
	public void editarEmpresa(int id, String nuevoNombre);
	
	public List<Modelo> listaEmpresas();

}
