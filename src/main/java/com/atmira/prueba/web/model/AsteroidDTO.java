package com.atmira.prueba.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AsteroidDTO {

    private String nombre;
    private Double diametro;
    private String velocidad;
    private String fecha;
    private String planeta;

}
