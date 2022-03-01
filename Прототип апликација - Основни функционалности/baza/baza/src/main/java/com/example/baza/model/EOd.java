package com.example.baza.model;

import javax.persistence.*;

@Entity
@Table(name = "e_od", schema = "project")
public class EOd {
    @EmbeddedId
    private EOdId id;

    @MapsId("idKnigi")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_knigi", nullable = false)
    private Knigi idKnigi;

    @MapsId("idNaKategorija")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_na_kategorija", nullable = false)
    private Kategorija idNaKategorija;

    public Kategorija getIdNaKategorija() {
        return idNaKategorija;
    }

    public void setIdNaKategorija(Kategorija idNaKategorija) {
        this.idNaKategorija = idNaKategorija;
    }

    public Knigi getIdKnigi() {
        return idKnigi;
    }

    public void setIdKnigi(Knigi idKnigi) {
        this.idKnigi = idKnigi;
    }

    public EOdId getId() {
        return id;
    }

    public void setId(EOdId id) {
        this.id = id;
    }
}