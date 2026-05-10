package com.cerveza.cerveza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cerveza.cerveza.model.Recetas;

@Repository
public interface RecetasRepository extends JpaRepository<Recetas, Integer>{

}
