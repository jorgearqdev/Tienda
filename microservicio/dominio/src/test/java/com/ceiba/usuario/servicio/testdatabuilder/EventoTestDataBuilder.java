package com.ceiba.usuario.servicio.testdatabuilder;

import java.time.LocalDateTime;
import java.util.UUID;

import com.ceiba.evento.modelo.entidad.Evento;

public class EventoTestDataBuilder {

	private static final char ACTIVO = 'N';
	private static final Long UN_DIA = 1L;

	private Integer id;
	private String nombre;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;

	public EventoTestDataBuilder() {
		nombre = UUID.randomUUID().toString();
		fechaInicio = LocalDateTime.now().minusDays(UN_DIA);
		fechaFin = LocalDateTime.now().plusDays(UN_DIA);
	}

	public EventoTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public Evento build() {
		return new Evento(id, nombre, fechaInicio, fechaFin, ACTIVO);
	}
}
