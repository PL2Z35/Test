package com.example.demo.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Objeto de transferencia de datos que representa un agente de transito.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2022
 */
@Getter
@Setter
public class TrafficPoliceDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Double yearsExperience;
    private String idSecretary;
    /*
     * Identificador de la via.
     */
    private int highway;
}
