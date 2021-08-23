package com.ceiba.eventoreferenciaproducto.adaptador.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.eventoreferenciaproducto.modelo.dto.DtoEventoReferenciaProducto;
import com.ceiba.eventoreferenciaproducto.puerto.dao.DaoEventoReferenciaProducto;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DaoEventoReferenciaProductoMysql implements DaoEventoReferenciaProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="eventoreferenciaproducto", value="listar")
    private static String sqlListar;

    public DaoEventoReferenciaProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoEventoReferenciaProducto> listar(Integer evento) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idEvento", evento);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,paramSource, new MapeoEventoReferenciaProducto());
    }
}
