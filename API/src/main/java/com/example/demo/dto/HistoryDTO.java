package com.example.demo.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Objeto de transferencia de datos que representa una historia.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
@Getter
@Setter
public class HistoryDTO implements Serializable {
    /**
     * Valor de serializacion.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Indentificador de la historia generado automaticamente.
     */
    private int id;
    /**
     * Identificador del agente de transito.
     */
    private long transitAgentId;
    /**
     * Identificador de la via.
     */
    private int highwayId;
    /**
     * Dia y hora en la que se realizo la historia.
     */
    private String date;
}
