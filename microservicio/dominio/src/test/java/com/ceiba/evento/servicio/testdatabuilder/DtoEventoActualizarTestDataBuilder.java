package com.ceiba.evento.servicio.testdatabuilder;

import com.ceiba.evento.modelo.dto.DtoEventoActualizar;

public class DtoEventoActualizarTestDataBuilder {

	private static final char ACTIVO = 'N';
	private static final char SUSPENDIDO = 'S';

	private Integer id;
	private char suspendido;

	public DtoEventoActualizarTestDataBuilder() {
		id = 1;
		suspendido = ACTIVO;
	}

	public DtoEventoActualizarTestDataBuilder suspendido() {
		this.suspendido = SUSPENDIDO;
		return this;
	}

	public DtoEventoActualizar build() {
		return new DtoEventoActualizar(id, suspendido);
	}
}
