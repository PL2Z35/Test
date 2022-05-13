package com.app.web.demo.service;
import java.util.List;
import com.app.web.demo.entity.TrafficPolice;
import com.app.web.demo.entity.History;

public interface TrafficPoliceService {
    public List<TrafficPolice> allList();
    public TrafficPolice saveTransitAgent(TrafficPolice trafficPolice);
    public TrafficPolice getTransitAgentId(Long id);
    public TrafficPolice updateTransitAgent(TrafficPolice trafficPolice);
    public void deleteTransitAgent(Long id);
    public History addHistory(History history);
    public List<History> allHistory();
}