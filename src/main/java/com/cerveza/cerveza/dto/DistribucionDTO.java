package com.cerveza.cerveza.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistribucionDTO {
    private Integer id_distribucion;
    private String patente_camion;
    private String nombre_conductor;
    private String estado_distribucion;

}
