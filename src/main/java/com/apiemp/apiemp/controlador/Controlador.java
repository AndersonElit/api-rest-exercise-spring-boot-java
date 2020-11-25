package com.apiemp.apiemp.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apiemp.apiemp.modelo.Modelo;
import com.apiemp.apiemp.servicio.Servicio;

@RestController
public class Controlador implements ControladorInt {
	
	@Autowired
	private Servicio serv;
	
	@RequestMapping(value="/insertarEmp", method = RequestMethod.POST)
	public void insertarEmp(@RequestBody Modelo mod) {
		serv.insertarEmpresa(mod);
	}
	
	@RequestMapping(value="/eliminarEmp/{id}", method = RequestMethod.DELETE)
	public void eliminarEmp(@PathVariable int id) {
		serv.eliminarEmpresa(id);
	}
	
	@RequestMapping(value="/editarEmp/{id}/{nuevoNombre}", method = RequestMethod.PUT)
	public void editarEmp(@PathVariable int id, @PathVariable String nuevoNombre) {
		serv.editarEmpresa(id, nuevoNombre);
	}
	
	@RequestMapping(value="/listaEmpresas", method = RequestMethod.GET)
	public List<Modelo> listarEmp() {
		return serv.listarEmpresas();
	}

}
