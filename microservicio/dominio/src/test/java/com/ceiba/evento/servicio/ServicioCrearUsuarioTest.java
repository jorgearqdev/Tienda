package com.ceiba.evento.servicio;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;
import com.ceiba.evento.servicio.testdatabuilder.EventoTestDataBuilder;

public class ServicioCrearUsuarioTest {

    @Test
    public void validarClaveLongitudMenor4Test() {
        // arrange
    	EventoTestDataBuilder usuarioTestDataBuilder = new EventoTestDataBuilder();
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
    }

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
    	LocalDateTime hoy = LocalDateTime.now();
    	
        Evento evento = new EventoTestDataBuilder().build();
        RepositorioEvento repositorioEvento = Mockito.mock(RepositorioEvento.class);
        Mockito.when(repositorioEvento.existeDentroDeFechas(hoy, hoy)).thenReturn(1L);
        ServicioCrearEvento servicioCrearUsuario = new ServicioCrearEvento(repositorioEvento, null);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(evento), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }
}
