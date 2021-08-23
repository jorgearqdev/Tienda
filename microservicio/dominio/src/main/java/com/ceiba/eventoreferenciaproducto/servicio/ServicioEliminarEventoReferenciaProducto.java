package com.ceiba.eventoreferenciaproducto.servicio;

import com.ceiba.eventoreferenciaproducto.puerto.repositorio.RepositorioEventoReferenciaProducto;

public class ServicioEliminarEventoReferenciaProducto {

	private final RepositorioEventoReferenciaProducto repositorioEventoReferenciaProducto;

	public ServicioEliminarEventoReferenciaProducto(
			RepositorioEventoReferenciaProducto repositorioEventoReferenciaProducto) {
		this.repositorioEventoReferenciaProducto = repositorioEventoReferenciaProducto;
	}

	public void ejecutar(Integer idReferenciaProducto) {
		this.repositorioEventoReferenciaProducto.eliminar(idReferenciaProducto);
	}
}
