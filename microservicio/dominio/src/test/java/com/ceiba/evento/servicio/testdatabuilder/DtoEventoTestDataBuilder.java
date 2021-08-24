package com.ceiba.evento.servicio.testdatabuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ceiba.evento.modelo.dto.DtoEvento;
import com.ceiba.eventoreferenciaproducto.modelo.dto.DtoEventoReferenciaProducto;

public class DtoEventoTestDataBuilder {

	private static final char ACTIVO = 'N';
	private static final Long UN_DIA = 1L;

	private Integer id;
	private String nombre;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	List<DtoEventoReferenciaProducto> productos;

	public DtoEventoTestDataBuilder() {
		id = 1;
		productos = new ArrayList<>();
		DtoEventoReferenciaProductoTestDataBuilder eventoReferenciaProductoTestDataBuilder = new DtoEventoReferenciaProductoTestDataBuilder();
		productos.add(eventoReferenciaProductoTestDataBuilder.build());
	
		nombre = UUID.randomUUID().toString();
		fechaInicio = LocalDateTime.now().minusDays(UN_DIA);
		fechaFin = LocalDateTime.now().plusDays(UN_DIA);
	}
	
	public DtoEventoTestDataBuilder conFechaActual() {
		fechaInicio = LocalDateTime.now().minusDays(UN_DIA);
		fechaFin = LocalDateTime.now().plusDays(UN_DIA);
		return this;
	}

	public DtoEventoTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public DtoEventoTestDataBuilder conId() {
		this.id = 1;
		return this;
	}

	public DtoEvento build() {
		return new DtoEvento(id, nombre, fechaInicio, fechaFin, ACTIVO, productos);
	}
}
