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
 * @since : 6/27/2022
 */

@Getter
@Setter
@Entity
public class Highway {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "streetOrRace", nullable = false)
    private String streetOrRace;
    @Column(name = "number", nullable = false)
    private int number;
    @Column(name = "congestionLevel", nullable = false)
    private double congestionLevel;
}
