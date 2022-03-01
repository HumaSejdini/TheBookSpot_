package com.example.baza.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IzdavaId implements Serializable {
    private static final long serialVersionUID = 3804192735403669550L;
    @Column(name = "id_knigi", nullable = false)
    private Integer idKnigi;
    @Column(name = "id_avtor", nullable = false)
    private Integer idAvtor;

    public Integer getIdAvtor() {
        return idAvtor;
    }

    public void setIdAvtor(Integer idAvtor) {
        this.idAvtor = idAvtor;
    }

    public Integer getIdKnigi() {
        return idKnigi;
    }

    public void setIdKnigi(Integer idKnigi) {
        this.idKnigi = idKnigi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAvtor, idKnigi);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IzdavaId entity = (IzdavaId) o;
        return Objects.equals(this.idAvtor, entity.idAvtor) &&
                Objects.equals(this.idKnigi, entity.idKnigi);
    }
}