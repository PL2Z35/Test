package com.app.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.web.demo.service.TrafficPoliceService;
import com.app.web.demo.entity.TrafficPolice;
import com.app.web.demo.service.HighwayService;
import java.util.List;
import org.springframework.ui.Model;
import com.app.web.demo.entity.Highway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TrafficPoliceController {
    
    @Autowired
    private TrafficPoliceService serviceTransitagent;

    @Autowired
    private HighwayService serviceHighway;


    @GetMapping("/trafficPolice")
    public String listTransitAgent(Model model){
        List<TrafficPolice> TrafficPolice = serviceTransitagent.allList();
        model.addAttribute("TrafficPolice", TrafficPolice);
        return "trafficPolice/trafficPolice";
    }

    @GetMapping("/trafficPolice/new")
    public String newTransitAgent(Model model){
        List<Highway> Highway = serviceHighway.allList();
        TrafficPolice trafficPolice = new TrafficPolice();
        model.addAttribute("Highway", Highway);
        model.addAttribute("trafficPolice", trafficPolice);
        return "trafficPolice/newTrafficPolice";
    }

    @PostMapping("/trafficPolice")
    public String saveTransitAgent(@ModelAttribute TrafficPolice trafficPolice){
        serviceTransitagent.saveTransitAgent(trafficPolice);
        return "redirect:/trafficPolice";
    }

    @GetMapping("/trafficPolice/edit/{id}")
    public String getFormTransitAgent(@PathVariable Long id,Model model){
        List<Highway> Highway = serviceHighway.allList();
        model.addAttribute("Highway", Highway);
        model.addAttribute("trafficPolice",serviceTransitagent.getTransitAgentId(id));
        return "trafficPolice/editTrafficPolice";
    }

    @PostMapping("/trafficPolice/{id}")
    public String updateTrafficPolice(@PathVariable long id, @ModelAttribute TrafficPolice trafficPolice){
        TrafficPolice TrafficPoliceExisting = serviceTransitagent.getTransitAgentId(id);
        TrafficPoliceExisting.setId(id);
        TrafficPoliceExisting.setName(trafficPolice.getName());
        TrafficPoliceExisting.setYears_experience(trafficPolice.getYears_experience());
        TrafficPoliceExisting.setId_Secretary(trafficPolice.getId_Secretary());
        TrafficPoliceExisting.setHighway(trafficPolice.getHighway());
        serviceTransitagent.updateTransitAgent(TrafficPoliceExisting);
        return "redirect:/trafficPolice";
    }

    @GetMapping("/trafficPolice/{id}")
    public String deleteTrafficPolice(@PathVariable Long id){
        serviceTransitagent.deleteTransitAgent(id);
        return "redirect:/trafficPolice";
    }
}
