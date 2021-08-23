package com.ceiba.evento.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.evento.consulta.ManejadorListarEventos;
import com.ceiba.evento.modelo.dto.DtoEvento;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/evento")
@Api(tags={"Controlador consulta evento"})
public class ConsultaControladorEvento {

    private final ManejadorListarEventos manejadorListarEventos;

    public ConsultaControladorEvento(ManejadorListarEventos manejadorListarEventos) {
        this.manejadorListarEventos = manejadorListarEventos;
    }

    @GetMapping
    @ApiOperation("Listar eventos")
    public List<DtoEvento> listar() {
        return this.manejadorListarEventos.ejecutar();
    }

}
