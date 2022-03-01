package com.example.baza.model;

import javax.persistence.*;

@Entity
@Table(name = "izdava", schema = "project")
public class Izdava {
    @EmbeddedId
    private IzdavaId id;

    @MapsId("idKnigi")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_knigi", nullable = false)
    private Knigi idKnigi;

    @MapsId("idAvtor")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_avtor", nullable = false)
    private Avtor idAvtor;

    public Avtor getIdAvtor() {
        return idAvtor;
    }

    public void setIdAvtor(Avtor idAvtor) {
        this.idAvtor = idAvtor;
    }

    public Knigi getIdKnigi() {
        return idKnigi;
    }

    public void setIdKnigi(Knigi idKnigi) {
        this.idKnigi = idKnigi;
    }

    public IzdavaId getId() {
        return id;
    }

    public void setId(IzdavaId id) {
        this.id = id;
    }
}