package com.cerveza.cerveza.dto;

import lombok.Data;

@Data
public class Inventario_MaterialesDTO {

    private Integer id_material;
    private String nombre_material;
    private Integer cantidad_stock;
    private String nombre_proveedor;

}
