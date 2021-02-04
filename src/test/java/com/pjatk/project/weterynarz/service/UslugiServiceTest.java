package com.pjatk.project.weterynarz.service;

import com.pjatk.project.weterynarz.model.Klient;
import com.pjatk.project.weterynarz.model.Uslugi;
import com.pjatk.project.weterynarz.repository.UslugiRepository;
import com.pjatk.project.weterynarz.services.UslugiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UslugiServiceTest {
    @Mock
    private UslugiRepository uslugiRepository;

    @InjectMocks
    private UslugiService uslugiService;

    @Test
    void findAll() {
        when(uslugiRepository.findAll())
                .thenReturn(List.of(new Uslugi()));
        List<Uslugi> all = uslugiService.findAllUslugi();
        assertThat(all).hasSize(1);
    }

    @Test
    void shouldAddUsluga(){
        Uslugi uslugi = new Uslugi("Fajna usluga", 50);
        String result = uslugiService.addUslugi(uslugi);
        assertThat(result).isEqualTo("successful");
    }

    @Test
    void shouldFailToAddUslugaCausedByNazwa(){
        Uslugi uslugi = new Uslugi("", 50);
        String result = uslugiService.addUslugi(uslugi);
        assertThat(uslugi.getNazwa()).isEqualTo("");
        assertThat(result).isEqualTo("bladdanychuser");
    }

    @Test
    void shouldFailToAddUslugaCausedByCenaEqualsLess0(){
        Uslugi uslugi = new Uslugi("Fajna usluga", -2);
        String result = uslugiService.addUslugi(uslugi);
        assertThat(uslugi.getCena()).isLessThanOrEqualTo(0);
        assertThat(result).isEqualTo("bladdanychuser");
    }
}
