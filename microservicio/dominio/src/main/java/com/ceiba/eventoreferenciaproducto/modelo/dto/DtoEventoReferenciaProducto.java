package com.ceiba.eventoreferenciaproducto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DtoEventoReferenciaProducto {
	private Integer id;
	private Integer idEvento;
	private String referencia;
	private int precioAntiguo;
	private int precioNuevo;
	private int descuento;
}
