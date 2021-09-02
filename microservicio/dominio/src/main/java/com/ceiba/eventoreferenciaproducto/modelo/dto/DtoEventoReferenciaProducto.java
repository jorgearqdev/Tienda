package com.ceiba.eventoreferenciaproducto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoEventoReferenciaProducto {
	private Integer id;
	private Integer idEvento;
	private String referencia;
	private int precioAntiguo;
	private int precioNuevo;
	private Integer descuento;
	private Integer valorConDescuentoAdicional;
}
