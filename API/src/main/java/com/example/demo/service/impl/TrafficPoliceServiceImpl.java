package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.entity.TrafficPolice;
import com.example.demo.exception.MyException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.example.demo.repository.TrafficPoliceRepository;
import com.example.demo.service.*;

/**
 * Implementacion de los servicios para el objeto agente de transito.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2022
 */
@Service
public class TrafficPoliceServiceImpl implements TrafficPoliceService {

    @Autowired
    private TrafficPoliceRepository trafficPoliceRepository;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private Environment env;

    /*
     * Metodo que obtiene una lista de todos los agentes de transito.
     * 
     * @return List : Lista de objetos del agente de transito.
     */
    @Override
    public List<TrafficPolice> allList() {
        return trafficPoliceRepository.findAll();
    }

    /*
     * Metodo que guarda un nuevo agente de transito.
     * 
     * Guarda los datos del nuevo objeto en la base de datos.
     * Genera una nueva historia.
     * 
     * @params TrafficPolice: Objeto agente de transito.
     * 
     * @return TrafficPolice: Si el agente de transito no existe en la base de
     * datos.
     * 
     * @return null: Si el agente de transito ya existe en la base de datos.\
     * 
     * @return null: Si la via que se desea modificar ya fue asignada 3 veces o si
     * la via tiene un nivel de congestion mayor a 30.
     * 
     * @return null: si la via que se la asignar al agente de transito ya a sido
     * registrada 3 veces o si la via tiene un nivel de congestion mayor a 30.
     */
    @Override
    public TrafficPolice saveTransitAgent(TrafficPolice trafficPolice) {
        if (!trafficPoliceRepository.existsById(trafficPolice.getId())
                && trafficPolice.getHighway().getCongestionLevel() <= getMaxCongestionLevel()
                && getContAssignmentsHighway(trafficPolice.getHighway().getId()) < getMaxAsigmentsHighway()) {
            historyService.saveHistory(trafficPolice.getHighway().getId(), trafficPolice.getId());
            return trafficPoliceRepository.save(trafficPolice);
        } else {
            return null;
        }
    }

    /*
     * Metodo que obtiene un agente de transito por su identificador.
     * 
     * @params long : Identificador del agente de transito.
     * 
     * @return TrafficPolice : Si existe un agente de transito con el identificador.
     * 
     * @Throws Exception : Si no existe un agente de transito con el identificador.
     */
    @Override
    public TrafficPolice getTransitAgentId(Long id) throws MyException {
        return trafficPoliceRepository.getReferenceById(id);
    }

    /*
     * Metodo que actualiza un agente de transito.
     * 
     * Actualiza cada parametro del agente de transito.
     * Exceptuando el identificador.
     * Crea una nueva historia.
     * 
     * @params TrafficPolice : Objeto tipo agente de transito.
     * 
     * @return TrafficPolice : Si existe el agente de transito.
     * 
     * @return null: Si la via que se desea modificar ya fue asignada 3 veces o si
     * la via tiene un nivel de congestion mayor a 30.
     * 
     * @return null: si no existe el agente de transito.
     */
    @Override
    public TrafficPolice updateTransitAgent(TrafficPolice trafficPolice) {
        if (trafficPoliceRepository.existsById(trafficPolice.getId())
                && trafficPolice.getHighway().getCongestionLevel() <= getMaxCongestionLevel()
                && getContAssignmentsHighway(trafficPolice.getHighway().getId()) < getMaxAsigmentsHighway()) {
            historyService.saveHistory(trafficPolice.getHighway().getId(), trafficPolice.getId());
            return trafficPoliceRepository.save(trafficPolice);
        } else {
            return null;
        }
    }

    /*
     * Metodo que elimina un agente de transito.
     * 
     * Busca el agente de transito por su identificador y lo elimina.
     * 
     * @params long : Identificador del agente de transito.
     * 
     * @throws Exception : Si no existe un agente de transito con el identificador.
     */
    @Override
    public void deleteTransitAgent(Long id) throws MyException {
        try {
            trafficPoliceRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyException("No existe un agente de transito con el identificador " + id);
        }
    }

    /*
     * Metodo que obtiene el mayor valor de congestion para la asignacion de una
     * via.
     * 
     * @return int: maximo valor de congestion.
     */
    private int getMaxCongestionLevel() {
        return env.getProperty("max.level.congestionlevel", Integer.class);
    }

    /*
     * Metodo que obtiene el numero de asignaciones de una via.
     * 
     * @return int: maximo valor de asignaciones.
     */
    private int getMaxAsigmentsHighway() {
        return env.getProperty("max.asignments.highway", Integer.class);
    }

    /*
     * Metodo que obtiene el numero de asignaciones de una via.
     * 
     * @params long : Identificador de la via.
     * 
     * @return int : Numero de asignaciones de la via.
     */
    private int getContAssignmentsHighway(int id) {
        return (int) allList().stream().filter(trafficPolice -> (trafficPolice.getHighway().getId() == id)).count();
    }
}
