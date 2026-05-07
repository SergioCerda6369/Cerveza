package com.cerveza.cerveza.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @NotBlank(message = "El cliente no puede estar vacio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String cliente;

    @ManyToOne
    @JoinColumn(name = "id_stock_final", nullable = false)
    private StockFinal producto;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "Debe pedir al menos una unidad")
    @Column(nullable = false)
    private Integer cantidadSolicitada;

    @NotNull(message = "El total es obligatorio")
    @Min(value = 0, message = "El total de la venta no puede ser negativo")
    @Column(nullable = false)
    private Double totalVenta;

    @NotBlank(message = "El estado del pedido es obligatorio")
    @Column(nullable = false, length = 50)
    private String estadoPedido;

}


