package com.app.web.demo.service;
import java.util.List;
import com.app.web.demo.entity.Highway;

public interface HighwayService {
    public List<Highway> allList();
    public Highway saveHighway(Highway highway);
    public Highway getHighwayId(int id);
    public Highway updateHighway(Highway highway);
    public void deleteHighway(int id);
}
