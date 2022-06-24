package com.app.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.web.demo.service.TrafficPoliceService;
import com.app.web.demo.entity.TrafficPolice;
import com.app.web.demo.service.HighwayService;
import com.app.web.demo.service.HistoryService;

import java.util.ArrayList;
import java.util.List;
import com.app.web.demo.entity.Highway;
import com.app.web.demo.entity.History;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TrafficPoliceController {

    @Autowired
    private TrafficPoliceService serviceTransitagent;

    @Autowired
    private HighwayService serviceHighway;

    @Autowired
    private HistoryService serviceHistory;

    @GetMapping("/")
    public ArrayList<TrafficPolice> getTrafficPolice(){
        ArrayList<TrafficPolice> list = new ArrayList<>();
        return list;
    }

}
