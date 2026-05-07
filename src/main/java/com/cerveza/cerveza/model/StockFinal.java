package com.cerveza.cerveza.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stock_final")
public class StockFinal {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idStockFinal;

    @NotBlank(message = "El nombre de la cerveza es obligatorio.")
    @Size(min = 3, max = 100, message = "El nombre de la cerveza debe tener entre 3 a 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String nombreCerveza;

    @NotBlank(message = "El formato de distribucion es obligatorio. (Ejemplo: Pack 6, Pack 12, etc.)")
    @Column(nullable = false, length = 50)
    private String formatoDistribucion;

    @NotNull(message = "La cantidad de stock disponible es obligatoria.")
    @Min(value = 0, message = "La cantidad de stock disponible debe de ser mayor o igual a 0.")
    @Column(nullable = false)
    private Integer cantidadDisponible;

    @NotNull(message = "El precio de venta es obligatorio.")
    @Min(value = 0, message = "El precio de venta debe de ser mayor o igual a 0.")
    @Column(nullable = false)
    private Integer precioVenta;

}
