package com.pjatk.project.weterynarz.services;

import com.pjatk.project.weterynarz.model.MyPracownikDetails;
import com.pjatk.project.weterynarz.model.Pracownik;
import com.pjatk.project.weterynarz.repository.PracownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyPracownikDetailsService implements UserDetailsService {

    @Autowired
    PracownikRepository pracownikRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Pracownik> pracownik = pracownikRepository.findByLogin(s);

        pracownik.orElseThrow(() -> new UsernameNotFoundException("Użytkownik nie znaleziony"));

        return pracownik.map(MyPracownikDetails::new).get();
    }

}
