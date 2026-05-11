package com.cerveza.cerveza.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.FermentacionDTO;
import com.cerveza.cerveza.model.Fermentacion;
import com.cerveza.cerveza.repository.FermentacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FermentacionService {

    @Autowired
    private FermentacionRepository fermentacionRepository;

    private FermentacionDTO convertirADTO(Fermentacion fermentacion) {
        FermentacionDTO dto = new FermentacionDTO();
        dto.setId_fermentacion(fermentacion.getId_fermentacion());
        dto.setCodigo_tanque(fermentacion.getCodigo_tanque());
        dto.setTemperatura_actual(fermentacion.getTemperatura_actual());
        return dto;
    }

    public List<FermentacionDTO> obtenerTodos() {
        return fermentacionRepository.findAll().stream()
            .map(this::convertirADTO)
            .toList();
    }

    public FermentacionDTO buscarPorId(Integer id){
        Fermentacion fermentacion = fermentacionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("La fermentación " + id + " no existe en los registros"));
        return convertirADTO(fermentacion);
    }

    public FermentacionDTO buscarPorCodigoTanque(String codigo_tanque){
        Fermentacion fermentacion = fermentacionRepository.findBycodigo_tanqueContainingIgnoreCase(codigo_tanque)
            .orElseThrow(() -> new RuntimeException("La fermentación con código de tanque " + codigo_tanque + " no existe en los registros"));
        return convertirADTO(fermentacion);
    }

    public FermentacionDTO guardarFermentacion (Fermentacion fermentacion){
        Fermentacion guardada = fermentacionRepository.save(fermentacion);
        return convertirADTO(guardada);
    }

}
