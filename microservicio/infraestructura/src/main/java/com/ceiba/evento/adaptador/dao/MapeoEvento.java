package com.ceiba.evento.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.evento.modelo.dto.DtoEvento;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoEvento implements RowMapper<DtoEvento>, MapperResult {

	@Override
	public DtoEvento mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Integer id = resultSet.getInt("id");
		String nombre = resultSet.getString("nombre");
		LocalDateTime fechaInicio = extraerLocalDateTime(resultSet, "fecha_inicio");
		LocalDateTime fechaFin = extraerLocalDateTime(resultSet, "fecha_fin");
		char suspendido = resultSet.getString("suspendido").charAt(0);

		return new DtoEvento(id, nombre, fechaInicio, fechaFin, suspendido, null);
	}

}
