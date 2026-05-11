package com.cerveza.cerveza.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.MantenimientoDTO;
import com.cerveza.cerveza.model.Mantenimiento;
import com.cerveza.cerveza.repository.MantenimientoRepository;

@Service
public class MantenimientoService {

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    public List<MantenimientoDTO> obtenerTodos() {
        return mantenimientoRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public MantenimientoDTO buscarPorId(Integer id) {
        return mantenimientoRepository.findById(id)
                .map(this::convertirADTO)
                .orElse(null);
    }

    public MantenimientoDTO guardar(Mantenimiento mantenimiento) {
        return convertirADTO(mantenimientoRepository.save(mantenimiento));
    }

    public MantenimientoDTO actualizar(Integer id, Mantenimiento nuevosDatos) {
        return mantenimientoRepository.findById(id).map(existente -> {
            existente.setTipo_equipo(nuevosDatos.getTipo_equipo());
            existente.setCodigo_equipo(nuevosDatos.getCodigo_equipo());
            existente.setEstado_equipo(nuevosDatos.getEstado_equipo());
            existente.setEstado_mantenimiento(nuevosDatos.getEstado_mantenimiento());
            return convertirADTO(mantenimientoRepository.save(existente));
        }).orElse(null);
    }

    public boolean eliminar(Integer id) {
        return mantenimientoRepository.findById(id).map(m -> {
            mantenimientoRepository.delete(m);
            return true;
        }).orElse(false);
    }

    private MantenimientoDTO convertirADTO(Mantenimiento mantenimiento) {
        MantenimientoDTO dto = new MantenimientoDTO();
        dto.setId_mantenimiento(mantenimiento.getId_mantenimiento());
        dto.setTipo_equipo(mantenimiento.getTipo_equipo());
        dto.setCodigo_equipo(mantenimiento.getCodigo_equipo());
        dto.setEstado_equipo(mantenimiento.getEstado_equipo());
        dto.setEstado_mantenimiento(mantenimiento.getEstado_mantenimiento());
        return dto;
    }

}
