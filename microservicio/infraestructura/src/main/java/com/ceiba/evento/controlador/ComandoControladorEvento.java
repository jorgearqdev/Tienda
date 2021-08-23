package com.ceiba.evento.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.evento.comando.ComandoEvento;
import com.ceiba.evento.comando.ComandoEventoActualizar;
import com.ceiba.evento.comando.manejador.ManejadorActualizarEvento;
import com.ceiba.evento.comando.manejador.ManejadorCrearEvento;
import com.ceiba.evento.comando.manejador.ManejadorSwitchEvento;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/evento")
@Api(tags = { "Controlador comando evento" })
public class ComandoControladorEvento {

	private final ManejadorCrearEvento manejadorCrearEvento;
	private final ManejadorSwitchEvento manejadorSwitchEvento;
	private final ManejadorActualizarEvento manejadorActualizarEvento;

	@Autowired
	public ComandoControladorEvento(ManejadorCrearEvento manejadorCrearEvento,
			ManejadorSwitchEvento manejadorSwitchEvento, ManejadorActualizarEvento manejadorActualizarUsuario) {
		this.manejadorCrearEvento = manejadorCrearEvento;
		this.manejadorSwitchEvento = manejadorSwitchEvento;
		this.manejadorActualizarEvento = manejadorActualizarUsuario;
	}

	@PostMapping
	@ApiOperation("Crear evento")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoEvento comandoEvento) {
		return manejadorCrearEvento.ejecutar(comandoEvento);
	}

	@DeleteMapping(value = "/{id}")
	@ApiOperation("Modificar suspender evento")
	public void switchSuspendido(@RequestBody ComandoEventoActualizar comandoEventoActualizar, @PathVariable int id) {
		comandoEventoActualizar.setId(id);
		manejadorSwitchEvento.ejecutar(comandoEventoActualizar);
	}

	@PutMapping(value = "/{id}")
	@ApiOperation("Actualizar evento")
	public void actualizar(@RequestBody ComandoEvento comandoEvento, @PathVariable int id) {
		comandoEvento.setId(id);
		manejadorActualizarEvento.ejecutar(comandoEvento);
	}
}
