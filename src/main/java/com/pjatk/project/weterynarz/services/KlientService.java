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

    public String createKlient(Klient klient) {
        if(klient.getEmail() == "" || klient.getTelefon() == 0 || klient.getImie() == "" || klient.getNazwisko() == "" ){
            return "bladdanychuser";
        }
        else{
            if(klient.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") == false){
                return "bladdanychuser";
            }
            if(klient.getTelefon() < 99999999 || klient.getTelefon() > 1000000000){
                return "bladdanychuser";
            }
            else {
                klientRepository.save(klient);
                return "successful";

            }
        }
    }
    public List<Klient> findAllKlient() {return klientRepository.findAll();}


}
