package com.ceiba.evento.servicio.testdatabuilder;

import java.util.UUID;

import com.ceiba.eventoreferenciaproducto.modelo.entidad.EventoReferenciaProducto;

public class EventoReferenciaProductoTestDataBuilder {

	private Integer id;
	private Integer idEvento;
	private String referencia;
	private int precioAntiguo;
	private int precioNuevo;

	public EventoReferenciaProductoTestDataBuilder() {
		referencia = UUID.randomUUID().toString();
		precioAntiguo = 10000;
		precioNuevo = 9000;
	}

	public EventoReferenciaProductoTestDataBuilder conReferencia(String referencia) {
		this.referencia = referencia;
		return this;
	}

	public EventoReferenciaProducto build() {
		return new EventoReferenciaProducto(id, idEvento, referencia, precioAntiguo, precioNuevo);
	}
}
