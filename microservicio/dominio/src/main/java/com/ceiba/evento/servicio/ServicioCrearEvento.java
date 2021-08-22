package com.ceiba.evento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;

public class ServicioCrearEvento {

	private static final String YA_EXISTEN_EVENTOS_DENTRO_DE_LAS_FECHAS_SELECCIONADAS = "Ya existen eventos dentro de las fechas seleccionadas";

	private final RepositorioEvento repositorioEvento;

	public ServicioCrearEvento(RepositorioEvento repositorioEvento) {
		this.repositorioEvento = repositorioEvento;
	}

	public Long ejecutar(Evento evento) {
		validarExistenciaDeEventosDentroDeFechas(evento);
		return this.repositorioEvento.crear(evento);
	}

	private void validarExistenciaDeEventosDentroDeFechas(Evento evento) {
		boolean existe = this.repositorioEvento.existeDentroDeFechas(evento.getFechaInicio(), evento.getFechaFin());
		if (existe) {
			throw new ExcepcionDuplicidad(YA_EXISTEN_EVENTOS_DENTRO_DE_LAS_FECHAS_SELECCIONADAS);
		}
	}
}
