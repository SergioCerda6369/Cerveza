package com.cerveza.cerveza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "pedidos")
public class Pedido {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El cliente no puede estar vacio")
    private String cliente;

    @Min(value = 1, message = "Debe pedir al menos una unidad")
    private Integer cantidad;

    private Integer idProducto;

}
