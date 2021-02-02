package com.pjatk.project.weterynarz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pracownik {

    @Id
    @GeneratedValue
    private Long id;
    private String imie;
    private String nazwisko;
    private String login;
    private String haslo;
    private int telefon;
    private String email;
    private String rola;


    public Pracownik(String imie, String nazwisko, String login, String haslo, int telefon, String email, String rola) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.haslo = haslo;
        this.telefon = telefon;
        this.email = email;
        this.rola = rola;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public Pracownik(String imie, String nazwisko, String login, String haslo, int telefon, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.haslo = haslo;
        this.telefon = telefon;
        this.email = email;
    }

    public Pracownik() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }

    public int getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }
}
