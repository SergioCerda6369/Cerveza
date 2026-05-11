package com.cerveza.cerveza.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.DistribucionDTO;
import com.cerveza.cerveza.model.Distribucion;
import com.cerveza.cerveza.repository.DistribucionRepository;


@Service
public class DistribucionService {

    @Autowired
    private DistribucionRepository distribucionRepository;

    public List<DistribucionDTO> obtenerTodas() {
        return distribucionRepository.findAll().stream()
                .map(this:: convertirADTO)
                .collect(Collectors.toList());
    }

    public DistribucionDTO buscarPorId(Integer id) {
        return distribucionRepository.findById(id)
                .map(this::convertirADTO)
                .orElse(null);
    }

    public DistribucionDTO guardar(Distribucion distribucion) {
        Distribucion guardada = distribucionRepository.save(distribucion);
        return convertirADTO(guardada);
    }

    private DistribucionDTO convertirADTO(Distribucion distribucion) {
        DistribucionDTO dto = new DistribucionDTO();
        dto.setId_distribucion(distribucion.getId_distribucion());
        dto.setPatente_camion(distribucion.getPatente_camion());
        dto.setNombre_conductor(distribucion.getNombre_conductor());
        dto.setEstado_distribucion(distribucion.getEstado_distribucion());
        return dto;
    }


}
