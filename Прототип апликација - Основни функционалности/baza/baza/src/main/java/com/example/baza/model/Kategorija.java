package com.example.baza.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "kategorija", schema = "project")
@NoArgsConstructor
public class Kategorija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_na_kategorija", nullable = false)
    private Integer id;

    @Column(name = "ime_kategorija", nullable = false, length = 30)
    private String imeKategorija;

    public Kategorija(String imeKategorija) {
        this.imeKategorija = imeKategorija;
    }

    public String getImeKategorija() {
        return imeKategorija;
    }

    public void setImeKategorija(String imeKategorija) {
        this.imeKategorija = imeKategorija;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
    @ManyToMany
    @JoinTable(name = "e_od",
            joinColumns = @JoinColumn(name = "id_na_kategorija"),
            inverseJoinColumns = @JoinColumn(name = "id_knigi"))
    private Set<Knigi> knigis = new LinkedHashSet<>();

    public Set<Knigi> getKnigis() {
        return knigis;
    }

    public void setKnigis(Set<Knigi> knigis) {
        this.knigis = knigis;
    }

}