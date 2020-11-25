package com.apiemp.apiemp.repositorio;

import com.apiemp.apiemp.modelo.Modelo;

public interface RepositorioInt {
	
	public void insertarEmpresa(Modelo mod);
	
	public void eliminarEmpresa(int id);

}
