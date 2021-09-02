package com.ceiba.evento.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;
import com.ceiba.evento.comando.ComandoEvento;
import com.ceiba.evento.comando.ComandoEventoActualizar;
import com.ceiba.evento.servicio.testdatabuilder.ComandoEventoActualizarTestDataBuilder;
import com.ceiba.evento.servicio.testdatabuilder.ComandoEventoTestDataBuilder;
import com.ceiba.evento.servicio.testdatabuilder.EventoReferenciaProductoTestDataBuilder;
import com.ceiba.eventoreferenciaproducto.modelo.dto.DtoEventoReferenciaProducto;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoEventoTestDataBuilder.class)
@DirtiesContext(methodMode = MethodMode.BEFORE_METHOD)
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
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut scelerisque velit id cursus maximus. Fusce sit amet arcu ut..")
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
	public void crearEventoSinReferencias() throws Exception {
		ComandoEvento evento = new ComandoEventoTestDataBuilder().conListaReferencias(new ArrayList<>()).build();

		mocMvc.perform(post("/evento").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(evento))).andExpect(status().isBadRequest())
				.andExpect(content().json(
						"{'nombreExcepcion': 'ExcepcionValorObligatorio',    'mensaje': 'Se debe ingresar al menos un producto'}"));
	}

	@Test
	public void crearEventoSinPrecioAntiguo() throws Exception {
		List<DtoEventoReferenciaProducto> eventoReferenciaProductos = new ArrayList<>();
		EventoReferenciaProductoTestDataBuilder eventoReferenciaProductoTestDataBuilder = new EventoReferenciaProductoTestDataBuilder();
		eventoReferenciaProductos.add(eventoReferenciaProductoTestDataBuilder.conPrecioAntiguo(0).build());

		ComandoEvento evento = new ComandoEventoTestDataBuilder().conListaReferencias(eventoReferenciaProductos)
				.build();

		mocMvc.perform(post("/evento").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(evento))).andExpect(status().isBadRequest())
				.andExpect(content().json(
						"{'nombreExcepcion': 'ExcepcionValorInvalido',    'mensaje': 'Se debe ingresar el precio antiguo'}"));
	}

	@Test
	public void crearEventoSinPrecioNuevo() throws Exception {
		List<DtoEventoReferenciaProducto> eventoReferenciaProductos = new ArrayList<>();
		EventoReferenciaProductoTestDataBuilder eventoReferenciaProductoTestDataBuilder = new EventoReferenciaProductoTestDataBuilder();
		eventoReferenciaProductos.add(eventoReferenciaProductoTestDataBuilder.conPrecioNuevo(0).build());

		ComandoEvento evento = new ComandoEventoTestDataBuilder().conListaReferencias(eventoReferenciaProductos)
				.build();

		mocMvc.perform(post("/evento").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(evento))).andExpect(status().isBadRequest())
				.andExpect(content().json(
						"{'nombreExcepcion': 'ExcepcionValorInvalido',    'mensaje': 'Se debe ingresar el precio nuevo'}"));
	}

	@Test
	public void crearEventoPrecioMenor() throws Exception {
		List<DtoEventoReferenciaProducto> eventoReferenciaProductos = new ArrayList<>();
		EventoReferenciaProductoTestDataBuilder eventoReferenciaProductoTestDataBuilder = new EventoReferenciaProductoTestDataBuilder();
		eventoReferenciaProductos
				.add(eventoReferenciaProductoTestDataBuilder.conPrecioNuevo(10000).conPrecioAntiguo(9000).build());

		ComandoEvento evento = new ComandoEventoTestDataBuilder().conListaReferencias(eventoReferenciaProductos)
				.build();

		mocMvc.perform(post("/evento").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(evento))).andExpect(status().isBadRequest())
				.andExpect(content().json(
						"{'nombreExcepcion': 'ExcepcionValorInvalido',    'mensaje': 'El nuevo precio debe ser menor que el precio antiguo'}"));
	}

	@Test
	public void crearEventoConReferenciaCorto() throws Exception {
		List<DtoEventoReferenciaProducto> eventoReferenciaProductos = new ArrayList<>();
		EventoReferenciaProductoTestDataBuilder eventoReferenciaProductoTestDataBuilder = new EventoReferenciaProductoTestDataBuilder();
		eventoReferenciaProductos.add(eventoReferenciaProductoTestDataBuilder.conReferencia("Te").build());

		ComandoEvento evento = new ComandoEventoTestDataBuilder().conListaReferencias(eventoReferenciaProductos).build();

		mocMvc.perform(post("/evento").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(evento))).andExpect(status().isBadRequest())
				.andExpect(content().json(
						"{'nombreExcepcion': 'ExcepcionLongitudValor',    'mensaje': 'La longitud minima de la referencia debe ser 3'}"));
	}

	@Test
	public void crearEventoConReferenciaLargo() throws Exception {
		List<DtoEventoReferenciaProducto> eventoReferenciaProductos = new ArrayList<>();
		EventoReferenciaProductoTestDataBuilder eventoReferenciaProductoTestDataBuilder = new EventoReferenciaProductoTestDataBuilder();
		eventoReferenciaProductos.add(eventoReferenciaProductoTestDataBuilder
				.conReferencia(
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut scelerisque velit id cursus maximus. Fusce sit amet arcu ut..")
				.build());

		ComandoEvento evento = new ComandoEventoTestDataBuilder().conListaReferencias(eventoReferenciaProductos).build();
		
		mocMvc.perform(post("/evento").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(evento))).andExpect(status().isBadRequest())
				.andExpect(content().json(
						"{'nombreExcepcion': 'ExcepcionLongitudValor',    'mensaje': 'La longitud maxima de la referencia debe ser 120'}"));
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
