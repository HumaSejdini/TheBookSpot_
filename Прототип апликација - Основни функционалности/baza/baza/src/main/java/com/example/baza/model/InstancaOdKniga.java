package com.example.baza.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "instanca_od_kniga", schema = "project")
@NoArgsConstructor
public class InstancaOdKniga {
    @EmbeddedId
    private InstancaOdKnigaId id;

    @MapsId("idNaKniga")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_na_kniga", nullable = false)
    private Knigi idNaKniga;

    @Column(name = "dali_e_ostetena", nullable = false)
    private Boolean daliEOstetena = false;

    @Column(name = "status", nullable = false)
    private Boolean status = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_na_dobavuvac", nullable = false)
    private Dobavuvac idNaDobavuvac;

    public InstancaOdKniga(Knigi idNaKniga, Boolean daliEOstetena, Boolean status, Dobavuvac idNaDobavuvac) {
        this.idNaKniga = idNaKniga;
        this.daliEOstetena = daliEOstetena;
        this.status = status;
        this.idNaDobavuvac = idNaDobavuvac;
    }

    public InstancaOdKniga(InstancaOdKnigaId id, Knigi idNaKniga, Boolean daliEOstetena, Boolean status, Dobavuvac idNaDobavuvac) {
        this.id = id;
        this.idNaKniga = idNaKniga;
        this.daliEOstetena = daliEOstetena;
        this.status = status;
        this.idNaDobavuvac = idNaDobavuvac;
    }

    public Dobavuvac getIdNaDobavuvac() {
        return idNaDobavuvac;
    }

    public void setIdNaDobavuvac(Dobavuvac idNaDobavuvac) {
        this.idNaDobavuvac = idNaDobavuvac;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getDaliEOstetena() {
        return daliEOstetena;
    }

    public void setDaliEOstetena(Boolean daliEOstetena) {
        this.daliEOstetena = daliEOstetena;
    }

    public Knigi getIdNaKniga() {
        return idNaKniga;
    }

    public void setIdNaKniga(Knigi idNaKniga) {
        this.idNaKniga = idNaKniga;
    }

    public InstancaOdKnigaId getId() {
        return id;
    }

    public void setId(InstancaOdKnigaId id) {
        this.id = id;
    }
}