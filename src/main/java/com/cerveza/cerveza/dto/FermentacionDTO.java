package com.cerveza.cerveza.dto;

import lombok.Data;

@Data
public class FermentacionDTO {
    private Integer id_fermentacion;
    private String codigo_tanque;
    private Integer temperatura_actual;
}
