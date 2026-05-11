package com.cerveza.cerveza.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cerveza.cerveza.model.Produccion;
import com.cerveza.cerveza.repository.ProduccionRepository;
import com.cerveza.cerveza.dto.ProduccionDTO;
import java.util.List;


public class ProduccionService {

    @Autowired
    private ProduccionRepository produccionRepository;

    private ProduccionDTO convertirADTO(Produccion produccion) {
        ProduccionDTO dto = new ProduccionDTO();
        dto.setId_produccion(produccion.getId_produccion());
        dto.setEstado_produccion(produccion.getEstado_produccion());
        dto.setResponsable_produccion(produccion.getResponsable_produccion());
        return dto;
    }

    public List<ProduccionDTO> obtenerTodos(){
        return produccionRepository.findAll().stream()
            .map(this::convertirADTO)
            .toList();
    }

    public ProduccionDTO buscarPorId(Integer id){
        Produccion produccion = produccionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No existe ninguna produccion asociada a la id: " + id));
            return convertirADTO(produccion);
    }

    public ProduccionDTO actualizaProduccion(Integer id, ProduccionDTO datosNuevos) {
        Produccion produccionExistente = produccionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No existe produccion asociada a la id: " + id));
        
        if(datosNuevos.getEstado_produccion() != null){
            produccionExistente.setEstado_produccion(datosNuevos.getEstado_produccion());
        }
        if(datosNuevos.getResponsable_produccion() != null) {
            produccionExistente.setResponsable_produccion(datosNuevos.getResponsable_produccion());
        }

        return convertirADTO(produccionRepository.save(produccionExistente));
    }

    public ProduccionDTO guardarProduccion(Produccion produccion){
        return convertirADTO(produccionRepository.save(produccion));
    }

    public String eliminarProduccion(Integer id){
        try {
            produccionRepository.deleteById(id);
            return "Produccion eliminada";
        } catch (Exception e){
            return "No se pudo eliminar la produccion";
        }
    }
    
}


