package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.TrafficPolice;
import com.example.demo.dto.TrafficPoliceDTO;
import com.example.demo.entity.Highway;
import com.example.demo.entity.History;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.TrafficPoliceRepository;
import com.example.demo.repository.HighwayRepository;
import com.example.demo.repository.HistoryRepository;
import com.example.demo.service.*;

/**
 * Implementacion de los servicios para el objeto agente de transito.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
@Service
public class TrafficPoliceServiceImp implements TrafficPoliceService {

    /**
     * Repositorio de los agentes de transito.
     */
    @Autowired
    private TrafficPoliceRepository trafficPoliceRepository;

    /**
     * Repositorio de las historias.
     */
    @Autowired
    private HistoryRepository historyRepository;

    /**
     * Repositorio de las vias.
     */
    @Autowired
    private HighwayRepository highwayRepository;

    /*
     * Obtiene una lista de todos los agentes de transito.
     * 
     * @return List<TrafficPolice> : Lista de objetos de tranferencia de agente de
     * transito.
     */
    @Override
    public List<TrafficPoliceDTO> allList() {
        List<TrafficPolice> allList = trafficPoliceRepository.findAll();
        List<TrafficPoliceDTO> aux = new ArrayList<>();
        for (int i = 0; i < allList.size(); i++) {
            aux.add(convertTrafficPolicetoDTO(allList.get(i)));
        }
        return aux;
    }

    /*
     * Guarda un nuevo agente de transito.
     * 
     * @params TrafficPoliceDTO : Objeto de transferencia de datos del agente de
     * transito.
     * 
     * @return TrafficPoliceDTO : Objeto que se creo.
     */
    @Override
    public TrafficPoliceDTO saveTransitAgent(TrafficPoliceDTO trafficPoliceDTO) {
        List<TrafficPolice> list = trafficPoliceRepository.findAll();
        int cont = 0;
        for (TrafficPolice trafficPolice : list) {
            if (trafficPolice.getHighway().getId() == trafficPoliceDTO.getHighway()) {
                cont++;
            }
        }
        if (highwayRepository.existsById(trafficPoliceDTO.getHighway()) && (cont < 3)
                && highwayRepository.getReferenceById(trafficPoliceDTO.getHighway()).getCongestionLevel() <= 30) {
            trafficPoliceRepository.save(convertDTOtoTrafficPolice(trafficPoliceDTO,
                    highwayRepository.getReferenceById(trafficPoliceDTO.getHighway())));
            History history = new History();
            history.setDate(date());
            history.setHighwayId(trafficPoliceDTO.getHighway());
            history.setTransitAgentId(trafficPoliceDTO.getId());
            historyRepository.save(history);
            return trafficPoliceDTO;
        } else {
            return null;
        }
    }

    /*
     * Obtiene un agente de transito por su identificador.
     * 
     * @params long : Identificador del agente de transito.
     * 
     * @return TrafficPoliceDTO : Objeto de transferencia de datos del agente de
     * transito.
     */
    @Override
    public TrafficPoliceDTO getTransitAgentId(Long id) {
        return convertTrafficPolicetoDTO(trafficPoliceRepository.getReferenceById(id));
    }

    /*
     * Actualiza un agente de transito.
     * 
     * @params TrafficPoliceDTO : Objeto de transferencia de datos del agente de
     * transito.
     * 
     * @return TrafficPoliceDTO : Objeto de transferencia del agente que se
     * actualizo.
     */
    @Override
    public TrafficPoliceDTO updateTransitAgent(TrafficPoliceDTO trafficPolice) {
        return convertTrafficPolicetoDTO(trafficPoliceRepository.save(convertDTOtoTrafficPolice(trafficPolice,
                highwayRepository.getReferenceById(trafficPolice.getHighway()))));
    }

    /*
     * Elimina un agente de transito.
     * 
     * @params long : Identificador del agente de transito.
     * 
     * @return boolean : True si se elimino, false si no.
     */
    @Override
    public boolean deleteTransitAgent(Long id) {
        if (trafficPoliceRepository.existsById(id)) {
            trafficPoliceRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    /*
     * Metodo para crear una nueva historia para el agente de transito.
     * 
     * @params History : Objeto de transferencia de datos de la historia.
     * 
     * @return History : Objeto que se creo.
     */
    public History addHistory(History history) {
        return historyRepository.save(history);
    }

    public String date() {
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy/MMMM/dd HH:mm:ss");
        return dtf3.format(LocalDateTime.now());
    }

    /*
     * Metodo para convertir un objeto de transferencia de datos de agente de
     * transito a un objeto de dominio.
     * 
     * @params TrafficPoliceDTO : Objeto de transferencia de datos del agente de
     * transito.
     * 
     * @return TrafficPolice : Objeto de entidad del agente de transito.
     */
    TrafficPolice convertDTOtoTrafficPolice(TrafficPoliceDTO trafficPoliceDTO, Highway highway) {
        TrafficPolice trafficPolice = new TrafficPolice();
        trafficPolice.setId(trafficPoliceDTO.getId());
        trafficPolice.setName(trafficPoliceDTO.getName());
        trafficPolice.setIdSecretary(trafficPoliceDTO.getIdSecretary());
        trafficPolice.setYearsExperience(trafficPoliceDTO.getYearsExperience());
        trafficPolice.setHighway(highway);
        return trafficPolice;
    }

    /*
     * Metodo para convertir un objeto tipo agente de
     * transito a un objeto de transferencia de datos.
     * 
     * @params TrafficPolice : Objeto tipo agente de
     * transito.
     * 
     * @return TrafficPoliceDTO : Objeto de tranferencia de datos de agente de
     * transito.
     */
    TrafficPoliceDTO convertTrafficPolicetoDTO(TrafficPolice trafficPolice) {
        TrafficPoliceDTO trafficPoliceDTO = new TrafficPoliceDTO();
        trafficPoliceDTO.setId(trafficPolice.getId());
        trafficPoliceDTO.setName(trafficPolice.getName());
        trafficPoliceDTO.setIdSecretary(trafficPolice.getIdSecretary());
        trafficPoliceDTO.setYearsExperience(trafficPolice.getYearsExperience());
        trafficPoliceDTO.setHighway(trafficPolice.getHighway().getId());
        return trafficPoliceDTO;
    }
}
