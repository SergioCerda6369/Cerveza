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

import com.cerveza.cerveza.dto.EnvasadoDTO;
import com.cerveza.cerveza.model.Envasado;
import com.cerveza.cerveza.service.EnvasadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/envasado")
@CrossOrigin(origins = "*")
public class EnvasadoController {

    @Autowired
    private EnvasadoService envasadoService;

    @GetMapping
    public ResponseEntity<List<EnvasadoDTO>> listarTodos() {
        List<EnvasadoDTO> lista = envasadoService.obtenerTodos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvasadoDTO> obtenerPorId(@PathVariable Integer id) {
        EnvasadoDTO dto = envasadoService.buscarPorId(id);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<EnvasadoDTO> crear(@Valid @RequestBody Envasado envasado) {
        EnvasadoDTO nuevo = envasadoService.guardar(envasado);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

}
