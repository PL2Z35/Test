package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.HistoryDTO;
import com.example.demo.entity.History;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.HistoryRepository;
import com.example.demo.service.*;

/**
 * Implementacion de los servicios para el objeto Historia.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
@Service
public class HistoryServiceImp implements HistoryService {

    /**
     * Repositorio de las historias.
     */
    @Autowired
    private HistoryRepository repository;

    /**
     * Obtiene una lista de todas las historias.
     * 
     * @return List<History> : Lista de objetos tipo historia.
     */
    public List<History> allList() {
        return repository.findAll();
    }

    /**
     * Obtiene una lista de las historias de una via.
     * 
     * @return list : Lista de objetos tipo historia.
     */
    public List<HistoryDTO> getListHighway(int id) {
        List<HistoryDTO> aux = new ArrayList<>();
        List<History> allList = allList();
        for (int i = 0; i < allList.size(); i++) {
            if (id == allList.get(i).getHighwayId()) {
                aux.add(convertHistorytoDTO(allList.get(i)));
            }
        }
        return aux;
    }

    /**
     * Guarda una nueva historia.
     * 
     * @return History : Objeto que se creo.
     */
    public List<HistoryDTO> getListTrafficPolice(long id) {
        List<HistoryDTO> aux = new ArrayList<>();
        List<History> allList = allList();
        for (int i = 0; i < allList.size(); i++) {
            if (id == allList.get(i).getTransitAgentId()) {
                aux.add(convertHistorytoDTO(allList.get(i)));
            }
        }
        return aux;
    }

    /**
     * Guarda una nueva historia.
     * 
     * @return History : Objeto que se creo.
     */
    public History saveHistory(History history) {
        return repository.save(history);
    }

    /**
     * Convierte un objeto tipo historia a un objeto tipo historiaDTO.
     * 
     * @return HistoryDTO : Objeto tipo historiaDTO.
     */
    HistoryDTO convertHistorytoDTO(History history) {
        HistoryDTO aux = new HistoryDTO();
        aux.setId(history.getId());
        aux.setDate(history.getDate());
        aux.setHighwayId(history.getHighwayId());
        aux.setTransitAgentId(history.getTransitAgentId());
        return aux;
    }
}