package com.pjatk.project.weterynarz.controller;

import com.pjatk.project.weterynarz.model.User;
import com.pjatk.project.weterynarz.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class FirstController {

    private UserService userService;

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

    @PostMapping("/addedUser")
    public ResponseEntity<String> addUser(@ModelAttribute("user") User user){
        userService.createUser(new User(user.getImie(),user.getNazwisko(),user.getTelefon(), user.getEmail()));
        return ResponseEntity.ok("Dodano uzytkownika");
    }
    @PostMapping("/addToDatabase")
    public String submitUser(@ModelAttribute User user, Model model){
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/greeting")
    public String mainPage(@RequestParam(name="name", required = false, defaultValue="World") String name, Model model){
        model.addAttribute("name", name);
        return "greeting";
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
