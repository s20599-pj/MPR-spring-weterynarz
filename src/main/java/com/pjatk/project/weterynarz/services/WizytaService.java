package com.pjatk.project.weterynarz.services;

import com.pjatk.project.weterynarz.model.Wizyta;
import com.pjatk.project.weterynarz.repository.WizytaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WizytaService {
    private WizytaRepository wizytaRepository;

    public WizytaService(WizytaRepository wizytaRepository){
        this.wizytaRepository = wizytaRepository;
    }

    public List<Wizyta> findAllWizyta(){
        return wizytaRepository.findAll();
    }
    public Wizyta addWizyta(Wizyta wizyta){
        return wizytaRepository.save(wizyta);
    }

}
