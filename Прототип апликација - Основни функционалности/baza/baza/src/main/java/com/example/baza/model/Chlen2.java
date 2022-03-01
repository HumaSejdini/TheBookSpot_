package com.example.baza.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "chlen", schema = "project")
public class Chlen2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chovek", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_chovek", nullable = false)
    private Chovek2 chovek;

    @Column(name = "broj", nullable = false)
    private Integer broj;

    @Column(name = "datum_na_zachlenuvanje", nullable = false)
    private Instant datumNaZachlenuvanje;

    public Instant getDatumNaZachlenuvanje() {
        return datumNaZachlenuvanje;
    }

    public void setDatumNaZachlenuvanje(Instant datumNaZachlenuvanje) {
        this.datumNaZachlenuvanje = datumNaZachlenuvanje;
    }

    public Integer getBroj() {
        return broj;
    }

    public void setBroj(Integer broj) {
        this.broj = broj;
    }

    public Chovek2 getChovek2() {
        return chovek;
    }

    public void setChovek2(Chovek2 chovek2) {
        this.chovek = chovek2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}