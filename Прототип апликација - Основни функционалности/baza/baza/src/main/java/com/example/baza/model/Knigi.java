package com.example.baza.model;


import lombok.Data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "knigi", schema = "project")
public class Knigi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_na_kniga", nullable = false)
    private Integer id;

    @Column(name = "opis", nullable = false, length = 5500)
    private String opis;

    @Column(name = "naslov", nullable = false, length = 100)
    private String naslov;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_izdavac", nullable = false)
    private Izdavac izdavac;

    @ManyToMany(mappedBy = "knigis", fetch = FetchType.EAGER)
    private Set<Kategorija> kategorijas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idNaKniga")
    private Set<InstancaOdKniga> instancaOdKnigas = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "izdava",
            joinColumns = @JoinColumn(name = "id_knigi"),
            inverseJoinColumns = @JoinColumn(name = "id_avtor"))
    private Set<Avtor> avtors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "knigi")
    private Set<Ocena> ocenas = new LinkedHashSet<>();

//    public Knigi(String naslov, String opis, Izdavac izdavac, Kategorija kategorija, Avtor avtor) {
//        this.naslov = naslov;
//        this.opis = opis;
//        this.izdavac = izdavac;
//        this.kategorija = kategorija;
//
//    }

    public Set<Ocena> getOcenas() {
        return ocenas;
    }

    public void setOcenas(Set<Ocena> ocenas) {
        this.ocenas = ocenas;
    }

    public Set<Avtor> getAvtors() {
        return avtors;
    }

    public void setAvtors(Set<Avtor> avtors) {
        this.avtors = avtors;
    }

    public Set<InstancaOdKniga> getInstancaOdKnigas() {
        return instancaOdKnigas;
    }

    public void setInstancaOdKnigas(Set<InstancaOdKniga> instancaOdKnigas) {
        this.instancaOdKnigas = instancaOdKnigas;
    }

    public Set<Kategorija> getKategorijas() {
        return kategorijas;
    }

    public void setKategorijas(Set<Kategorija> kategorijas) {
        this.kategorijas = kategorijas;
    }

    public Izdavac getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(Izdavac izdavac) {
        this.izdavac = izdavac;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Knigi(String naslov, String opis,  Izdavac izdavac, Set<Kategorija> kategorijas, Set<Avtor> avtors) {
        this.opis = opis;
        this.naslov = naslov;
        this.izdavac = izdavac;
        this.kategorijas = kategorijas;
        this.avtors = avtors;
    }

    public Knigi(String opis, String naslov, Izdavac izdavac, Set<Kategorija> kategorijas, Set<InstancaOdKniga> instancaOdKnigas, Set<Avtor> avtors, Set<Ocena> ocenas) {
        this.opis = opis;
        this.naslov = naslov;
        this.izdavac = izdavac;
        this.kategorijas = kategorijas;
        this.instancaOdKnigas = instancaOdKnigas;
        this.avtors = avtors;
        this.ocenas = ocenas;
    }

    public Knigi(Integer id, String opis, String naslov, Izdavac izdavac, Set<Kategorija> kategorijas, Set<InstancaOdKniga> instancaOdKnigas, Set<Avtor> avtors, Set<Ocena> ocenas) {
        this.id = id;
        this.opis = opis;
        this.naslov = naslov;
        this.izdavac = izdavac;
        this.kategorijas = kategorijas;
        this.instancaOdKnigas = instancaOdKnigas;
        this.avtors = avtors;
        this.ocenas = ocenas;
    }

    public Knigi(){}
}