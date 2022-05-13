package com.app.web.demo.service;
import java.util.ArrayList;
import java.util.List;
import com.app.web.demo.entity.History;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.web.demo.repository.HistoryRepository;

@Service
public class HistoryServiceImp implements HistoryService{
    
    @Autowired
    private HistoryRepository repository;

    public List<History> allList(){
        return repository.findAll();
    }
    public List<History> getListHighway(int id){
        List<History> aux = new ArrayList<History>();
        List<History> allList = allList();
        for (int i = 0; i < allList.size(); i++) {
            if(id==allList.get(i).getHighwayId()){
                aux.add(allList.get(i));
            }
        }
        return aux;
    }

    public List<History> getListTrafficPolice(long id){
        List<History> aux = new ArrayList<History>();
        List<History> allList = allList();
        for (int i = 0; i < allList.size(); i++) {
            if(id==allList.get(i).getTransitAgentId()){
                aux.add(allList.get(i));
            }
        }
        return aux;
    }

    public History saveHistory(History history){
        return repository.save(history);
    }
}