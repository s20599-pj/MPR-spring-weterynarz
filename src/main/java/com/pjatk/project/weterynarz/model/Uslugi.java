package com.pjatk.project.weterynarz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Uslugi {

    @Id
    @GeneratedValue
    private Long id;
    private String nazwa;
    private float cena;

    public Uslugi() {
    }

    public Uslugi(Long id, String nazwa, float cena) {
        this.id = id;
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }
}
