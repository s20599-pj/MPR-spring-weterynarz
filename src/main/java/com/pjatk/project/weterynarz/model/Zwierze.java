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
    private String typ;
    private int wiek;
    private Long klient_id;

    public Zwierze(Long id, String nazwa, String typ, int wiek, Long klient_id) {
        this.id = id;
        this.nazwa = nazwa;
        this.typ = typ;
        this.wiek = wiek;
        this.klient_id = klient_id;
    }

    public Zwierze(String nazwa, String typ, int wiek, Long klient_id) {
        this.nazwa = nazwa;
        this.typ = typ;
        this.wiek = wiek;
        this.klient_id = klient_id;
    }

    public Zwierze() {

    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Long getKlient_id() {
        return klient_id;
    }

    public void setKlient_id(Long klient_id) {
        this.klient_id = klient_id;
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

    public void setWlasciciel_id(Long wlasciciel_id) {
        this.klient_id = wlasciciel_id;
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

    public Long getWlasciciel_id() {
        return klient_id;
    }
}
