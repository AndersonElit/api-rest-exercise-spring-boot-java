package com.apiemp.apiemp.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apiemp.apiemp.modelo.Modelo;
import com.apiemp.apiemp.repositorio.Repositorio;

@Service
public class Servicio implements ServicioInt {
	
	@Autowired
	private Repositorio repo;
	
	@Transactional
	public void insertarEmpresa(Modelo mod) {
		repo.insertarEmpresa(mod);
		System.out.println("se agrego una empresa");
	}
	
	public void eliminarEmpresa(int id) {
		repo.eliminarEmpresa(id);
		System.out.println("se elimino la empresa");
	}

}