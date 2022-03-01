package com.example.baza.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "dobavuvac", schema = "project")
@NoArgsConstructor
public class Dobavuvac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_na_dobavuvac", nullable = false)
    private Integer id;

    @Column(name = "ime_na_dobavuvac", nullable = false, length = 100)
    private String imeNaDobavuvac;

    public Dobavuvac(String imeDobabuvac) {
        this.imeNaDobavuvac=imeDobabuvac;
    }

    public String getImeNaDobavuvac() {
        return imeNaDobavuvac;
    }

    public void setImeNaDobavuvac(String imeNaDobavuvac) {
        this.imeNaDobavuvac = imeNaDobavuvac;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}