package com.pjatk.project.weterynarz.controller;

import com.pjatk.project.weterynarz.model.Klient;
import com.pjatk.project.weterynarz.model.User;
import com.pjatk.project.weterynarz.model.Wizyta;
import com.pjatk.project.weterynarz.model.Zwierze;
import com.pjatk.project.weterynarz.services.KlientService;
import com.pjatk.project.weterynarz.services.UserService;
import com.pjatk.project.weterynarz.services.WizytaService;
import com.pjatk.project.weterynarz.services.ZwierzeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class FirstController {

    private UserService userService;
    private KlientService klientService;
    private ZwierzeService zwierzeService;
    private WizytaService wizytaService;

    public FirstController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/kontakt")
    public String goToContact(){
        return "kontakt";
    }
    @RequestMapping("/opis")
    public String goToOpis(){
        return "opis";
    }
    @RequestMapping("/cennik")
    public String goToCennik(){
        return "cennik";
    }
    @RequestMapping("/uslugi")
    public String goToUslugi(){
        return "uslugi";
    }

    @PostMapping("/addedKlient")
    public ResponseEntity<String> addKlient(@ModelAttribute("Klient") Klient klient, @ModelAttribute("Zwierze") Zwierze zwierze, @ModelAttribute("Wizyta") Wizyta wizyta){
        klientService.createKlient(new Klient(klient.getImie(),klient.getNazwisko(), klient.getTelefon(), klient.getEmail()));
        zwierzeService.addZwierze(new Zwierze(zwierze.getNazwa(), zwierze.getTyp(), zwierze.getWiek(), klient.getId()));
        return ResponseEntity.ok("Dodano uzytkownika");
    }


    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Gabinet Weterynaryjny");
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping("/saveuser")
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.ok("Dodano uzytkownika");
    }
}
