package com.ceiba.evento.adaptador.repositorio;

import java.time.LocalDateTime;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.evento.modelo.dto.DtoEventoActualizar;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioEventoMysql implements RepositorioEvento {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="evento", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="evento", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="evento", value="modificarEstadoSuspendido")
    private static String sqlModificarEstadoSuspendido;

    @SqlStatement(namespace="evento", value="existenEventosDentroDeFechas")
    private static String sqlExistenEventosDentroDeFechas;

    @SqlStatement(namespace="evento", value="existenEventosDentroDeFechasExcluyendoId") 
    private static String sqlExistenEventosDentroDeFechasExcluyendoId;

    public RepositorioEventoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
 
	@Override
	public Long crear(Evento evento) {
		return this.customNamedParameterJdbcTemplate.crear(evento, sqlCrear);
	}

	@Override
	public void actualizar(Evento evento) {
		this.customNamedParameterJdbcTemplate.actualizar(evento, sqlActualizar);
	}

	@Override
	public void switchSuspendido(DtoEventoActualizar dtoEventoActualizar) {        
		this.customNamedParameterJdbcTemplate.actualizar(dtoEventoActualizar, sqlModificarEstadoSuspendido);
	}

	@Override
	public Long existeDentroDeFechasExcluyendoId(int id, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("fechaInicio", fechaInicio);
        paramSource.addValue("fechaFin", fechaFin);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistenEventosDentroDeFechasExcluyendoId,paramSource, Long.class);
	}

	@Override
	public Long existeDentroDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fechaInicio", fechaInicio);
        paramSource.addValue("fechaFin", fechaFin);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistenEventosDentroDeFechas,paramSource, Long.class);
	}
}
