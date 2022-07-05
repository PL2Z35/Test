package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Highway;

/**
 * Repositorio de la entidad Highway.
 * Conector a la base de datos.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2022
 */
@Repository
public interface HighwayRepository extends JpaRepository<Highway, Integer> {

}