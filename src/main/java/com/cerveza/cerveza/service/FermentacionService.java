package com.cerveza.cerveza.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.FermentacionDTO;
import com.cerveza.cerveza.model.Fermentacion;
import com.cerveza.cerveza.repository.FermentacionRepository;

@Service
public class FermentacionService {

    @Autowired
    private FermentacionRepository fermentacionRepository;

    public List<FermentacionDTO> obtenerTodos() {
        return fermentacionRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public FermentacionDTO buscarPorId(Integer id) {
        return fermentacionRepository.findById(id)
                .map(this::convertirADTO)
                .orElse(null);
    }

    public FermentacionDTO buscarPorCodigoTanque(String codigo) {
        return fermentacionRepository.findByCodigoTanque(codigo)
                .map(this::convertirADTO)
                .orElse(null);
    }

    public FermentacionDTO guardarFermentacion(Fermentacion fermentacion) {
        Fermentacion guardada = fermentacionRepository.save(fermentacion);
        return convertirADTO(guardada);
    }

    private FermentacionDTO convertirADTO(Fermentacion fermentacion) {
        FermentacionDTO dto = new FermentacionDTO();
        dto.setId_fermentacion(fermentacion.getId_fermentacion());
        dto.setCodigo_tanque(fermentacion.getCodigo_tanque());
        dto.setTemperatura_actual(fermentacion.getTemperatura_actual());
        return dto;
    }

}
