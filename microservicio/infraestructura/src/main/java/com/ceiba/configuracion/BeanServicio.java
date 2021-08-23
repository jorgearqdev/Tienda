package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.evento.puerto.dao.DaoEvento;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;
import com.ceiba.evento.servicio.ServicioActualizarEvento;
import com.ceiba.evento.servicio.ServicioCrearEvento;
import com.ceiba.evento.servicio.ServicioListarEvento;
import com.ceiba.evento.servicio.ServicioSwitchEvento;
import com.ceiba.eventoreferenciaproducto.puerto.dao.DaoEventoReferenciaProducto;
import com.ceiba.eventoreferenciaproducto.puerto.repositorio.RepositorioEventoReferenciaProducto;
import com.ceiba.eventoreferenciaproducto.servicio.ServicioActualizarEventoReferenciaProducto;
import com.ceiba.eventoreferenciaproducto.servicio.ServicioCrearEventoReferenciaProducto;
import com.ceiba.eventoreferenciaproducto.servicio.ServicioEliminarEventoReferenciaProducto;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearEvento servicioCrearEvento(RepositorioEvento repositorioEvento,
			ServicioCrearEventoReferenciaProducto servicioCrearEventoReferenciaProducto) {
		return new ServicioCrearEvento(repositorioEvento, servicioCrearEventoReferenciaProducto);
	}

	@Bean
	public ServicioCrearEventoReferenciaProducto servicioCrearEventoReferenciaProducto(
			RepositorioEventoReferenciaProducto repositorioEventoReferenciaProducto) {
		return new ServicioCrearEventoReferenciaProducto(repositorioEventoReferenciaProducto);
	}

	@Bean
	public ServicioActualizarEventoReferenciaProducto servicioActualizarEventoReferenciaProducto(
			RepositorioEventoReferenciaProducto repositorioEventoReferenciaProducto) {
		return new ServicioActualizarEventoReferenciaProducto(repositorioEventoReferenciaProducto);
	}

	@Bean
	public ServicioEliminarEventoReferenciaProducto servicioEliminarEventoReferenciaProducto(
			RepositorioEventoReferenciaProducto repositorioEventoReferenciaProducto) {
		return new ServicioEliminarEventoReferenciaProducto(repositorioEventoReferenciaProducto);
	}

	@Bean
	public ServicioSwitchEvento servicioSwitchEvento(RepositorioEvento repositorioEvento) {
		return new ServicioSwitchEvento(repositorioEvento);
	}

	@Bean
	public ServicioActualizarEvento servicioActualizarEvento(RepositorioEvento repositorioEvento,
			ServicioActualizarEventoReferenciaProducto servicioActualizarEventoReferenciaProducto) {
		return new ServicioActualizarEvento(repositorioEvento, servicioActualizarEventoReferenciaProducto);
	}

	@Bean
	public ServicioListarEvento servicioListarEvento(DaoEvento daoEvento, DaoEventoReferenciaProducto daoEventoReferenciaProducto) {
		return new ServicioListarEvento(daoEvento, daoEventoReferenciaProducto);
	}

}
