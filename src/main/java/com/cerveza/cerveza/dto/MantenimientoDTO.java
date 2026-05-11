package com.cerveza.cerveza.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MantenimientoDTO {
    private Integer id_mantenimiento;
    private String tipo_equipo;
    private String codigo_equipo;
    private String estado_equipo;
    private String estado_mantenimiento;

}
