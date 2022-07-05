package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.entity.Highway;
import com.example.demo.exception.MyException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.HighwayRepository;
import com.example.demo.service.*;

/**
 * Implementacion de los servicios para el objeto via.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2022
 */
@Service
public class HighwayServiceImpl implements HighwayService {

    @Autowired
    private HighwayRepository repository;

    /**
     * Metodo que obtiene una lista de todas las calles.
     * 
     * @return Lista de calles.
     */
    @Override
    public List<Highway> allList() {
        return repository.findAll();
    }

    /**
     * Metodo que guarda una nueva via.
     * 
     * @param highway Objeto de tipo via.
     * @return Highway: si el objetio no existe en la base de datos.
     * @return null: si el objeto existe en la base de datos.
     */
    @Override
    public Highway saveHighway(Highway highway) {
        return repository.existsById(highway.getId()) ? null : repository.save(highway);
    }

    /**
     * Metodo que obtiene una via por su identificador.
     * 
     * @param int: id Identificador de la via.
     * @return Highway: Objeto existe en la base de datos.
     * @Throws Exception: Si no existe la via.
     */
    @Override
    public Highway getHighwayId(int id) throws MyException {
        return repository.getReferenceById(id);
    }

    /**
     * Metodo que actualiza los datos de una via.
     * 
     * @param highway Objeto de tipo via.
     * @return Highway: si el objetio existe en la base de datos.
     * @return null: si el objeto no existe en la base de datos.
     */
    @Override
    public Highway updateHighway(Highway highway) {
        return repository.existsById(highway.getId()) ? repository.save(highway) : null;
    }

    /**
     * Metodo que elimina una via.
     * 
     * Este metodo buca una via por su identificador y la elimina.
     * 
     * @param int Identificador de la via.
     * @throws Exception: Si no existe la via.
     */

    @Override
    public void deleteHighway(int id) throws MyException {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new MyException("No existe la via");
        }
    }
}