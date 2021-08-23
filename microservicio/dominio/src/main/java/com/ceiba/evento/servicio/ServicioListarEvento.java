package com.ceiba.evento.servicio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ceiba.evento.modelo.dto.DtoEvento;
import com.ceiba.evento.puerto.dao.DaoEvento;
import com.ceiba.eventoreferenciaproducto.modelo.dto.DtoEventoReferenciaProducto;
import com.ceiba.eventoreferenciaproducto.puerto.dao.DaoEventoReferenciaProducto;

public class ServicioListarEvento {

	private final DaoEvento daoEvento;
	private final DaoEventoReferenciaProducto daoEventoReferenciaProducto;
	private static final int CERO = 0;
	private static final int CIEN = 100;

	public ServicioListarEvento(DaoEvento daoEvento, DaoEventoReferenciaProducto daoEventoReferenciaProducto) {
		this.daoEvento = daoEvento;
		this.daoEventoReferenciaProducto = daoEventoReferenciaProducto;
	}

	public List<DtoEvento> ejecutar() {
		List<DtoEvento> listado = this.daoEvento.listar();

		boolean esUltimoViernes = obtenerUltimoViernesDelMes().compareTo(eliminarHoraMinutos(new Date())) == CERO;

		listado.forEach(evento -> {
			evento.setEventoReferenciaProductos(daoEventoReferenciaProducto.listar(evento.getId()));
			this.calcularPorcentajeDescuento(evento, esUltimoViernes);
		});

		return listado;
	}

	private void calcularPorcentajeDescuento(DtoEvento evento, boolean esUltimoViernes) {
		for (DtoEventoReferenciaProducto eventoReferenciaProducto : evento.getEventoReferenciaProductos()) {
			eventoReferenciaProducto.setDescuento(
					CIEN * (eventoReferenciaProducto.getPrecioAntiguo() - eventoReferenciaProducto.getPrecioNuevo())
							/ eventoReferenciaProducto.getPrecioAntiguo());
			if (esUltimoViernes)
				eventoReferenciaProducto.setDescuento(eventoReferenciaProducto.getDescuento() + 10);
		}
	}

	private Date obtenerUltimoViernesDelMes() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, -1);

		return eliminarHoraMinutos(calendar.getTime());
	}

	private Date eliminarHoraMinutos(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
}
