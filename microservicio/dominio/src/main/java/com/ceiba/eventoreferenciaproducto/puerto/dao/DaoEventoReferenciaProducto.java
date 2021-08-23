package com.ceiba.eventoreferenciaproducto.puerto.dao;

import java.util.List;

import com.ceiba.eventoreferenciaproducto.modelo.dto.DtoEventoReferenciaProducto;

public interface DaoEventoReferenciaProducto {

    /**
     * Permite listar las referencias de los productos por evento
     * 
     * @param evento a consultar
     * @return los eventos
     */
    List<DtoEventoReferenciaProducto> listar(Integer evento);
}
