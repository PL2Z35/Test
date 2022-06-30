package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.HistoryDTO;
import com.example.demo.entity.History;

/**
 * Servicios para el objeto History.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
public interface HistoryService {

    /**
     * Genera una lista de todas las historias.
     * 
     * @return List<History> : Lista de objetos tipo historia.
     */
    public List<History> allList();

    /**
     * Genera una lista de las historias de una via.
     * 
     * @return list : Lista de objetos tipo historia.
     */
    public List<HistoryDTO> getListHighway(int id);

    /*
     * Genera una lista de las historias de un agente de transito.
     * 
     * @return list : Lista de objetos tipo historia.
     */
    public List<HistoryDTO> getListTrafficPolice(long id);

    /**
     * Guarda una nueva historia.
     * 
     * @return History : Objeto que se creo.
     */
    public History saveHistory(History history);
}
