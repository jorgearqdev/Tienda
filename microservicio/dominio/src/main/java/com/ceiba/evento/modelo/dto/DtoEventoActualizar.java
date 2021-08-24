package com.ceiba.evento.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class DtoEventoActualizar {

	private Integer id;
	@Setter
	private char suspendido;
}
