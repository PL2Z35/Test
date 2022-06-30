package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.service.TrafficPoliceService;
import com.example.demo.service.HistoryService;
import java.util.List;

import com.example.demo.dto.HistoryDTO;
import com.example.demo.dto.TrafficPoliceDTO;
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

    /**
     * Objeto de tipo TrafficPoliceService el cual se encargará de realizar las
     * operaciones de negocio en las que se incluya la policía de tránsito.
     */
    @Autowired
    private TrafficPoliceService serviceTransitagent;

    /**
     * Objeto de tipo HistoryService el cual se encargará de realizar las
     * operaciones de negocio en las que se incluya la historia de la policía de
     * tránsito.
     */
    @Autowired
    private HistoryService serviceHistory;

    /**
     * Método que devuelve todos los policías de tránsito.
     */
    @GetMapping("/all")
    public List<TrafficPoliceDTO> listTrafficPolices() {
        return serviceTransitagent.allList();
    }

    /*
     * Método que devuelve un policía de tránsito por su id.
     */
    @GetMapping({ "/{id}" })
    public TrafficPoliceDTO getTrafficPolice(@PathVariable(value = "id") Long id) {
        return serviceTransitagent.getTransitAgentId(id);
    }

    /**
     * Método que crea un policía de tránsito.
     */
    @GetMapping({ "/{id}/history" })
    public List<HistoryDTO> getTrafficPoliceHistory(@PathVariable(value = "id") Long id) {
        return serviceHistory.getListTrafficPolice(id);
    }

    /**
     * Método que crea un policía de tránsito.
     */
    @PostMapping()
    public ResponseEntity<TrafficPoliceDTO> saveTrafficePolice(@RequestBody TrafficPoliceDTO trafficPolice) {
        if (serviceTransitagent.saveTransitAgent(trafficPolice) != null) {
            return new ResponseEntity<>(trafficPolice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Método que actualiza un policía de tránsito.
     */
    @PutMapping()
    public ResponseEntity<TrafficPoliceDTO> updateTrafficePolice(@RequestBody TrafficPoliceDTO trafficPolice) {
        if (serviceTransitagent.saveTransitAgent(trafficPolice) != null) {
            return new ResponseEntity<>(trafficPolice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Método que elimina un policía de tránsito.
     */
    @DeleteMapping({ "/{id}" })
    public ResponseEntity<TrafficPoliceDTO> deleteTrafficPolice(@PathVariable(value = "id") Long id) {
        if (serviceTransitagent.deleteTransitAgent(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
