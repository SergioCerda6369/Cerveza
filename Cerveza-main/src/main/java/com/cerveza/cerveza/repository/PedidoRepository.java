package com.cerveza.cerveza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cerveza.cerveza.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByEstadoPedido(String estadoPedido);

    List<Pedido> findByClienteContainingIgnoreCase(String cliente);

    @Query("SELECT p FROM Pedido p WHERE p.totalVenta >= :montoMinimo")
    List<Pedido> buscarPedidosVip(@Param("montoMinimo") Double montoMinimo);

    List<Pedido> findByProducto_IdStockFinal(Integer idStockFinal);
}