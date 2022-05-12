package com.app.web.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.ArrayList;

import javax.persistence.Column;

@Entity
@Table(name="TransitAgent")
public class TransitAgent {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable= false, unique=true)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "yearsExperience", nullable = false)
    private Double yearsExperience;
    @Column(name = "idSecretary", nullable = false)
    private String idSecretary;
    @Column(name = "idHighway", nullable = false)
    private int idHighway;
    @Column(name = "history", nullable = false)
    private ArrayList<String> history;

    public TransitAgent(){

    }

    public TransitAgent(int id, String name, Double yearsExperience, String idSecretary, int idHighway) {
        this.id = id;
        this.name = name;
        this.yearsExperience = yearsExperience;
        this.idSecretary = idSecretary;
        this.idHighway = idHighway;
        this.history = new ArrayList<String>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(Double yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public String getIdSecretary() {
        return idSecretary;
    }

    public void setIdSecretary(String idSecretary) {
        this.idSecretary = idSecretary;
    }

    public int getIdHighway() {
        return idHighway;
    }

    public void setIdHighway(int idHighway) {
        this.idHighway = idHighway;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }
}
