package com.cerveza.cerveza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cerveza.cerveza.dto.CalidadDTO;
import com.cerveza.cerveza.model.Calidad;
import com.cerveza.cerveza.repository.CalidadRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CalidadService {

    @Autowired
    private CalidadRepository calidadRepository;

    public List<CalidadDTO> obtenerTodos() {
        return calidadRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public CalidadDTO buscarPorId(Integer id) {
        return calidadRepository.findById(id)
                .map(this::convertirADTO)
                .orElse(null);
    }

    public CalidadDTO guardar(Calidad calidad) {
        Calidad guardada = calidadRepository.save(calidad);
        return convertirADTO(guardada);
    }

    public CalidadDTO actualizar(Integer id, Calidad nuevosDatos) {
        return calidadRepository.findById(id).map(existente -> {
            existente.setCantidad_ph(nuevosDatos.getCantidad_ph());
            existente.setControl_calidad(nuevosDatos.isControl_calidad());
            return convertirADTO(calidadRepository.save(existente));
        }).orElse(null);
    }

    public boolean eliminar(Integer id) {
        if (calidadRepository.existsById(id)) {
            calidadRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private CalidadDTO convertirADTO(Calidad calidad) {
        CalidadDTO dto = new CalidadDTO();
        dto.setId_calidad(calidad.getId_calidad());
        dto.setCantidad_ph(calidad.getCantidad_ph());
        dto.setControl_calidad(calidad.isControl_calidad());
        return dto;
    }




}
