package com.example.baza.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "izdavac", schema = "project")
@NoArgsConstructor
public class Izdavac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_na_izdavac", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "lokacija", nullable = false, length = 200)
    private String lokacija;

    @Column(name = "ime_na_izdavac", nullable = false, length = 100)
    private String imeNaIzdavac;

    public Izdavac(String email, String lokacija, String imeNaIzdavac) {
        this.email = email;
        this.lokacija = lokacija;
        this.imeNaIzdavac = imeNaIzdavac;
    }

    public String getImeNaIzdavac() {
        return imeNaIzdavac;
    }

    public void setImeNaIzdavac(String imeNaIzdavac) {
        this.imeNaIzdavac = imeNaIzdavac;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}