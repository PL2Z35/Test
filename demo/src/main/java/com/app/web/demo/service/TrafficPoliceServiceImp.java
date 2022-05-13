package com.app.web.demo.service;
import java.util.List;
import com.app.web.demo.entity.TrafficPolice;
import com.app.web.demo.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.web.demo.repository.TrafficPoliceRepository;
import com.app.web.demo.repository.HistoryRepository;

@Service
public class TrafficPoliceServiceImp implements TrafficPoliceService{

    @Autowired
    private TrafficPoliceRepository trafficPoliceRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public List<TrafficPolice> allList(){
        return trafficPoliceRepository.findAll();
    }

    @Override
    public TrafficPolice saveTransitAgent(TrafficPolice trafficPolice){
        return trafficPoliceRepository.save(trafficPolice);
    }

    @Override
    public TrafficPolice getTransitAgentId(Long id){
        return trafficPoliceRepository.findById(id).get();
    }

    @Override
    public TrafficPolice updateTransitAgent(TrafficPolice trafficPolice){
        return trafficPoliceRepository.save(trafficPolice);
    }

    @Override
    public void deleteTransitAgent(Long id){
        trafficPoliceRepository.deleteById(id);
    }

    public History addHistory(History history){
        return historyRepository.save(history);
    }

    public List<History> allHistory(){
        return historyRepository.findAll();
    }
}
