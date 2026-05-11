package com.cerveza.cerveza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cerveza.cerveza.dto.CalidadDTO;
import com.cerveza.cerveza.model.Calidad;
import com.cerveza.cerveza.repository.CalidadRepository;

import java.util.List;

@Service
@Transactional
public class CalidadService {

    @Autowired
    private CalidadRepository calidadRepository;

    private CalidadDTO convertirDTO(Calidad calidad) {
        CalidadDTO calidadDTO = new CalidadDTO();
        calidadDTO.setId_calidad(calidad.getId_calidad());
        calidadDTO.setCantidad_ph(calidad.getCantidad_ph());
        calidadDTO.setControl_calidad(calidad.getControl_calidad());
        return calidadDTO;
    }

    public List<CalidadDTO> obtenerTodos(){
        return calidadRepository.findAll().stream()
                .map(this::convertirDTO)
                .toList();
    }

    public CalidadDTO guardar(Calidad calidad){
        Calidad calidadGuardada = calidadRepository.save(calidad);
        return convertirDTO(calidadGuardada);
    }

    public CalidadDTO buscarPorId(Integer id){
        Calidad calidad = calidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado (ID: " + id + ")"));
        return convertirDTO(calidad);
    }

    public CalidadDTO actualizar(Integer id, Calidad nuevosDatos){
        Calidad existente = calidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el registro para actualizar (ID: " + id + ")"));

        if (nuevosDatos.getCantidad_ph() != null) {
            existente.setCantidad_ph(nuevosDatos.getCantidad_ph());
        }
        if (nuevosDatos.getControl_calidad() != null) {
            existente.setControl_calidad(nuevosDatos.getControl_calidad());
        }

        Calidad actualizado = calidadRepository.save(existente);
        return convertirDTO(actualizado);
    }

    public String eliminar(Integer id){
        try {
            calidadRepository.deleteById(id);
            return "Registro eliminado exitosamente.";
        } catch (Exception e) {
            return "Error al eliminar el registro: " + e.getMessage();
        }

    }




}
