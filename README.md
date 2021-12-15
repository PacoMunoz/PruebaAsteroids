# PruebaAsteroids

Api rest que expone el endpoint /asteroids?days=X donde X tiene que ser un valor entre 
1 y 7. 

Devuelve una lista de asteroides potencialmente peligrosos en los siguientes X's días.
Un asteroide es un objeto con los siguientes campos:

nombre: Obtenido de "name",

diametro: Tamaño medio calculado

velocidad: "close_approach_data:relative_velocity:kilometers_per_hour"

fecha: "close_approach_data:close_approach_date"

planeta: "close_approach_date:orbiting_body"

 
