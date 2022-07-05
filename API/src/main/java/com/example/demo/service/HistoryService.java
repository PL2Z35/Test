package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.History;

/**
 * Servicios para el objeto History.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
public interface HistoryService {

    /**
     * Metodo que lista todas las historias creadas.
     * 
     * @return List : Lista de objetos tipo historia.
     */
    public List<History> allList();

    /**
     * Metodo que genera una lista de las historias de una via.
     * 
     * 1. Obtiene todas las historias.
     * 2. Filtra las historias por el id de la via.
     * 
     * @return list : Lista de objetos tipo historia.
     */
    public List<History> getListHighway(int id);

    /*
     * Metodo que genera una lista de las historias de un agente de transito.
     * 
     * 1. Obtiene todas las historias.
     * 2. Filtra las historias por el id del agente de transito.
     * 
     * @return list : Lista de objetos tipo historia.
     */
    public List<History> getListTrafficPolice(long id);

    /**
     * Metodo que guarda una nueva historia.
     * 
     * Crea una historia cada vez que se agrega un agente de transito.
     * Crea una historia cdad vez que se modifica la via del agente de transito.
     * 
     * @param int id de la via y long: identificador del policia de transito.
     * @return History : Objeto que se creo.
     */
    public History saveHistory(int highwayId, long trafficPoliceId);
}
