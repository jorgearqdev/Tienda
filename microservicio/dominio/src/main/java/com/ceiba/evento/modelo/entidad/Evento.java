package com.ceiba.evento.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarNoVacio;
import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMinima;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMaxima;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ceiba.eventoreferenciaproducto.modelo.entidad.EventoReferenciaProducto;

import lombok.Getter;

@Getter
public class Evento {
	
	private static final int LONGITUD_MINIMA_TEXTO = 3;
	private static final int LONGITUD_MAXIMA_TEXTO = 120;

	private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIO = "Se debe ingresar la fecha inicio";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_FIN = "Se debe ingresar la fecha fin";
	private static final String FECHA_INICIO_DEBE_SER_MENOR = "La fecha inicio debe ser menor a la fecha fin";
	
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
	private static final String MENSAJE_LONGITUD_MINIMA_NOMBRE = "La longitud minima del nombre debe ser 3";
	private static final String MENSAJE_LONGITUD_MAXIMA_NOMBRE = "La longitud maxima del nombre debe ser 120";
	
 	private static final String SE_DEBE_INGRESAR_AL_MENOS_UN_PRODUCTO = "Se debe ingresar al menos un producto";

	private Integer id;
	private String nombre;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private char suspendido;
	private List<EventoReferenciaProducto> eventoReferenciaProductos;

	public Evento(Integer id, String nombre, LocalDateTime fechaInicio, LocalDateTime fechaFin, char suspendido,
			List<EventoReferenciaProducto> eventoReferenciaProductos) {
		
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
		validarLongitudMinima(nombre, LONGITUD_MINIMA_TEXTO, MENSAJE_LONGITUD_MINIMA_NOMBRE);
		validarLongitudMaxima(nombre, LONGITUD_MAXIMA_TEXTO, MENSAJE_LONGITUD_MAXIMA_NOMBRE);
		
		validarObligatorio(fechaInicio, SE_DEBE_INGRESAR_LA_FECHA_INICIO);
		validarObligatorio(fechaFin, SE_DEBE_INGRESAR_LA_FECHA_FIN);
		validarNoVacio(eventoReferenciaProductos, SE_DEBE_INGRESAR_AL_MENOS_UN_PRODUCTO);
		validarMenor(fechaInicio, fechaFin, FECHA_INICIO_DEBE_SER_MENOR);

		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.suspendido = suspendido;
		this.eventoReferenciaProductos = new ArrayList<>(eventoReferenciaProductos);
	}

}
