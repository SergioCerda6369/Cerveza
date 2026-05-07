package com.cerveza.cerveza.dto;

import lombok.Data;

@Data
public class PedidoDTO {

    private Integer idPedido;
    private String cliente;
    private Integer idProducto;
    private Integer cantidadSolicitada;
    private Double totalVenta;
    private String estadoPedido;

}
