package com.ceiba.evento.puerto.dao;

import java.util.List;

import com.ceiba.evento.modelo.dto.DtoEvento;

public interface DaoEvento {

    /**
     * Permite listar eventos
     * @return los eventos
     */
    List<DtoEvento> listar();
}
