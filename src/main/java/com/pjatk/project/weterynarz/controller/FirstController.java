package com.pjatk.project.weterynarz.controller;

import com.pjatk.project.weterynarz.model.Klient;
import com.pjatk.project.weterynarz.model.Wizyta;
import com.pjatk.project.weterynarz.model.Zwierze;
import com.pjatk.project.weterynarz.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class FirstController {

    private KlientService klientService;
    private ZwierzeService zwierzeService;
    private WizytaService wizytaService;
    private UslugiService uslugiService;

    public FirstController(KlientService klientService, ZwierzeService zwierzeService, WizytaService wizytaService, UslugiService uslugiService){
        this.klientService = klientService;
        this.zwierzeService = zwierzeService;
        this.wizytaService = wizytaService;
        this.uslugiService = uslugiService;
    }

    @RequestMapping("/kontakt")
    public String goToContact(@ModelAttribute("Klient") Klient klient, @ModelAttribute("Zwierze") Zwierze zwierze, @ModelAttribute("Wizyta") Wizyta wizyta){
        return "kontakt";
    }

    @RequestMapping("/opis")
    public String goToOpis(){
        return "opis";
    }

    @RequestMapping("/cennik")
    public String goToCennik(Model model){
        model.addAttribute("uslugi", uslugiService.findAllUslugi());
        return "cennik";
    }

    @GetMapping("/uslugi")
    public String goToUslugi(Model model)
    {
        model.addAttribute("uslugi", uslugiService.findAllUslugi());
        return "uslugi";
    }

    @PostMapping("/kontakt")
    public String addKlient(@ModelAttribute("Klient") Klient klient, @ModelAttribute("Zwierze") Zwierze zwierze,@ModelAttribute("Wizyta") Wizyta wizyta){
        klientService.createKlient(klient);
        zwierzeService.addZwierze(new Zwierze(zwierze.getNazwa(), zwierze.getTyp(), zwierze.getWiek(), klient.getId()));
        wizytaService.addWizyta(new Wizyta(wizyta.getData(), wizyta.getOpis(),klient.getId()));
        return "successful";
    }


    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Gabinet Weterynaryjny");
    }

}
