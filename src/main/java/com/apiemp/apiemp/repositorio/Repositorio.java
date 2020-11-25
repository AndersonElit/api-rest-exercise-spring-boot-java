package com.apiemp.apiemp.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
	
	public void editarEmpresa(int id, String nuevoNombre) {
		String procedure = "call procedimientos_empresas.editar_empresa(?, ?)";
		jdbcTemplate.update(procedure, id, nuevoNombre);
	}
	
	@Override
	public List<Modelo> listaEmpresas() {
		
		String sql = "select * from empresas";
		
		List<Modelo> listaemp = jdbcTemplate.query(sql, new ResultSetExtractor<List<Modelo>>() {
			@Override
			public List<Modelo> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Modelo> list = new ArrayList<Modelo>();
				while (rs.next()) {
					Modelo empresa = new Modelo();
					empresa.setId(rs.getInt("ID_EMPRESA"));
					empresa.setNombre(rs.getString("NOMBRE"));
					list.add(empresa);
				}
				return list;
			}
		});
		
		return listaemp;
		
	}

}
