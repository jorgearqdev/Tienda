package com.ceiba.evento.modelo.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.ceiba.eventoreferenciaproducto.modelo.dto.DtoEventoReferenciaProducto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DtoEvento {
	private int id;
	private String nombre;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private char suspendido;
	private List<DtoEventoReferenciaProducto> eventoReferenciaProductos;
}
