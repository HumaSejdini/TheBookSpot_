package com.example.baza.service;

import com.example.baza.model.Avtor;
import com.example.baza.model.Chlen2;
import com.example.baza.model.Knigi;
import com.example.baza.model.Ocena;

import java.util.List;
import java.util.Optional;

public interface OcenaService {
Optional<Ocena> findById(Integer id);
List<Ocena> findByKomentar(String komentar);
Ocena create(Integer ocena, String komentar, Chlen2 chlen, Knigi knigi, Avtor avtor);
void delete(Integer id);
}
