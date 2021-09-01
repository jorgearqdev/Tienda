package com.ceiba.evento.servicio;

import com.ceiba.evento.modelo.dto.DtoEventoActualizar;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;

public class ServicioSwitchEvento {

	private static final String SUSPENDIDO = "S";
	private static final String ACTIVO = "N";

	private final RepositorioEvento repositorioEvento;

	public ServicioSwitchEvento(RepositorioEvento repositorioEvento) {
		this.repositorioEvento = repositorioEvento;
	}

	public void ejecutar(DtoEventoActualizar dtoEventoActualizar) {
		if (dtoEventoActualizar.getSuspendido().equals(SUSPENDIDO)) {
			dtoEventoActualizar.setSuspendido(ACTIVO);
			this.repositorioEvento.switchSuspendido(dtoEventoActualizar);
		} else {
			dtoEventoActualizar.setSuspendido(SUSPENDIDO);
			this.repositorioEvento.switchSuspendido(dtoEventoActualizar);
		}
	}
}
