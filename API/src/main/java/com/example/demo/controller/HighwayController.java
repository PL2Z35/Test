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
import java.util.List;

/**
 * Clase controladora del objeto Highway.

 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
@RestController
@RequestMapping("/highway")
public class HighwayController {

    /**
     * Objeto de tipo HighwayService el cual se encargará de realizar las
     * operaciones de negocio en las que se incluya la via.
     */
    @Autowired
    private HighwayService service;

    /**
     * Objeto de tipo HistoryService el cual se encargará de realizar las
     * operaciones de negocio en las que se incluya la historia de la via.
     */
    @Autowired
    private HistoryService serviceHistory;

    /**
     * Método que devuelve todas las vías.
     */
    @GetMapping("/all")
    public List<HighwayDTO> listHighway() {
        return service.allList();
    }

    /**
     * Método que devuelve una via por su id.
     */
    @GetMapping({ "/{id}" })
    public HighwayDTO getHighway(@PathVariable(value = "id") Integer id) {
        return service.getHighwayId(id);
    }

    /*
     * Método que devuelve la historia de una via por su id.
     */
    @GetMapping({ "/{id}/history" })
    public List<HistoryDTO> getHighwayHistory(@PathVariable(value = "id") Integer id) {
        return serviceHistory.getListHighway(id);
    }

    /**
     * Método que crea una via.
     */
    @PostMapping()
    public ResponseEntity<HighwayDTO> saveHighway(@RequestBody HighwayDTO highway) {
        return ResponseEntity.ok(service.saveHighway(highway));
    }

    /**
     * Método que actualiza una via.
     */
    @PutMapping()
    public HighwayDTO updateHighway(@RequestBody HighwayDTO highway) {
        return service.saveHighway(highway);
    }

    /**
     * Método que elimina una via.
     */
    @DeleteMapping({ "/{id}" })
    public ResponseEntity<String> deleteHighway(@PathVariable(value = "id") Integer id) {
        if (service.deleteHighway(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
