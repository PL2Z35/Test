package com.app.web.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.web.demo.service.HighwayService;
import com.app.web.demo.service.HistoryService;
import com.app.web.demo.entity.Highway;
import com.app.web.demo.entity.History;

import java.util.List;

@Controller
public class HighwayController {

    @Autowired
    private HighwayService service;

    @Autowired
    private HistoryService serviceHistory;

    @GetMapping("/highway")
    public String listHighway(Model model) {
        List<Highway> Highway = service.allList();
        model.addAttribute("Highway", Highway);
        return "highway/highway";
    }

    @GetMapping("/highway/new")
    public String newHighway(Model model) {
        Highway highway = new Highway();
        model.addAttribute("highway", highway);
        return "highway/newHighway";
    }

    @PostMapping("/highway")
    public String saveHighway(@ModelAttribute Highway highway) {
        service.saveHighway(highway);
        return "redirect:/highway";
    }

    @GetMapping("/highway/edit/{id}")
    public String getFormHighway(@PathVariable int id, Model model) {
        model.addAttribute("highway", service.getHighwayId(id));
        return "highway/editHighway";
    }

    @PostMapping("/highway/{id}")
    public String updateHighway(@PathVariable int id, @ModelAttribute Highway highway) {
        Highway highwayExisting = service.getHighwayId(id);
        highwayExisting.setId(id);
        highwayExisting.setCongestion_level(highway.getCongestion_level());
        highwayExisting.setNumber(highway.getNumber());
        highwayExisting.setStreet_or_race(highway.getStreet_or_race());
        highwayExisting.setType(highway.getType());
        service.updateHighway(highwayExisting);
        return "redirect:/highway";
    }

    @GetMapping("/highway/{id}")
    public String deleteHighway(@PathVariable int id) {
        service.deleteHighway(id);
        return "redirect:/highway";
    }

    @GetMapping("/highway/history/{id}")
    public String getHistory(@PathVariable int id, Model model) {
        List<History> History = serviceHistory.getListHighway(id);
        model.addAttribute("History", History);
        return "/highway/history";
    }
}
