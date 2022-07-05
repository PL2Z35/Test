package com.example.demo.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Objeto de transferencia de datos que representa una calle.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2022
 */
@Getter
@Setter
public class HighwayDTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String type;
    private String streetOrRace;
    private int number;
    private double congestionLevel;
}
