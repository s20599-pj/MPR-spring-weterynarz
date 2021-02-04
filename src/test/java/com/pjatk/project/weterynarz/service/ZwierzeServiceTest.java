package com.pjatk.project.weterynarz.service;


import com.pjatk.project.weterynarz.model.Zwierze;
import com.pjatk.project.weterynarz.repository.ZwierzeRepository;
import com.pjatk.project.weterynarz.services.ZwierzeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ZwierzeServiceTest {
    @Mock
    private ZwierzeRepository zwierzeRepository;

    @InjectMocks
    private ZwierzeService zwierzeService;

    @Test
    void findAll(){
        when(zwierzeRepository.findAll())
                .thenReturn(List.of(new Zwierze()));
        List<Zwierze> all = zwierzeService.findAllZwierze();
        assertThat(all).hasSize(1);
    }

    @Test
    void shouldAddZwierze(){
        Zwierze zwierze = new Zwierze("Azor", "Pies", 5, 1L);
        String result = zwierzeService.addZwierze(zwierze);
        assertThat(result).isEqualTo("successful");
    }
    @Test
    void shouldFailToAddZwierzeCausedByNazwa(){
        Zwierze zwierze = new Zwierze("", "Pies", 5, 1L);
        String result = zwierzeService.addZwierze(zwierze);
        assertThat(zwierze.getNazwa()).isEqualTo("");
        assertThat(result).isEqualTo("bladdanychuser");
    }
    @Test
    void shouldFailToAddZwierzeCausedByTyp(){
        Zwierze zwierze = new Zwierze("Azor", "", 5, 1L);
        String result = zwierzeService.addZwierze(zwierze);
        assertThat(zwierze.getTyp()).isEqualTo("");
        assertThat(result).isEqualTo("bladdanychuser");
    }
    @Test
    void shouldFailToAddZwierzeCausedByWiekToLow(){
        Zwierze zwierze = new Zwierze("Azor", "Pies", -2, 1L);
        String result = zwierzeService.addZwierze(zwierze);
        assertThat(zwierze.getWiek()).isLessThan(0);
        assertThat(result).isEqualTo("bladdanychuser");
    }
    @Test
    void shouldFailToAddZwierzeCausedByWiekToHigh(){
        Zwierze zwierze = new Zwierze("Azor", "Pies", 21, 1L);
        String result = zwierzeService.addZwierze(zwierze);
        assertThat(zwierze.getWiek()).isGreaterThan(20);
        assertThat(result).isEqualTo("bladdanychuser");
    }
}
