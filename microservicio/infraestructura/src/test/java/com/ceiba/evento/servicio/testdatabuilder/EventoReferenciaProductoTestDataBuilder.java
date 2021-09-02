package com.ceiba.evento.servicio.testdatabuilder;

import java.util.UUID;

import com.ceiba.eventoreferenciaproducto.modelo.dto.DtoEventoReferenciaProducto;

public class EventoReferenciaProductoTestDataBuilder {

	private Integer id;
	private Integer idEvento;
	private String referencia;
	private int precioAntiguo;
	private int precioNuevo;
	private Integer descuento;
	private Integer valorConDescuentoAdicional;

	public EventoReferenciaProductoTestDataBuilder() {
		referencia = UUID.randomUUID().toString();
		precioAntiguo = 10000;
		precioNuevo = 9000;
	}
	
	public EventoReferenciaProductoTestDataBuilder conReferencia(String referencia) {
		this.referencia = referencia;
		return this;
	}

	public EventoReferenciaProductoTestDataBuilder conPrecioAntiguo(int precioAntiguo) {
		this.precioAntiguo = precioAntiguo;
		return this;
	}
	
	public EventoReferenciaProductoTestDataBuilder conPrecioNuevo(int precioNuevo) {
		this.precioNuevo = precioNuevo;
		return this;
	}

	public DtoEventoReferenciaProducto build() {
		return new DtoEventoReferenciaProducto(id, idEvento, referencia, precioAntiguo, precioNuevo, descuento, valorConDescuentoAdicional);
	}
}
