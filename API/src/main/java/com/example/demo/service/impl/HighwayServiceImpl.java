package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.HighwayDTO;
import com.example.demo.entity.Highway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.HighwayRepository;
import com.example.demo.service.*;

/**
 * Implementacion de los servicios para el objeto via.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
@Service
public class HighwayServiceImpl implements HighwayService {

    /**
     * Repositorio de las calles.
     */
    @Autowired
    private HighwayRepository repository;

    /**
     * Obtiene una lista de todas las calles.
     * 
     * @return List<HighwayDTO> : Lista de objetios de transferencia de las calles.
     */
    @Override
    public List<HighwayDTO> allList() {
        List<Highway> highways = repository.findAll();
        List<HighwayDTO> highwayDTOs = new ArrayList<>();
        for (Highway highway : highways) {
            highwayDTOs.add(converDto(highway));
        }
        return highwayDTOs;
    }

    /**
     * Guarda una nueva via.
     * 
     * @param highway Objeto de transferencia de datos de via.
     * @return Highway : Objeto de transferencia que se creo.
     */
    @Override
    public HighwayDTO saveHighway(HighwayDTO highwayDto) {
        return converDto(repository.save(convertDTOtoHighway(highwayDto)));
    }

    /**
     * Obtiene una via por su identificador.
     * 
     * @param id Identificador de la via.
     * @return HighwayDTO : Objeto de transferencia de datos de la via.
     */
    @Override
    public HighwayDTO getHighwayId(int id) {
        return converDto(repository.getReferenceById(id));
    }

    /**
     * Actualiza una via.
     * 
     * @param highway Objeto de transferencia de datos de via.
     * @return HighwayDTO : Objeto de transferencia de datos de la via.
     */
    @Override
    public HighwayDTO updateHighway(HighwayDTO highway) {
        return converDto(repository.save(convertDTOtoHighway(highway)));
    }

    /**
     * Elimina una via.
     * 
     * @param id Identificador de la via.
     * @return True si se elimino, false si no..
     */
    @Override
    public boolean deleteHighway(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Convierte un objeto via a un objeto de transferencia de via.
     * 
     * @param highwayDto Objeto via.
     * @return Highway : Objeto de transferencia de datos de via.
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
     * @param highwayDto Objeto de transferencia de datos de via.
     * @return Highway : Objeto via.
     */
    Highway convertDTOtoHighway(HighwayDTO highwayDto){
        Highway highway = new Highway();
        highway.setId(highwayDto.getId());
        highway.setType(highwayDto.getType());
        highway.setStreetOrRace(highwayDto.getStreetOrRace());
        highway.setNumber(highwayDto.getNumber());
        highway.setCongestionLevel(highwayDto.getCongestionLevel());
        return highway;
    }
}
