package com.ceiba.eventoreferenciaproducto.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.eventoreferenciaproducto.modelo.entidad.EventoReferenciaProducto;
import com.ceiba.eventoreferenciaproducto.puerto.repositorio.RepositorioEventoReferenciaProducto;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioEventoReferenciaProductoMysql implements RepositorioEventoReferenciaProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="eventoreferenciaproducto", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="eventoreferenciaproducto", value="actualizar")
    private static String sqlActualizar;
    
    @SqlStatement(namespace="eventoreferenciaproducto", value="eliminar")
    private static String sqlEliminar;

    public RepositorioEventoReferenciaProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
 
	@Override
	public Long crear(EventoReferenciaProducto eventoReferenciaProducto) {
		return this.customNamedParameterJdbcTemplate.crear(eventoReferenciaProducto, sqlCrear);
	}

	@Override
	public void actualizar(EventoReferenciaProducto eventoReferenciaProducto) {
		this.customNamedParameterJdbcTemplate.actualizar(eventoReferenciaProducto, sqlActualizar);
	}

	@Override
	public void eliminar(Integer id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        
		this.customNamedParameterJdbcTemplate.actualizar(paramSource, sqlEliminar);
	}
}
