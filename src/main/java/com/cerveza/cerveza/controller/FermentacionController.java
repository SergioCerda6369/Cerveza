package com.cerveza.cerveza.controller;
import java.util.List;
import com.cerveza.cerveza.dto.FermentacionDTO;
import com.cerveza.cerveza.model.Fermentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cerveza.cerveza.service.FermentacionService;

@RestController
@RequestMapping("api/fermentaciones")
@CrossOrigin(origins = "*")
public class FermentacionController {

    @Autowired
    private FermentacionService fermentacionService;

    @GetMapping
    public List<FermentacionDTO> obtenerTodos(){
        return fermentacionService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public FermentacionDTO buscarPorId(@PathVariable Integer id){
        return fermentacionService.buscarPorId(id);
    }

    @GetMapping("/tanque/{codigo}")
    public FermentacionDTO buscarPorCodigoTanque(@PathVariable String codigo){
        return fermentacionService.buscarPorCodigoTanque(codigo);
    }

    @PostMapping
    public FermentacionDTO guardar(@RequestBody Fermentacion fermentacion){
        return fermentacionService.guardarFermentacion(fermentacion);
    }




}
