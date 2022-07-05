package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Highway;
import com.example.demo.exception.MyException;

/**
 * Servicios para el objeto Highway.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
public interface HighwayService {
    /**
     * Metodo que obtiene una lista de todas las calles.
     * 
     * @return Lista de calles.
     */
    public List<Highway> allList();

    /**
     * Metodo que guarda una nueva via.
     * 
     * @param highway Objeto de tipo via.
     * @return Highway: si el objetio no existe en la base de datos.
     * @return null: si el objeto existe en la base de datos.
     */
    public Highway saveHighway(Highway highway);

    /**
     * Metodo que obtiene una via por su identificador.
     * 
     * @param int: id Identificador de la via.
     * @return Highway: Objeto existe en la base de datos.
     * @Throws Exception: Si no existe la via.
     */
    public Highway getHighwayId(int id) throws MyException;

    /**
     * Metodo que actualiza los datos de una via.
     * 
     * @param highway Objeto de tipo via.
     * @return Highway: si el objetio existe en la base de datos.
     * @return null: si el objeto no existe en la base de datos.
     */
    public Highway updateHighway(Highway highway);

    /**
     * Metodo que elimina una via.
     * 
     * Este metodo buca una via por su identificador y la elimina.
     * 
     * @param int Identificador de la via.
     * @throws Exception: Si no existe la via.
     */
    public void deleteHighway(int id) throws MyException;
}
