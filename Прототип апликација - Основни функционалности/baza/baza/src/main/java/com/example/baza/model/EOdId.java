package com.example.baza.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EOdId implements Serializable {
    private static final long serialVersionUID = -2023892387074364524L;
    @Column(name = "id_knigi", nullable = false)
    private Integer idKnigi;
    @Column(name = "id_na_kategorija", nullable = false)
    private Integer idNaKategorija;

    public Integer getIdNaKategorija() {
        return idNaKategorija;
    }

    public void setIdNaKategorija(Integer idNaKategorija) {
        this.idNaKategorija = idNaKategorija;
    }

    public Integer getIdKnigi() {
        return idKnigi;
    }

    public void setIdKnigi(Integer idKnigi) {
        this.idKnigi = idKnigi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNaKategorija, idKnigi);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EOdId entity = (EOdId) o;
        return Objects.equals(this.idNaKategorija, entity.idNaKategorija) &&
                Objects.equals(this.idKnigi, entity.idKnigi);
    }
}