package com.ceiba.evento.comando;

import java.time.LocalDateTime;
import java.util.List;

import com.ceiba.eventoreferenciaproducto.modelo.dto.DtoEventoReferenciaProducto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEvento{

    private Integer id;
    private String nombre;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private char suspendido;
    private List<DtoEventoReferenciaProducto> eventoReferenciaProductos;
}
