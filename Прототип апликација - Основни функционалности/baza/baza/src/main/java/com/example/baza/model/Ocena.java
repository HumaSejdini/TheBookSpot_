package com.example.baza.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ocena", schema = "project")
@NoArgsConstructor
public class Ocena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_na_ocena", nullable = false)
    private Integer id;

    @Column(name = "ocena", nullable = false)
    private Integer ocena;

    @Column(name = "komentar", nullable = false, length = 500)
    private String komentar;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_chovek_dava", nullable = false)
    private Chlen2 chlen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ocena_id_kniga")
    private Knigi knigi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ocena_id_avtor")
    private Avtor avtor;

    public Avtor getAvtor() {
        return avtor;
    }

    public void setAvtor(Avtor avtor) {
        this.avtor = avtor;
    }

    public Knigi getKnigi() {
        return knigi;
    }

    public void setKnigi(Knigi knigi) {
        this.knigi = knigi;
    }

    public Chlen2 getChlen() {
        return chlen;
    }

    public void setChlen(Chlen2 chlen) {
        this.chlen = chlen;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ocena(Integer ocena, String komentar, Chlen2 chlen, Knigi knigi, Avtor avtor) {
        this.ocena = ocena;
        this.komentar = komentar;
        this.chlen = chlen;
        this.knigi = knigi;
        this.avtor = avtor;
    }
}