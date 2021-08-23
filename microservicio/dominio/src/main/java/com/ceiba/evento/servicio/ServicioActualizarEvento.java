package com.ceiba.evento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;
import com.ceiba.eventoreferenciaproducto.servicio.ServicioActualizarEventoReferenciaProducto;

public class ServicioActualizarEvento {

	private static final String YA_EXISTEN_EVENTOS_DENTRO_DE_LAS_FECHAS_SELECCIONADAS = "Ya existen eventos dentro de las fechas seleccionadas";

	private final RepositorioEvento repositorioEvento;
	private final ServicioActualizarEventoReferenciaProducto servicioActualizarEventoReferenciaProducto;

	public ServicioActualizarEvento(RepositorioEvento repositorioEvento,
			ServicioActualizarEventoReferenciaProducto servicioActualizarEventoReferenciaProducto) {

		this.repositorioEvento = repositorioEvento;
		this.servicioActualizarEventoReferenciaProducto = servicioActualizarEventoReferenciaProducto;
	}

	public void ejecutar(Evento evento) {
		validarExistenciaDeEventosDentroDeFechas(evento);

		evento.getEventoReferenciaProductos().stream().forEach(servicioActualizarEventoReferenciaProducto::ejecutar);

		this.repositorioEvento.actualizar(evento);
	}

	private void validarExistenciaDeEventosDentroDeFechas(Evento evento) {
		boolean existe = this.repositorioEvento.existeDentroDeFechasExcluyendoId(evento.getId(),
				evento.getFechaInicio(), evento.getFechaFin()) != 0;

		if (existe) {
			throw new ExcepcionDuplicidad(YA_EXISTEN_EVENTOS_DENTRO_DE_LAS_FECHAS_SELECCIONADAS);
		}

	}
}
