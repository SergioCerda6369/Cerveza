package com.cerveza.cerveza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cerveza.cerveza.dto.StockFinalDTO;
import com.cerveza.cerveza.model.StockFinal;
import com.cerveza.cerveza.service.StockFinalService;

@RestController
@RequestMapping("/api/stock")
@CrossOrigin(origins = "*")
public class StockFinalController {

    @Autowired
    private StockFinalService stockService;

    @GetMapping
    public List<StockFinalDTO> listar() {
        return stockService.obtenerTodos();
    }

    @PostMapping
    public StockFinalDTO crear(@RequestBody StockFinal stock) {
        return stockService.guardar(stock);
    }

    @PatchMapping("/{id}")
    public String borrar(@PathVariable Integer id) {
        return stockService.eliminar(id);
    }

}
