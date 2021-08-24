package com.ceiba.evento.servicio;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;
import com.ceiba.evento.servicio.testdatabuilder.EventoTestDataBuilder;

public class ServicioCrearEventoTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange    	
        Evento evento = new EventoTestDataBuilder().build();
        RepositorioEvento repositorioEvento = Mockito.mock(RepositorioEvento.class);
        Mockito.when(repositorioEvento.existeDentroDeFechas(Mockito.any(LocalDateTime.class), Mockito.any(LocalDateTime.class))).thenReturn(1L);
        ServicioCrearEvento servicioCrearUsuario = new ServicioCrearEvento(repositorioEvento, null);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(evento), ExcepcionDuplicidad.class,"Ya existen eventos dentro de las fechas seleccionadas");
    }
}
