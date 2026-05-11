package com.cerveza.cerveza.dto;

import lombok.Data;

@Data
public class StockFinalDTO {
    private Integer idStockFinal;
    private String nombreCerveza;
    private String formatoDistribucion;
    private Integer cantidadDisponible;
    private Integer precioVenta;

}
