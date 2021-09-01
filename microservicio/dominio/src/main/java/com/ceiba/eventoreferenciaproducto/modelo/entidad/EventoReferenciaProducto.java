package com.ceiba.eventoreferenciaproducto.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMaxima;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMinima;
import static com.ceiba.dominio.ValidadorArgumento.validarMenor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class EventoReferenciaProducto {
	
	private static final int LONGITUD_MINIMA_TEXTO = 3;
	private static final int LONGITUD_MAXIMA_TEXTO = 120;

	private static final String SE_DEBE_INGRESAR_EL_PRECIO_ANTIGUO = "Se debe ingresar el precio antiguo";
	private static final String SE_DEBE_INGRESAR_EL_PRECIO_NUEVO = "Se debe ingresar el precio nuevo";
	private static final String PRECIO_NUEVO_MENOR_PRECIO_ANTIGUO = "El nuevo precio debe ser menor que el precio antiguo";
	private static final String SE_DEBE_INGRESAR_LA_REFERENCIA_DEL_PRODUCTO = "Se debe ingresar la referencia del producto";
	private static final String MENSAJE_LONGITUD_MINIMA_REFERENCIA = "La longitud minima de la referencia debe ser 3";
	private static final String MENSAJE_LONGITUD_MAXIMA_REFERENCIA = "La longitud maxima de la referencia debe ser 120";
	
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
		validarMenor(Long.valueOf(precioNuevo), Long.valueOf(precioAntiguo), PRECIO_NUEVO_MENOR_PRECIO_ANTIGUO);
		validarLongitudMinima(referencia, LONGITUD_MINIMA_TEXTO, MENSAJE_LONGITUD_MINIMA_REFERENCIA);
		validarLongitudMaxima(referencia, LONGITUD_MAXIMA_TEXTO, MENSAJE_LONGITUD_MAXIMA_REFERENCIA);
		
		this.id = id;
		this.idEvento = idEvento;
		this.referencia = referencia;
		this.precioAntiguo = precioAntiguo;
		this.precioNuevo = precioNuevo;
	}

}
