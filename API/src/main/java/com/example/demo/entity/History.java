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
 * @since : 6/27/2022
 */

@Getter
@Setter
@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "transitAgentId", nullable = false)
    private long transitAgentId;
    @Column(name = "highwayId", nullable = false)
    private int highwayId;
    @Column(name = "date", nullable = false)
    private String date;
}
