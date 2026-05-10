package com.cerveza.cerveza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cerveza.cerveza.model.StockFinal;

@Repository
public interface StockFinalRepository extends JpaRepository<StockFinal, Integer> {

    List<StockFinal> findByNombreCervezaContainingIgnoreCase(String nombreCerveza);

    List<StockFinal> findByCantidadDisponibleLessThan(Integer cantidadDisponible);

    @Query("SELECT s FROM StockFinal s WHERE s.cantidadDisponible <= :minimo")
    List<StockFinal> buscarStockCritico(@Param("minimo") Integer minimo);

}
