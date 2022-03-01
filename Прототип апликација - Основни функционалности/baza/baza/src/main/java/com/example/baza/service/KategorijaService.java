package com.example.baza.service;


import com.example.baza.model.Kategorija;

import java.util.List;
import java.util.Optional;

public interface KategorijaService {
 Optional<Kategorija> findById(Integer id);
 List<Kategorija> findAll();
 List<Kategorija> findByImeKategorija(String imeKategorija);
 Kategorija create(String imeKategorija);
 void delete(Integer id);
}