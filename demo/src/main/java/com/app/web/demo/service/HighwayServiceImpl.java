package com.app.web.demo.service;
import java.util.List;
import com.app.web.demo.entity.Highway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.web.demo.repository.HighwayRepository;

@Service
public class HighwayServiceImpl implements HighwayService{
    
    @Autowired
    private HighwayRepository repository;

    @Override
    public List<Highway> allList(){
        return repository.findAll();
    }
        
    @Override
    public Highway saveHighway(Highway highway){
        return repository.save(highway);
    }

    @Override
    public Highway getHighwayId(int id){
        return repository.findById(id).get();
    }

    @Override
    public Highway updateHighway(Highway highway){
        return repository.save(highway);
    }

    @Override
    public void deleteHighway(int id){
        repository.deleteById(id);
    }
}
