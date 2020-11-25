package com.apiemp.apiemp.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.apiemp.apiemp.modelo.Modelo;

@Repository
public class Repositorio implements RepositorioInt {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertarEmpresa(Modelo mod) {
		String procedure = "call procedimientos_empresas.insertar_empresa(?)";
		jdbcTemplate.update(procedure, mod.getNombre());
	}
	
	@Override
	public void eliminarEmpresa(int id) {
		String procedure = "call procedimientos_empresas.eliminar_empresa(?)";
		jdbcTemplate.update(procedure, id);
	}

}
