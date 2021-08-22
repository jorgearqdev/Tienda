select e.id, 
	nombre,
	e.fecha_inicio,
	e.fecha_fin,
	e.suspendido
	erp.ID id_referencia_producto,
 	erp.EVENTO_ID,
	erp.REFERENCIA,
	erp.PRECIO_ANTIGUO,
	erp.PRECIO_NUEVO
from evento e 
inner join evento_referencia_producto erp
	on erp.EVENTO_ID = e.id 
where sysdate between fecha_inicio and fecha_fin