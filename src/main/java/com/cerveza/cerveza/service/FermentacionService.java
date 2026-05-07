package com.cerveza.cerveza.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.FermentacionDTO;
import com.cerveza.cerveza.model.Fermentacion;
import com.cerveza.cerveza.repository.FermentacionRepository;

@Service
public class FermentacionService {
    private Logger log = LoggerFactory.getLogger(FermentacionService.class);
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
        log.info("Consultando la lista completa de fermentaciones");
        return fermentacionRepository.findAll().stream()
            .map(this::convertirADTO)
            .toList();
    }

    public FermentacionDTO buscarPorId(Integer id){
        Fermentacion fermentacion = fermentacionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("La fermentación " + id + " no existe en los registros"));
        return convertirADTO(fermentacion);
    }

    public FermentacionDTO buscarPorCodigoTanque(Fermentacion codigo){
        Fermentacion fermentacion = fermentacionRepository.findByCodigo_tanque(codigo)
            .orElseThrow(() -> new RuntimeException("La fermentación con código de tanque " + codigo + " no existe en los registros"));
        return convertirADTO(fermentacion);
    }

    public FermentacionDTO guardarFermentacion (Fermentacion fermentacion){
        log.info("Guardando nueva fermentacion: {}", fermentacion.getCodigo_tanque());
        Fermentacion guardada = fermentacionRepository.save(fermentacion);
        log.info("Fermentacion #{} guardada.", guardada.getId_fermentacion());
        return convertirADTO(guardada);
    }

}
