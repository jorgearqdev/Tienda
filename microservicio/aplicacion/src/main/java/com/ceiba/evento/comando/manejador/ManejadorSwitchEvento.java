package com.ceiba.evento.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.evento.comando.ComandoEventoActualizar;
import com.ceiba.evento.comando.fabrica.FabricaEventoActualizar;
import com.ceiba.evento.modelo.dto.DtoEventoActualizar;
import com.ceiba.evento.servicio.ServicioSwitchEvento;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorSwitchEvento implements ManejadorComando<ComandoEventoActualizar> {

	private final ServicioSwitchEvento servicioSwitchEvento;
	private final FabricaEventoActualizar fabricaEventoActualizar;

	public ManejadorSwitchEvento(FabricaEventoActualizar fabricaEventoActualizar,
			ServicioSwitchEvento servicioSwitchEvento) {
		this.fabricaEventoActualizar = fabricaEventoActualizar;
		this.servicioSwitchEvento = servicioSwitchEvento;
	}

	public void ejecutar(ComandoEventoActualizar comandoEventoActualizar) {
		DtoEventoActualizar dtoEventoActualizar = this.fabricaEventoActualizar.crear(comandoEventoActualizar);
		this.servicioSwitchEvento.ejecutar(dtoEventoActualizar);
	}
}
