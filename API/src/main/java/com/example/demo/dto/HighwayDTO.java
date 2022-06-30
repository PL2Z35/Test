package com.example.demo.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Objeto de transferencia de datos que representa una calle.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
@Getter
@Setter
public class HighwayDTO  implements Serializable {
    /**
     * Valor de serializacion.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Indentificador de la via asignado por el cliente.
     */
    private int id;
    /**
     * Tipo de via.
     */
    private String type;
    /**
     * Valor cambia si es calle o carrera.
     */
    private String streetOrRace;
    /**
     * Numero de la via.
     */
    private int number;
    /**
     * Nivel de congesition actual de la via.
     */
    private double congestionLevel;
}
