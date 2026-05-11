package com.cerveza.cerveza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import com.cerveza.cerveza.service.ProduccionService;
import com.cerveza.cerveza.dto.ProduccionDTO;
import com.cerveza.cerveza.model.Produccion;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/produccion")
@CrossOrigin(origins = "*")
public class ProduccionController {

    @Autowired
    private ProduccionService produccionService;

    @GetMapping
    public List<ProduccionDTO> listar(){
        return produccionService.obtenerTodos();
    }

    @PostMapping
    public ProduccionDTO guardar(@RequestBody Produccion produccion){
        return produccionService.guardarProduccion(produccion);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id){
        return produccionService.eliminarProduccion(id);
    }

    @GetMapping("/{id}")
    public ProduccionDTO buscarPorId(@PathVariable Integer id){
        return produccionService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ProduccionDTO actualizar(@PathVariable Integer id, @RequestBody ProduccionDTO datosNuevos){
        return produccionService.actualizaProduccion(id, datosNuevos);
    }

}

    


