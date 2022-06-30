package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.HighwayDTO;

/**
 * Servicios para el objeto Highway.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
public interface HighwayService {
    /**
     * Obtiene una lista de todas las calles.
     * 
     * @return List<HighwayDTO> : Lista de objetios de transferencia de las calles.
     */
    public List<HighwayDTO> allList();

    /**
     * Envia el objeto de transferencia de datos de Highway.
     * 
     * @param type Objeto de transferencia de via.
     * @return objeto de tranferencia de la via.
     */
    public HighwayDTO saveHighway(HighwayDTO highway);

    /**
     * Envia el objeto de transferencia de via.
     * 
     * @param int Identificador de la via.
     * @return Objeto de transferencia de datos la via.
     */
    public HighwayDTO getHighwayId(int id);

    /**
     * Actualiza el objeto de transferencia de via.
     * 
     * @param type objeto de la via.
     * @return Objeto de transferencia de la via.
     */
    public HighwayDTO updateHighway(HighwayDTO highway);

    /**
     * Elimina el objeto de transferencia de via.
     * 
     * @param int identificador de la via.
     * @return True si se elimino, false si no..
     */
    public boolean deleteHighway(int id);
}
