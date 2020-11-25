package com.apiemp.apiemp.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiemp.apiemp.modelo.Modelo;
import com.apiemp.apiemp.repositorio.Repositorio;

@Service
public class Servicio implements ServicioInt {
	
	@Autowired
	private Repositorio repo;
	
	public void insertarEmpresa(Modelo mod) {
		repo.insertarEmpresa(mod);
		System.out.println("se agrego una empresa");
	}
	
	public void eliminarEmpresa(int id) {
		repo.eliminarEmpresa(id);
		System.out.println("se elimino la empresa");
	}
	
	public void editarEmpresa(int id, String nuevoNombre) {
		repo.editarEmpresa(id, nuevoNombre);
		System.out.println("se edito la empresa");
	}
	
	public List<Modelo> listarEmpresas() {
		return repo.listaEmpresas();
	}

}
