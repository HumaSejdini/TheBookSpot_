package com.example.baza.service;


import com.example.baza.model.Izdavac;

import java.util.List;
import java.util.Optional;

public interface IzdavacService {
    Optional<Izdavac> findById(Integer id);
    List<Izdavac> findByimeNaIzdavac( String imeNaIzdavac);
    Izdavac create(String email, String lokacija, String imeNaIzdavac);
    void delete(Integer id);
}
