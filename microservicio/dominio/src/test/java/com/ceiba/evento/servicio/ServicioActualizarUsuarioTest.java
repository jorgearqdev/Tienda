package com.ceiba.evento.servicio;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;
import com.ceiba.evento.servicio.testdatabuilder.EventoTestDataBuilder;

public class ServicioActualizarUsuarioTest {

	@Test
	public void validarEventoExistenciaPreviaTest() {
		// arrange
		Evento evento = new EventoTestDataBuilder().build();
		RepositorioEvento repositorioEvento = Mockito.mock(RepositorioEvento.class);
		
		LocalDateTime hoy = LocalDateTime.now();
		
		Mockito.when(repositorioEvento.existeDentroDeFechasExcluyendoId(Mockito.anyInt(), hoy, hoy))
				.thenReturn(1L);
		
		ServicioActualizarEvento servicioActualizarEvento = new ServicioActualizarEvento(repositorioEvento, null);
		// act - assert
		
        BasePrueba.assertThrows(() -> servicioActualizarEvento.ejecutar(evento), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");

	}
}
