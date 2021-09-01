package com.ceiba.evento.servicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.evento.modelo.dto.DtoEvento;
import com.ceiba.evento.puerto.dao.DaoEvento;
import com.ceiba.evento.servicio.testdatabuilder.DtoEventoTestDataBuilder;
import com.ceiba.eventoreferenciaproducto.modelo.dto.DtoEventoReferenciaProducto;
import com.ceiba.eventoreferenciaproducto.puerto.dao.DaoEventoReferenciaProducto;

public class ServicioListarEventoTest {
	
	@Test
	public void validarExisteEventoTest() {
		
		// arrange
		DtoEvento evento = new DtoEventoTestDataBuilder().conNombre("test").build();
		List<DtoEvento> eventos = new ArrayList<>();
		eventos.add(evento);

		DaoEventoReferenciaProducto daoEventoReferenciaProducto = Mockito.mock(DaoEventoReferenciaProducto.class);
		DaoEvento daoEvento = Mockito.mock(DaoEvento.class);

		ServicioCalcularFechaUltimoViernes servicioCalcularFechaUltimoViernes = new ServicioCalcularFechaUltimoViernes();
		
		ServicioListarEvento servicioListarEvento = new ServicioListarEvento(daoEvento, daoEventoReferenciaProducto, servicioCalcularFechaUltimoViernes);

		Mockito.when(daoEvento.listar()).thenReturn(eventos);
		
		Mockito.when(daoEventoReferenciaProducto.listar(Mockito.anyInt()))
				.thenReturn(eventos.get(0).getEventoReferenciaProductos());

		// act - assert
		Assertions.assertEquals("test", servicioListarEvento.ejecutar().get(0).getNombre());
	}
	
	@Test
	public void validarDescuentoViernesEventoTest() {
		
		// arrange
		DtoEvento evento = new DtoEventoTestDataBuilder().conNombre("test").build();
		List<DtoEvento> eventos = new ArrayList<>();
		eventos.add(evento);

		DaoEventoReferenciaProducto daoEventoReferenciaProducto = Mockito.mock(DaoEventoReferenciaProducto.class);
		DaoEvento daoEvento = Mockito.mock(DaoEvento.class);
		ServicioCalcularFechaUltimoViernes servicioCalcularFechaUltimoViernes = Mockito.mock(ServicioCalcularFechaUltimoViernes.class);

		ServicioListarEvento servicioListarEvento = new ServicioListarEvento(daoEvento, daoEventoReferenciaProducto, servicioCalcularFechaUltimoViernes);
		
		Mockito.when(daoEvento.listar()).thenReturn(eventos);

		Mockito.when(servicioCalcularFechaUltimoViernes.obtenerUltimoViernesDelMes()).thenReturn(new Date());

		Mockito.when(daoEventoReferenciaProducto.listar(Mockito.anyInt()))
				.thenReturn(eventos.get(0).getEventoReferenciaProductos());
		
		List<DtoEventoReferenciaProducto> referencias = servicioListarEvento.ejecutar().get(0).getEventoReferenciaProductos();

		referencias.forEach(referencia -> {
			Assertions.assertNotNull(referencia.getValorConDescuentoAdicional());
		});

	}

	@Test
	public void validarNoExisteEventoTest() {
		// arrange
		DtoEvento evento = new DtoEventoTestDataBuilder().conNombre("test").build();
		List<DtoEvento> eventos = new ArrayList<>();
		eventos.add(evento);

		DaoEventoReferenciaProducto daoEventoReferenciaProducto = Mockito.mock(DaoEventoReferenciaProducto.class);
		DaoEvento daoEvento = Mockito.mock(DaoEvento.class);

		Mockito.when(daoEvento.listar()).thenReturn(Collections.emptyList());

		ServicioCalcularFechaUltimoViernes servicioCalcularFechaUltimoViernes = new ServicioCalcularFechaUltimoViernes();
		
		ServicioListarEvento servicioListarEvento = new ServicioListarEvento(daoEvento, daoEventoReferenciaProducto, servicioCalcularFechaUltimoViernes);
		
		Assertions.assertEquals(0, servicioListarEvento.ejecutar().size());
	}

}
