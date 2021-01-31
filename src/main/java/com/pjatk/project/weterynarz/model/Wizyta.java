package com.pjatk.project.weterynarz.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Wizyta {

    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private String opis;
    private Long klient_id;

    public Wizyta(Date data, String opis) {
        this.data = data;
        this.opis = opis;
    }

    public Wizyta(Date data, String opis, Long klient_id) {
        this.data = data;
        this.opis = opis;
        this.klient_id = klient_id;
    }

    public Wizyta() {
    }

    public Long getKlient_id() {
        return klient_id;
    }

    public void setKlient_id(Long klient_id) {
        this.klient_id = klient_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
