package com.ceiba.eventoreferenciaproducto.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.eventoreferenciaproducto.modelo.dto.DtoEventoReferenciaProducto;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoEventoReferenciaProducto implements RowMapper<DtoEventoReferenciaProducto>, MapperResult {

	@Override
	public DtoEventoReferenciaProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Integer id = resultSet.getInt("id");
		Integer idEvento = resultSet.getInt("evento_id");
		String referencia = resultSet.getString("referencia");
		int precioAntiguo = resultSet.getInt("precio_antiguo");
		int precioNuevo = resultSet.getInt("precio_nuevo");

		return new DtoEventoReferenciaProducto(id, idEvento, referencia, precioAntiguo, precioNuevo, 0);
	}

}
