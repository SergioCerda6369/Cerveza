package com.cerveza.cerveza.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fermentacion")
public class Fermentacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_fermentacion;

    @NotBlank(message = "Debe de estar registrado el codigo del tanque de la fermentacion.")
    @Size(min = 3, max = 10, message = "El codigo del tanque debe de tener entre 3 a 10 caracteres. (Ejemplo: A-01, B-02, etc.)")
    @Column(nullable = false, length = 10)
    private String codigo_tanque;

    @NotNull (message = "La temperatura actual de la fermentacion es obligatoria. (Recomendacion que se trate en celsius)")
    @Column(nullable = false)
    private Integer temperatura_actual;


}