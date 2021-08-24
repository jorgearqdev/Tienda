package com.ceiba.evento.servicio;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.evento.modelo.dto.DtoEventoActualizar;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;
import com.ceiba.evento.servicio.testdatabuilder.DtoEventoActualizarTestDataBuilder;

public class ServicioSwitchEventoTest {

	@Test
	public void validarSuspenderEventoPreviaTest() {
		// arrange
		DtoEventoActualizar evento = new DtoEventoActualizarTestDataBuilder().build();

		RepositorioEvento repositorioEvento = Mockito.mock(RepositorioEvento.class);

		ServicioSwitchEvento servicioSwitchEvento = new ServicioSwitchEvento(repositorioEvento);
		// act - assert
		Assertions.assertDoesNotThrow(() -> servicioSwitchEvento.ejecutar(evento));
	}

	@Test
	public void validarActivarEventoPreviaTest() {
		// arrange
		DtoEventoActualizar evento = new DtoEventoActualizarTestDataBuilder().suspendido().build();

		RepositorioEvento repositorioEvento = Mockito.mock(RepositorioEvento.class);

		ServicioSwitchEvento servicioSwitchEvento = new ServicioSwitchEvento(repositorioEvento);
		// act - assert
		Assertions.assertDoesNotThrow(() -> servicioSwitchEvento.ejecutar(evento));
	}
}
