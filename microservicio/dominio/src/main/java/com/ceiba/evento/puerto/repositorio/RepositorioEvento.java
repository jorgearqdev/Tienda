package com.ceiba.evento.puerto.repositorio;

import java.time.LocalDateTime;

import com.ceiba.evento.modelo.dto.DtoEventoActualizar;
import com.ceiba.evento.modelo.entidad.Evento;

public interface RepositorioEvento {
	/**
	 * Permite crear un evento
	 * 
	 * @param evento
	 * @return el id generado
	 */
	Long crear(Evento evento);

	/**
	 * Permite actualizar un evento
	 * 
	 * @param evento
	 */
	void actualizar(Evento evento);

	/**
	 * Permite validar si existe un evento dentro de las fechas seleccionadas
	 * excluyendo el id
	 * 
	 * @param id
	 * @param fechaInicio
	 * @param fechaFin
	 * @return cantidadExisitentes
	 */
	Long existeDentroDeFechasExcluyendoId(int id, LocalDateTime fechaInicio, LocalDateTime fechaFin);

	/**
	 * Permite validar si existe un evento dentro de las fechas seleccionadas
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @return cantidadExisitentes
	 */
	Long existeDentroDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);

	/**
	 * Permite moficar el estado de suspendido, en caso de estar activo(N) pasa
	 * a estar en suspendido(S) y en caso viceversa
	 * 
	 * @param dtoEventoActualizar
	 */
	void switchSuspendido(DtoEventoActualizar dtoEventoActualizar);

}
