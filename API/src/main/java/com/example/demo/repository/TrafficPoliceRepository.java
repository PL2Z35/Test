package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Highway;
import com.example.demo.entity.TrafficPolice;

/**
 * Repositorio de la entidad TrafficPolice.
 * Conector a la base de datos.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
@Repository
public interface TrafficPoliceRepository extends JpaRepository<TrafficPolice, Long> {
    public abstract List<Highway> findByHighway(Highway highway);
}