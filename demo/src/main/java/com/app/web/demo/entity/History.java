package com.app.web.demo.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "History")
public class History {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "transitAgentId", nullable = false)
    private long transitAgentId;
    @Column(name = "highwayId", nullable = false)
    private int highwayId;
    @Column(name = "date", nullable = false)
    private String date;

    public History(){

    }

    public History(long transitAgentId, int highwayId) {
        this.id = id;
        this.transitAgentId = transitAgentId;
        this.highwayId = highwayId;
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy/MMMM/dd HH:mm:ss");
        date = dtf3.format(LocalDateTime.now());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTransitAgentId() {
        return transitAgentId;
    }

    public void setTransitAgentId(long transitAgentId) {
        this.transitAgentId = transitAgentId;
    }

    public int getHighwayId() {
        return highwayId;
    }

    public void setHighwayId(int highwayId) {
        this.highwayId = highwayId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
}
