package com.cerveza.cerveza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cerveza.cerveza.model.Calidad;


@Repository
public interface CalidadRepository extends JpaRepository<Calidad, Integer> {

}
