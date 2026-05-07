package com.cerveza.cerveza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")

public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<PedidoDTO> obtenerTodos(){
        return pedidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public PedidoDTO buscarPorId(@PathVariable Integer id) {
        return pedidoService.buscarPorId(id);
    }

    @PostMapping
    public PedidoDTO guardar(@RequestBody Pedido pedido) {
        return pedidoService.guardarPedido(pedido);
    }

    @PatchMapping("/{id}")
    public PedidoDTO actualizar(@PathVariable Integer id, @RequestBody Pedido datos) {
        return pedidoService.actualizarPedido(id, datos);
    }
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        return pedidoService.eliminar(id);
    }

    @GetMapping("/estado/{estado}")
    public List<PedidoDTO> buscarPorEstado(@PathVariable String estado) {
        return pedidoService.buscarPorEstado(estado);
    }

    @GetMapping("/cliente/{cliente}")
    public List<PedidoDTO> buscarPorCliente(@PathVariable String cliente) {
        return pedidoService.buscarPorCliente(cliente);
    }

    @GetMapping("/vip/{monto}")
    public List<PedidoDTO> buscarVip(@PathVariable Double monto) {
        return pedidoService.buscarVip(monto);
    }

    @GetMapping("/producto/{idProducto}")
<<<<<<< HEAD
    public List<PedidoDTO> buscarPorProducto(@PathVariable Integer idProducto) {
=======
    public List<PedidoDTO> buscarPorProducto(@PathVariable Long idProducto) {
>>>>>>> 50a7fcb0dbe5354675d2e86bbf9da1a6b1ce766c
        return pedidoService.buscarPorProducto(idProducto);
    }
}
