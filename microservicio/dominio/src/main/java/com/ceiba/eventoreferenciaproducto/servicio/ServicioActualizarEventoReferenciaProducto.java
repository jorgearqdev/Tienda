package com.ceiba.eventoreferenciaproducto.servicio;

import com.ceiba.eventoreferenciaproducto.modelo.entidad.EventoReferenciaProducto;
import com.ceiba.eventoreferenciaproducto.puerto.repositorio.RepositorioEventoReferenciaProducto;

public class ServicioActualizarEventoReferenciaProducto {

	private final RepositorioEventoReferenciaProducto repositorioEventoReferenciaProducto;

	public ServicioActualizarEventoReferenciaProducto(RepositorioEventoReferenciaProducto repositorioEventoReferenciaProducto) {
		this.repositorioEventoReferenciaProducto = repositorioEventoReferenciaProducto;
	}

	public void ejecutar(EventoReferenciaProducto eventoReferenciaProducto) {
		this.repositorioEventoReferenciaProducto.actualizar(eventoReferenciaProducto);
	}

}
