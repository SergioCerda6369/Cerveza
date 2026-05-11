package com.cerveza.cerveza.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.EnvasadoDTO;
import com.cerveza.cerveza.model.Envasado;
import com.cerveza.cerveza.repository.EnvasadoRepository;

@Service
public class EnvasadoService {

    @Autowired
    private EnvasadoRepository envasadoRepository;

    public List<EnvasadoDTO> obtenerTodos() {
        return envasadoRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public EnvasadoDTO buscarPorId(Integer id) {
        return envasadoRepository.findById(id)
                .map(this::convertirADTO)
                .orElse(null);
    }

    public EnvasadoDTO guardar(Envasado envasado) {
        Envasado guardado = envasadoRepository.save(envasado);
        return convertirADTO(guardado);
    }

    private EnvasadoDTO convertirADTO(Envasado envasado) {
        EnvasadoDTO dto = new EnvasadoDTO();
        dto.setId_envasado(envasado.getId_envasado());
        dto.setTipo_envase(envasado.getTipo_envase());
        dto.setCantidad_envases(envasado.getCantidad_envases());
        return dto;
    }

}
