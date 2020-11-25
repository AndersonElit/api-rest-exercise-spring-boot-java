package com.apiemp.apiemp.controlador;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.apiemp.apiemp.modelo.Modelo;

public interface ControladorInt {
	
	public void insertarEmp(@RequestBody Modelo mod);
	
	//public void eliminarEmp(@RequestBody Modelo mod);
	
	public void eliminarEmp(@PathVariable int id);

}
