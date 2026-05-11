package com.cerveza.cerveza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cerveza.cerveza.model.Produccion;


@Repository
public interface ProduccionRepository extends JpaRepository<Produccion, Integer>{







}
