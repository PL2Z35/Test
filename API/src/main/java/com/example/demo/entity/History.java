package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

/**
 * Objeto de dominio que representa una historia.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
@Entity
@Getter
@Setter
public class History {
    /**
     * Indentificador de la historia generado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    /*
     * Identificador del agente de transito.
     */
    @Column(name = "transitAgentId", nullable = false)
    private long transitAgentId;
    /*
     * Identificador de la via.
     */
    @Column(name = "highwayId", nullable = false)
    private int highwayId;
    /*
     * Dia y hora en la que se realizo la historia.
     */
    @Column(name = "date", nullable = false)
    private String date;
}
