package com.ceiba.evento.servicio.testdatabuilder;

import com.ceiba.evento.comando.ComandoEventoActualizar;

public class ComandoEventoActualizarTestDataBuilder {

	private static final String ACTIVO = "N";

	private Integer id;
    private String suspendido;
    
	public ComandoEventoActualizarTestDataBuilder() {
		id = 2;
		suspendido = ACTIVO;
	}

	public ComandoEventoActualizar build() {
		return new ComandoEventoActualizar(id, suspendido);
	}
}
