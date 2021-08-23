package com.ceiba.evento.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.evento.comando.ComandoEventoActualizar;
import com.ceiba.evento.modelo.dto.DtoEventoActualizar;

@Component
public class FabricaEventoActualizar {

	public DtoEventoActualizar crear(ComandoEventoActualizar comandoEventoActualizar) {
		return new DtoEventoActualizar(comandoEventoActualizar.getId(), comandoEventoActualizar.getSuspendido());
	}

}
