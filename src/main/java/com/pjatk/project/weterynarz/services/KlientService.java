package com.pjatk.project.weterynarz.services;

import com.pjatk.project.weterynarz.model.Klient;
import com.pjatk.project.weterynarz.repository.KlientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlientService {

    private KlientRepository klientRepository;

    public KlientService(KlientRepository klientRepository){
        this.klientRepository = klientRepository;
    }

    public Klient createKlient(Klient klient) {return klientRepository.save(klient); }
    public List<Klient> findAllKlient() {return klientRepository.findAll();}


}
