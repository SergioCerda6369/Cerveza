package com.cerveza.cerveza.controller;

import java.util.List;

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

import com.cerveza.cerveza.dto.DistribucionDTO;
import com.cerveza.cerveza.model.Distribucion;
import com.cerveza.cerveza.service.DistribucionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/distribucion")
@CrossOrigin(origins = "*")
public class DistribucionController {

    @Autowired
    private DistribucionService distribucionService;

    @GetMapping
    public ResponseEntity<List<DistribucionDTO>> listarTodas() {
        List<DistribucionDTO> lista = distribucionService.obtenerTodas();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistribucionDTO> obtenerPorId(@PathVariable Integer id) {
        DistribucionDTO dto = distribucionService.buscarPorId(id);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<DistribucionDTO> crear(@Valid @RequestBody Distribucion distribucion) {
        DistribucionDTO nueva = distribucionService.guardar(distribucion);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

}
