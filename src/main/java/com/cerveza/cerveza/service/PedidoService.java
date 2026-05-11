package com.cerveza.cerveza.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cerveza.cerveza.dto.PedidoDTO;
import com.cerveza.cerveza.model.Pedido;
import com.cerveza.cerveza.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoDTO> obtenerTodos() {
        return pedidoRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public PedidoDTO buscarPorId(Integer id) {
        return pedidoRepository.findById(id)
                .map(this::convertirADTO)
                .orElse(null);
    }

    public PedidoDTO guardarPedido(Pedido pedido) {
        return convertirADTO(pedidoRepository.save(pedido));
    }

    public PedidoDTO actualizarPedido(Integer id, Pedido datosNuevos) {
        return pedidoRepository.findById(id).map(existente -> {
            if (datosNuevos.getCliente() != null) existente.setCliente(datosNuevos.getCliente());
            if (datosNuevos.getEstadoPedido() != null) existente.setEstadoPedido(datosNuevos.getEstadoPedido());
            if (datosNuevos.getCantidadSolicitada() != null) existente.setCantidadSolicitada(datosNuevos.getCantidadSolicitada());
            if (datosNuevos.getProducto() != null) existente.setProducto(datosNuevos.getProducto());
            if (datosNuevos.getTotalVenta() != null) existente.setTotalVenta(datosNuevos.getTotalVenta());
            return convertirADTO(pedidoRepository.save(existente));
        }).orElse(null);
    }

    public boolean eliminar(Integer id) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedidoRepository.delete(pedido);
            return true;
        }).orElse(false);
    }

    public List<PedidoDTO> buscarPorEstado(String estado) {
        return pedidoRepository.findByEstadoPedido(estado).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public List<PedidoDTO> buscarPorCliente(String cliente) {
        return pedidoRepository.findByClienteContainingIgnoreCase(cliente).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public List<PedidoDTO> buscarVip(Double monto) {
        return pedidoRepository.buscarPedidosVip(monto).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public List<PedidoDTO> buscarPorProducto(Integer idStockFinal) {
        return pedidoRepository.findByProducto_IdStockFinal(idStockFinal).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    private PedidoDTO convertirADTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setIdPedido(pedido.getIdPedido());
        dto.setCliente(pedido.getCliente());
        if (pedido.getProducto() != null) {
            dto.setIdProducto(pedido.getProducto().getIdStockFinal());
        }
        dto.setCantidadSolicitada(pedido.getCantidadSolicitada());
        dto.setTotalVenta(pedido.getTotalVenta());
        dto.setEstadoPedido(pedido.getEstadoPedido());
        return dto;
    }
    
}