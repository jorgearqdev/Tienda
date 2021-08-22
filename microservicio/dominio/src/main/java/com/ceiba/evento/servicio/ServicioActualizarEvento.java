package com.ceiba.evento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;

public class ServicioActualizarEvento {

	private static final String YA_EXISTEN_EVENTOS_DENTRO_DE_LAS_FECHAS_SELECCIONADAS = "Ya existen eventos dentro de las fechas seleccionadas";

	private final RepositorioEvento repositorioEvento;

	public ServicioActualizarEvento(RepositorioEvento repositorioEvento) {
		this.repositorioEvento = repositorioEvento;
	}

	public void ejecutar(Evento evento) {
		validarExistenciaDeEventosDentroDeFechas(evento);
		this.repositorioEvento.actualizar(evento);
	}

	private void validarExistenciaDeEventosDentroDeFechas(Evento evento) {
		boolean existe = this.repositorioEvento.existeDentroDeFechasExcluyendoId(evento.getId(),
				evento.getFechaInicio(), evento.getFechaFin());
		if (existe) {
			throw new ExcepcionDuplicidad(YA_EXISTEN_EVENTOS_DENTRO_DE_LAS_FECHAS_SELECCIONADAS);
		}
	}
}
