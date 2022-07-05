package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.HighwayService;
import com.example.demo.service.HistoryService;
import com.example.demo.dto.HighwayDTO;
import com.example.demo.dto.HistoryDTO;
import com.example.demo.entity.Highway;
import com.example.demo.entity.History;
import com.example.demo.exception.MyException;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase controladora del objeto Highway.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2022
 */
@RestController
@RequestMapping("/highway")
public class HighwayController {

    @Autowired
    private HighwayService service;

    @Autowired
    private HistoryService serviceHistory;

    /**
     * Método que devuelve todas las vías.
     * 
     * 1. Obtiene todas las vías.
     * 2. Convierte la lista del paso 1 en una lista de objetos tipo HighwayDTO.
     * 
     * @return ResponseEntity : Con estado 200 y la lista de vías tipo HighwayDTO.
     */
    @GetMapping("/all")
    public ResponseEntity<List<HighwayDTO>> listHighway() {
        List<Highway> highways = service.allList();
        List<HighwayDTO> highwayDTOs = new ArrayList<>();
        for (Highway highway : highways) {
            highwayDTOs.add(converDto(highway));
        }
        return new ResponseEntity<>(highwayDTOs, HttpStatus.OK);
    }

    /**
     * Método que devuelve una via por su id.
     * 
     * 1. Realiza una conversion de objeto de tipo HighwayDTO a objeto de tipo
     * Highway.
     * 2. Realiza la busqueda del la via mediante el objeto del paso 1.
     * 
     * @return ResponseEntity: Con estado 200 y la via, si se encuentra la via en la
     *         base de datos.
     * @throws ResponseEntity :Con estado 404 si no se encuentra la via en la base
     *                        de datos.
     */
    @GetMapping({ "/{id}" })
    public ResponseEntity<HighwayDTO> getHighway(@PathVariable(value = "id") Integer id) {
        try {
            return new ResponseEntity<>(converDto(service.getHighwayId(id)), HttpStatus.OK);
        } catch (MyException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
     * Método que devuelve la historia de una via por su id.
     * 
     * 1. Realiza una busqueda de las historias del la via.
     * 2. Convierte la lista del paso 1 en una lista de objetos tipo HistoryDTO.
     * 
     * @return ResponseEntity : Con estado 200 y la lista de historias tipo
     * HistoryDTO.
     */
    @GetMapping({ "/{id}/history" })
    public ResponseEntity<List<HistoryDTO>> getHighwayHistory(@PathVariable(value = "id") Integer id) {
        List<HistoryDTO> historyDTOs = new ArrayList<>();
        List<History> histories = serviceHistory.getListHighway(id);
        for (History history : histories) {
            historyDTOs.add(converDtoHistory(history));
        }
        return new ResponseEntity<>(historyDTOs, HttpStatus.OK);
    }

    /**
     * Método que crea una via.
     * 
     * 1. Convierte todos los atributos del objeto HighwayDTO a objeto de tipo
     * Highway.
     * 2. Realiza la busqueda del objeto 1 en la base de datos.
     * 
     * @return ResponseEntity: Con estado 200 y se almacena la via correctamente.
     * @return ResponseEntity: Con estado 409, si se encuentra problemas al
     *         almacenar la via.
     */
    @PostMapping()
    public ResponseEntity<HighwayDTO> saveHighway(@RequestBody HighwayDTO highway) {
        if (service.saveHighway(convertDTOtoHighway(highway)) != null) {
            return new ResponseEntity<>(highway, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    /**
     * Método que actualiza una via.
     * 
     * 1. Convierte todos los atributos del objeto via tipo HighwayDTO a objeto de
     * tipo Highway.
     * 2. Realiza la busqueda del objeto 1 en la base de datos.
     * 
     * @return ResponseEntity : Con estado 200 y si se encotro la via y se modifico
     *         correctamnte.
     * @return ResponseEntity : Con estado 409 si no se encuentra la via en la base
     *         de datos.
     * 
     */
    @PutMapping()
    public ResponseEntity<HighwayDTO> updateHighway(@RequestBody HighwayDTO highway) {
        if (service.updateHighway(convertDTOtoHighway(highway)) != null) {
            return new ResponseEntity<>(highway, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    /**
     * Método que elimina una via.
     * 
     * 1. Convierte todos los atributos del objeto via tipo HighwayDTO a objeto de
     * tipo Highway.
     * 2. Realiza la busqueda del objeto 1 en la base de datos.
     * 
     * @return ResponseEntity : Con estado 200 y si se encuntra el objeto y se
     *         elimina correctamnete.
     * @return ResponseEntity : Con estado 404 si no se encuentra la via en la base
     *         de datos.
     */
    @DeleteMapping({ "/{id}" })
    public ResponseEntity<String> deleteHighway(@PathVariable(value = "id") Integer id) {
        try {
            service.deleteHighway(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (MyException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Convierte un objeto via a un objeto de transferencia de via.
     * 
     * Convierte todos los atributos del objeto via en DTO.
     * 
     * @param highway Objeto tipo via.
     * @return HighwayDTO : Objeto de transferencia de datos de via.
     */
    HighwayDTO converDto(Highway highway) {
        HighwayDTO highwayDto = new HighwayDTO();
        highwayDto.setId(highway.getId());
        highwayDto.setCongestionLevel(highway.getCongestionLevel());
        highwayDto.setNumber(highway.getNumber());
        highwayDto.setStreetOrRace(highway.getStreetOrRace());
        highwayDto.setType(highway.getType());
        return highwayDto;
    }

    /**
     * Convierte un objeto de transferencia de datos de via a un objeto via.
     * 
     * Convierte todos los atributos del objeto DTO en atributos para el objeto via.
     * 
     * @param highwayDto Objeto de transferencia de datos de via.
     * @return Highway : Objeto via.
     */
    Highway convertDTOtoHighway(HighwayDTO highwayDto) {
        Highway highway = new Highway();
        highway.setId(highwayDto.getId());
        highway.setType(highwayDto.getType());
        highway.setStreetOrRace(highwayDto.getStreetOrRace());
        highway.setNumber(highwayDto.getNumber());
        highway.setCongestionLevel(highwayDto.getCongestionLevel());
        return highway;
    }

    /**
     * Convierte un objeto de historia de via a un objeto de transferencia de
     * historia de via.
     * 
     * Convierte todos los atributos del objeto via en DTO.
     * 
     * @param history Objeto de historia de via.
     * @return HistoryDTO : Objeto de transferencia de datos de historia de via.
     */
    HistoryDTO converDtoHistory(History history) {
        HistoryDTO historyDto = new HistoryDTO();
        historyDto.setDate(history.getDate());
        historyDto.setHighwayId(history.getHighwayId());
        historyDto.setTransitAgentId(history.getTransitAgentId());
        return historyDto;
    }
}
