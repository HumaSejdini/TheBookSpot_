package com.example.baza.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InstancaOdKnigaId implements Serializable {
    private static final long serialVersionUID = -8279685280812568305L;
    @Column(name = "id_na_kniga", nullable = false)
    private Integer idNaKniga;
    @Column(name = "unique_id", nullable = false)
    private Integer uniqueId;

    public Integer getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Integer uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Integer getIdNaKniga() {
        return idNaKniga;
    }

    public void setIdNaKniga(Integer idNaKniga) {
        this.idNaKniga = idNaKniga;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNaKniga, uniqueId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InstancaOdKnigaId entity = (InstancaOdKnigaId) o;
        return Objects.equals(this.idNaKniga, entity.idNaKniga) &&
                Objects.equals(this.uniqueId, entity.uniqueId);
    }
}