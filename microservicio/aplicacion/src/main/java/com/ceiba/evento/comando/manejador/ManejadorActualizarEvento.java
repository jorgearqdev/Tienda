package com.ceiba.evento.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.evento.comando.ComandoEvento;
import com.ceiba.evento.comando.fabrica.FabricaEvento;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.servicio.ServicioActualizarEvento;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorActualizarEvento implements ManejadorComando<ComandoEvento> {

    private final FabricaEvento fabricaEvento;
    private final ServicioActualizarEvento servicioActualizarEvento;

    public ManejadorActualizarEvento(FabricaEvento fabricaEvento, ServicioActualizarEvento servicioActualizarEvento) {
        this.fabricaEvento = fabricaEvento;
        this.servicioActualizarEvento = servicioActualizarEvento;
    }

    public void ejecutar(ComandoEvento comandoEvento) {
        Evento evento = this.fabricaEvento.crear(comandoEvento);
        this.servicioActualizarEvento.ejecutar(evento);
    }
}
