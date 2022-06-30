package com.example.demo.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Objeto de transferencia de datos que representa un agente de transito.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
@Getter
@Setter
public class TrafficPoliceDTO implements Serializable {
    /**
     * Valor de serializacion.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Identificador del agente de transito.
     */
    private Long id;
    /*
     * Nombre del agente de transito.
     */
    private String name;
    /*
     * Años de experiencia del agente de transito.
     */
    private Double yearsExperience;
    /*
     * Identificador de la secretaria.
     */
    private String idSecretary;
    /*
     * Identificador de la via asignada al agente.
     */
    private int highway;
}
