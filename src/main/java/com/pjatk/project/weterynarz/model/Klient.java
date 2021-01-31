package com.pjatk.project.weterynarz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Klient {

    @Id
    @GeneratedValue
    private Long id;
    private String imie;
    private String nazwisko;
    private int telefon;
    private String email;
    private Long wizyty_id;
    private Long zwierze_id;

    public Klient(String imie, String nazwisko, int telefon, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.email = email;
    }

    public Klient() {
    }

    public Klient(String imie, String nazwisko, int telefon, String email, Long wizyty_id, Long zwierze_id) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.email = email;
        this.wizyty_id = wizyty_id;
        this.zwierze_id = zwierze_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getWizyty_id() {
        return wizyty_id;
    }

    public void setWizyty_id(Long wizyty_id) {
        this.wizyty_id = wizyty_id;
    }

    public Long getZwierze_id() {
        return zwierze_id;
    }

    public void setZwierze_id(Long zwierze_id) {
        this.zwierze_id = zwierze_id;
    }
}
