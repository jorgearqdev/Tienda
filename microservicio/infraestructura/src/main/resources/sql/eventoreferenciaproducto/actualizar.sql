update evento_referencia_producto
set referencia = :referencia,
  precio_antiguo = :precioAntiguo,
  precio_nuevo = :precioNuevo
where id = :id