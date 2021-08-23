package com.ceiba.eventoreferenciaproducto.puerto.repositorio;

import com.ceiba.eventoreferenciaproducto.modelo.entidad.EventoReferenciaProducto;

public interface RepositorioEventoReferenciaProducto {
	/**
	 * Permite crear una referencia del evento
	 * 
	 * @param evento
	 * @return el id generado
	 */
	Long crear(EventoReferenciaProducto eventoReferenciaProducto);

	/**
	 * Permite actualizar una referencia del evento
	 * 
	 * @param evento
	 */
	void actualizar(EventoReferenciaProducto eventoReferenciaProducto);

	/**
	 * Permite eliminar una referencia del evento
	 * 
	 * @param idReferenciaProducto
	 */
	void eliminar(Integer idReferenciaProducto);
}
