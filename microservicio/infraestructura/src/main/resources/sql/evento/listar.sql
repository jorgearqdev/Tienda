select e.id, 
	e.nombre,
	e.fecha_inicio,
	e.fecha_fin,
	e.suspendido
from evento e 
where now() < fecha_fin