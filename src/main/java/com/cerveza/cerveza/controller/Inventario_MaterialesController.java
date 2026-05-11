package com.cerveza.cerveza.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cerveza.cerveza.dto.Inventario_MaterialesDTO;
import com.cerveza.cerveza.model.Inventario_Materiales;
import com.cerveza.cerveza.service.Inventario_MaterialesService;

@RestController
@RequestMapping("/api/inventario_materiales")
@CrossOrigin(origins = "*")
public class Inventario_MaterialesController {

    @Autowired
    private Inventario_MaterialesService inventario_Materiales;

    @GetMapping
    public List<Inventario_MaterialesDTO> listar(){
        return inventario_Materiales.obtenerTodos();
    }

    @PostMapping
    public Inventario_MaterialesDTO guardar(@RequestBody Inventario_Materiales inv_new){
        return inventario_Materiales.guardarInventario(inv_new);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id){
        return inventario_Materiales.eliminarInventario(id);
    }

    @PatchMapping("/{id}")
    public Inventario_MaterialesDTO actualizar(@PathVariable Integer id, @RequestBody Inventario_Materiales datos){
        return inventario_Materiales.actualizarInventario(id, datos);
    }

    @GetMapping("/{id}")
    public Inventario_MaterialesDTO buscarId(@PathVariable Integer id){
        return inventario_Materiales.buscarPorId(id);
    }

    


}
