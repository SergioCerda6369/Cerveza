package com.cerveza.cerveza.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.Inventario_MaterialesDTO;
import com.cerveza.cerveza.model.Inventario_Materiales;
import com.cerveza.cerveza.repository.Inventario_MaterialesRepository;


@Service
public class Inventario_MaterialesService {

    @Autowired
    private Inventario_MaterialesRepository inventarioRepository;

    public List<Inventario_MaterialesDTO> obtenerTodos() {
        return inventarioRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Inventario_MaterialesDTO buscarPorId(Integer id) {
        return inventarioRepository.findById(id)
                .map(this::convertirADTO)
                .orElse(null);
    }

    public Inventario_MaterialesDTO guardarInventario(Inventario_Materiales inventario) {
        return convertirADTO(inventarioRepository.save(inventario));
    }

    public Inventario_MaterialesDTO actualizarInventario(Integer id, Inventario_Materiales datosNuevos) {
        return inventarioRepository.findById(id).map(existente -> {
            if (datosNuevos.getNombre_material() != null) existente.setNombre_material(datosNuevos.getNombre_material());
            if (datosNuevos.getCantidad_stock() != null) existente.setCantidad_stock(datosNuevos.getCantidad_stock());
            if (datosNuevos.getNombre_proveedor() != null) existente.setNombre_proveedor(datosNuevos.getNombre_proveedor());
            return convertirADTO(inventarioRepository.save(existente));
        }).orElse(null);
    }

    public boolean eliminarInventario(Integer id) {
        return inventarioRepository.findById(id).map(material -> {
            inventarioRepository.delete(material);
            return true;
        }).orElse(false);
    }

    private Inventario_MaterialesDTO convertirADTO(Inventario_Materiales inventario) {
        Inventario_MaterialesDTO dto = new Inventario_MaterialesDTO();
        dto.setId_material(inventario.getId_material());
        dto.setNombre_material(inventario.getNombre_material());
        dto.setCantidad_stock(inventario.getCantidad_stock());
        dto.setNombre_proveedor(inventario.getNombre_proveedor());
        return dto;
    }
        
}






    



