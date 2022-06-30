package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Objeto de dominio que representa una calle.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
@Entity
@Getter
@Setter
public class Highway {
    /**
     * Indentificador de la via asignado por el cliente.
     */
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    /**
     * Tipo de via.
     */
    @Column(name = "type", nullable = false)
    private String type;
    /**
     * Valor cambia si es calle o carrera.
     */
    @Column(name = "streetOrRace", nullable = false)
    private String streetOrRace;
    /**
     * Numero de la via.
     */
    @Column(name = "number", nullable = false)
    private int number;
    /**
     * Nivel de congesition actual de la via.
     */
    @Column(name = "congestionLevel", nullable = false)
    private double congestionLevel;
}
