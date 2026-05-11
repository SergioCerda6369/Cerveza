package com.cerveza.cerveza.dto;

import lombok.Data;

@Data
public class RecetasDTO {
    
    private Integer id_receta;
    private String nombre_receta;
    private String tipo_cerveza;
    private Integer tiempo_coccion;

}
