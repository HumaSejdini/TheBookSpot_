package com.example.baza.service;


import com.example.baza.model.Bibliotekar2;

import java.util.List;

public interface BibliotekarService {
    List<Bibliotekar2> findAll();
    List<Bibliotekar2> findByIdNaBibliotekar(Integer idNaBibliotekar);
    void delete(Integer idNaBibliotekar);
}
