package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.entity.History;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.HistoryRepository;
import com.example.demo.service.*;

/**
 * Implementacion de los servicios para el objeto Historia.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2022
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepository repository;

    /**
     * Metodo que lista todas las historias creadas.
     * 
     * @return List : Lista de objetos tipo historia.
     */
    public List<History> allList() {
        return repository.findAll();
    }

        /**
     * Metodo que genera una lista de las historias de una via.
     * 
     * 1. Obtiene todas las historias.
     * 2. Filtra las historias por el id de la via.
     * 
     * @return list : Lista de objetos tipo historia.
     */
    public List<History> getListHighway(int id) {
        List<History> aux = new ArrayList<>();
        List<History> allList = allList();
        for (int i = 0; i < allList.size(); i++) {
            if (id == allList.get(i).getHighwayId()) {
                aux.add(allList.get(i));
            }
        }
        return aux;
    }

    /*
     * Metodo que genera una lista de las historias de un agente de transito.
     * 
     * 1. Obtiene todas las historias.
     * 2. Filtra las historias por el id del agente de transito.
     * 
     * @return list : Lista de objetos tipo historia.
     */
    public List<History> getListTrafficPolice(long id) {
        List<History> aux = new ArrayList<>();
        List<History> allList = allList();
        for (int i = 0; i < allList.size(); i++) {
            if (id == allList.get(i).getTransitAgentId()) {
                aux.add(allList.get(i));
            }
        }
        return aux;
    }

    /**
     * Metodo que guarda una nueva historia.
     * 
     * Crea una historia cada vez que se agrega un agente de transito.
     * Crea una historia cdad vez que se modifica la via del agente de transito.
     * 
     * @return History : Objeto que se creo.
     */
    public History saveHistory(int highwayId, long trafficPoliceId) {
        History history = new History();
        history.setHighwayId(highwayId);
        history.setTransitAgentId(trafficPoliceId);
        history.setDate(date());
        return repository.save(history);
    }

    /*
     * Metodo que obtiene la fecha actual.
     * 
     * Este metodo es llamado cada vez que se crea una nueva historia.
     * 
     * @return String : Fecha actual.
     */
    public String date() {
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy/MMMM/dd HH:mm:ss");
        return dtf3.format(LocalDateTime.now());
    }
}