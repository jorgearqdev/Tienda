package com.ceiba.usuario.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;
import com.ceiba.evento.servicio.ServicioActualizarEvento;
import com.ceiba.usuario.servicio.testdatabuilder.EventoTestDataBuilder;

public class ServicioActualizarUsuarioTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Evento evento = new EventoTestDataBuilder().conId(1L).build();
        RepositorioEvento repositorioEvento = Mockito.mock(RepositorioEvento.class);
        Mockito.when(repositorioEvento.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarEvento servicioActualizarEvento = new ServicioActualizarEvento(repositorioEvento);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarEvento.ejecutar(evento), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }
}
