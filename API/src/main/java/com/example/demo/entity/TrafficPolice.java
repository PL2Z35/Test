package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Objeto de dominio que representa una historia.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
@Entity
@Getter
@Setter
@ToString
public class TrafficPolice {
    /**
     * Indentificador de la agente de transito.
     */
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    /**
     * Nombre del agente de transito.
     */
    @Column(name = "name", nullable = false)
    private String name;
    /*
     * Años de experiencia del agente de transito.
     */
    @Column(name = "yearsExperience", nullable = false)
    private Double yearsExperience;
    /*
     * Identificador de la secretaria.
     */
    @Column(name = "idSecretary", nullable = false)
    private String idSecretary;
    /*
     * Objeto via asignada al agente.
     */
    @JoinColumn(name = "Highway")
    @ManyToOne
    private Highway highway;
}
