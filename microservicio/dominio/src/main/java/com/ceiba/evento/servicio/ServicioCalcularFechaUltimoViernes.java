package com.ceiba.evento.servicio;

import java.util.Calendar;
import java.util.Date;

public class ServicioCalcularFechaUltimoViernes {

	public Date obtenerUltimoViernesDelMes() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, -1);

		return calendar.getTime();
	}

}
