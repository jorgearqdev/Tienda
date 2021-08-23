select e.id, 
	e.nombre,
	e.fecha_inicio,
	e.fecha_fin,
	e.suspendido
from evento e 
where now() between fecha_inicio and fecha_fin