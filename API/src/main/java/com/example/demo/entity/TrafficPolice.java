package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class TrafficPolice {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "yearsExperience", nullable = false)
    private Double yearsExperience;
    @Column(name = "idSecretary", nullable = false)
    private String idSecretary;
    @JoinColumn(name = "Highway")
    @ManyToOne
    private Highway highway;
}
