package com.ceiba.eventoreferenciaproducto.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class EventoReferenciaProducto {

	private static final String SE_DEBE_INGRESAR_EL_PRECIO_ANTIGUO = "Se debe ingresar el precio antiguo";
	private static final String SE_DEBE_INGRESAR_EL_PRECIO_NUEVO = "Se debe ingresar el precio nuevo";
	private static final String SE_DEBE_INGRESAR_LA_REFERENCIA_DEL_PRODUCTO = "Se debe ingresar la referencia del producto";

	private Integer id;
	@Setter
	private Integer idEvento;
	private String referencia;
	private int precioAntiguo;
	private int precioNuevo;
	
	public EventoReferenciaProducto(Integer id, Integer idEvento, String referencia, int precioAntiguo,
			int precioNuevo) {
		
		validarObligatorio(precioAntiguo, SE_DEBE_INGRESAR_EL_PRECIO_ANTIGUO);
		validarObligatorio(precioNuevo, SE_DEBE_INGRESAR_EL_PRECIO_NUEVO);
		validarObligatorio(referencia, SE_DEBE_INGRESAR_LA_REFERENCIA_DEL_PRODUCTO);
		
		this.id = id;
		this.idEvento = idEvento;
		this.referencia = referencia;
		this.precioAntiguo = precioAntiguo;
		this.precioNuevo = precioNuevo;
	}

}
