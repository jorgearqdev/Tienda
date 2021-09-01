package com.ceiba.evento.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;
import com.ceiba.evento.comando.ComandoEvento;
import com.ceiba.evento.comando.ComandoEventoActualizar;
import com.ceiba.evento.servicio.testdatabuilder.ComandoEventoActualizarTestDataBuilder;
import com.ceiba.evento.servicio.testdatabuilder.ComandoEventoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoEventoTestDataBuilder.class)
public class ComandoControladorEventoTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void crear() throws Exception {
		ComandoEvento evento = new ComandoEventoTestDataBuilder().build();

		mocMvc.perform(post("/evento").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(evento))).andExpect(status().isOk())
				.andExpect(content().json("{'valor': 2}"));
	}

	@Test
	public void crearEventoConNombreCorto() throws Exception {
		ComandoEvento evento = new ComandoEventoTestDataBuilder().conNombre("Fe").build();

		mocMvc.perform(post("/evento").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(evento))).andExpect(status().isBadRequest())
				.andExpect(content().json(
						"{'nombreExcepcion': 'ExcepcionLongitudValor',    'mensaje': 'La longitud minima del nombre debe ser 3'}"));
	}

	@Test
	public void crearEventoConNombreLargo() throws Exception {
		ComandoEvento evento = new ComandoEventoTestDataBuilder()
				.conNombre(
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut scelerisque velit id cursus maximus. Fusce sit amet arcu ut.1")
				.build();

		mocMvc.perform(post("/evento").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(evento))).andExpect(status().isBadRequest())
				.andExpect(content().json(
						"{'nombreExcepcion': 'ExcepcionLongitudValor',    'mensaje': 'La longitud maxima del nombre debe ser 120'}"));
	}

	@Test
	public void crearEventoSinFechaInicio() throws Exception {
		ComandoEvento evento = new ComandoEventoTestDataBuilder().conFechaInicio(null).build();

		mocMvc.perform(post("/evento").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(evento))).andExpect(status().isBadRequest())
				.andExpect(content().json(
						"{'nombreExcepcion': 'ExcepcionValorObligatorio',    'mensaje': 'Se debe ingresar la fecha inicio'}"));
	}

	@Test
	public void crearEventoSinFechaFin() throws Exception {
		ComandoEvento evento = new ComandoEventoTestDataBuilder().conFechaFin(null).build();

		mocMvc.perform(post("/evento").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(evento))).andExpect(status().isBadRequest())
		.andExpect(content().json(
				"{'nombreExcepcion': 'ExcepcionValorObligatorio',    'mensaje': 'Se debe ingresar la fecha fin'}"));
	}

	@Test
	public void actualizar() throws Exception {
		// arrange
		Long id = 2L;
		ComandoEvento evento = new ComandoEventoTestDataBuilder().conNombre("test").build();

		// act - assert
		mocMvc.perform(put("/evento/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(evento))).andExpect(status().isOk());
	}

	@Test
	public void switchSuspendido() throws Exception {
		// arrange
		Long id = 2L;
		ComandoEventoActualizar evento = new ComandoEventoActualizarTestDataBuilder().build();

		// act - assert
		mocMvc.perform(delete("/evento/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(evento))).andExpect(status().isOk());
	}
}
