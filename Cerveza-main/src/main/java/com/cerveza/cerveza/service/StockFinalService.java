package com.cerveza.cerveza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.StockFinalDTO;
import com.cerveza.cerveza.model.StockFinal;
import com.cerveza.cerveza.repository.StockFinalRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StockFinalService {
    
    @Autowired
    private StockFinalRepository stockRepository;

    private StockFinalDTO convertirADTO(StockFinal stock) {
        StockFinalDTO dto = new StockFinalDTO();
        dto.setIdStockFinal(stock.getIdStockFinal());
        dto.setNombreCerveza(stock.getNombreCerveza());
        dto.setFormatoDistribucion(stock.getFormatoDistribucion());
        dto.setCantidadDisponible(stock.getCantidadDisponible());
        dto.setPrecioVenta(stock.getPrecioVenta());
        return dto;
    }

    public List<StockFinalDTO> obtenerTodos() {
        return stockRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    public StockFinalDTO buscarPorId(Integer id) {
        StockFinal stock = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        return convertirADTO(stock);
    }

    public StockFinalDTO guardar(StockFinal stock) {
        return convertirADTO(stockRepository.save(stock));
    }

    public StockFinalDTO actualizar(Integer id, StockFinal nuevosDatos) {
        StockFinal existente = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el registro para actualizar"));

        if (nuevosDatos.getNombreCerveza() != null) {
            existente.setNombreCerveza(nuevosDatos.getNombreCerveza());
        }
        if (nuevosDatos.getFormatoDistribucion() != null) {
            existente.setFormatoDistribucion(nuevosDatos.getFormatoDistribucion());
        }
        if (nuevosDatos.getCantidadDisponible() != null) {
            existente.setCantidadDisponible(nuevosDatos.getCantidadDisponible());
        }
        if (nuevosDatos.getPrecioVenta() != null) {
            existente.setPrecioVenta(nuevosDatos.getPrecioVenta());
        }

        return convertirADTO(stockRepository.save(existente));
    }

    public String eliminar(Integer id) {
        try {
            stockRepository.deleteById(id);
            return "Registro eliminado correctamente";
        } catch (Exception e) {
            return "Error al eliminar: " + e.getMessage();
        }
    }

    public List<StockFinalDTO> buscarPorNombre(String nombre) {
        return stockRepository.findByNombreCervezaContainingIgnoreCase(nombre).stream()
                .map(this::convertirADTO)
                .toList();
    }

}