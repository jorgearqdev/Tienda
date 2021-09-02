package com.ceiba.evento.servicio.testdatabuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ceiba.evento.comando.ComandoEvento;
import com.ceiba.eventoreferenciaproducto.modelo.dto.DtoEventoReferenciaProducto;

public class ComandoEventoTestDataBuilder {

	private static final char ACTIVO = 'N';
	private static final Long VEINTE_DIAS = 20L;
	private static final Long TREINTA_DIAS = 30L;

	private Integer id;
    private String nombre;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private char suspendido;
    private List<DtoEventoReferenciaProducto> eventoReferenciaProductos;

	public ComandoEventoTestDataBuilder() throws Exception {
		nombre = UUID.randomUUID().toString();
		fechaInicio = LocalDateTime.now().plusDays(VEINTE_DIAS);
		fechaFin = LocalDateTime.now().plusDays(TREINTA_DIAS);
		suspendido = ACTIVO;
		eventoReferenciaProductos = new ArrayList<>();
		EventoReferenciaProductoTestDataBuilder eventoReferenciaProductoTestDataBuilder = new EventoReferenciaProductoTestDataBuilder();
		eventoReferenciaProductos.add(eventoReferenciaProductoTestDataBuilder.build());
	}

	public ComandoEventoTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public ComandoEventoTestDataBuilder conFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
		return this;
	}
	
	public ComandoEventoTestDataBuilder conFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
		return this;
	}
	
	public ComandoEventoTestDataBuilder conListaReferencias(List<DtoEventoReferenciaProducto> eventoReferenciaProductos) {
		this.eventoReferenciaProductos = eventoReferenciaProductos;
		return this;
	}

	public ComandoEvento build() {
		return new ComandoEvento(id, nombre, fechaInicio, fechaFin, suspendido, eventoReferenciaProductos);
	}
}
