package com.cerveza.cerveza.controller;
import java.util.List;
import jakarta.validation.Valid;
import com.cerveza.cerveza.dto.FermentacionDTO;
import com.cerveza.cerveza.model.Fermentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<FermentacionDTO>> obtenerTodos(){
        return ResponseEntity.ok(fermentacionService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FermentacionDTO> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(fermentacionService.buscarPorId(id)); // 200 OK
    }

    @GetMapping("/tanque/{codigo}")
    public ResponseEntity<FermentacionDTO> buscarPorCodigoTanque(@PathVariable String codigo){
        return ResponseEntity.ok(fermentacionService.buscarPorCodigoTanque(codigo));
    }
    @PostMapping
    public ResponseEntity<FermentacionDTO> guardar(@Valid @RequestBody Fermentacion fermentacion){
        FermentacionDTO guardado = fermentacionService.guardarFermentacion(fermentacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }




}
