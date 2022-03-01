package com.example.baza.service;

import com.example.baza.model.Chlen2;
import com.example.baza.model.Kazna;
import com.example.baza.model.Pozajmica;

import java.time.LocalDate;
import java.util.List;

public interface KaznaService {
    Kazna findById(Integer id);
    List<Kazna> listAll();
    Kazna create(LocalDate datum, Double cenaVoDenari, Pozajmica pozajmica, Chlen2 chlen);
    Kazna deleteId (Integer id);
}
