package com.example.baza.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "kazna", schema = "project")
@NoArgsConstructor
public class Kazna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kazna", nullable = false)
    private Integer id;

    @Column(name = "datum", nullable = false)
    private LocalDate datum;

    @Column(name = "cena_vo_denari", nullable = false)
    private Double cenaVoDenari;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pozajmica_proverka", nullable = false)
    private Pozajmica pozajmica;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_chovek_imakazna", nullable = false)
    private Chlen2 chlen;

    public Kazna(LocalDate datum, Double cenaVoDenari, Pozajmica pozajmica, Chlen2 chlen) {
        this.datum = datum;
        this.cenaVoDenari = cenaVoDenari;
        this.pozajmica = pozajmica;
        this.chlen = chlen;
    }

    public Chlen2 getChlen() {
        return chlen;
    }

    public void setChlen(Chlen2 chlen) {
        this.chlen = chlen;
    }

    public Pozajmica getPozajmica() {
        return pozajmica;
    }

    public void setPozajmica(Pozajmica pozajmica) {
        this.pozajmica = pozajmica;
    }

    public Double getCenaVoDenari() {
        return cenaVoDenari;
    }

    public void setCenaVoDenari(Double cenaVoDenari) {
        this.cenaVoDenari = cenaVoDenari;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}