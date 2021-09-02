package com.ceiba.evento.comando.fabrica;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.evento.comando.ComandoEvento;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.eventoreferenciaproducto.modelo.entidad.EventoReferenciaProducto;

@Component
public class FabricaEvento {

	public Evento crear(ComandoEvento comandoEvento) {
		
		List<EventoReferenciaProducto> eventoReferenciaProductos = new ArrayList<>();
		comandoEvento.getEventoReferenciaProductos().forEach(referencia -> 
			eventoReferenciaProductos.add(new EventoReferenciaProducto(referencia.getId(), referencia.getIdEvento(), referencia.getReferencia(), referencia.getPrecioAntiguo(), referencia.getPrecioNuevo()))
		);
		
		return new Evento(comandoEvento.getId(), comandoEvento.getNombre(), comandoEvento.getFechaInicio(),
				comandoEvento.getFechaFin(), comandoEvento.getSuspendido(), eventoReferenciaProductos);
	}

}
