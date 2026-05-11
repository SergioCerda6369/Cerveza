package com.cerveza.cerveza.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "recetas")
public class Recetas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_receta;

    @NotBlank
    @Size(min = 10, max = 255, message = "La receta debe de llevar nombre (En consecuencia a lo que se creara.)")
    @Column(nullable = false, length = 255)
    private String nombre_receta;

    @NotBlank
    @Size(min = 10, max = 255, message = "La receta debe de llevar el tipo de cerveza que se creara (IPA, Stout, Porter, etc.)")
    @Column(nullable = false, length = 255)
    private String tipo_cerveza;

    @NotNull(message = "La cantidad de tiempo de coccion de la cerveza es obligatoria.")
    @Min(value = 0, message = "La cantidad de tiempo de coccion debe de ser mayor a 0.")
    @Column(nullable = false)
    private Integer tiempo_coccion;




}
