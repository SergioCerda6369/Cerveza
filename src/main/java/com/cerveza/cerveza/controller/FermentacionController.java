package com.cerveza.cerveza.controller;
import java.util.List;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/fermentacion")
@CrossOrigin(origins = "*")
public class FermentacionController {

    @Autowired
    private FermentacionService fermentacionService;

    @GetMapping
    public ResponseEntity<List<FermentacionDTO>> obtenerTodos() {
        List<FermentacionDTO> lista = fermentacionService.obtenerTodos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FermentacionDTO> buscarPorId(@PathVariable Integer id) {
        FermentacionDTO dto = fermentacionService.buscarPorId(id);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/tanque/{codigo}")
    public ResponseEntity<FermentacionDTO> buscarPorCodigoTanque(@PathVariable String codigo) {
        FermentacionDTO dto = fermentacionService.buscarPorCodigoTanque(codigo);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<FermentacionDTO> guardar(@Valid @RequestBody Fermentacion fermentacion) {
        FermentacionDTO nuevo = fermentacionService.guardarFermentacion(fermentacion);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

}
