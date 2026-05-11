package com.cerveza.cerveza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cerveza.cerveza.model.Fermentacion;

@Repository
public interface FermentacionRepository extends JpaRepository<Fermentacion, Integer> {

    List<Fermentacion> findBycodigo_tanqueContainingIgnoreCase(String Codigo_tanque);

    

}
