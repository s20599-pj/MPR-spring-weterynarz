package com.pjatk.project.weterynarz.service;


import com.pjatk.project.weterynarz.model.Klient;
import com.pjatk.project.weterynarz.model.Zwierze;
import com.pjatk.project.weterynarz.repository.KlientRepository;
import com.pjatk.project.weterynarz.services.KlientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class KlientServiceTest {
    @Mock
    private KlientRepository klientRepository;

    @InjectMocks
    private KlientService klientService;

    @Test
    void findAll() {
        when(klientRepository.findAll())
                .thenReturn(List.of(new Klient()));
        List<Klient> all = klientService.findAllKlient();
        assertThat(all).hasSize(1);
    }

    @Test
    void shouldAddKlient(){
        Klient klient = new Klient("Kamil", "Rominski", 503932474, "kamil.rominski@gmail.com");
        String result = klientService.createKlient(klient);
        assertThat(result).isEqualTo("successful");
    }
    @Test
    void shouldFailAtTelefonIsLessThanExpected(){
        Klient klient = new Klient("Kamil", "Rominski", 50393244, "kamil.rominski@gmail.com");
        String result = klientService.createKlient(klient);
        assertThat(klient.getTelefon()).isLessThan(100000000);
        assertThat(result).isEqualTo("bladdanychuser");
    }
    @Test
    void shouldFailAtTelefonIsGreaterThanExpected(){
        Klient klient = new Klient("Kamil", "Rominski", 1000000000, "kamil.rominski@gmail.com");
        String result = klientService.createKlient(klient);
        assertThat(klient.getTelefon()).isGreaterThan(999999999);
        assertThat(result).isEqualTo("bladdanychuser");
    }

}
