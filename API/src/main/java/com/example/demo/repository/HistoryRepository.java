package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.History;

/**
 * Repositorio de la entidad History.
 * Conector a la base de datos.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {

}