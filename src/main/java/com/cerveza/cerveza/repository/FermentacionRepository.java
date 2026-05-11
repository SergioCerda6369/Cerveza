package com.cerveza.cerveza.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cerveza.cerveza.model.Fermentacion;

@Repository
public interface FermentacionRepository extends JpaRepository<Fermentacion, Integer> {

    Optional<Fermentacion> findByCodigoTanque(String codigoTanque);

}
