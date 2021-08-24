package com.ceiba.evento.servicio;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;
import com.ceiba.evento.servicio.testdatabuilder.EventoTestDataBuilder;
import com.ceiba.eventoreferenciaproducto.modelo.entidad.EventoReferenciaProducto;
import com.ceiba.eventoreferenciaproducto.servicio.ServicioCrearEventoReferenciaProducto;

public class ServicioCrearEventoTest {

	@Test
	public void validarEventoExistenciaPreviaTest() {
		// arrange
		Evento evento = new EventoTestDataBuilder().build();
		RepositorioEvento repositorioEvento = Mockito.mock(RepositorioEvento.class);
		Mockito.when(repositorioEvento.existeDentroDeFechas(Mockito.any(LocalDateTime.class),
				Mockito.any(LocalDateTime.class))).thenReturn(1L);
		ServicioCrearEvento servicioCrearEvento = new ServicioCrearEvento(repositorioEvento, null);
		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearEvento.ejecutar(evento), ExcepcionDuplicidad.class,
				"Ya existen eventos dentro de las fechas seleccionadas");
	}

	@Test
	public void validarEventoSinExistenciaPreviaTest() {
		// arrange
		Evento evento = new EventoTestDataBuilder().build();
		RepositorioEvento repositorioEvento = Mockito.mock(RepositorioEvento.class);
		ServicioCrearEventoReferenciaProducto servicioCrearEventoReferenciaProducto = Mockito.mock(ServicioCrearEventoReferenciaProducto.class);
		
		Mockito.when(repositorioEvento.existeDentroDeFechas(Mockito.any(LocalDateTime.class),
				Mockito.any(LocalDateTime.class))).thenReturn(0L);
		
		Mockito.when(repositorioEvento.crear(Mockito.any(Evento.class))).thenReturn(1L);
		
		Mockito.when(servicioCrearEventoReferenciaProducto.ejecutar(Mockito.any(EventoReferenciaProducto.class))).thenReturn(1L);
		
		ServicioCrearEvento servicioCrearEvento = new ServicioCrearEvento(repositorioEvento, servicioCrearEventoReferenciaProducto);
		// act - assert
		Assert.assertTrue(servicioCrearEvento.ejecutar(evento) > 0L);
	}
}
