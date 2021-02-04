package com.pjatk.project.weterynarz.services;

import com.pjatk.project.weterynarz.model.Pracownik;
import com.pjatk.project.weterynarz.repository.PracownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
