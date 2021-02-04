package com.pjatk.project.weterynarz.service;

import com.pjatk.project.weterynarz.model.Klient;
import com.pjatk.project.weterynarz.model.Pracownik;
import com.pjatk.project.weterynarz.repository.PracownikRepository;
import com.pjatk.project.weterynarz.services.PracownikService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PracownikServiceTest {
    @Mock
    private PracownikRepository pracownikRepository;

    @InjectMocks
    private PracownikService pracownikService;

    @Test
    void findAll() {
        when(pracownikRepository.findAll())
                .thenReturn(List.of(new Pracownik()));
        List<Pracownik> all = pracownikService.findAllPracownik();
        assertThat(all).hasSize(1);
    }
}
