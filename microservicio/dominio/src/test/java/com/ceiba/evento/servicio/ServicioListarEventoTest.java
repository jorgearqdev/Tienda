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
		ServicioListarEvento servicioListarEvento = new ServicioListarEvento(daoEvento, daoEventoReferenciaProducto);

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
		ServicioListarEvento servicioListarEvento = new ServicioListarEvento(daoEvento, daoEventoReferenciaProducto);
		
		ServicioListarEvento spyTemp = Mockito.spy(servicioListarEvento);

		Mockito.when(daoEvento.listar()).thenReturn(eventos);

	    Mockito.doReturn(new Date()).when(spyTemp).obtenerUltimoViernesDelMes();

		Mockito.when(daoEventoReferenciaProducto.listar(Mockito.anyInt()))
				.thenReturn(eventos.get(0).getEventoReferenciaProductos());
		
		List<DtoEventoReferenciaProducto> referencias = spyTemp.ejecutar().get(0).getEventoReferenciaProductos();

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

		ServicioListarEvento servicioListarEvento = new ServicioListarEvento(daoEvento, daoEventoReferenciaProducto);
		// act - assert
		Assertions.assertEquals(0, servicioListarEvento.ejecutar().size());
	}

}
