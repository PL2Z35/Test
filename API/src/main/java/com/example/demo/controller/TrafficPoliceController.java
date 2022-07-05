package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.service.TrafficPoliceService;
import com.example.demo.service.HighwayService;
import com.example.demo.service.HistoryService;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.HistoryDTO;
import com.example.demo.dto.TrafficPoliceDTO;
import com.example.demo.entity.Highway;
import com.example.demo.entity.History;
import com.example.demo.entity.TrafficPolice;
import com.example.demo.exception.MyException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Clase controladora del objeto TrafficPolice.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
@RestController
@RequestMapping("/trafficpolice")
public class TrafficPoliceController {

    @Autowired
    private TrafficPoliceService serviceTransitagent;

    @Autowired
    private HistoryService serviceHistory;

    @Autowired
    private HighwayService serviceHighway;

    /**
     * Método que devuelve todos los policías de tránsito.
     * 
     * 1. Realiza una lista con todos los agentes de transito.
     * 2. Realiza una conversion de la lista del paso 1 en una lista de DTO.
     * 
     * @return ResponseEntity: con estado 200 y la lista de todos los agentes de
     *         transito.
     */
    @GetMapping("/all")
    public ResponseEntity<List<TrafficPoliceDTO>> listTrafficPolices() {
        List<TrafficPoliceDTO> listTrafficPolicesDTO = new ArrayList<>();
        List<TrafficPolice> listTrafficPolices = serviceTransitagent.allList();
        for (TrafficPolice trafficPolice : listTrafficPolices) {
            listTrafficPolicesDTO.add(convertTrafficPolicetoDTO(trafficPolice));
        }
        return new ResponseEntity<>(listTrafficPolicesDTO, HttpStatus.OK);
    }

    /**
     * Método que devuelve un policía de tránsito por su id.
     * 
     * 1. Realiza una conversion de objeto de tipo TrafficPoliceDTO a objeto de tipo
     * TrafficPolice.
     * 2. Realiza una busqueda del policía de tránsito por su id.
     *
     * @param long: identificador del policía de tránsito.
     * @return ResponseEntity: con estado 200 y el objeto de transferencia de datos
     *         de tipo policía de tránsito.
     * @throws MyException: con un estado 404, por que no se encuentra el policia de
     *                      transito.
     */
    @GetMapping({ "/{id}" })
    public ResponseEntity<TrafficPoliceDTO> getTrafficPolice(@PathVariable(value = "id") Long id) {
        try {
            TrafficPolice trafficPolice = serviceTransitagent.getTransitAgentId(id);
            return new ResponseEntity<>(convertTrafficPolicetoDTO(trafficPolice), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Método que lista las historias de un policía de tránsito.
     * 
     * 1. Realiza una lista con todos las historias del policía de tránsito.
     * 2. convierte la lista del paso 1 en una lista de DTO.
     * 
     * @params int: identificador del policía de tránsito.
     * @return ResponseEntity: con estado 200 y la lista de todos las historias del
     *         policía de tránsito
     */
    @GetMapping({ "/{id}/history" })
    public ResponseEntity<List<HistoryDTO>> getTrafficPoliceHistory(@PathVariable(value = "id") Long id) {
        List<HistoryDTO> listHistoryDTO = new ArrayList<>();
        List<History> listHistory = serviceHistory.getListTrafficPolice(id);
        for (History history : listHistory) {
            listHistoryDTO.add(convertHistorytoDTO(history));
        }
        return new ResponseEntity<>(listHistoryDTO, HttpStatus.OK);
    }

    /**
     * Método que crea un policía de tránsito.
     * 
     * 1. Realiza una busqueda para ver si el identificador de la via existe.
     * 2. Realiza una conversion de objeto de transferencia de datos del policía de
     * tránsito a objeto tipo policía de tránsito.
     * 3. Realiza una creacion del policía de tránsito.
     * 
     * @params TrafficPoliceDTO: objeto de transferencia de datos del policía de
     *         tránsito.
     * @return ResponseEntity: con estado 200 y el objeto de transferencia de datos
     *         del policía de tránsito.
     * @return ResponseEntity: con estado 400 y un objeto null si no se cumplen las
     *         reglas de negocio.
     * @return ResponseEntity: con estado 400, si no se completo correctamente la
     *         creacion del policía de tránsito.
     */
    @PostMapping()
    public ResponseEntity<Object> saveTrafficePolice(@RequestBody TrafficPoliceDTO trafficPoliceDTO) {
        try {
            Highway highway = serviceHighway.getHighwayId(trafficPoliceDTO.getHighway());
            TrafficPolice trafficPolice = convertDTOtoTrafficPolice(trafficPoliceDTO, highway);
            return new ResponseEntity<>(convertTrafficPolicetoDTO(serviceTransitagent.saveTransitAgent(trafficPolice)),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Método que actualiza un policía de tránsito.
     * 
     * 1. Realiza una busqueda para ver si el identificador de la via existe.
     * 2. Realiza una conversion de objeto de transferencia de datos del policía de
     * tránsito a objeto tipo policía de tránsito.
     * 3. Realiza una creacion la actualizacion del agente de transito.
     * 
     * @params TrafficPoliceDTO: Objeto de transferencia de datos del policía de
     *         tránsito..
     * @return ResponseEntity: con estado 200 y el objeto de transferencia de datos
     *         del policía de tránsito.
     * @return ResponseEntity: con estado 200 y un objeto null si no se cumplen las
     *         reglas de negocio.
     * @return ResponseEntity: con estado 404, si no se completo correctamente la
     *         actualizacion del policía de tránsito.
     */
    @PutMapping()
    public ResponseEntity<TrafficPolice> updateTrafficePolice(@RequestBody TrafficPoliceDTO trafficPoliceDTO) {
        try {
            Highway highway = serviceHighway.getHighwayId(trafficPoliceDTO.getHighway());
            TrafficPolice trafficPolice = serviceTransitagent
                    .updateTransitAgent(convertDTOtoTrafficPolice(trafficPoliceDTO, highway));
            return new ResponseEntity<>(trafficPolice, HttpStatus.OK);
        } catch (MyException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    /**
     * Método que elimina un policía de tránsito.
     * 
     * 1. Envia el identificador del agente de transito.
     * 
     * @return ResponseEntity: con estado 200 y un mensaje Delete si se borro correctamente.
     * @return ResponseEntity: con estado 404 si no se encuantra el agente de transito.
     */
    @DeleteMapping({ "/{id}" })
    public ResponseEntity<String> deleteTrafficPolice(@PathVariable(value = "id") Long id) {
        try {
            serviceTransitagent.deleteTransitAgent(id);
            return new ResponseEntity<>("Delete", HttpStatus.OK);
        } catch (MyException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
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

    /*
     * Metodo para convertir un objeto de transferencia de datos de historial a un
     * objeto de dominio.
     * 
     * @params History: Objeto tipo historia.
     * 
     * @return historyDTO: Objeto de transferencia de datos del historia.
     */
    private HistoryDTO convertHistorytoDTO(History history) {
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setHighwayId(history.getHighwayId());
        historyDTO.setTransitAgentId(history.getTransitAgentId());
        return historyDTO;
    }

}
