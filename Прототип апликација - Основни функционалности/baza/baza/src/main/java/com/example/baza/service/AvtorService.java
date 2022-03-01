package com.example.baza.service;


import com.example.baza.model.Avtor;

import java.util.List;
import java.util.Optional;

public interface AvtorService {
    List<Avtor> findAll();
    List<Avtor> findByImeLike(String ime);
    Optional<Avtor> findById(Integer id);
    void delete(Integer id);
}
