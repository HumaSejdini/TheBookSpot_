package com.example.baza.model;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "avtor", schema = "project")
public class Avtor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_na_avtor", nullable = false)
    private Integer id;

    @Column(name = "ime", nullable = false, length = 100)
    private String ime;

    @ManyToMany(mappedBy = "avtors")
    private Set<Knigi> knigis = new LinkedHashSet<>();

    @OneToMany(mappedBy = "avtor")
    private Set<Ocena> ocenas = new LinkedHashSet<>();

    public Set<Ocena> getOcenas() {
        return ocenas;
    }

    public void setOcenas(Set<Ocena> ocenas) {
        this.ocenas = ocenas;
    }

    public Set<Knigi> getKnigis() {
        return knigis;
    }

    public void setKnigis(Set<Knigi> knigis) {
        this.knigis = knigis;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}