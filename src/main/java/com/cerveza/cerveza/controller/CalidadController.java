package com.cerveza.cerveza.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import com.cerveza.cerveza.dto.CalidadDTO;
import com.cerveza.cerveza.model.Calidad;
import com.cerveza.cerveza.service.CalidadService;

import java.util.List;


@RestController
@RequestMapping("/api/calidad")
@CrossOrigin(origins = "*")
public class CalidadController {

    @Autowired
    private CalidadService calidadService;

    @GetMapping
    public List<CalidadDTO> listar() {
        return calidadService.obtenerTodos();
    }

    @PostMapping
    public CalidadDTO guardar(@RequestBody Calidad calidad) {
        return calidadService.guardar(calidad);
    }
    
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        return calidadService.eliminar(id);
    }

    @PutMapping("/{id}")
    public CalidadDTO actualizar(@PathVariable Integer id, @RequestBody Calidad nuevosDatos) {
        return calidadService.actualizar(id, nuevosDatos);
    }
}   
