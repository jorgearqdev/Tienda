package com.ceiba.evento.servicio.testdatabuilder;

import java.time.LocalDateTime;
import java.util.UUID;

import com.ceiba.evento.comando.ComandoEvento;

public class ComandoEventoTestDataBuilder {

	private static final char ACTIVO = 'N';
	private static final Long SEIS_DIAS = 5L;
	private static final Long CINCO_DIAS = 6L;

	private Integer id;
	private String nombre;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;

	public ComandoEventoTestDataBuilder() {
		nombre = UUID.randomUUID().toString();
		fechaInicio = LocalDateTime.now().minusDays(CINCO_DIAS);
		fechaFin = LocalDateTime.now().plusDays(SEIS_DIAS);
	}

	public ComandoEventoTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ComandoEvento build() {
		return new ComandoEvento(id, nombre, fechaInicio, fechaFin, ACTIVO, null);
	}
}
