package com.pjatk.project.weterynarz.controller;

import com.pjatk.project.weterynarz.model.Zwierze;
import com.pjatk.project.weterynarz.services.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KlientService klientService;
    @MockBean
    private ZwierzeService zwierzeService;
    @MockBean
    private WizytaService wizytaService;
    @MockBean
    private UslugiService uslugiService;
    @MockBean
    private PracownikService pracownikService;

    @Test
    void shouldGoToKontakt() throws Exception{
        mockMvc.perform(get("/kontakt"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void shouldBeRedirectedFromPracownik() throws Exception{
        mockMvc.perform(get("/pracownik"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }

}
