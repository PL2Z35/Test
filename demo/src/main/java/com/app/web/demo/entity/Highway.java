package com.app.web.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;

@Entity
@Table(name = "highways")
public class Highway {

    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "street_or_race", nullable = false)
    private String street_or_race;
    @Column(name = "number", nullable = false)
    private int number;
    @Column(name = "congestion_level", nullable = false)
    private double congestion_level;
    @OneToOne(mappedBy="highway")
    private TrafficPolice trafficPolice;

    public Highway(){

    }

    public Highway(int id, String type, String street_or_race, int number, double congestion_level) {
        this.id = id;
        this.type = type;
        this.street_or_race = street_or_race;
        this.number = number;
        this.congestion_level = congestion_level;
    }

    public int getId() {
        return id;
    }

    //records (constructores and getters and setters)
    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStreet_or_race() {
        return street_or_race;
    }

    public void setStreet_or_race(String street_or_race) {
        this.street_or_race = street_or_race;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getCongestion_level() {
        return congestion_level;
    }

    public void setCongestion_level(double congestion_level) {
        this.congestion_level = congestion_level;
    }

}
