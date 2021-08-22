package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.evento.puerto.repositorio.RepositorioEvento;
import com.ceiba.evento.servicio.ServicioActualizarEvento;
import com.ceiba.evento.servicio.ServicioCrearEvento;
import com.ceiba.evento.servicio.ServicioSwitchEvento;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearEvento servicioCrearEvento(RepositorioEvento repositorioEvento) {
        return new ServicioCrearEvento(repositorioEvento);
    }

    @Bean
    public ServicioSwitchEvento servicioSwitchEvento(RepositorioEvento repositorioEvento) {
        return new ServicioSwitchEvento(repositorioEvento);
    }

    @Bean
    public ServicioActualizarEvento servicioActualizarEvento(RepositorioEvento repositorioEvento) {
        return new ServicioActualizarEvento(repositorioEvento);
    }
	

}
