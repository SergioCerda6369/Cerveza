package com.cerveza.cerveza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.PedidoDTO;
import com.cerveza.cerveza.model.Pedido;
import com.cerveza.cerveza.repository.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

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

    public List<PedidoDTO> obtenerTodos() {
        return pedidoRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    public PedidoDTO buscarPorId(Integer id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El pedido " + id + " no existe en los registros"));
        return convertirADTO(pedido);
    }

    public PedidoDTO guardarPedido(Pedido pedido) {
        Pedido guardado = pedidoRepository.save(pedido);
        return convertirADTO(guardado);
    }

    public PedidoDTO actualizarPedido(Integer id, Pedido datosNuevos) {
        Pedido pedidoExistente = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El pedido no existe"));

        if (datosNuevos.getCliente() != null) {
            pedidoExistente.setCliente(datosNuevos.getCliente());
        }
        if (datosNuevos.getEstadoPedido() != null) {
            pedidoExistente.setEstadoPedido(datosNuevos.getEstadoPedido());
        }
        if (datosNuevos.getCantidadSolicitada() != null) {
            pedidoExistente.setCantidadSolicitada(datosNuevos.getCantidadSolicitada());
        }
        if (datosNuevos.getProducto() != null) {
            pedidoExistente.setProducto(datosNuevos.getProducto());
        }
        if (datosNuevos.getTotalVenta() != null) {
            pedidoExistente.setTotalVenta(datosNuevos.getTotalVenta());
        }

        return convertirADTO(pedidoRepository.save(pedidoExistente));
    }

    public String eliminar(Integer id) {
        try {
            Pedido pedido = pedidoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Imposible eliminar. El pedido con ID " + id + " no existe"));
            pedidoRepository.delete(pedido);
            return "El pedido de '" + pedido.getCliente() + "' ha sido retirado exitosamente";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public List<PedidoDTO> buscarPorEstado(String estado) {
        return pedidoRepository.findByEstadoPedido(estado).stream()
                .map(this::convertirADTO)
                .toList();
    }

    public List<PedidoDTO> buscarPorCliente(String cliente) {
        return pedidoRepository.findByClienteContainingIgnoreCase(cliente).stream()
                .map(this::convertirADTO)
                .toList();
    }

    public List<PedidoDTO> buscarVip(Double monto) {
        return pedidoRepository.buscarPedidosVip(monto).stream()
                .map(this::convertirADTO)
                .toList();
    }

    public List<PedidoDTO> buscarPorProducto(Integer idStockFinal) {
        return pedidoRepository.findByProducto_IdStockFinal(idStockFinal).stream()
                .map(this::convertirADTO)
                .toList();
    }
}