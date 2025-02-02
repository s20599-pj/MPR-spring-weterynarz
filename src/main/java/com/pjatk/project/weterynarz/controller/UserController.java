package com.pjatk.project.weterynarz.controller;

import com.pjatk.project.weterynarz.model.Klient;
import com.pjatk.project.weterynarz.model.Uslugi;
import com.pjatk.project.weterynarz.model.Wizyta;
import com.pjatk.project.weterynarz.model.Zwierze;
import com.pjatk.project.weterynarz.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    private KlientService klientService;
    private ZwierzeService zwierzeService;
    private WizytaService wizytaService;
    private UslugiService uslugiService;
    private PracownikService pracownikService;

    public UserController(KlientService klientService, ZwierzeService zwierzeService, WizytaService wizytaService, UslugiService uslugiService, PracownikService pracownikService){
        this.klientService = klientService;
        this.zwierzeService = zwierzeService;
        this.wizytaService = wizytaService;
        this.uslugiService = uslugiService;
        this.pracownikService = pracownikService;
    }

    @RequestMapping("/pracownik")
    public String goToPracownik(Model model){
        model.addAttribute("pracownik", pracownikService.findAllPracownik());
        return "panel/pracownik";
    }

    @RequestMapping("/zwierzeta")
    public String goToZwierze(Model model){
        model.addAttribute("zwierze", zwierzeService.findAllZwierze());
        return "panel/zwierzeta";
    }

    @RequestMapping("/dodajUslugi")
    public String goToDodajUsluge(@ModelAttribute("Uslugi") Uslugi uslugi){
        return "panel/dodajUslugi";
    }

    @PostMapping("/dodajUslugi")
    public String addUsluga(@ModelAttribute("Uslugi") Uslugi uslugi){
        return uslugiService.addUslugi(uslugi);
    }

    @RequestMapping("/regulamin")
    public String goToRegulamin(){
        return "regulamin";
    }

    @RequestMapping("/kontakt")
    public String goToContact(@ModelAttribute("Klient") Klient klient, @ModelAttribute("Zwierze") Zwierze zwierze, @ModelAttribute("Wizyta") Wizyta wizyta){
        return "kontakt";
    }

    @RequestMapping("/klienci")
    public String goToKlienci(Model model){
        model.addAttribute("klienci", klientService.findAllKlient());
        return "panel/klienci";
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
        if(klientService.createKlient(klient) == "bladdanychuser")
            return "bladdanychuser";
        if(zwierzeService.addZwierze(new Zwierze(zwierze.getNazwa(), zwierze.getTyp(), zwierze.getWiek(), klient.getId())) == "bladdanychuser"){
            return "bladdanychuser";
        }
        return wizytaService.addWizyta(new Wizyta(wizyta.getData(), wizyta.getOpis(),klient.getId()));
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Gabinet Weterynaryjny");
    }

}
