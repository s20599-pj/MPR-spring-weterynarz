package com.pjatk.project.weterynarz.services;

import com.pjatk.project.weterynarz.model.Uslugi;
import com.pjatk.project.weterynarz.repository.UslugiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UslugiService {
    private UslugiRepository uslugiRepository;

    public UslugiService(UslugiRepository uslugiRepository){
        this.uslugiRepository = uslugiRepository;
    }

    public List<Uslugi> findAllUslugi(){
        return uslugiRepository.findAll();
    }

    public String addUslugi(Uslugi uslugi){
        if(uslugi.getNazwa() == "" || uslugi.getCena() <= 0){
            return "bladdanychuser";
        }
        else{
            uslugiRepository.save(uslugi);
            return "successful";
        }

    }
}
