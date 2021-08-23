package com.ceiba.evento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;
import com.ceiba.eventoreferenciaproducto.servicio.ServicioCrearEventoReferenciaProducto;

public class ServicioCrearEvento {

	private static final String YA_EXISTEN_EVENTOS_DENTRO_DE_LAS_FECHAS_SELECCIONADAS = "Ya existen eventos dentro de las fechas seleccionadas";

	private final RepositorioEvento repositorioEvento;
	private final ServicioCrearEventoReferenciaProducto servicioCrearEventoReferenciaProducto;

	public ServicioCrearEvento(RepositorioEvento repositorioEvento,
			ServicioCrearEventoReferenciaProducto servicioCrearEventoReferenciaProducto) {
		this.repositorioEvento = repositorioEvento;
		this.servicioCrearEventoReferenciaProducto = servicioCrearEventoReferenciaProducto;
	}

	public Long ejecutar(Evento evento) {
		validarExistenciaDeEventosDentroDeFechas(evento);
		Long idEvento = this.repositorioEvento.crear(evento);

		evento.getEventoReferenciaProductos().stream().forEach(eventoReferenciaProducto -> {
			eventoReferenciaProducto.setIdEvento(idEvento.intValue());
			servicioCrearEventoReferenciaProducto.ejecutar(eventoReferenciaProducto);
		});

		return idEvento;
	}

	private void validarExistenciaDeEventosDentroDeFechas(Evento evento) {
		boolean existe = this.repositorioEvento.existeDentroDeFechas(evento.getFechaInicio(),
				evento.getFechaFin()) != 0;
		if (existe) {
			throw new ExcepcionDuplicidad(YA_EXISTEN_EVENTOS_DENTRO_DE_LAS_FECHAS_SELECCIONADAS);
		}
	}
}
