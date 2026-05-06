package com.cerveza.cerveza.model;

<<<<<<< HEAD
import jakarta.persistence.Column;
=======
>>>>>>> cfd278de0f4b8a5d406cf03c737d260eca2356a5
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
<<<<<<< HEAD
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

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

    @NotNull(message = "El id del producto es obligatorio")
    @Column(nullable = false)
    private Long idProducto;

    @Min(value = 1, message = "Debe pedir al menos una unidad")
    @Column(nullable = false)
    private Integer cantidadSolicitada;

    @Min(value = 0, message = "El total de la venta no puede ser negativo")
    @Column(nullable = false)
    private Double totalVenta;

    @NotBlank(message = "El estado del pedido es obligatorio")
    @Column(nullable = false, length = 50)
    private String estadoPedido;
=======
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
>>>>>>> cfd278de0f4b8a5d406cf03c737d260eca2356a5

}
