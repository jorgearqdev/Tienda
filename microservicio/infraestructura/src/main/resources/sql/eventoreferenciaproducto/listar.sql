select 
	erp.ID,
 	erp.EVENTO_ID,
	erp.REFERENCIA,
	erp.PRECIO_ANTIGUO,
	erp.PRECIO_NUEVO
from evento_referencia_producto erp
where EVENTO_ID = :idEvento