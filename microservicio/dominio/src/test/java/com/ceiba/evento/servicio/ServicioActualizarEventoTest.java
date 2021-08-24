package com.ceiba.evento.servicio;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;
import com.ceiba.evento.servicio.testdatabuilder.EventoTestDataBuilder;
import com.ceiba.eventoreferenciaproducto.servicio.ServicioActualizarEventoReferenciaProducto;

public class ServicioActualizarEventoTest {

	@Test
	public void validarEventoExistenciaPreviaTest() {
		// arrange
		Evento evento = new EventoTestDataBuilder().conId().build();
		RepositorioEvento repositorioEvento = Mockito.mock(RepositorioEvento.class);
		ServicioActualizarEventoReferenciaProducto servicioActualizarEventoReferenciaProducto = Mockito
				.mock(ServicioActualizarEventoReferenciaProducto.class);

		Mockito.when(repositorioEvento.existeDentroDeFechasExcluyendoId( Mockito.any(Integer.class),
				Mockito.any(LocalDateTime.class), Mockito.any(LocalDateTime.class))).thenReturn(1L);
		
		ServicioActualizarEvento servicioActualizarEvento = new ServicioActualizarEvento(repositorioEvento,
				servicioActualizarEventoReferenciaProducto);
		// act - assert

		BasePrueba.assertThrows(() -> servicioActualizarEvento.ejecutar(evento), ExcepcionDuplicidad.class,
				"Ya existen eventos dentro de las fechas seleccionadas");
	}
	
	@Test
	public void validarEventoSinExistenciaPreviaTest() {
		// arrange
		Evento evento = new EventoTestDataBuilder().conId().build();
		RepositorioEvento repositorioEvento = Mockito.mock(RepositorioEvento.class);
		ServicioActualizarEventoReferenciaProducto servicioActualizarEventoReferenciaProducto = Mockito
				.mock(ServicioActualizarEventoReferenciaProducto.class);

		Mockito.when(repositorioEvento.existeDentroDeFechasExcluyendoId( Mockito.any(Integer.class),
				Mockito.any(LocalDateTime.class), Mockito.any(LocalDateTime.class))).thenReturn(0L);
				
		ServicioActualizarEvento servicioActualizarEvento = new ServicioActualizarEvento(repositorioEvento,
				servicioActualizarEventoReferenciaProducto);
		// act - assert

		Assertions.assertDoesNotThrow(() -> servicioActualizarEvento.ejecutar(evento));

	}
}
