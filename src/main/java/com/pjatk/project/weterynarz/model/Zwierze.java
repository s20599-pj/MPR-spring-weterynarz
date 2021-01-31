package com.pjatk.project.weterynarz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Zwierze {

    @Id
    @GeneratedValue
    private Long id;
    private String nazwa;
    private int wiek;
    private int wlasciciel_id;

    public Zwierze(Long id, String nazwa, int wiek, int wlasciciel_id) {
        this.id = id;
        this.nazwa = nazwa;
        this.wiek = wiek;
        this.wlasciciel_id = wlasciciel_id;
    }

    public Zwierze(Long id, String nazwa, int wiek) {
        this.id = id;
        this.nazwa = nazwa;
        this.wiek = wiek;
    }

    public Zwierze() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public void setWlasciciel_id(int wlasciciel_id) {
        this.wlasciciel_id = wlasciciel_id;
    }

    public Long getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getWiek() {
        return wiek;
    }

    public int getWlasciciel_id() {
        return wlasciciel_id;
    }
}
