package com.cerveza.cerveza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cerveza.cerveza.repository.RecetasRepository;
import jakarta.transaction.Transactional;
import com.cerveza.cerveza.dto.RecetasDTO;
import com.cerveza.cerveza.model.Recetas;
import java.util.List;

@Service
@Transactional
public class RecetasService {

    @Autowired
    private RecetasRepository recetasRepository;

    private RecetasDTO convertirDTO (Recetas receta){
        RecetasDTO dto = new RecetasDTO();
        dto.setId_receta(receta.getId_receta());
        dto.setNombre_receta(receta.getNombre_receta());
        dto.setTipo_cerveza(receta.getTipo_cerveza());
        dto.setTiempo_coccion(receta.getTiempo_coccion());
        return dto;
    }

    public List<RecetasDTO> obtenerTodos() {
        return recetasRepository.findAll().stream()
                .map(this::convertirDTO)
                .toList();
    }

    public RecetasDTO guardar(Recetas receta){
        return convertirDTO(recetasRepository.save(receta));
    }

    public RecetasDTO buscarPorId(Integer id){
        Recetas receta = recetasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));
        return convertirDTO(receta);
    }

    public RecetasDTO actualizar(Integer id, Recetas nuevosDatos){
        Recetas existente = recetasRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("No existe la receta para actualizar"));
        if (nuevosDatos.getNombre_receta() != null){
        existente.setNombre_receta(nuevosDatos.getNombre_receta());
        }
        if (nuevosDatos.getTipo_cerveza() != null){
        existente.setTipo_cerveza(nuevosDatos.getTipo_cerveza());
        }
        if (nuevosDatos.getTiempo_coccion() != null){
        existente.setTiempo_coccion(nuevosDatos.getTiempo_coccion());
        }
        return convertirDTO(recetasRepository.save(existente));
    }

    public String eliminar(Integer id){
        try {
            recetasRepository.deleteById(id);
            return "Receta eliminada correctamente";

        }catch (Exception e){
            return "Error al eliminar la receta: " + e.getMessage(); 
        }
    }
    
}

