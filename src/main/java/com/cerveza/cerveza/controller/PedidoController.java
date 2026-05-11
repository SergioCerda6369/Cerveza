package com.cerveza.cerveza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cerveza.cerveza.dto.PedidoDTO;
import com.cerveza.cerveza.model.Pedido;
import com.cerveza.cerveza.service.PedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = "*")

public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> obtenerTodos() {
        return new ResponseEntity<>(pedidoService.obtenerTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Integer id) {
        PedidoDTO dto = pedidoService.buscarPorId(id);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> guardar(@Valid @RequestBody Pedido pedido) {
        PedidoDTO nuevo = pedidoService.guardarPedido(pedido);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PedidoDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody Pedido datos) {
        PedidoDTO actualizado = pedidoService.actualizarPedido(id, datos);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (pedidoService.eliminar(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<PedidoDTO>> buscarPorEstado(@PathVariable String estado) {
        return new ResponseEntity<>(pedidoService.buscarPorEstado(estado), HttpStatus.OK);
    }

    @GetMapping("/cliente/{cliente}")
    public ResponseEntity<List<PedidoDTO>> buscarPorCliente(@PathVariable String cliente) {
        return new ResponseEntity<>(pedidoService.buscarPorCliente(cliente), HttpStatus.OK);
    }

    @GetMapping("/vip/{monto}")
    public ResponseEntity<List<PedidoDTO>> buscarVip(@PathVariable Double monto) {
        return new ResponseEntity<>(pedidoService.buscarVip(monto), HttpStatus.OK);
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<List<PedidoDTO>> buscarPorProducto(@PathVariable Integer idProducto) {
        return new ResponseEntity<>(pedidoService.buscarPorProducto(idProducto), HttpStatus.OK);
    }

    
}
