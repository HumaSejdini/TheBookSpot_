package com.example.baza.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pozajmica", schema = "project")
@NoArgsConstructor
public class Pozajmica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_na_pozajmica", nullable = false)
    private Integer id;

    @Column(name = "datum_na_zemanje", nullable = false)
    private LocalDate datumNaZemanje;

    @Column(name = "datum_na_vrakjanje", nullable = false)
    private LocalDate datumNaVrakjanje;

    @Column(name = "status", nullable = false)
    private Boolean status = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_chovek_odobruva", nullable = false)
    private Bibliotekar2 bibliotekar;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_chovek_prave", nullable = false)
    private Chlen2 chlen;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "id_na_kniga", referencedColumnName = "id_na_kniga", nullable = false),
            @JoinColumn(name = "unique_id", referencedColumnName = "unique_id", nullable = false)
    })
    private InstancaOdKniga instancaOdKniga;
    @OneToMany(mappedBy = "pozajmica")
    private Set<Kazna> kaznas = new LinkedHashSet<>();

    public Pozajmica(LocalDate datumNaZemanje, LocalDate datumNaVrakjanje, Boolean status, Bibliotekar2 bibliotekar, Chlen2 chlen, InstancaOdKniga instanca) {
    }

    public Set<Kazna> getKaznas() {
        return kaznas;
    }

    public void setKaznas(Set<Kazna> kaznas) {
        this.kaznas = kaznas;
    }
    public InstancaOdKniga getInstancaOdKniga() {
        return instancaOdKniga;
    }

    public void setInstancaOdKniga(InstancaOdKniga instancaOdKniga) {
        this.instancaOdKniga = instancaOdKniga;
    }

    public Chlen2 getChlen() {
        return chlen;
    }

    public void setChlen(Chlen2 chlen) {
        this.chlen = chlen;
    }

    public Bibliotekar2 getBibliotekar() {
        return bibliotekar;
    }

    public void setBibliotekar(Bibliotekar2 bibliotekar) {
        this.bibliotekar = bibliotekar;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDate getDatumNaVrakjanje() {
        return datumNaVrakjanje;
    }

    public void setDatumNaVrakjanje(LocalDate datumNaVrakjanje) {
        this.datumNaVrakjanje = datumNaVrakjanje;
    }

    public LocalDate getDatumNaZemanje() {
        return datumNaZemanje;
    }

    public void setDatumNaZemanje(LocalDate datumNaZemanje) {
        this.datumNaZemanje = datumNaZemanje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity

    public Pozajmica(LocalDate datumNaZemanje, LocalDate datumNaVrakjanje, Boolean status, Bibliotekar2 bibliotekar, Chlen2 chlen, InstancaOdKniga instancaOdKniga, Set<Kazna> kaznas) {
        this.datumNaZemanje = datumNaZemanje;
        this.datumNaVrakjanje = datumNaVrakjanje;
        this.status = status;
        this.bibliotekar = bibliotekar;
        this.chlen = chlen;
        this.instancaOdKniga = instancaOdKniga;
        this.kaznas = kaznas;
    }

    public Pozajmica(Integer id, LocalDate datumNaZemanje, LocalDate datumNaVrakjanje, Boolean status, Bibliotekar2 bibliotekar, Chlen2 chlen, InstancaOdKniga instancaOdKniga, Set<Kazna> kaznas) {
        this.id = id;
        this.datumNaZemanje = datumNaZemanje;
        this.datumNaVrakjanje = datumNaVrakjanje;
        this.status = status;
        this.bibliotekar = bibliotekar;
        this.chlen = chlen;
        this.instancaOdKniga = instancaOdKniga;
        this.kaznas = kaznas;
    }
}