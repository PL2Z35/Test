package com.app.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.web.demo.service.TrafficPoliceService;
import com.app.web.demo.entity.TrafficPolice;
import com.app.web.demo.service.HighwayService;
import com.app.web.demo.service.HistoryService;

import java.util.List;
import org.springframework.ui.Model;
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

    @GetMapping("/trafficPolice")
    public String listTransitAgent(Model model) {
        List<TrafficPolice> TrafficPolice = serviceTransitagent.allList();
        model.addAttribute("TrafficPolice", TrafficPolice);
        return "trafficPolice/trafficPolice";
    }

    @GetMapping("/trafficPolice/new")
    public String newTransitAgent(Model model) {
        List<Highway> Highway = serviceHighway.allList();
        TrafficPolice trafficPolice = new TrafficPolice();
        for (int i = 0; i < Highway.size(); i++) {
            if (Highway.get(i).getCongestion_level() <= 30) {
                Highway.remove(Highway.get(i));
            }
        }
        List<TrafficPolice> allTrafficPolice = serviceTransitagent.allList();
        for (int i = 0; i < allTrafficPolice.size(); i++) {
            for (int j = 0; j < Highway.size(); j++) {
                if (trafficPolice.getId() != allTrafficPolice.get(i).getId()) {
                    if (allTrafficPolice.get(i).getHighway().getId() == Highway.get(j).getId()) {
                        Highway.remove(Highway.get(j));
                    }
                }
            }
        }
        model.addAttribute("Highway", Highway);
        model.addAttribute("trafficPolice", trafficPolice);

        return "trafficPolice/newTrafficPolice";
    }

    @PostMapping("/trafficPolice")
    public String saveTransitAgent(@ModelAttribute TrafficPolice trafficPolice) {
        serviceTransitagent.saveTransitAgent(trafficPolice);
        serviceHistory.saveHistory(new History(trafficPolice.getId(), trafficPolice.getHighway().getId()));
        return "redirect:/trafficPolice";
    }

    @GetMapping("/trafficPolice/edit/{id}")
    public String getFormTransitAgent(@PathVariable Long id, Model model) {
        List<Highway> Highway = serviceHighway.allList();
        for (int i = 0; i < Highway.size(); i++) {
            if (Highway.get(i).getCongestion_level() <= 30) {
                Highway.remove(Highway.get(i));
            }
        }
        TrafficPolice trafficPolice = serviceTransitagent.getTransitAgentId(id);
        List<TrafficPolice> allTrafficPolice = serviceTransitagent.allList();
        for (int i = 0; i < allTrafficPolice.size(); i++) {
            for (int j = 0; j < Highway.size(); j++) {
                if (trafficPolice.getId() != allTrafficPolice.get(i).getId()) {
                    if (allTrafficPolice.get(i).getHighway().getId() == Highway.get(j).getId()) {
                        Highway.remove(Highway.get(j));
                    }
                }
            }
        }
        model.addAttribute("Highway", Highway);
        model.addAttribute("trafficPolice", trafficPolice);
        return "trafficPolice/editTrafficPolice";
    }

    @PostMapping("/trafficPolice/{id}")
    public String updateTrafficPolice(@PathVariable long id, @ModelAttribute TrafficPolice trafficPolice) {
        TrafficPolice TrafficPoliceExisting = serviceTransitagent.getTransitAgentId(id);
        TrafficPoliceExisting.setId(id);
        TrafficPoliceExisting.setName(trafficPolice.getName());
        TrafficPoliceExisting.setYears_experience(trafficPolice.getYears_experience());
        TrafficPoliceExisting.setId_Secretary(trafficPolice.getId_Secretary());
        if (TrafficPoliceExisting.getHighway().getId() != trafficPolice.getHighway().getId()) {
            serviceHistory.saveHistory(new History(trafficPolice.getId(), trafficPolice.getHighway().getId()));
        }
        TrafficPoliceExisting.setHighway(trafficPolice.getHighway());
        serviceTransitagent.updateTransitAgent(TrafficPoliceExisting);
        return "redirect:/trafficPolice";
    }

    @GetMapping("/trafficPolice/{id}")
    public String deleteTrafficPolice(@PathVariable Long id) {
        serviceTransitagent.deleteTransitAgent(id);
        return "redirect:/trafficPolice";
    }

    @GetMapping("/trafficPolice/history/{id}")
    public String getHistory(@PathVariable long id, Model model) {
        List<History> History = serviceHistory.getListTrafficPolice(id);
        model.addAttribute("History", History);
        return "/trafficPolice/history";
    }
}
