package com.ceiba.evento.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Evento {

	private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIO = "Se debe ingresar la fecha inicio";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_FIN = "Se debe ingresar la fecha fin";
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";

	private int id;
	private String nombre;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private char suspendido;

	public Evento(Integer id, String nombre, LocalDateTime fechaInicio, LocalDateTime fechaFin, char suspendido) {
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
		validarObligatorio(fechaInicio, SE_DEBE_INGRESAR_LA_FECHA_INICIO);
		validarObligatorio(fechaFin, SE_DEBE_INGRESAR_LA_FECHA_FIN);

		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.suspendido = suspendido;
	}

}
