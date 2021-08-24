package com.ceiba.evento.servicio.testdatabuilder;

import java.util.UUID;

import com.ceiba.eventoreferenciaproducto.modelo.dto.DtoEventoReferenciaProducto;

public class DtoEventoReferenciaProductoTestDataBuilder {

	private Integer id;
	private Integer idEvento;
	private String referencia;
	private int precioAntiguo;
	private int precioNuevo;
	private int descuento;

	public DtoEventoReferenciaProductoTestDataBuilder() {
		id = 1;
		idEvento = 2;
		referencia = UUID.randomUUID().toString();
		precioAntiguo = 10000;
		precioAntiguo = 9000;
		descuento = 80;
	}

	public DtoEventoReferenciaProductoTestDataBuilder conReferencia(String referencia) {
		this.referencia = referencia;
		return this;
	}

	public DtoEventoReferenciaProducto build() {
		return new DtoEventoReferenciaProducto(id, idEvento, referencia, precioAntiguo, precioNuevo, descuento);
	}
}
