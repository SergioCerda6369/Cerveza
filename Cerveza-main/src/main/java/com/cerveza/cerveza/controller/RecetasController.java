package com.cerveza.cerveza.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cerveza.cerveza.model.Recetas;
import com.cerveza.cerveza.dto.RecetasDTO;
import com.cerveza.cerveza.service.RecetasService;

@RestController
@RequestMapping("/api/recetas")
@CrossOrigin(origins = "*")
public class RecetasController {

    @Autowired
    private RecetasService recetasService;

    @GetMapping
    public List<RecetasDTO> listar(){
        return recetasService.obtenerTodos();
    }

    @PostMapping
    public RecetasDTO guardar(@RequestBody Recetas receta){
        return recetasService.guardar(receta);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id){
        return recetasService.eliminar(id);
    }

    @GetMapping("/{id}")
    public RecetasDTO buscarPorId(@PathVariable Integer id){
        return recetasService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public RecetasDTO actualizar(@PathVariable Integer id, @RequestBody Recetas nuevosDatos){
        return recetasService.actualizar(id, nuevosDatos);
    }







}
