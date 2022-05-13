package com.app.web.demo.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
@Table(name = "History")
public class History {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "transitAgentId", nullable = false)
    private String transitAgentId;
    @Column(name = "highwayId", nullable = false)
    private int highwayId;

    public History(){

    }

    public History(int id, String transitAgentId, int highwayId) {
        this.id = id;
        this.transitAgentId = transitAgentId;
        this.highwayId = highwayId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransitAgentId() {
        return transitAgentId;
    }

    public void setTransitAgentId(String transitAgentId) {
        this.transitAgentId = transitAgentId;
    }

    public int getHighwayId() {
        return highwayId;
    }

    public void setHighwayId(int highwayId) {
        this.highwayId = highwayId;
    }

    
    
}
