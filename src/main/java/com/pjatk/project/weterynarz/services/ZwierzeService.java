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

    public Zwierze addZwierze(Zwierze zwierze){
        return zwierzeRepository.save(zwierze);
    }

    public List<Zwierze> findAllZwierze(){
        return zwierzeRepository.findAll();
    }

}
