package com.app.web.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity

public class TrafficPolice {

    @Id
    @Column(name = "id", nullable = false)
    private Long  id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "years_experience", nullable = false)
    private Double years_experience;
    @Column(name = "id_Secretary", nullable = false)
    private String id_Secretary;
    @OneToOne
    @JoinColumn(name="Highways_id")
    private Highway highway;
    
    public TrafficPolice(){

    }

    public TrafficPolice(Long id, String name, Double years_experience, String id_Secretary) {
        this.id = id;
        this.name = name;
        this.years_experience = years_experience;
        this.id_Secretary = id_Secretary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getYears_experience() {
        return years_experience;
    }

    public void setYears_experience(Double years_experience) {
        this.years_experience = years_experience;
    }

    public String getId_Secretary() {
        return id_Secretary;
    }

    public void setId_Secretary(String id_Secretary) {
        this.id_Secretary = id_Secretary;
    }

    public Highway getHighway() {
        return highway;
    }

    public void setHighway(Highway highway) {
        this.highway = highway;
    }

}
