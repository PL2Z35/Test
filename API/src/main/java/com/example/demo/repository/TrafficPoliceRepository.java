package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.TrafficPolice;

/**
 * Repositorio de la entidad TrafficPolice.
 * Conector a la base de datos.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2022
 */
@Repository
public interface TrafficPoliceRepository extends JpaRepository<TrafficPolice, Long> {
    
}