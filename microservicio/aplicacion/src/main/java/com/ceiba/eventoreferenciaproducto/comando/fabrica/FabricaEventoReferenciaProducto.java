package com.ceiba.eventoreferenciaproducto.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.evento.comando.ComandoEvento;
import com.ceiba.evento.modelo.entidad.Evento;

@Component
public class FabricaEventoReferenciaProducto {

	public Evento crear(ComandoEvento comandoEvento) {
		return new Evento(comandoEvento.getId(), comandoEvento.getNombre(), comandoEvento.getFechaInicio(),
				comandoEvento.getFechaFin(), comandoEvento.getSuspendido(), comandoEvento.getEventoReferenciaProductos());
	}

}
