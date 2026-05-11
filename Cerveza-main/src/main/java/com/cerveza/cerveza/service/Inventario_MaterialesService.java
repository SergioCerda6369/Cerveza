package com.cerveza.cerveza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.Inventario_MaterialesDTO;
import com.cerveza.cerveza.model.Inventario_Materiales;
import com.cerveza.cerveza.repository.Inventario_MaterialesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Inventario_MaterialesService {

    @Autowired
    private Inventario_MaterialesRepository Inventario_MaterialesRepository;

        private Inventario_MaterialesDTO convertirADTO(Inventario_Materiales inventario){
        Inventario_MaterialesDTO dto = new Inventario_MaterialesDTO();
        dto.setId_material(inventario.getId_material());
        dto.setNombre_material(inventario.getNombre_material());
        dto.setCantidad_stock(inventario.getCantidad_stock());
        dto.setNombre_proveedor(inventario.getNombre_proveedor());
        return dto;
        }

        public List<Inventario_MaterialesDTO> obtenerTodos(){
            return Inventario_MaterialesRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
        }

        public Inventario_MaterialesDTO buscarPorId(Integer id){
            Inventario_Materiales inventario = Inventario_MaterialesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe material con id" + id +"en los registros"));
            return convertirADTO(inventario);
        }

        public Inventario_MaterialesDTO guardarInventario(Inventario_Materiales inventario){
            Inventario_Materiales guardado = Inventario_MaterialesRepository.save(inventario);
            return convertirADTO(guardado);
        }

        public Inventario_MaterialesDTO actualizarInventario(Integer id, Inventario_Materiales datosNuevos){
            Inventario_Materiales inventarioExistente = Inventario_MaterialesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el material con id " + id));

            if (datosNuevos.getNombre_material() != null){
                inventarioExistente.setNombre_material(datosNuevos.getNombre_material());
            }
            if (datosNuevos.getCantidad_stock() != null){
                inventarioExistente.setCantidad_stock(datosNuevos.getCantidad_stock());
            }
            if (datosNuevos.getNombre_proveedor() != null){
                inventarioExistente.setNombre_proveedor(datosNuevos.getNombre_proveedor());
            }

            return convertirADTO(Inventario_MaterialesRepository.save(inventarioExistente));
        }

        public String eliminarInventario(Integer id){
            Inventario_Materiales inventarioExistente = Inventario_MaterialesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro material asociado a la id" + id));
            Inventario_MaterialesRepository.delete(inventarioExistente);
            return "Material eliminado correctamente";
        }




        
}






    



