package com.pjatk.project.weterynarz.services;

import com.pjatk.project.weterynarz.model.Zwierze;
import com.pjatk.project.weterynarz.repository.ZwierzeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZwierzeService {

    private ZwierzeRepository zwierzeRepository;

    public ZwierzeService(ZwierzeRepository zwierzeRepository){
        this.zwierzeRepository = zwierzeRepository;
    }

    public String addZwierze(Zwierze zwierze){
        if(zwierze.getWiek()>20 || zwierze.getWiek()<0 || zwierze.getNazwa() == "" || zwierze.getTyp() == ""){
            return "bladdanychuser";
        }
        else{
            zwierzeRepository.save(zwierze);
            return "successful";
        }

    }

    public List<Zwierze> findAllZwierze(){
        return zwierzeRepository.findAll();
    }

}
