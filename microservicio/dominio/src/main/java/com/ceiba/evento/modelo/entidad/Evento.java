package com.ceiba.evento.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarNoVacio;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ceiba.eventoreferenciaproducto.modelo.entidad.EventoReferenciaProducto;

import lombok.Getter;

@Getter
public class Evento {

	private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIO = "Se debe ingresar la fecha inicio";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_FIN = "Se debe ingresar la fecha fin";
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
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
		validarObligatorio(fechaInicio, SE_DEBE_INGRESAR_LA_FECHA_INICIO);
		validarObligatorio(fechaFin, SE_DEBE_INGRESAR_LA_FECHA_FIN);
		validarNoVacio(eventoReferenciaProductos, SE_DEBE_INGRESAR_AL_MENOS_UN_PRODUCTO);

		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.suspendido = suspendido;
		this.eventoReferenciaProductos = new ArrayList<>(eventoReferenciaProductos);
	}

}
