package com.pjatk.project.weterynarz.services;

import com.pjatk.project.weterynarz.model.Pracownik;
import com.pjatk.project.weterynarz.repository.PracownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracownikService {

    @Autowired
    private PracownikRepository pracownikRepository;


    public PracownikService(PracownikRepository pracownikRepository){
        this.pracownikRepository = pracownikRepository;
    }

    public List<Pracownik> findAllPracownik(){
        return pracownikRepository.findAll();
    }

    public Optional<Pracownik> findByImie(String imie){
        return pracownikRepository.getPracownikByImie(imie);
    }
}
