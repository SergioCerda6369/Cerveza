package com.cerveza.cerveza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cerveza.cerveza.model.Inventario_Materiales;


public interface Inventario_MaterialesRepository extends JpaRepository<Inventario_Materiales, Integer> {

    List<Inventario_Materiales> findById_Material(Integer id_material);

    

}
