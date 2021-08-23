package com.ceiba.evento.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.evento.modelo.dto.DtoEvento;
import com.ceiba.evento.servicio.ServicioListarEvento;

@Component
public class ManejadorListarEventos {

    private final ServicioListarEvento servicioListarEvento;

    public ManejadorListarEventos(ServicioListarEvento servicioListarEvento){
        this.servicioListarEvento = servicioListarEvento;
    }

    public List<DtoEvento> ejecutar(){ return this.servicioListarEvento.ejecutar(); }
}
