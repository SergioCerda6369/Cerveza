package com.cerveza.cerveza.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_mantenimiento;

    @NotBlank(message = "El tipo de equipo es obligatorio.")
    @Size(min = 3, max = 255, message = "El tipo de equipo debe de tener entre 3 y 255 caracteres.")
    @Column(nullable = false, length = 255)
    private String tipo_equipo;

    @NotBlank(message = "El CODIGO del equipo al que se le hara mantenimiento es obligatorio.")
    @Size(min = 3, max = 10, message = "El CODIGO del equipo debe de tener entre 3 y 10 caracteres. (Ejemplo: A-01, B-02, etc.)")
    @Column(nullable = false, length = 10)
    private String codigo_equipo;

    @NotBlank(message = "El estado del equipo es obligatorio.")
    @Size(min = 3, max = 255, message = "El estado del equipo debe de tener entre 3 y 255 caracteres.")
    @Column(nullable = false, length = 255)
    private String estado_equipo;

    @NotBlank(message = "El estado del mantenimiento es obligatorio.")
    @Size(min = 3, max = 255, message = "El estado del mantenimiento debe de tener entre 3 y 255 caracteres.")
    @Column(nullable = false, length = 255)
    private String estado_mantenimiento;

}

