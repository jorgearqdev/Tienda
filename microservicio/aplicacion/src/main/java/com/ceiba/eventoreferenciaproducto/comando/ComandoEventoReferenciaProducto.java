package com.ceiba.eventoreferenciaproducto.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEventoReferenciaProducto {
	private Integer id;
	private Integer idEvento;
	private String referencia;
	private int precioAntiguo;
	private int precioNuevo;
}
