package com.ceiba.evento.servicio.testdatabuilder;

import com.ceiba.evento.modelo.dto.DtoEventoActualizar;

public class DtoEventoActualizarTestDataBuilder {

	private static final String ACTIVO = "N";
	private static final String SUSPENDIDO = "S";

	private Integer id;
	private String suspendido;

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
