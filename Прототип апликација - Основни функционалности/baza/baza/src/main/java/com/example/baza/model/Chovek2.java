package com.example.baza.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "chovek", schema = "project")
//public class Chovek2 {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_chovek", nullable = false)
//    private Integer id;
//
//    @Column(name = "ime", nullable = false, length = 50)
//    private String ime;
//
//    @Column(name = "prezime", nullable = false, length = 50)
//    private String prezime;
//
//    @Column(name = "email", nullable = false, length = 50)
//    private String email;
//
//    @Column(name = "tel_broj", nullable = false, length = 25)
//    private String telBroj;
//
//    @Column(name = "adresa", nullable = false, length = 150)
//    private String adresa;
//
//    @Column(name = "embg", nullable = false, length = 13)
//    private String embg;
//
//    @Column(name = "username", nullable = false, length = 50)
//    private String username;
//
//    @Column(name = "password", nullable = false, length = 100)
//    private String password;
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmbg() {
//        return embg;
//    }
//
//    public void setEmbg(String embg) {
//        this.embg = embg;
//    }
//
//    public String getAdresa() {
//        return adresa;
//    }
//
//    public void setAdresa(String adresa) {
//        this.adresa = adresa;
//    }
//
//    public String getTelBroj() {
//        return telBroj;
//    }
//
//    public void setTelBroj(String telBroj) {
//        this.telBroj = telBroj;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPrezime() {
//        return prezime;
//    }
//
//    public void setPrezime(String prezime) {
//        this.prezime = prezime;
//    }
//
//    public String getIme() {
//        return ime;
//    }
//
//    public void setIme(String ime) {
//        this.ime = ime;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//}


import com.example.baza.model.Authentication;
import com.example.baza.model.Bibliotekar2;
import com.example.baza.model.Chlen2;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "chovek", schema = "project")
public class Chovek2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chovek", nullable = false)
    private Integer id;

    @Column(name = "ime", nullable = false, length = 50)
    private String ime;

    @Column(name = "prezime", nullable = false, length = 50)
    private String prezime;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "tel_broj", nullable = false, length = 25)
    private String telBroj;

    @Column(name = "adresa", nullable = false, length = 150)
    private String adresa;

    @Column(name = "embg",columnDefinition = "bpchar(13)", nullable = false, length = 13)
    private String embg;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "chovek")
    private Chlen2 chlen;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "chovek")
    private Bibliotekar2 bibliotekar;

    @OneToMany(mappedBy = "chovek")
    private Set<Authentication> authentications = new LinkedHashSet<>();

    public Set<Authentication> getAuthentications() {
        return authentications;
    }

    public void setAuthentications(Set<Authentication> authentications) {
        this.authentications = authentications;
    }

    public Bibliotekar2 getBibliotekar() {
        return bibliotekar;
    }

    public void setBibliotekar(Bibliotekar2 bibliotekar) {
        this.bibliotekar = bibliotekar;
    }

    public Chlen2 getChlen() {
        return chlen;
    }

    public void setChlen(Chlen2 chlen) {
        this.chlen = chlen;
    }

    public Chovek2(String ime, String prezime, String email, String telBroj, String adresa, String embg, String username, String password) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.telBroj = telBroj;
        this.adresa = adresa;
        this.embg = embg;
        this.username = username;
        this.password = password;
    }

    public Chovek2() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmbg() {
        return embg;
    }

    public void setEmbg(String embg) {
        this.embg = embg;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelBroj() {
        return telBroj;
    }

    public void setTelBroj(String telBroj) {
        this.telBroj = telBroj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
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