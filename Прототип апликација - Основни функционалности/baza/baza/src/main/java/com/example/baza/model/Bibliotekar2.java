package com.example.baza.model;


import javax.persistence.*;

@Entity
@Table(name = "bibliotekar", schema = "project")
public class Bibliotekar2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chovek", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_chovek", nullable = false)
    private Chovek2 chovek;

    @Column(name = "id_na_bibliotekar", nullable = false)
    private Integer idNaBibliotekar;

    public Integer getIdNaBibliotekar() {
        return idNaBibliotekar;
    }

    public void setIdNaBibliotekar(Integer idNaBibliotekar) {
        this.idNaBibliotekar = idNaBibliotekar;
    }

    public Chovek2 getChovek() {
        return chovek;
    }

    public void setChovek(Chovek2 chovek) {
        this.chovek = chovek;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}