package com.ceiba.eventoreferenciaproducto.servicio;

import com.ceiba.eventoreferenciaproducto.modelo.entidad.EventoReferenciaProducto;
import com.ceiba.eventoreferenciaproducto.puerto.repositorio.RepositorioEventoReferenciaProducto;

public class ServicioCrearEventoReferenciaProducto {

	private final RepositorioEventoReferenciaProducto repositorioEventoReferenciaProducto;

	public ServicioCrearEventoReferenciaProducto(RepositorioEventoReferenciaProducto repositorioEventoReferenciaProducto) {
		this.repositorioEventoReferenciaProducto = repositorioEventoReferenciaProducto;
	}

	public Long ejecutar(EventoReferenciaProducto eventoReferenciaProducto) {
		return this.repositorioEventoReferenciaProducto.crear(eventoReferenciaProducto);
	}
}
