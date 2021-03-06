package com.ceiba.evento.servicio.testdatabuilder;

import com.ceiba.eventoreferenciaproducto.modelo.dto.DtoEventoReferenciaProducto;

public class DtoEventoReferenciaProductoTestDataBuilder {

	private Integer id;
	private Integer idEvento;
	private String referencia;
	private int precioAntiguo;
	private int precioNuevo;
	private int descuento;
	private int valorConDescuentoAdicional;

	public DtoEventoReferenciaProductoTestDataBuilder() {
		id = 1;
		idEvento = 2;
		referencia = "referencia test";
		precioAntiguo = 10000;
		precioAntiguo = 9000;
		descuento = 80;
		valorConDescuentoAdicional = 0;
	}

	public DtoEventoReferenciaProductoTestDataBuilder conReferencia(String referencia) {
		this.referencia = referencia;
		return this;
	}

	public DtoEventoReferenciaProducto build() {
		return new DtoEventoReferenciaProducto(id, idEvento, referencia, precioAntiguo, precioNuevo, descuento, valorConDescuentoAdicional);
	}
}
